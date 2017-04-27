package com.action;

import java.util.List;

import javax.inject.Inject;

import dao.action.GenericoDAO;
import dao.action.UsuarioDAO;
import entidade.Usuario;

public class LoginAction {
	private String usuario;
	private String senha;
	private String totalAtendido;
	private String senhaPreferencial;
	private String senhaNormal;
	private String totalFila;
	
	@Inject
	UsuarioDAO dao;
	@Inject
	Usuario user;

	public String execute() {
		// confere se o login esta correto
		
		user.setUsuario(usuario);
		user.setSenha(senha);
		List<Usuario> cli = dao.logar(user);

		String retorno = "error";

		for (Usuario login : cli) {
			if (usuario.equals(login.getUsuario())) {
				retorno = "sucesso";
			}
		}

		senhaNormal = GenericoDAO.emAtendimentoN();
		senhaPreferencial = GenericoDAO.emAtendimentoP();
		totalAtendido = GenericoDAO.totalAtendido();
		totalFila = GenericoDAO.totalFila();
		
		return retorno;

	}

	public String getTotalFila() {
		return totalFila;
	}

	public void setTotalFila(String totalFila) {
		this.totalFila = totalFila;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTotalAtendido() {
		return totalAtendido;
	}

	public void setTotalAtendido(String totalAtendido) {
		this.totalAtendido = totalAtendido;
	}

	public String getSenhaPreferencial() {
		return senhaPreferencial;
	}

	public void setSenhaPreferencial(String senhaPreferencial) {
		this.senhaPreferencial = senhaPreferencial;
	}

	public String getSenhaNormal() {
		return senhaNormal;
	}

	public void setSenhaNormal(String senhaNormal) {
		this.senhaNormal = senhaNormal;
	}
}
