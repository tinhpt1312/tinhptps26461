package com.poly.bai3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.catalina.realm.UserDatabaseRealm;

public class UserDAO {
	private EntityManager em=JPAUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	public User findByID(String id) {
		User entity=em.find(User.class, id);
		return entity;
	}
	public List<User> findAll(){
		String sqlString="SELECT o FROM User o";
		TypedQuery<User> query=em.createQuery(sqlString,User.class);
		List<User> list=query.getResultList();
		return list;
	}
	
	public User create(User entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	public User update(User entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public User remove(String id) {
		User entity=this.findByID(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
}
