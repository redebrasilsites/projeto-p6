package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Client;

public interface ClientDao {

	public Client getClient(String email);
	
	public Client getPhone(String phone);
	
	public Client getSenha(String password);

	public List<Client> getAll();

	public void save(Client client);

	public void deleteById(Long idClient);
	
	public void update(Client client);
}
