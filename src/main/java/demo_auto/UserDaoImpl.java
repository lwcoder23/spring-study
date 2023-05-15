package demo_auto;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

    public void addUserDao() {
        System.out.println("addDao");
    }

}
