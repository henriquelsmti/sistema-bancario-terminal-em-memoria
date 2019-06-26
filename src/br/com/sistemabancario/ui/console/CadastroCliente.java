package br.com.sistemabancario.ui.console;

import br.com.sistemabancario.dominio.Cliente;
import br.com.sistemabancario.rn.ClienteRN;

import java.util.Scanner;

public class CadastroCliente implements Runnable {

	private ClienteRN clienteRN = new ClienteRN();
	private EdicaoCliente edicaoCliente = new EdicaoCliente();
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void run() {
		boolean sair = false;
		do {
			ConsoleUtil.clearScreen();
			ListagemCliente listagemCliente = new ListagemCliente();
			listagemCliente.run();
			System.out.println("| V para voltar | N para novo | E {id} para editar | R {id} para remover");
			System.out.print("Digite a opção desejada:");

			String opcaoDigitada = scanner.nextLine();


			if (opcaoDigitada.equalsIgnoreCase("V")) {
				sair = true;
			} else if (opcaoDigitada.equalsIgnoreCase("N")) {
				edicaoCliente.edite(new Cliente());
			} else if (opcaoDigitada.toUpperCase().startsWith("E ")) {
				editarCliente(opcaoDigitada);
			} else if (opcaoDigitada.toUpperCase().startsWith("R ")) {
				removerCliente(opcaoDigitada);
			} else {
				ConsoleUtil.clearScreen();
				ConsoleUtil.printOpcaoInvalida();
			}

		} while (!sair);
	}

	private void removerCliente(String opcaoDigitada) {
		try {
			String[] partes = opcaoDigitada.split(" ");
			long id = Long.valueOf(partes[1]);
			clienteRN.remover(id);
		} catch (NumberFormatException e) {
			ConsoleUtil.printOpcaoInvalida();
		} catch (Exception e) {
			System.out.println("Erro ao remover o cliente: " + e.getMessage());
			ConsoleUtil.aguardeUsuario();
		}
	}

	private void editarCliente(String opcaoDigitada) {
		try {
			String[] partes = opcaoDigitada.split(" ");
			long id = Long.valueOf(partes[1]);
			Cliente cliente = clienteRN.getClientePorId(id);
			edicaoCliente.edite(cliente);
		} catch (NumberFormatException e) {
			ConsoleUtil.printOpcaoInvalida();
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Erro ao editar o cliente: " + e.getMessage());
			ConsoleUtil.aguardeUsuario();
		}
	}

}
