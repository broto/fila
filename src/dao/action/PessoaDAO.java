package dao.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Pessoa;
import utils.Arquivos;

public class PessoaDAO {

	EntityManagerFactory fac;
	EntityManager em;
	Arquivos arq = new Arquivos();

	public void cadastrarPessoas(Pessoa pessoa) {
		fac = Persistence.createEntityManagerFactory(Arquivos.getDb());
		em = fac.createEntityManager();

		Pessoa cadastro = new Pessoa();
		cadastro.setCpf(pessoa.getCpf());
		cadastro.setFKEndereco(pessoa.getFKEndereco());
		cadastro.setIdPessoa(pessoa.getIdPessoa());
		cadastro.setNome(pessoa.getNome());
		cadastro.setRg(pessoa.getRg());

		em.getTransaction().begin();
		em.merge(cadastro);
		em.getTransaction().commit();
		fac.close();

	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> utimoPessoa() {
		em.getTransaction().begin();

		String sql = "SELECT id_pessoa FROM pessoa ORDER BY id_pessoa desc limit 1";
		Query query = em.createNativeQuery(sql);
		List<Pessoa> pessoas = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return pessoas;
	}

}
