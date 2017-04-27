package com.action;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import dao.action.ClienteDAO;
import dao.action.EnderecoDAO;
import dao.action.PessoaDAO;
import dao.action.SenhaDAO;
import entidade.Cliente;
import entidade.Endereco;
import entidade.Pessoa;
import entidade.Senha;

public class CadastrarClienteAction {
	private String nome;
	private String cpf;
	private String rg;
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;
	private String tipoSenha;
	private String codigo;
	private List<Cliente> lista;
	
	@Inject
	EnderecoDAO enderecodao;
	@Inject
	PessoaDAO pessoadao;
	@Inject
	SenhaDAO senhadao;
	@Inject
	ClienteDAO clientedao;

	public String execute() {



		Senha senha = new Senha();
		Endereco endereco = new Endereco();
		Pessoa pessoa = new Pessoa();
		Cliente cliente = new Cliente();

		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setUf(uf);
		enderecodao.cadastrarEnderecos(endereco);

		pessoa.setCpf(cpf);
		int enderec = Integer.valueOf(String.valueOf(enderecodao.utimoEndereco()).replace("[", "").replace("]", ""));
		pessoa.setFKEndereco(enderec);
		pessoa.setNome(nome);
		pessoa.setRg(rg);
		pessoadao.cadastrarPessoas(pessoa);

		codigo = String.valueOf(senhadao.ultimaSenha()).replace("[", "").replace("]", "");
		senha.setCodigo(String.valueOf(Integer.valueOf(codigo)+1));
		senha.setData(new Date());
		senha.setStatus("Em Espera");
		senha.setTipoSenha(tipoSenha);
		senhadao.cadastrarSenhas(senha);

		int upessoa = Integer.valueOf(String.valueOf(pessoadao.utimoPessoa()).replace("[", "").replace("]", ""));
		int x = upessoa +1;

		cliente.setFkPessoa(x-1);
		cliente.setFkSenha(x-1);
		clientedao.cadastrarClientes(cliente);

		ClienteDAO dao = new ClienteDAO();

		List<Cliente> clis = dao.listarTodos();

		lista = clis;
		return "ok";

	}

	public String getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(String tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

}
