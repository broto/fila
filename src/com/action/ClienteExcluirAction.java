package com.action;

import java.util.Date;

import javax.inject.Inject;

import dao.action.SenhaDAO;
import entidade.Senha;

public class ClienteExcluirAction {
	private String nome;
	
	@Inject
	SenhaDAO dao;
	@Inject
	Senha senha;

	public String execute() {
		
		senha.setCodigo(nome);
		senha.setIdSenha(Integer.valueOf(String.valueOf(dao.senhaStatus(senha)).replace("[", "").replace("]","")));
		senha.setStatus("Finalizado");
		
		senha.setData(new Date());
		senha.setTipoSenha(String.valueOf(dao.ultimaIdSenha("tipoSenha")).replace("[", "").replace("]", ""));
		
		dao.editarSenhas(senha);

		return "ok";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
