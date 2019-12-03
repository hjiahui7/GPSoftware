package software.dao;

import software.model.UserComments;

import java.util.List;

public interface UserCommentsMapper {
  int deleteByPrimaryKey(Integer cid);

  int insert(UserComments record);

  int insertSelective(UserComments record);

  UserComments selectByPrimaryKey(Integer cid);

  int updateByPrimaryKeySelective(UserComments record);

  int updateByPrimaryKey(UserComments record);

  int deleteByMotherId(Integer mid);

  List<UserComments> selectAllCommentsByMid(Integer cid);

  List<UserComments> selectAllCommentsByUid(Integer uid);

  int deleteCommentByPid(int pid);
}
