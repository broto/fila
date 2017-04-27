package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	@Column(name = "id_cliente")
	private int idCliente;

	private int fkPessoa;

	private int fkSenha;
	@Transient
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public int getFkPessoa() {
		return fkPessoa;
	}

	public void setFkPessoa(int fkPessoa) {
		this.fkPessoa = fkPessoa;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getFkSenha() {
		return fkSenha;
	}

	public void setFkSenha(int fkSenha) {
		this.fkSenha = fkSenha;
	}

}
