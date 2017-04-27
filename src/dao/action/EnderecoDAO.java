package dao.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Endereco;
import utils.Arquivos;

public class EnderecoDAO {
	EntityManagerFactory fac;
	EntityManager em;
	Arquivos arq = new Arquivos();

	public void cadastrarEnderecos(Endereco endereco) {
		fac = Persistence.createEntityManagerFactory(Arquivos.getDb());
		em = fac.createEntityManager();
		em.getTransaction().begin();
		
		Endereco enderec = new Endereco();
		enderec.setBairro(endereco.getBairro());
		enderec.setCidade(endereco.getCidade());
		enderec.setUf(endereco.getUf());

		em.merge(enderec);
		em.getTransaction().commit();
		fac.close();
	}

	public List listarTodos() {
		fac = Persistence.createEntityManagerFactory(Arquivos.getDb());
		em = fac.createEntityManager();

		String hql = "FROM Endereco endereco";
		Query query = em.createQuery(hql);
		List<Endereco> endereco = (List) query.getResultList();

		em.getTransaction().commit();
		em.close();

		return endereco;
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> utimoEndereco() {
		em.getTransaction().begin();

		String sql = "SELECT id_endereco FROM endereco ORDER BY id_endereco desc limit 1";
		Query query = em.createNativeQuery(sql);
		List<Endereco> enderecos = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return enderecos;
	}

}
