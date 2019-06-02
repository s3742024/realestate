package br.com.realstate.controllers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.realstate.dao.ClienteDAO;
import br.com.realstate.dao.ImovelDAO;
import br.com.realstate.dao.SituacaoImovelDAO;
import br.com.realstate.models.Cliente;
import br.com.realstate.models.Imovel;
import br.com.realstate.models.SituacaoImovel;
import br.com.realstate.services.ImageService;

@WebServlet(urlPatterns = "/cadastroimovel")
public class CadastroImovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Cliente> clientes = new ClienteDAO().getAll(Cliente.class);
			List<SituacaoImovel> status = new SituacaoImovelDAO().getAll(SituacaoImovel.class);
			req.setAttribute("listaDeProprietarios", clientes);
			req.setAttribute("listaDeStatus", status);
			req.getRequestDispatcher("WEB-INF/views/cadastroimovel.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
			final String destino = getServletConfig().getServletContext().getRealPath("");
			String nome = " ";
			Imovel imovel = new Imovel();
			for (FileItem item : items) {

				if (item.isFormField()) {

					if (item.getFieldName().equals("descricao")) {
						imovel.setDescricao(item.getString());
					}else if (item.getFieldName().equals("detalhes")) {
						imovel.setDetalhes(item.getString());
					}else if (item.getFieldName().equals("valor")) {
						imovel.setValor(new BigDecimal(item.getString()));
					}else if (item.getFieldName().equals("status")) {
						int idStatus = Integer.valueOf(item.getString());
						SituacaoImovel statusSelecionado = new SituacaoImovelDAO().getById(SituacaoImovel.class,
								idStatus);
						imovel.setStatus(statusSelecionado);
					}else if (item.getFieldName().equals("proprietario")) {
						int idProprietario = Integer.valueOf(item.getString());
						Cliente propSelecionado = new ClienteDAO().getById(Cliente.class, idProprietario);
						imovel.setProprietario(propSelecionado);
					}
				} else {
					nome = new File(item.getName()).getName();
					File imagem = new File(destino, nome);
					item.write(imagem);
					URI foto = ImageService.imageUpload(imagem);
					imovel.setFotos(foto.toString());
				}
			}
			ImovelDAO id = new ImovelDAO();
			id.save(imovel);
			List<Imovel> imoveis = new ImovelDAO().getAll(Imovel.class);
			HttpSession session = req.getSession();
			session.removeAttribute("listaDeImoveis");
			session.setAttribute("listaDeImoveis", imoveis);
			req.setAttribute("imovelCadastrado", "Imóvel Cadastrado com Sucesso!");
			req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("imovelCadastrado", "Ocorreu um erro ao Cadastrar esse imóvel!");
		}
	}

}
