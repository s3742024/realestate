package br.com.realstate.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario implements BaseEntity{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String senha;
	private String email;
	@ManyToOne
	private Cargo cargo;
	
	public Usuario() {}
	
	public Usuario(String nome, String senha, String email, Cargo cargo) {
		this.setNome(nome);
		this.setSenha(senha);
		this.setEmail(email);
		this.setCargo(cargo);
	}
	
	public Usuario(int id, String nome, String senha, String email, Cargo cargo) {
		this.setId(id);
		this.setNome(nome);
		this.setSenha(senha);
		this.setEmail(email);
		this.setCargo(cargo);
	}
	
	public String encriptaSenha(String senha) throws NoSuchAlgorithmException {
		
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(senha.getBytes());
        byte[] hash = md.digest();
        StringBuffer senhaEncrip = new StringBuffer();
        for (int i=0;i<hash.length;i++)
        {
            senhaEncrip.append(Integer.toHexString(hash[i]&0xff));
        }
        return senhaEncrip.toString();
	}
	
	public boolean validaSenha(String senha, String confirma) {
		
		return senha.equals(confirma);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
