package software.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import software.jsonModel.ResponseObject;
import software.model.UserComments;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserProfileService;
import software.service.util.SessionCtr;

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
  public ResponseObject updatePS(@RequestBody UserPosts postObject) {
    boolean check =
        userProfileService.updatePS(
            postObject.getUid(), postObject.getToken(), postObject.getPostData());
    ResponseObject responseObject = new ResponseObject();
    if (check) {
      responseObject.setMsg("successful");
      responseObject.setMsgType(SessionCtr.success);
    } else {
      responseObject.setErrMsg("failure");
      responseObject.setMsgType(SessionCtr.timeOut);
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
  public ResponseObject getUserFile(@RequestBody UserPosts uidAndToken) {
    UserInfo userInfo =
        userProfileService.getUserProfile(uidAndToken.getUid(), uidAndToken.getToken());
    ResponseObject result = new ResponseObject();
    if (userInfo != null) {
      result.setMsg("successful");
      result.setUserInfo(userInfo);
      result.setMsgType(SessionCtr.success);
    } else {
      result.setErrMsg("failure");
      result.setMsgType(SessionCtr.timeOut);
    }
    return result;
  }

  /**
   * 上传个性签名
   *
   * @param
   * @return
   */
  @RequestMapping(value = "/getOtherUserProfile", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getOtherUserFile(@RequestBody UserPosts uidAndToken) {
    UserInfo userInfo =
        userProfileService.getUserProfile(uidAndToken.getUid(), uidAndToken.getToken());
    ResponseObject result = new ResponseObject();
    if (userInfo != null) {
      result.setMsg("successful");
      UserInfo otherU = new UserInfo();
      otherU.setNickName(userInfo.getNickName());
      otherU.setpSignature(userInfo.getpSignature());
      result.setUserInfo(otherU);
      result.setMsgType(SessionCtr.success);
    } else {
      result.setErrMsg("failure");
      result.setMsgType(SessionCtr.timeOut);
    }
    return result;
  }

  /**
   * 得到当前profile下user所有post
   *
   * @param
   * @return
   */
  @RequestMapping(value = "/getUserPosts", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getUserPosts(@RequestBody UserPosts uidAndToken) {
    List<UserPosts> userPosts = userProfileService.getUserPostsByUserId(uidAndToken.getUid());
    ResponseObject responseObject = new ResponseObject();
    if (userPosts != null && userPosts.size() >= 0) {
      responseObject.setMsg("successful");
      responseObject.setMsgType(SessionCtr.success);
      responseObject.setUserPosts(userPosts);
    } else {
      responseObject.setErrMsg("failure");
      responseObject.setMsgType(SessionCtr.timeOut);
    }
    return responseObject;
  }

  /** 得到当前user所有评论别人的 */
  @RequestMapping(value = "/getUserComments", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getUserComments(@RequestBody UserPosts uid) {
    List<UserComments> userComments = userProfileService.getCommentByUserId(uid.getUid());
    ResponseObject responseObject = new ResponseObject();
    responseObject.setMsg("successful");
    responseObject.setMsgType(SessionCtr.success);
    responseObject.setComments(userComments);
    return responseObject;
  }

  /** 得到当前user所有评论别人的 */
  @RequestMapping(value = "/getUserReplies", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getUserReplies(@RequestBody UserPosts uid) {
    List<UserPosts> userPosts = userProfileService.getUserReplyByUserId(uid.getUid());
    ResponseObject responseObject = new ResponseObject();
    responseObject.setMsg("successful");
    responseObject.setMsgType(SessionCtr.success);
    responseObject.setUserPosts(userPosts);
    return responseObject;
  }
}
