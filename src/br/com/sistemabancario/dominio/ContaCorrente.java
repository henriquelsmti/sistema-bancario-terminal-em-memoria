package br.com.sistemabancario.dominio;


public class ContaCorrente extends Conta {

	private double limiteChequeEspecial;

	@Override
	public void retirar(double valor) throws Exception {
		double saldoDepois = (getSaldo() - valor);
		if (saldoDepois >= 0 || Math.abs(saldoDepois) <= limiteChequeEspecial) {
			setSaldo(getSaldo() - valor);
		} else {
			throw new Exception("Saldo insuficiente!");
		}
	}

	@Override
	public void depositar(double valor) {
		setSaldo(getSaldo() + valor);
	}

	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}
}