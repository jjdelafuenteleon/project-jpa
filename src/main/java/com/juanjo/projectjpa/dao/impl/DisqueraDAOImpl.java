/**
 * 
 */
package com.juanjo.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.juanjo.projectjpa.dao.DisqueraDAO;
import com.juanjo.projectjpa.entity.Disquera;

/**
 * @author Juanjo
 *
 */
public class DisqueraDAOImpl implements DisqueraDAO {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceDevJuanjo");

	@Override
	public void guardar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
		

	}

	@Override
	public void actualizar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disquera = em.find(Disquera.class, id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public List<Disquera> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		return queryDisquera.getResultList();
	}

	@Override
	public Disquera consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultada = em.find(Disquera.class, id);
		
		if (disqueraConsultada == null) {
			throw new EntityNotFoundException("La Disquera con id = "+id+"no se encontro");
		}
		return disqueraConsultada;
	}

	@Override
	public Disquera consultarByDescripcionJPQL(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera WHERE descripcion = :desc");
		queryDisquera.setParameter("desc", descripcion);
		return queryDisquera.getSingleResult();
	}

	@Override
	public Disquera consultarByDescripcionNative(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createNativeQuery("SELECT * FROM disquera WHERE descripcion = :desc", Disquera.class);
		queryDisquera.setParameter("desc", descripcion);
		return queryDisquera.getSingleResult();
	}
	
	

}
