package com.action;

import java.util.Date;

import javax.inject.Inject;

import dao.action.SenhaDAO;
import entidade.Senha;


public class AtenderFilaAction {
	@Inject
	SenhaDAO dao;
	@Inject
	Senha senha;
	
	public String execute() {

		senha.setIdSenha(Integer.valueOf(String.valueOf(dao.ultimaIdSenha("id_senha")).replace("[", "").replace("]", "")));
		senha.setCodigo(String.valueOf(dao.ultimaIdSenha("codigo")).replace("[", "").replace("]", ""));
		senha.setData(new Date());
		senha.setTipoSenha(String.valueOf(dao.ultimaIdSenha("tipoSenha")).replace("[", "").replace("]", ""));
		senha.setStatus("Em Atendimento");
		dao.editarSenhas(senha);

		return "ok";
	}
}
