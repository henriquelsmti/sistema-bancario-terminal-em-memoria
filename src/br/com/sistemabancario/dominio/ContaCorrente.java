package br.com.sistemabancario.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaCorrente extends Conta {

    private double valorCesta;
    private double limiteChequeEspecial;
    private double jurosChequeEspecial;

    @Override
    public void retirar(double valor) throws Exception {
        double saldoDepois = getSaldo() - limiteChequeEspecial - valor;
        if (saldoDepois >= 0) {
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
            if (getSaldo() < 0) {
                double juros = (Math.abs(getSaldo()) / 100) * jurosChequeEspecial;
                setSaldo(getSaldo() - juros);
            }
            setSaldo(getSaldo() - valorCesta);
            setUltimaCorrecao(LocalDate.now());
        }
    }
}
