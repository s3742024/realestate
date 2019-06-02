package br.com.realstate.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Imovel implements BaseEntity{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private String detalhes;
	private BigDecimal valor;
	private String fotos;
	@ManyToOne
	private SituacaoImovel status;
	@ManyToOne
	private Cliente proprietario;
	
	public Imovel() {}
	
	public Imovel(String descricao, String detalhes, BigDecimal valor, SituacaoImovel status, Cliente proprietario, String imagem) {
		this.setDetalhes(detalhes);
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setStatus(status);
		this.setProprietario(proprietario);
		this.setFotos(imagem);
	}
	public Imovel(int id, String descricao, String detalhes, BigDecimal valor, SituacaoImovel status, Cliente proprietario, String imagem) {
		this.setId(id);
		this.setDescricao(descricao);
		this.setDetalhes(detalhes);
		this.setValor(valor);
		this.setStatus(status);
		this.setProprietario(proprietario);
		this.setFotos(imagem);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getFotos() {
		return fotos;
	}
	public void setFotos(String fotos) {
		this.fotos = fotos;
	}
	public SituacaoImovel getStatus() {
		return status;
	}
	public void setStatus(SituacaoImovel status) {
		this.status = status;
	}
	public Cliente getProprietario() {
		return proprietario;
	}
	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}	

}
