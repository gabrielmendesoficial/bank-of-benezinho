import br.com.bankofbenezinho.model.Agencia;
import br.com.bankofbenezinho.model.Banco;
import br.com.bankofbenezinho.model.ContaCorrente;
import br.com.bankofbenezinho.model.ContaPoupanca;
import br.com.bankofbenezinho.pessoa.Pessoa;
import br.com.bankofbenezinho.pessoa.PessoaFisica;
import br.com.bankofbenezinho.pessoa.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.MonthDay;

public class Main {

    public static ContaPoupanca novaContaPoupanca(Agencia agencia, Pessoa titular, MonthDay dia) {
        ContaPoupanca cp = new ContaPoupanca();
        cp.setAniversario(dia.getDayOfMonth());
        cp.setAgencia(agencia);
        cp.setTitular(titular);
        agencia.addConta(cp);
        return cp;
    }

    public static PessoaFisica novaPessoa(String nome, LocalDate nascimento, String CPF, PessoaFisica mae) {
        PessoaFisica pf = new PessoaFisica();
        pf.setCPF(CPF);
        pf.setNascimento(nascimento);
        pf.setNome(nome);
        pf.setMae(mae);
        return pf;
    }

    public static Agencia novaAgencia(String nome, Banco banco) {
        Agencia agencia = new Agencia();
        agencia.setNome(nome);
        banco.addAgencia(agencia);
        return agencia;
    }

    public static ContaCorrente novaContaCorrente(Agencia agencia, Pessoa titular, double limite) {
        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(agencia);
        cc.setTitular(titular);
        cc.setLimite(limite);
        agencia.addConta(cc);
        return cc;
    }


    public static PessoaJuridica novaPessoaJuridica(String nomeFantasia, String razaoSocial, String CNPJ, LocalDate fundacao){
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCNPJ(CNPJ);
        pj.setNascimento(fundacao);
        pj.setNome(nomeFantasia);
        pj.setRazaoSocial(razaoSocial);
        return pj;
    }

    public static void main(String[] args) {

        Banco gabriel = new Banco("GabBenezinho Bank and Bar");
        Agencia bahamas = novaAgencia("Bahamas", gabriel);
        PessoaFisica mae = novaPessoa("Maria Cirillo", LocalDate.of(2077, 10, 9), "457234772-60", null);
        PessoaFisica biel = novaPessoa("Gabriel Parducci", LocalDate.of(2077, 3, 8), "213246546-50", mae);
        ContaCorrente cc = novaContaCorrente(bahamas, biel, 4000);
        ContaPoupanca cp = novaContaPoupanca(bahamas, mae, MonthDay.now());

        PessoaJuridica holding = novaPessoaJuridica(
                "Cirillo Parducci Company",
                "CPC AWORLD LTDA",
                "862345345/0027-10",
                LocalDate.of(1988, 10, 5)
        );

        PessoaFisica lucca = novaPessoa(
                "Julia",
                LocalDate.of(2004, 8, 19),
                "34567809123",
                mae);


        holding.addSocio(biel).addSocio(mae).addSocio(lucca);

        ContaCorrente ccH = novaContaCorrente(bahamas, holding, 500);



        int continua = 0;
        System.out.println("SALDO ANTERIOR: " + ccH.getSaldo());
        System.out.println("Limite: " + ccH.getLimite());
        System.out.println("Disponível: " + (ccH.getSaldo() + ccH.getLimite()));

        do {

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar"));
            boolean saquei = ccH.sacar(valor);

            if (saquei) {
                System.out.println("Saque efetuado com sucesso!");
            } else {
                System.out.println("Erro no saque");
            }

            String texto = """
                    Deseja realizar um novo saque?
                    [1] SIM
                    [2] NÃO
                    """;
            continua = Integer.parseInt(JOptionPane.showInputDialog(texto));

        } while (continua == 1);

        System.out.println("SALDO ANTERIOR: " + ccH.getSaldo());
        System.out.println("Limite: " + ccH.getLimite());
        System.out.println("Disponível: " + (ccH.getSaldo() + ccH.getLimite()));

    }
}