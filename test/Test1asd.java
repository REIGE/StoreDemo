import com.reige.storedemo.dao.UserDao;
import com.reige.storedemo.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class Test1asd {

////    user.getUsername(),
//                Md5Utils.md5(user.getPassword()),
//                        user.getNickname(),
//                        user.getEmail(),
//                        "user",
//                        0,
//                        user.getActivecode()
    @Test
    public void testt(){
        UserDao dao = new UserDao();
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        user.setNickname("aaa");
        user.setEmail("user@qq.com");
        user.setRole("user");
        user.setState(0);
        user.setActivecode("dfasdfasdfasdf");
        try {
            dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
