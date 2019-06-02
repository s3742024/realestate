package br.com.realstate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.ImovelDAO;
import br.com.realstate.models.Imovel;

@WebServlet(urlPatterns="/imoveis")
public class ListarImoveisController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
		ImovelDAO id = new ImovelDAO();
		List<Imovel> imoveis = id.getAll(Imovel.class);
		req.setAttribute("listaDeImoveis", imoveis);
		req.getRequestDispatcher("WEB-INF/views/imoveis.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
