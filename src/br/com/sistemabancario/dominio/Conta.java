package br.com.sistemabancario.dominio;

import java.time.LocalDate;
import java.util.Date;

public abstract class Conta {
    private double saldo;
    private LocalDate ultimaCorrecao;

    public abstract void retirar(double valor) throws Exception ;

    public abstract void depositar(double valor);

    public abstract void corrigirValorMonetario();

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getUltimaCorrecao() {
        return ultimaCorrecao;
    }

    protected void setUltimaCorrecao(LocalDate ultimaCorrecao) {
        this.ultimaCorrecao = ultimaCorrecao;
    }
}
