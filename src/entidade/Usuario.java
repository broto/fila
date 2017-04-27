package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private int idUsuario;

	@Column(name = "senha")
	private String senha;

	private String user;

	private int fkPessoa;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getFkPessoa() {
		return fkPessoa;
	}

	public void setFkPessoa(int fkPessoa) {
		this.fkPessoa = fkPessoa;
	}

	public String getUsuario() {
		return user;
	}

	public void setUsuario(String user) {
		this.user = user;
	}
}
