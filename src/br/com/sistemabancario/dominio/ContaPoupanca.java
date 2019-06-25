package br.com.sistemabancario.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {

	private double percentualRendimento;

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

	@Override
	public void corrigirValorMonetario() {
		LocalDate hoje = LocalDate.now();
		long quantidadeDeDias = ChronoUnit.DAYS.between(hoje, getUltimaCorrecao());
		if (quantidadeDeDias >= 30) {
			double valor = getSaldo();
			double rendimento = (valor / 100) * percentualRendimento;
			setSaldo(valor + rendimento);
			setUltimaCorrecao(LocalDate.now());
		}
	}
}
