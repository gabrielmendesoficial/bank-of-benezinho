package br.com.bankofbenezinho.model;

import br.com.bankofbenezinho.model.Conta;

public class ContaPoupanca extends Conta {

    private int aniversario;

    public ContaPoupanca() {
    }

    public ContaPoupanca(String numero, double saldo, Agencia agencia, int aniversario) {
        super(numero, saldo, agencia);
        this.aniversario = aniversario;
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "aniversario=" + aniversario +
                "} " + super.toString();
    }
}
