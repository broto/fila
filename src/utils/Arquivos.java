package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Arquivos {
	
	private static final String DB = "TesteBanco";

	

	public static String getDb() {
		return DB;
	}

	public String dataInicio() {
		Date data = new Date();
		SimpleDateFormat inicio = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return inicio.format(data);
	}

	public String dataFim() {
		Date data = new Date();
		SimpleDateFormat fim = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		return fim.format(data);
	}

}
