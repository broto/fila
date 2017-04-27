package com.action;

import javax.inject.Inject;

import dao.action.EnderecoDAO;
import entidade.Endereco;

public class CadastrarEnderecoAction {

	private String bairro; 
	private String cidade; 
	private String uf;
	
	@Inject
	EnderecoDAO enderecodao;

	public String execute() {

		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setUf(uf);
		enderecodao.cadastrarEnderecos(endereco);

		bairro = endereco.getBairro();
		cidade = endereco.getCidade();
		uf = endereco.getUf();
		return "ok";
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
