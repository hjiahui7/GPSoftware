package software.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.dao.UserCommentsMapper;
import software.dao.UserPostsMapper;
import software.jsonModel.IndexObject;
import software.model.UserComments;
import software.model.UserPosts;
import software.service.IndexService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
  @Resource private UserPostsMapper userPostsMapper;
  @Resource private UserCommentsMapper userCommentsMapper;

  @Override
  public List<IndexObject> getIndexContent() {
    List<IndexObject> allUsers = userPostsMapper.selectAllUserPosts();
    return allUsers;
  }

  /**
   * 得到当前post下所有内容
   *
   * @param mid
   * @return
   */
  @Override
  @Transactional
  public List<UserPosts> getContentByMid(int mid) {
    List<UserPosts> posts = userPostsMapper.selectAllUserPostByMotherId(mid);
    List<UserComments> comments = userCommentsMapper.selectAllCommentsByMid(mid);
    for (UserPosts userPost : posts) {
      List<UserComments> temp = new LinkedList<>();
      Iterator<UserComments> iterable = comments.iterator();
      while (iterable.hasNext()) {
        UserComments com = iterable.next();
        if (com.getPid() == userPost.getPid()) {
          temp.add(com);
          iterable.remove();
        }
      }
      userPost.setUserComments(temp);
    }
    return posts;
  }

  @Override
  public List<IndexObject> getUserPostByDate(Date dealTime) {
    List<IndexObject> posts = userPostsMapper.selectAllPostsByTime(dealTime);
    return posts;
  }
}
