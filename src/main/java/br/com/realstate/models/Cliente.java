package br.com.realstate.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements BaseEntity{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String endereco;
	private String contato;
	@OneToMany(mappedBy="proprietario")
	private List<Imovel> imoveis;
	
	public Cliente() {}
	
	public Cliente(String nome, String endereco, String contato) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setContato(contato);
	}
	
	public Cliente(int id, String nome, String endereco, String contato) {
		this.setId(id);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setContato(contato);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public List<Imovel> getImoveis() {
		return imoveis;
	}
	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	
}
