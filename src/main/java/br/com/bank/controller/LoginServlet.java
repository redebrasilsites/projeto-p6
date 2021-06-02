package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import br.com.bank.model.Client;
import br.com.bank.service.ClientService;
import br.com.bank.service.ClientServiceImpl;

@WebServlet ("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ClientServiceImpl service;

	public LoginServlet() {
		this.service = new ClientServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/LoginServlet")) {
			RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
			rd.forward(request, response);
		}
		if (action.equals("/lista")) {
			System.out.println("Lista ");
			RequestDispatcher rd = request.getRequestDispatcher("pages/contatos/list_contatos.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (this.service.getClient(email)!= null && this.service.getSenha(password)!=null) {
				
				List<Client> clients = this.service.getAll();
				request.setAttribute("clients", clients);
				RequestDispatcher rd = request.getRequestDispatcher("pages/contatos/list_contatos.jsp");
				rd.forward(request, response);
			
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				request.setAttribute("error", "Erro, usuário/senha incorreto(a)!");
				rd.forward(request, response);
			}
		
	}

}
