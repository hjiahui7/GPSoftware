package software.service;

import software.jsonModel.IndexObject;
import software.model.UserComments;
import software.model.UserPosts;

import java.util.Date;
import java.util.List;

public interface IndexService {
  List<IndexObject> getIndexContent();

  List<UserPosts> getContentByMid(int mid);

  List<IndexObject> getUserPostByDate(Date dealTime);
}
