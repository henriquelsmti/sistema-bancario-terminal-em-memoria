package br.com.sistemabancario.dominio;

public abstract class Conta {
	private double saldo;

	public abstract void retirar(double valor) throws Exception;

	public abstract void depositar(double valor);

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
