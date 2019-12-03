package software.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import software.jsonModel.IndexObject;
import software.jsonModel.ResponseObject;
import software.model.UserPosts;
import software.service.IndexService;
import software.service.UserService;
import software.service.util.SessionCtr;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {
  private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
  @Resource private IndexService indexService;

  @RequestMapping(value = "/getIndexContent", method = RequestMethod.GET)
  @ResponseBody
  public ResponseObject getIndexContent() {
    ResponseObject responseObject = new ResponseObject();
    List<IndexObject> objects = indexService.getIndexContent();
    if (objects != null && objects.size() > 0) {
      responseObject.setMsg("successful");
      responseObject.setObjects(objects);
      responseObject.setMsgType(SessionCtr.success);
    } else {
      responseObject.setErrMsg("no posts");
    }
    return responseObject;
  }

  /**
   * 得到一个post下面的所有comment，by motherId
   *
   * @param postObject
   * @return
   */
  @RequestMapping(value = "/getPostContent", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getCommentsByCid(@RequestBody UserPosts postObject) {
    List<UserPosts> userPosts = indexService.getContentByMid(postObject.getPid());
    ResponseObject responseObject = new ResponseObject();
    if (userPosts.size() >= 1) {
      responseObject.setMsg("successful");
      responseObject.setUserPosts(userPosts);
      responseObject.setMsgType(SessionCtr.success);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }

  /**
   * 得到一个post下面的所有comment，by motherId
   *
   * @param postObject
   * @return
   */
  @RequestMapping(value = "/getPostContentByDate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseObject getPostContentByDate(@RequestBody UserPosts postObject) {
    List<UserPosts> userPosts = indexService.getContentByMid(postObject.getPid());
    ResponseObject responseObject = new ResponseObject();
    if (userPosts.size() >= 1) {
      responseObject.setMsg("successful");
      responseObject.setUserPosts(userPosts);
      responseObject.setMsgType(SessionCtr.success);
    } else {
      responseObject.setErrMsg("failure");
    }
    return responseObject;
  }
}
