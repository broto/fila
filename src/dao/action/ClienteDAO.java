package dao.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Cliente;
import utils.Arquivos;

public class ClienteDAO {
	static final String SELECT_ATRIBUTOS = "SELECT p.nome , p.cpf , s.codigo , s.status , s.tipoSenha, e.bairro , e.cidade, e.uf, e.cep";
	static final String JOIN_ENDERECO_SENHA = "JOIN senha s on c.fkSenha = s.id_senha JOIN endereco e on p.fk_endereco = e.id_endereco";
	EntityManagerFactory fac;
	EntityManager em;
	Arquivos arq = new Arquivos();

	public ClienteDAO() {
		fac = Persistence.createEntityManagerFactory(Arquivos.getDb());
		em = fac.createEntityManager();
	}

	public void cadastrarClientes(Cliente cliente) {

		Cliente cli = new Cliente();

		cli.setFkPessoa(cliente.getFkPessoa());
		cli.setFkSenha(cliente.getFkSenha());

		em.getTransaction().begin();
		em.merge(cli);
		em.getTransaction().commit();
		fac.close();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos() {
		em.getTransaction().begin();

		String sql = SELECT_ATRIBUTOS
				+ " FROM cliente as c JOIN pessoa as p on c.fkPessoa = p.id_pessoa "
				+ JOIN_ENDERECO_SENHA
				+ "WHERE s.status='Em Espera' "		
				+ "ORDER BY s.tipoSenha DESC, s.codigo ASC ";
		Query query = em.createNativeQuery(sql);
		List<Cliente> clientes = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return clientes;
	}

	public List<Cliente> listarClienteSenha(String parametro) {
		em.getTransaction().begin();

		String sql = SELECT_ATRIBUTOS
				+ "FROM cliente as c JOIN pessoa as p on c.fkPessoa = p.id_pessoa "
				+ JOIN_ENDERECO_SENHA
				+ "WHERE s.codigo='" + parametro + "'";
		Query query = em.createNativeQuery(sql);
		List<Cliente> clientes = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return clientes;
	}

	public List<Cliente> listarClienteNome(String parametro) {
		em.getTransaction().begin();

		String sql = SELECT_ATRIBUTOS
				+ "FROM cliente as c JOIN pessoa as p on c.fkPessoa = p.id_pessoa "
				+ JOIN_ENDERECO_SENHA
				+ "WHERE p.nome LIKE '%" + parametro + "%' OR s.codigo='" + parametro + "' OR s.tipoSenha='" + parametro
				+ "' OR p.cpf='" + parametro + "'";
		Query query = em.createNativeQuery(sql);
		List<Cliente> clientes = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return clientes;
	}

}
