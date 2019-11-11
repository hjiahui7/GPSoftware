package software.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import software.jsonModel.IndexObject;
import software.jsonModel.ResponseObject;
import software.service.IndexService;
import software.service.UserService;

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
    } else {
      responseObject.setErrMsg("no register");
    }
    return responseObject;
  }
}
