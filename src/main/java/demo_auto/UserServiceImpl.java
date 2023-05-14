package demo_auto;

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUserService() {

        /*UserDao userDao = new UserDaoImpl();
        userDao.addUserDao();*/

        userDao.addUserDao();
        System.out.println("user service");
    }

}
