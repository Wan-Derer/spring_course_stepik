package kz.infinit.spring_course_stepik;

import kz.infinit.spring_course_stepik.model.User;
import kz.infinit.spring_course_stepik.repository.UserRepository;
import kz.infinit.spring_course_stepik.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepo;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testCreate(){
        User user = new User();
        user.setPassword("Qwerty123!");
        String encodedPwd = "jf2w0jisdlfnweijdf0qjiedsolkfmwepofdjmsd";

        Mockito.doReturn(encodedPwd).when(passwordEncoder).encode(user.getPassword());
        userService.create(user);
        Mockito.verify(userRepo).save(user);
        Assertions.assertEquals(encodedPwd, user.getPassword());

    }
}
