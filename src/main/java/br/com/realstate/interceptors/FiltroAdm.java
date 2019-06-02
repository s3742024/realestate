package br.com.realstate.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.realstate.models.Cargo;

@WebFilter(urlPatterns = {"/usuarios", "/atualizarusuario", "/excluirusuario"})
public class FiltroAdm implements Filter{


	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		Cargo cargo = null;
		if(session.getAttribute("logado") != null) {
			Cargo cargoUsuario = (Cargo) session.getAttribute("cargo");
			cargo = cargoUsuario;
		}
		
		if(session == null || session.getAttribute("logado") == null) {
			req.getRequestDispatcher("/login").forward(req, resp);
		
		}
		
		else if(session.getAttribute("logado") != null && !cargo.getDescricao().equalsIgnoreCase("administrador")) {
			req.getRequestDispatcher("WEB-INF/views/401.jsp").forward(req, resp);
		}
		chain.doFilter(request, response);
		
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
