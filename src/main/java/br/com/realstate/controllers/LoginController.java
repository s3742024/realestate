package br.com.realstate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.realstate.dao.ImovelDAO;
import br.com.realstate.dao.UsuarioDAO;
import br.com.realstate.models.Imovel;
import br.com.realstate.models.Usuario;

@WebServlet(urlPatterns="/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("logado") == null) {
		   req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		try {
		
		Usuario usuario = new UsuarioDAO().getUser(login, senha);
		
			List<Imovel> imoveis = new ImovelDAO().getAll(Imovel.class);
			
			HttpSession session = req.getSession();
			session.setAttribute("logado", true);
			session.setAttribute("id", usuario.getId());
			session.setAttribute("nome", usuario.getNome());
			session.setAttribute("email", usuario.getEmail());
			session.setAttribute("cargo", usuario.getCargo());
			session.setAttribute("listaDeImoveis", imoveis);
			session.setAttribute("msg", "Login Efetuado com Sucesso!");
			req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
			
		}catch(Exception e) {
			req.setAttribute("msg", "E-mail ou Senha Incorretos!");
		}

	}

}
