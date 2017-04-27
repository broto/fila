package com.action;

import java.util.List;

import javax.inject.Inject;

import dao.action.ClienteDAO;
import dao.action.GenericoDAO;
import entidade.Cliente;

public class DashboardAction {
	private List<Cliente> lista;

	private String totalAtendido;
	private String senhaPreferencial;
	private String senhaNormal;
	private String totalFila;
	
	@Inject
	ClienteDAO dao;

	public String execute() {
		

		List<Cliente> clientes = dao.listarTodos();

		lista = clientes;

		senhaNormal = GenericoDAO.emAtendimentoN();
		senhaPreferencial = GenericoDAO.emAtendimentoP();
		totalAtendido = GenericoDAO.totalAtendido();
		totalFila = GenericoDAO.totalFila();

		return "ok";
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

	public String getTotalFila() {
		return totalFila;
	}

	public void setTotalFila(String totalFila) {
		this.totalFila = totalFila;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

}
