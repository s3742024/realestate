package br.com.realstate.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.ClienteDAO;
import br.com.realstate.models.Cliente;

@WebServlet(urlPatterns="/excluircliente")
public class ExclusaoClienteController extends HttpServlet{
	private static final long serialVersionUID = 9102117235940541361L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClienteDAO cd = new ClienteDAO();
		int clienteId = Integer.parseInt(req.getParameter("clienteId"));
		cd.remove(Cliente.class, clienteId);
	}
	

}
