package aop.springAopAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 切面类（一个切面）
@Component
@Aspect
public class LogAspect {

    // value 表明切点的位置，若无其它，value可省略
    @Before("execution(public int aop.springAopAnnotation.CalculateImpl.*(..))")
    // JoinPoint 封装了连接点信息
    public void beforeMethod(JoinPoint joinPoint) {
        // 连接点的签名信息
        String methodName = joinPoint.getSignature().getName();
        // 获取目标方法的实参信息
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
    }

    // 切入点表达式含义：修饰符和返回值类型任意， 包路径为 aop.springAopAnnotation.CalculateImpl 方法名任意（所有），参数列表任意
    @After("execution(* aop.springAopAnnotation.CalculateImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+methodName);
    }

    // returning 属性，将通知方法的某个形参用来接收目标方法的返回值
    @AfterReturning(value = "execution(* aop.springAopAnnotation.CalculateImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
    }

    // throwing 属性，将通知方法的某个形参用来接收目标方法的异常
    @AfterThrowing(value = "execution(* aop.springAopAnnotation.CalculateImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
    }

    @Around("execution(* aop.springAopAnnotation.CalculateImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {

        /*
        *    ProceedingJoinPoint 继承了 JoinPoint，在 JoinPoint的基础上暴露出 proceed()，这个方法是 AOP代理链执行的方法
        *
        *   JoinPoint仅能获取相关参数，无法执行连接点。
        *   暴露出proceed()这个方法，就能支持 aop:around 这种切面（而其他的几种切面只需要用到JoinPoint，这跟切面类型有关）
        *   就能控制走代理链还是走自己拦截的其它逻辑
        *
        * */

        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前，方法名：" + methodName + "，参数：" + args);
            //目标对象（连接点）方法的执行，目标方法的返回值一定要返回给外界调用者
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }

}
