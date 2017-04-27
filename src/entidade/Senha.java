package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Senha {

	@Id
	@GeneratedValue
	@Column(name = "id_senha")
	private int idSenha;

	private String codigo;

	private String status;

	private String tipoSenha;

	private Date data;

	public int getIdSenha() {
		return idSenha;
	}

	public void setIdSenha(int idSenha) {
		this.idSenha = idSenha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(String tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
