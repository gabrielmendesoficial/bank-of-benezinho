package br.com.bankofbenezinho.model;


import br.com.bankofbenezinho.pessoa.Pessoa;

import java.util.Collection;
import java.util.Vector;

public abstract class Conta {

    private String numero;

    private double saldo;

    private Agencia agencia;

    private Collection<Pessoa> titulares = new Vector<>();


    public Conta() {
    }

    public Conta(String numero, double saldo, Agencia agencia) {
        this.setNumero(numero);
        this.setSaldo(saldo);
        this.setAgencia(agencia);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + getNumero() + '\'' +
                ", saldo=" + getSaldo() +
                ", agencia=" + getAgencia() +
                '}';
    }

    public Collection<Pessoa> getTitulares() {
        return titulares;
    }

    public void setTitulares(Collection<Pessoa> titulares) {
        this.titulares = titulares;
    }

    public void setTitular(Pessoa titular) {
    }
}
