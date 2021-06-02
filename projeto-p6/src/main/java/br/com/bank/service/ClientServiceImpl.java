/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;

/**
 * @author 
 *
 */
public class ClientServiceImpl implements ClientService {
	
	private ClientDaoImpl dao;
	
	public ClientServiceImpl() {
		this.dao = new ClientDaoImpl();
	}

	@Override
	public Client getClient(String email) {
		return this.dao.getClient(email);
	}

	@Override
	public List<Client> getAll() {
		return this.dao.getAll();		
	}
	
	@Override
	public void listarTodos() {
		this.dao.getAll();
	}

	@Override
	public void save(Client client) {
		this.dao.save(client);
	}

	@Override
	public void deleteById(Long idClient) {
		this.dao.deleteById(idClient);
	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		this.dao.update(client);
	}

	@Override
	public Client getPhone(String phone) {
		return this.dao.getPhone(phone);
	}

	@Override
	public Client getSenha(String password) {
		// TODO Auto-generated method stub
		return this.dao.getSenha(password);
	}		

	
}
