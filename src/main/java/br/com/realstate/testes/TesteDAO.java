package br.com.realstate.testes;

import br.com.realstate.dao.CargoDAO;
import br.com.realstate.dao.ClienteDAO;
import br.com.realstate.dao.UsuarioDAO;
import br.com.realstate.models.Cargo;
import br.com.realstate.models.Cliente;
import br.com.realstate.models.Usuario;

public class TesteDAO {
	
	public static void main(String[] args) throws Exception {

//		Cliente cliente = new Cliente("nome", "endereco", "contato");
//
//		ClienteDAO c = new ClienteDAO();
//
//		c.save(cliente);

		Cargo cargo = new Cargo("Administrador");

		CargoDAO cd = new CargoDAO();

		cd.save(cargo);


//		Cliente usu = c.getCliente("nome");
//
//		System.out.printf(usu.getNome());
		
		
		
	}

}
