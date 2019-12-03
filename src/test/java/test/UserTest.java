package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import software.App;
import software.controller.UserInfoController;
import software.dao.UserInfoMapper;
import software.model.UserInfo;

import javax.annotation.Resource;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserTest {
  @Resource private UserInfoMapper usersMapper;

  @Test
  public void testAdd() {
    UserInfo users = new UserInfo();
    users.setFirstName("jiahui");
    users.setLastName("huang");
    users.seteMail("hjiahui7@vt.edu");
    users.setPasswd("123456");
    users.setNickName("eric");
    Assert.assertSame(1, usersMapper.insertSelective(users));
  }
}
