package com.action;

import java.util.List;

import javax.inject.Inject;

import dao.action.ClienteDAO;
import entidade.Cliente;

public class ListarClienteAction {
	private List<Cliente> lista;

	@Inject
	ClienteDAO dao;

	public String execute() {
		

		List<Cliente> clientes = dao.listarTodos();

		lista = clientes;

		return "ok";
	}
	



	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

}
