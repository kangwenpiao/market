package top.kwp8.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import top.kwp8.dao.AdminDao;
import top.kwp8.entity.Admin;
@Repository
public class AdminDaoImpl extends NamedParameterJdbcDaoSupport implements AdminDao {
	@Autowired	
	public AdminDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}
	@Override
	public Admin selectByName(String sql, Map<String,String> paramMap) {
		RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);
		return getNamedParameterJdbcTemplate().queryForObject(sql, paramMap, rowMapper);
	}

}
