package com.sopra.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sopra.hibernateutil.HibernateUtil;

public class RepositoryImpl <T> implements Repository<T> {

	protected Session session;
	protected Transaction transaction;
	
	public RepositoryImpl () {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	@Override
	public int add(T t) {
		int result=1;
		transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		
		return result;
	}

	@Override
	public int delete(int id,T t) {
		int result=1;
		
		transaction = session.beginTransaction();
		session.delete(session.get(t.getClass(), id));
		transaction.commit();
		return result;
	}

	@Override
	public int update(T t) {
		int result=1;
		transaction = session.beginTransaction();
		session.merge(t);
		transaction.commit();
		return result;
	}
	
	
    @SuppressWarnings("unchecked")
	@Override
	public List<T> list(T t) {
		
       return (List<T>) session.createCriteria(t.getClass()).list();
       
		
	}

    @SuppressWarnings("unchecked")
	@Override
	public T get (int id,T t) {
		return (T) session.get(t.getClass(), id);
       
	}

}
