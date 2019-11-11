package software.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import software.jsonModel.PostObject;
import software.jsonModel.ResponseObject;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserInfoController {
  private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
  @Resource private UserService userInfoService;

  @RequestMapping("/hello")
  public Object sayHello() {
    return "hello";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, String> register(@RequestBody UserInfo userInfo) {
    Map<String, String> re = new HashMap<>();
    if (userInfoService.register(
        userInfo.getFirstName(),
        userInfo.getLastName(),
        userInfo.geteMail(),
        userInfo.getPasswd(),
        userInfo.getNickName())) {
      re.put("msg", "successful");
    } else {
      re.put("errMsg", "duplicate");
    }
    return re;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  @ResponseBody
  public ResponseObject login(String email, String passwd) {
    ResponseObject responses = userInfoService.login(email, passwd);
    if (responses != null) {
      responses.setMsg("successful");
    } else {
      responses = new ResponseObject();
      responses.setErrMsg("no register");
    }
    return responses;
  }

  @RequestMapping(value = "/postTopic", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject postTopic(@RequestBody PostObject postObject) {
    ResponseObject postResult =
        userInfoService.postTopic(
            postObject.getToken(),
            postObject.getPostTitle(),
            postObject.getPostData(),
            postObject.getPostId());
    ResponseObject responseObject = new ResponseObject();
    if (postResult != null) {
      responseObject.setMsg("successful");
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /**
   * 得到一个post下面的所有post，by motherId
   *
   * @param postObject
   * @return
   */
  @RequestMapping(value = "/getPostsById", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getPostsById(@RequestBody PostObject postObject) {
    List<UserPosts> userPosts = userInfoService.getPostsById(postObject.getPostId());
    ResponseObject responseObject = new ResponseObject();
    if (userPosts.size() >= 1) {
      responseObject.setMsg("successful");
      responseObject.setUserPosts(userPosts);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /**
   * delete一个post by postid,就是delete一个帖子，或者帖子中一条数据
   *
   * @param postObject
   * @return
   */
  @RequestMapping(value = "/deletePostById", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject deletePostById(@RequestBody PostObject postObject) {
    boolean check = userInfoService.deletePost(postObject.getPostId());
    ResponseObject responseObject = new ResponseObject();
    if (check) {
      responseObject.setMsg("successful");
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }
}
