package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Client;
import br.com.bank.service.ClientServiceImpl;

@WebServlet(urlPatterns = { "/salvar", "/logar", "/excluir", "/editar", "/alterar", "/listar","/sucesso" })
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientServiceImpl service;

	public ClientServlet() {
		this.service = new ClientServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Response to client").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/excluir")) {
			Long idex = Long.parseLong(request.getParameter("id"));
			this.service.deleteById(idex);
			
			List<Client> clients = this.service.getAll();
			request.setAttribute("clients", clients);
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			request.setAttribute("msg", "Sucesso! Usuário removido.");
			dispatcher.forward(request, response);
			
		} else if (action.equals("/logar")) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			//System.out.println("Conta:" + email);
			if (this.service.getClient(email) != null && this.service.getSenha(password)!=null) {
				List<Client> clients = this.service.getAll();
				request.setAttribute("clients", clients);
				RequestDispatcher dispatcher = request.getRequestDispatcher("client-lista.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				request.setAttribute("error", "Erro, usuário/senha incorreto(a)!");
				rd.forward(request, response);
			}

		} else if (action.equals("/editar")) {
			String email = request.getParameter("email");
			Client client = this.service.getClient(email);
			RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp");
			request.setAttribute("id", client.getId());
			request.setAttribute("name", client.getName());
			request.setAttribute("email", client.getEmail());
			request.setAttribute("phone", client.getPhone());
			request.setAttribute("password", client.getPassword());
			rd.forward(request, response);

		} else if (action.equals("/alterar")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			
				Client client = new Client();
				client.setId(Long.parseLong(id));
				client.setName(name);
				client.setEmail(email);
				client.setPhone(phone);
				client.setPassword(password);

				this.service.update(client);
				
				List<Client> clients = this.service.getAll();
				request.setAttribute("clients", clients);
				RequestDispatcher dispatcher = request.getRequestDispatcher("client-lista.jsp");
				request.setAttribute("msg", "Sucesso! Usuário alterado.");
				dispatcher.forward(request, response);
			
		} else if (action.equals("/listar")) {

			List<Client> clients = this.service.getAll();
			request.setAttribute("clients", clients);
			RequestDispatcher dispatcher = request.getRequestDispatcher("client-lista.jsp");
			dispatcher.forward(request, response);

		} else {
			// PEGA OS DADOS DO REQUEST
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");

			if (this.service.getClient(email) == null && this.service.getPhone(phone)==null) {

				// MONTEI O MEU OBJETO CLIENT
				Client client = new Client();
				client.setName(name);
				client.setEmail(email);
				client.setPhone(phone);
				client.setPassword(password);

				// SALVAR O MEU CLIENT
				this.service.save(client);

				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				request.setAttribute("sucess", "Sucesso!");
				request.setAttribute("user", name);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				request.setAttribute("error", "Erro, usuário/phone já cadastrado");
				rd.forward(request, response);
			}
		}

	}

}
