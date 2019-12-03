package software.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import software.jsonModel.ResponseObject;
import software.model.UserComments;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserService;
import software.service.util.SessionCtr;

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
    UserInfo token = userInfoService.login(email, passwd);
    ResponseObject responses = new ResponseObject();
    if (token != null) {
      responses.setMsg("successful");
      responses.setUserInfo(token);
    } else {
      responses.setErrMsg("no register or password wrong, please re-login");
    }
    return responses;
  }

  @RequestMapping(value = "/postTopic", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject postTopic(@RequestBody UserPosts postObject) {
    int postResult =
        userInfoService.postTopic(
            postObject.getToken(),
            postObject.getPostTitle(),
            postObject.getPostData(),
            postObject.getUid(),
            postObject.getPid());
    ResponseObject responseObject = new ResponseObject();
    if (postResult == 1) {
      responseObject.setMsgType(SessionCtr.success);
      responseObject.setMsg("successful");
    } else if (postResult == 2) {
      responseObject.setMsgType(SessionCtr.timeOut);
      responseObject.setErrMsg("failure");
    } else {
      responseObject.setMsgType(SessionCtr.tokenFailed);
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
  public ResponseObject deletePostById(@RequestBody UserPosts postObject) {
    int check =
        userInfoService.deletePost(
            postObject.getPid(),
            postObject.getMotherPostId(),
            postObject.getToken(),
            postObject.getUid());
    ResponseObject responseObject = new ResponseObject();
    if (check == SessionCtr.success) {
      responseObject.setMsg("successful");
      responseObject.setMsgType(SessionCtr.success);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /**
   * delete一个post by postid,就是delete一个帖子，或者帖子中一条数据
   *
   * @param userComments
   * @return
   */
  @RequestMapping(value = "/postComment", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject deletePostById(@RequestBody UserComments userComments) {
    int check =
        userInfoService.postComment(
            userComments.getToken(),
            userComments.getComment(),
            userComments.getUidFrom(),
            userComments.getUidTo(),
            userComments.getPid(),
            userComments.getMid());
    ResponseObject responseObject = new ResponseObject();
    if (check == SessionCtr.success) {
      responseObject.setMsg("successful");
      responseObject.setMsgType(SessionCtr.success);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /**
   * delete一个post by postid,就是delete一个帖子，或者帖子中一条数据
   *
   * @param userComments
   * @return
   */
  @RequestMapping(value = "/deleteCommentByCid", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject deleteCommentByCid(@RequestBody UserComments userComments) {
    int check =
        userInfoService.deleteCommentByCid(
            userComments.getToken(),
            userComments.getCid(),
            userComments.getUidFrom(),
            userComments.getPid());
    ResponseObject responseObject = new ResponseObject();
    if (check == SessionCtr.success) {
      responseObject.setMsg("successful");
      responseObject.setMsgType(SessionCtr.success);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }
}
