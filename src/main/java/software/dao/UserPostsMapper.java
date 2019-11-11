package software.dao;

import org.apache.ibatis.annotations.Param;
import software.jsonModel.IndexObject;
import software.model.UserPosts;

import java.util.List;

public interface UserPostsMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(UserPosts record);

  int insertSelective(UserPosts record);

  UserPosts selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(UserPosts record);

  int updateByPrimaryKey(UserPosts record);

  List<IndexObject> selectAllUserPosts();

  UserPosts selectUserPostByPostId(@Param("postId") int postId);

  List<UserPosts> selectAllUserPostByMotherId(@Param("motherPostId") int motherPostId);

  List<UserPosts> selectUserPostByUserId(@Param("userId") int userId);

  int deleteByPostId(int postId);

  int deleteByMotherPostId(int motherPostId);

  List<UserPosts> selectOtherPostByUserId(@Param("userId") int userId);
}
