package dao.action;

import java.util.List;

import entidade.Senha;

public class GenericoDAO {
	
	private GenericoDAO(){}


	public static String totalAtendido() {
		SenhaDAO senhadao = new SenhaDAO();
		// seta o total de cliente atendido do dia
		return String.valueOf(senhadao.totalAtendido()).replace("[", "").replace("]", "");
	}

	public static String totalFila() {
		SenhaDAO senhadao = new SenhaDAO();
		// seta o total de cliente atendido do dia
		return String.valueOf(senhadao.totalFila()).replace("[", "").replace("]", "");
	}

	public static String emAtendimentoP() {
		SenhaDAO senhadao = new SenhaDAO();
		// seta a senha Preferencial em atendimento
		List<Senha> preferencial = senhadao.emAtendimento("PREFERENCIAL");
		for (Senha senha : preferencial) {
			return senha.getCodigo();
		}
		return null;
	}

	public static String emAtendimentoN() {
		SenhaDAO senhadao = new SenhaDAO();
		// seta a senha normal em atendimento
		List<Senha> normal = senhadao.emAtendimento("NORMAL");
		for (Senha senha : normal) {
			return senha.getCodigo();
		}
		return null;
	}
}
