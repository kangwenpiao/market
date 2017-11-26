package top.kwp8.service.impl;

import java.util.List;

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
	public User selectUser(User user) {
		String sql = "select * from user u where u.mobile = ? and u.password = ?";
		return userDao.select(sql, user);
	}
	@Override
	public void addUser(User user) {
		String sql = "insert user(mobile,password,nickname,sex,headimg) values(?,?,?,?,?)";
		userDao.addUser(sql, user.getMobile(),user.getPassword(),user.getMobile(),user.getSex(),user.getHeadimg());
	}
}
