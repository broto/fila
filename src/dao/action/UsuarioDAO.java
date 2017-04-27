package dao.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Usuario;
import utils.Arquivos;

public class UsuarioDAO {

	EntityManagerFactory fac;
	EntityManager em;
	Arquivos arq = new Arquivos();

	public UsuarioDAO() {

		fac = Persistence.createEntityManagerFactory(Arquivos.getDb());
		em = fac.createEntityManager();

	}

	public void cadastrarUsuarios(Usuario usuario) {

		Usuario cli = new Usuario();

		cli.setFkPessoa(usuario.getFkPessoa());
		cli.setSenha(usuario.getSenha());
		cli.setUsuario(usuario.getUsuario());

		em.getTransaction().begin();
		em.merge(cli);
		em.getTransaction().commit();
		fac.close();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> logar(Usuario user) {
		em.getTransaction().begin();

		String sql = "SELECT u FROM Usuario u WHERE usuario='" + user.getUsuario() + "' and senha='" + user.getSenha()
				+ "'";
		Query query = em.createQuery(sql);
		List<Usuario> usuarios = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return usuarios;
	}

}
