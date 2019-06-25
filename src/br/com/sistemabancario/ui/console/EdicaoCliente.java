package br.com.sistemabancario.ui.console;

import br.com.sistemabancario.dominio.Cliente;
import br.com.sistemabancario.dominio.ContaCorrente;
import br.com.sistemabancario.dominio.ContaPoupanca;
import br.com.sistemabancario.rn.ClienteRN;

import java.util.Scanner;

public class EdicaoCliente {

	private ClienteRN clienteRN = new ClienteRN();

	public void edite(Cliente cliente) {
		ConsoleUtil.clearScreen();
		boolean sair;
		Scanner scanner = new Scanner(System.in);
		do {
			lerNome(cliente, scanner);
			lerCpf(cliente, scanner);
			if (cliente.getId() == 0) {
				lerTipoDeConta(cliente, scanner);
			}
			sair = salvarRegistro(cliente);
		} while (!sair);
	}

	private boolean salvarRegistro(Cliente cliente) {
		boolean sair;
		try {
			clienteRN.salve(cliente);
			sair = true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar o cliente: " + e.getMessage());
			sair = false;
		}
		return sair;
	}

	private void lerTipoDeConta(Cliente cliente, Scanner scanner) {
		boolean invalido;
		do {
			System.out.println("É conta corrente(S/N)?");
			String resposta = scanner.nextLine().toUpperCase();
			if (!resposta.equals("S") && !resposta.equals("N")) {
				invalido = true;
				System.out.println("Opção invalida!");
			} else {
				invalido = false;
				if (resposta.equals("S")) {
					cliente.setConta(new ContaCorrente());
				} else {
					cliente.setConta(new ContaPoupanca());
				}
			}
		} while (invalido);
	}

	private void lerCpf(Cliente cliente, Scanner scanner) {
		System.out.println("Digite o CPF:");
		printValorAnterior(cliente.getId(), cliente.getCpf());
		String cpf = scanner.nextLine();
		if (!cpf.isBlank()) {
			cliente.setCpf(cpf);
		}
	}

	private void lerNome(Cliente cliente, Scanner scanner) {
		System.out.println("Digite o nome:");
		printValorAnterior(cliente.getId(), cliente.getNome());
		String nome = scanner.nextLine();
		if (!nome.isBlank()) {
			cliente.setNome(nome);
		}
	}

	private void printValorAnterior(long id, String valor) {
		if (id != 0) {
			System.out.println("Presione enter para manter: " + valor);
		}
	}
}
