package top.kwp8.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kwp8.dao.UserDao;
import top.kwp8.entity.User;
import top.kwp8.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public boolean selectUser(User user) {
		String sql = "select count(*) from user u where u.mobile = ? and u.password = ?";
		return userDao.select(sql, user) > 0;
	}

}
