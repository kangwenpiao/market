package top.kwp8.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import top.kwp8.dao.BaseDao;
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(String sql,Object...objects) {
		jdbcTemplate.update(sql,objects);
	}

	@Override
	public void update(String sql,Object...objects) {
		jdbcTemplate.update(sql,objects);
	}


	@Override
	public void delete(String sql,Integer id) {
		jdbcTemplate.update(sql,id);
	}

	@Override
	public T select(String sql,Integer id,Class<T> cla) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(cla);  
		T t = jdbcTemplate.queryForObject(sql,rowMapper,id);
		return t;
	}
	
	@Override
	public List<T> selectList(String sql,Class<T> cla) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(cla);
		return jdbcTemplate.query(sql, rowMapper);
	}
	@Override
	public List<T> selectListByName(String sql, Class<T> cla,String name) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(cla);
		return jdbcTemplate.query(sql, rowMapper,name);
	}
	@Override
	public List<T> selectListByPage(String sql, Class<T> cla,Object...objects) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(cla);
		return jdbcTemplate.query(sql, rowMapper,objects);
	}
	@Override
	public Long selCount(String sql,Object...objects) {
		return jdbcTemplate.queryForObject(sql, Long.class,objects);
	}
}
