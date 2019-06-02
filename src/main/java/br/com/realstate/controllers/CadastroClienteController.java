package br.com.realstate.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.ClienteDAO;
import br.com.realstate.models.Cliente;

@WebServlet(urlPatterns="/cadastrocliente")
public class CadastroClienteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.getRequestDispatcher("WEB-INF/views/cadastrocliente.jsp").forward(req, resp);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String contato = req.getParameter("contato");
		
		Cliente cliente = new Cliente(nome, endereco, contato);
		
		ClienteDAO cd = new ClienteDAO();
		
		try {
			cd.save(cliente);
			req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
