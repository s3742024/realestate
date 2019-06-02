package br.com.realstate.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.ClienteDAO;
import br.com.realstate.models.Cliente;

@WebServlet(urlPatterns="/atualizarcliente")
public class UpdateClienteController extends HttpServlet{
	private static final long serialVersionUID = 7492985142346121901L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(req.getParameter("clienteId"));
		Cliente cliente = new ClienteDAO().getById(Cliente.class, clienteId);
		req.setAttribute("cliente", cliente);
		req.getRequestDispatcher("WEB-INF/views/cadastrocliente.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(req.getParameter("clienteId"));
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String contato = req.getParameter("contato");
		
		Cliente cliente = new Cliente(clienteId, nome, endereco, contato);
		try {
			new ClienteDAO().save(cliente);
			resp.sendRedirect("/realstate/clientes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
