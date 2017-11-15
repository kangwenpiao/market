package top.kwp8.dao;

import top.kwp8.entity.User;

public interface UserDao {

	User select(String sql,User user);
}
