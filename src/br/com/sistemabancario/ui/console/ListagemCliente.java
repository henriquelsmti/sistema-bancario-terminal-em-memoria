package br.com.sistemabancario.ui.console;

import br.com.sistemabancario.dominio.Cliente;
import br.com.sistemabancario.rn.ClienteRN;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ListagemCliente implements Runnable {

	private ClienteRN clienteRN = new ClienteRN();

	@Override
	public void run() {
		List<Cliente> clientes;
		try {
			clientes = clienteRN.listAll();
		} catch (Exception e) {
			System.out.println("Erro ao listar clientes:" + e.getMessage());
			return;
		}
		System.out.println("________________________________________________________________________");
		System.out.println("|     ID|Nome               |CPF           |Tipo Conta     |      Saldo|");
		for (Cliente cliente : clientes) {
			System.out.print("|");
			String id = Long.toString(cliente.getId());
			System.out.print(StringUtils.leftPad(id, 7));
			System.out.print("|");
			String nome = StringUtils.truncate(cliente.getNome(), 19);
			System.out.print(StringUtils.rightPad(nome, 15));
			System.out.print("|");
			String cpf = StringUtils.truncate(cliente.getCpf(), 14);
			System.out.print(StringUtils.rightPad(cpf, 14));
			System.out.print("|");
			System.out.print(StringUtils.rightPad(cliente.getConta().getClass().getSimpleName(), 15));
			System.out.print("|");
			System.out.print(StringUtils.leftPad(Double.toString(cliente.getConta().getSaldo()), 11));
			System.out.println("|");
		}
		System.out.println("------------------------------------------------------------------------");
	}
}
