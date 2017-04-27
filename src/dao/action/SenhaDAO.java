package dao.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Senha;
import utils.Arquivos;

public class SenhaDAO {

	EntityManagerFactory fac;
	EntityManager em;
	Arquivos arq = new Arquivos();

	public SenhaDAO() {
		fac = Persistence.createEntityManagerFactory(Arquivos.getDb());
		em = fac.createEntityManager();
	}

	public void cadastrarSenhas(Senha senha) {

		Senha pass = new Senha();
		pass.setCodigo(senha.getCodigo());
		pass.setData(senha.getData());
		pass.setIdSenha(senha.getIdSenha());
		pass.setStatus(senha.getStatus());
		pass.setTipoSenha(senha.getTipoSenha());

		em.getTransaction().begin();
		em.merge(pass);
		em.getTransaction().commit();
		fac.close();

	}

	public void editarSenhas(Senha senha) {

		em.getTransaction().begin();
		em.merge(senha);
		em.getTransaction().commit();
		fac.close();

	}

	@SuppressWarnings("unchecked")
	public List<Senha> totalFila() {
		em.getTransaction().begin();

		String sql = "SELECT count(*) FROM Senha WHERE status='Em Espera' AND data>='" + arq.dataInicio() + "'"
				+ " AND data <='" + arq.dataFim() + "'";
		Query query = em.createQuery(sql);
		List<Senha> senha = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return senha;
	}

	@SuppressWarnings("unchecked")
	public List<Senha> totalAtendido() {
		em.getTransaction().begin();

		String sql = "SELECT count(*) FROM Senha WHERE status='Em Atendimento' AND data>='" + arq.dataInicio() + "'"
				+ " AND data <='" + arq.dataFim() + "'";
		Query query = em.createQuery(sql);
		List<Senha> senha = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return senha;
	}

	@SuppressWarnings("unchecked")
	public List<Senha> emAtendimento(String tipoSenha) {
		em.getTransaction().begin();

		String sql = "SELECT u FROM Senha u WHERE status='Em Atendimento' AND tipoSenha='" + tipoSenha + "' "
				+ "AND data>='" + arq.dataInicio() + "' AND data<='" + arq.dataFim() + "' ORDER BY id_senha DESC";
		Query query = em.createQuery(sql);
		List<Senha> senhas = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return senhas;
	}

	@SuppressWarnings("unchecked")
	public List<Senha> ultimaSenha() {
		em.getTransaction().begin();

		String sql = "SELECT codigo FROM senha ORDER BY codigo desc limit 1";
		Query query = em.createNativeQuery(sql);
		List<Senha> senhas = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return senhas;
	}

	@SuppressWarnings("unchecked")
	public List<Senha> ultimaId() {
		em.getTransaction().begin();

		String sql = "SELECT id_senha FROM senha ORDER BY id_senha desc limit 1";
		Query query = em.createNativeQuery(sql);
		List<Senha> senhas = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return senhas;
	}

	@SuppressWarnings("unchecked")
	public List<Senha> ultimaIdSenha(String parametro) {
		em.getTransaction().begin();

		String sql = "SELECT " + parametro
				+ " FROM senha WHERE status='Em Espera' ORDER BY tiposenha DESC, codigo ASC, id_senha DESC limit 1";
		Query query = em.createNativeQuery(sql);
		List<Senha> senhas = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return senhas;
	}

	@SuppressWarnings("unchecked")
	public List<Senha> senhaStatus(Senha senha) {
		em.getTransaction().begin();

		String sql = "SELECT id_senha FROM senha WHERE codigo='" + senha.getCodigo() + "'";
		Query query = em.createNativeQuery(sql);
		List<Senha> senhas = query.getResultList();
		em.getTransaction().commit();
		fac.close();

		return senhas;
	}

}
