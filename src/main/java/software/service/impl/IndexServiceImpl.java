package software.service.impl;

import org.springframework.stereotype.Service;
import software.dao.UserPostsMapper;
import software.jsonModel.IndexObject;
import software.service.IndexService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
  @Resource private UserPostsMapper userPostsMapper;

  @Override
  public List<IndexObject> getIndexContent() {
    List<IndexObject> allUsers = userPostsMapper.selectAllUserPosts();
    return allUsers;
  }
}
