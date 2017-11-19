package top.kwp8.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import top.kwp8.dao.HibernateDaoBase;

@Repository
public class HibernateDaoImpl<T> extends HibernateDaoSupport implements HibernateDaoBase<T>{
	@Autowired
	public HibernateDaoImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	@Override
	public void delete(T t) {
		this.getSession().delete(t);
	}

	@Override
	public T get(Class<T> cla, Integer id) {
		return this.getSession().get(cla, id);
	}

	@Override
	public void update(T t) {
		this.getSession().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String sql) {
		return this.getSession().createQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> pagelist(String sql,Integer pageNo,Integer pageSize,Object...objects) {
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult(pageNo).setMaxResults(pageSize);
		if(objects != null){
			for (int i = 0; i < objects.length; i++) {
				Object object = objects[i];
				query.setParameter(i, object);
			}
		}
		return query.getResultList();
	}

	@Override
	public Long getCount(String sql, Object... objects) {
		Query query = this.getSession().createQuery(sql);
		if(objects != null){
			for (int i = 0; i < objects.length; i++) {
				Object object = objects[i];
				query.setParameter(i, object);
			}
		}
		return (Long) query.getSingleResult();
	}

}
