package br.com.sistemabancario.ui.console;

public class ConsoleUtil {

	public static void clearScreen() {

		if (System.console() == null) {
			for (int i = 0; i < 50; i++){
				System.out.println();
			}
		} else {
			try {
				final String os = System.getProperty("os.name");

				if (os.contains("Windows")) {
					Runtime.getRuntime().exec("cls");
				} else {
					Runtime.getRuntime().exec("clear");
				}
			} catch (final Exception e) {
				System.out.println("ops");
			}
		}
	}

	public static void printOpcaoInvalida() {
		System.out.println("Opção invalida!");
		System.out.println("Presione qualquer tecla para continuar...");
	}
}
