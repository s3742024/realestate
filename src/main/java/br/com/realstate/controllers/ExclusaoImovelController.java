package br.com.realstate.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.ImovelDAO;
import br.com.realstate.models.Imovel;

@WebServlet(urlPatterns="/excluirimovel")
public class ExclusaoImovelController extends HttpServlet{
	private static final long serialVersionUID = -6228716721984907841L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ImovelDAO id = new ImovelDAO();
		int imovelId = Integer.parseInt(req.getParameter("imovelId"));
		id.remove(Imovel.class, imovelId);
	}

}
