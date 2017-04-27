package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name = "id_pessoa")
	private int idPessoa;

	private String nome;

	private String cpf;

	private String rg;

	@Column(name = "FK_Endereco")
	private int fkEndereco;

	public int getFKEndereco() {
		return fkEndereco;
	}

	public void setFKEndereco(int fKEndereco) {
		fkEndereco = fKEndereco;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
