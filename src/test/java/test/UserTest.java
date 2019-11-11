package test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import software.App;
import software.dao.UserInfoMapper;

import javax.annotation.Resource;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class UserTest {
  @Resource private UserInfoMapper usersMapper;

//  @Test
//  public void testAdd() {
//    UserInfo users = new UserInfo();
//    users.setPasswd("123");
//    users.setFirstName("enjoy");
//    usersMapper.insertSelective(users);
//  }
//
//  @Test
//  public void testFindUser() {
//    Users users = usersMapper.findByUsernameAndPasswd("enjoy", "123");
//    System.out.println(users);
//  }
//
//  @Test
//  public void testFindUserAll() {
//    List<Users> users = usersMapper.findAllUsers();
//    for (Users user : users) {
//      System.out.println(user);
//    }
//  }
}
