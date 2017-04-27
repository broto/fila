package com.action;

import java.util.List;

import javax.inject.Inject;

import dao.action.ClienteDAO;
import entidade.Cliente;

public class ClienteConsultaAction {
	private List<Cliente> lista;
	private String nome;
	
	@Inject
	ClienteDAO dao;

	public String execute() {
		

			List<Cliente> clientes = dao.listarClienteNome(nome);
			lista = clientes;
		
		return "ok";
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
