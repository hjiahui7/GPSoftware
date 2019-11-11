package software.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import software.jsonModel.PostObject;
import software.jsonModel.ResponseObject;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserProfileService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserProfileController {
  private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
  @Resource private UserProfileService userProfileService;

  /**
   * 上传个性签名
   *
   * @param
   * @return
   */
  @RequestMapping(value = "/setPS", method = RequestMethod.POST)
  @ResponseBody
  // String sessionId, @RequestBody String data
  public ResponseObject updatePS(@RequestBody PostObject postObject) {
    boolean check = userProfileService.updatePS(postObject.getToken(), postObject.getPostData());
    ResponseObject responseObject = new ResponseObject();
    if (check) {
      responseObject.setMsg("successful");
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /**
   * 上传个性签名
   *
   * @param
   * @return
   */
  @RequestMapping(value = "/getUserProfile", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getUserFile(@RequestBody String sessionId) {
    UserInfo userInfo = userProfileService.getUserProfile(sessionId);
    ResponseObject responseObject = new ResponseObject();
    if (userInfo != null) {
      responseObject.setMsg("successful");
      responseObject.setUserInfo(userInfo);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /**
   * 得到当前profile下user所有post
   *
   * @param
   * @return
   */
  @RequestMapping(value = "/getUserPosts", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getUserPosts(@RequestBody int uid) {
    List<UserPosts> userPosts = userProfileService.getUserPostsByUserId(uid);
    ResponseObject responseObject = new ResponseObject();
    if (userPosts != null && userPosts.size() >= 0) {
      responseObject.setMsg("successful");
      responseObject.setUserPosts(userPosts);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /** 得到当前user所有的被评论的 */
  @RequestMapping(value = "/getUserComments", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getUserComments(@RequestBody int uid) {
    List<UserPosts> userPosts = userProfileService.getOtherPostsByUserId(uid);
    ResponseObject responseObject = new ResponseObject();
    if (userPosts != null && userPosts.size() >= 0) {
      responseObject.setMsg("successful");
      responseObject.setUserPosts(userPosts);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }
}
