package top.kwp8.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import top.kwp8.dao.UserDao;
import top.kwp8.entity.User;
@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}
	@Override
	public User select(String sql, User user) {
		return this.getJdbcTemplate().queryForObject(sql, User.class,user.getMobile(),user.getPassword());
	}

}
