package software.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import software.App;
import software.service.UserService;
import software.service.impl.UserServiceImpl;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserServiceImplTest {
  @Resource UserServiceImpl userService;

  @Test
  public void register() {
    boolean result = userService.register("jiahui", "huang", "hjiahui7@.ve", "123", "eric");
    Assert.assertSame(true, result);
    result = userService.register("jiahui", "huang", "hjiahui7@.ve", "123", "eric");
    Assert.assertSame(false, result);
  }

  @Test
  public void login() {
    boolean result = userService.register("jiahui", "huang", "hjiahui8@.ve", "123", "eric");
    Assert.assertSame(true, result);
    Assert.assertNotNull(userService.login("hjiahui8@.ve", "123"));
    Assert.assertNull(userService.login("hjiahui8@.ve", "1234"));
  }

  @Test
  public void postTopic() {

  }

  @Test
  public void deletePost() {}

  @Test
  public void postComment() {}
}
