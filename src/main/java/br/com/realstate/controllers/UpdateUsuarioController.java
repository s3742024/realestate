package br.com.realstate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.realstate.dao.CargoDAO;
import br.com.realstate.dao.UsuarioDAO;
import br.com.realstate.models.Cargo;
import br.com.realstate.models.Usuario;

@WebServlet(urlPatterns="/atualizarusuario")
public class UpdateUsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1486128460334118980L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
			Usuario usuario = new UsuarioDAO().getById(Usuario.class, usuarioId);
			List<Cargo> cargos = new CargoDAO().getAll(Cargo.class);
			req.setAttribute("usuario", usuario);
			req.setAttribute("listaDeCargos", cargos);
			req.getRequestDispatcher("WEB-INF/views/cadastrousuario.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		int idCargo = Integer.valueOf(req.getParameter("cargo"));
		
		CargoDAO cargo = new CargoDAO();
		
		Cargo cargoSelecionado = cargo.getById(Cargo.class, idCargo);
		
		Usuario usuario = new Usuario(usuarioId, nome, senha, email, cargoSelecionado);
		
		UsuarioDAO u = new UsuarioDAO();
		try {
			u.save(usuario);
			resp.sendRedirect("realstate/usuarios");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
