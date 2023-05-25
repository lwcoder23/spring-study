package ioc.bean;

import ioc.annotation.Bean;
import ioc.annotation.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class AnnotationApplicationContext implements ApplicationContext {

    // 定义一个 map，存放 bean，作为容器
    private Map<Class, Object> beanFactory = new HashMap();

    private static String rootFilePath;

    // 返回对象
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 设置包扫描规则，创建有参构造，传递包路径，设置扫描规则
    // 将当前包及其子包，含有 @Bean注解的类都通过反射进行实例化


    public AnnotationApplicationContext(String basePackage) {
        try {
            String packageDirName = basePackage.replaceAll("\\.", "\\\\");
            // 获取这个包下所有资源的绝对路径，返回枚举类型，遍历枚举类型来查找所有包含注解的类
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                // decode() 方法，解码字符串；getFile()方法，获取这个路径下的文件名
                String ResourcesFilePath = URLDecoder.decode(url.getFile(), "utf-8");

                // 截取根路径
                rootFilePath = ResourcesFilePath.substring(0, ResourcesFilePath.length()-packageDirName.length());

                // 包扫描
                loadBean(new File(ResourcesFilePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        loadDi();

    }

    private void loadDi() {
        // 逐一遍历 map，获取，每个bean的参数列表，有注解的则进行属性注入
        for(Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
            Object o = entry.getValue();
            Class<?> oClass = o.getClass();
            Field[] fields = oClass.getDeclaredFields();
            for(Field field : fields) {
                if (field.getAnnotation(Di.class) != null) {
                    try {
                        field.set(o, beanFactory.get(field.getType()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void loadBean(File file) {
        // 判断当前内容是否为文件夹。若是文件夹则遍历其内容：若是文件则判断是否含有 @Bean注解，有则将其加入到容器中实例化为对象；若是文件夹则递归
        // 若当前文件夹为空、当前文件不含注解或不再有子文件，则直接返回
        // 实例化对象时获取其 包路径+类名，并且把.class后缀去掉，通过反射来实例化，最后放到 map容器中 map<Class, Object>

        if(file.length() > 0 && file != null) {
            if(file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File child : listFiles) {
                    loadBean(child);
                }
            } else {
                if(file.getName().contains(".class")) {
                    String packageAllPath = file.getAbsolutePath().substring(rootFilePath.length() - 1)
                                                        .replaceAll("\\\\", "\\.")
                                                        .replace(".class", "");
                    try {
                        Class clazz = Class.forName(packageAllPath);
                        // 扫描注解，将含有注解的类加载到容器
                        if(clazz.getAnnotation(Bean.class) != null) {
                            Object o = clazz.getConstructor().newInstance();
                            // 若该类是接口的实现类，那么将其父接口的 class 作为 map 容器的 key
                            if(clazz.getInterfaces().length > 0) {
                                // 加载该实现类
                                beanFactory.put(clazz.getInterfaces()[0], o);
                            } else {
                                beanFactory.put(clazz, o);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            return;
        }
    }


}
