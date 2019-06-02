package br.com.realstate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.UsuarioDAO;
import br.com.realstate.models.Usuario;

@WebServlet(urlPatterns="/usuarios")
public class ListarUsuariosController extends HttpServlet{
	private static final long serialVersionUID = 4870589711201460478L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			UsuarioDAO us = new UsuarioDAO();
			List<Usuario> usuarios = us.getAll(Usuario.class);
			req.setAttribute("listaDeUsuarios", usuarios);
			req.getRequestDispatcher("WEB-INF/views/usuarios.jsp").forward(req, resp);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
