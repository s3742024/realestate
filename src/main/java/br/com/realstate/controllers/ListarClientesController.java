package br.com.realstate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.ClienteDAO;
import br.com.realstate.models.Cliente;

@WebServlet(urlPatterns="/clientes")
public class ListarClientesController extends HttpServlet{
	private static final long serialVersionUID = 3201957653975413662L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClienteDAO cd = new ClienteDAO();
			List<Cliente> clientes = cd.getAll(Cliente.class);
			req.setAttribute("listaDeClientes", clientes);
			req.getRequestDispatcher("WEB-INF/views/clientes.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
