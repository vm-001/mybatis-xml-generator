package top.leeys.codegenerator;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
    
    User getById(int id);
    
    void insert(User user);
    
    int update(User user);
    
    int deleteById(int id);
    
    List<User> listByIds(@Param("ids") List<Integer> ids);
    
    List<User> list(QueryCondition<User> query);
    
    int count(User user);
    
    
}
