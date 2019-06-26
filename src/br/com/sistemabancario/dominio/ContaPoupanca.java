package br.com.sistemabancario.dominio;


public class ContaPoupanca extends Conta {

	@Override
	public void retirar(double valor) throws Exception {
		if (getSaldo() - valor >= 0) {
			setSaldo(getSaldo() - valor);
		} else {
			throw new Exception("Saldo insuficiente!");
		}
	}

	@Override
	public void depositar(double valor) {
		setSaldo(getSaldo() + valor);
	}

}
