package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import entidade.Cliente;

public class ClienteTeste {

	@Test
	public void testSetNome() {
		Cliente user = new Cliente();
		user.setNome("Anaclaudia");
		assertEquals(user.getNome(), "Anaclaudia");
	}

	@Test
	public void testSetFkPessoa() {
		Cliente user = new Cliente();
		user.setFkPessoa(1);
		assertEquals(user.getFkPessoa(), 1);
	}

	@Test
	public void testSetIdCliente() {
		Cliente user = new Cliente();
		user.setIdCliente(2);
		assertEquals(user.getIdCliente(), 2);
	}

	@Test
	public void testSetFkSenha() {
		Cliente user = new Cliente();
		user.setFkSenha(3);
		assertEquals(user.getFkSenha(), 3);
	}

}
