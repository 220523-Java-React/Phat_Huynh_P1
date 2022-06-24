package unit.service;

import com.revature.model.User;
import com.revature.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void whenGivenAUserObjectCreateUserDoesNotThrowAnException() {
        UserService service = new UserService();
        User user = new User();

        Assertions.assertDoesNotThrow(() -> service.createUser(user));
    }

    @Test
    public void whenGivenAUserObjectCreateUserReturnsTrue(){
        UserService service = new UserService();
        User user = new User();

        Assertions.assertNotNull(service.createUser(user));
    }


}
