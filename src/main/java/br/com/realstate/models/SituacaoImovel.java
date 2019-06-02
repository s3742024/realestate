package br.com.realstate.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SituacaoImovel implements BaseEntity{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	@OneToMany(mappedBy="status")
	private List<Imovel> imoveis;

	public SituacaoImovel() {}

	public SituacaoImovel(String descricao) {
		this.descricao = descricao;
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
}
