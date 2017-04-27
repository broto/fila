package com.action;

import javax.inject.Inject;

import dao.action.EnderecoDAO;
import dao.action.PessoaDAO;
import dao.action.UsuarioDAO;
import entidade.Endereco;
import entidade.Pessoa;
import entidade.Usuario;

public class CadastrarUsuarioAction {
	private String nome;
	private String cpf;
	private String rg;
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;
	private String senha;
	private String usuario;
	private String confirmasenha;

	@Inject
	PessoaDAO pessoaDAO;
	@Inject
	EnderecoDAO enderecoDAO;
	@Inject
	UsuarioDAO usuariodao;

	@Inject
	Endereco endereco;
	@Inject
	Pessoa pessoa;
	@Inject
	Usuario user;
	
	
	
	public String execute() {

		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setUf(uf);
		
		enderecoDAO.cadastrarEnderecos(endereco);

		pessoa.setCpf(cpf);
		pessoa.setFKEndereco(endereco.getIdEndereco());
		pessoa.setNome(nome);
		pessoa.setRg(rg);
		pessoaDAO.cadastrarPessoas(pessoa);

		user.setFkPessoa(pessoa.getIdPessoa());
		user.setSenha(senha);
		user.setUsuario(cpf);
		usuariodao.cadastrarUsuarios(user);

		return "ok";

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmasenha() {
		return confirmasenha;
	}

	public void setConfirmasenha(String confirmasenha) {
		this.confirmasenha = confirmasenha;
	}
}
