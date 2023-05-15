package demo_auto;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService{

    // 基于 xml的自动注入
    /*private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    // 基于 Resource注解的自动注入(byName)，name要和注解中的 id(value，可省) 名称相同，不指定name值则根据属性名来匹配
    // 当名字也不匹配时，则最后根据属性类型来匹配
    @Resource(name = "userDao")
    private UserDao userDao;

    public void addUserService() {

        /*UserDao userDao = new UserDaoImpl();
        userDao.addUserDao();*/

        userDao.addUserDao();
        System.out.println("user service");
    }

}
