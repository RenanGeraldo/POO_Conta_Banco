package aula05;

import java.util.Objects;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual() {
        System.out.println("------------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status da conta: " + this.getStatus());
    }

    public void abrirConta(String tipo) {
        this.setTipo(tipo);
        this.setStatus(true);
        if (Objects.equals(tipo, "Conta Corrente")) {
            this.setSaldo(2);
        } else if (Objects.equals(tipo, "Conta Poupança")) {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta não pode ser fechada porque ainda tem dinheiro");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta não pode ser fechada pois tem débito.");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float valor) {
        if (this.getStatus()) {
            this.setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado na conta de " + this.getDono() + ".");
        } else {
            System.out.println("Impossivel depósitar em uma conta fechada!");
        }
    }

    public void sacar(float valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(getSaldo() - valor);
                System.out.println("Saque realizado na conta de " + this.getDono() + ".");
            } else {
                System.out.println("Saldo insuficiente par saque");
            }
        } else {
            System.out.println("Imposivel sacar de uma conta fechada!");
        }
    }

    public void pagarMensal() {
        int valor = 0;
        if (Objects.equals(this.getTipo(), "Conta Corrente")) {
            valor = 20;
        } else if (Objects.equals(this.getTipo(), "Conta Poupança")) {
            valor = 30;
        }
        if (this.getSaldo() >= valor) {
            this.setSaldo(getSaldo() - valor);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono() + ".");
        } else if (getSaldo() < valor) {
            System.out.println(this.getDono() + " Não tem saldo para pagar a mensalidade");
        }
    }

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int numero) {
        this.numConta = numero;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String d) {
        this.dono = d;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    private boolean getStatus() {
        return status;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }
}
