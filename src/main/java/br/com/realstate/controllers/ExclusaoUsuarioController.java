package br.com.realstate.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.UsuarioDAO;
import br.com.realstate.models.Usuario;

@WebServlet(urlPatterns="/excluirusuario")
public class ExclusaoUsuarioController extends HttpServlet{
	private static final long serialVersionUID = 2091286381554766631L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UsuarioDAO us = new UsuarioDAO();
		int usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
		us.remove(Usuario.class, usuarioId);
		
	}

}
