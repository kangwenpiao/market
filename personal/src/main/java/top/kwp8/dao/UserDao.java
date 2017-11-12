package top.kwp8.dao;

import top.kwp8.entity.User;

public interface UserDao {

	int select(String sql,User user);
}
