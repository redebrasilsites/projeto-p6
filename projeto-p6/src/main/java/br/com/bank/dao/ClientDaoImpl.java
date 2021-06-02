/**
 * 
 */
package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil;

/**
 * @author cbgomes
 *
 */
public class ClientDaoImpl implements ClientDao {

	@Override
	public Client getClient(String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {
			Client client = entityManager.createNamedQuery("Client.getByEmail", Client.class).setParameter("email", email)
					.getSingleResult();
			return client;
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		return null;
	}
	
	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		/*
		 * for (Client c:this.dao.getAll()){
			System.out.println(c.getEmail());
		}
		 */
		List <Client> clientes = null;
		try {
			clientes = entityManager.createQuery("from Client c").getResultList();
			
		} catch (Exception e) {
			e.getMessage();
		} finally{
			entityManager.close();
		}
		return clientes;
	}
	@Override
	public void save(Client client) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(client);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void deleteById(Long idClient) {
		// TODO Auto-generated method stub
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {
			Client client = entityManager.find(Client.class, idClient);
			entityManager.remove(client);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void update(Client client) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(client);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println(client.getId());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public Client getPhone(String phone) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {
			Client client = entityManager.createNamedQuery("Client.getByPhone", Client.class).setParameter("phone", phone)
					.getSingleResult();
			return client;
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		return null;
	}

	@Override
	public Client getSenha(String password) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {
			Client client = entityManager.createNamedQuery("Client.getBySenha", Client.class).setParameter("password", password)
					.getSingleResult();
			return client;
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		return null;
	}

}
