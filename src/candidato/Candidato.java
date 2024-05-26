package candidato;

import java.util.Scanner;

public class Candidato {
    private double salarioBase = 2000.00;
    private double pretensaoSalarial;
    private String nomeCandidato;
    static Scanner scanner = new Scanner(System.in);

    public void analisarPretensaoSalario(double pretensaoSalarial) {
        if (this.salarioBase > pretensaoSalarial) {
            System.out.println("LIGAR PARA O CANDIDATO " + getNomeCandidato().toUpperCase() + "!!!");
        } else if (this.salarioBase == pretensaoSalarial) {
            System.out.println(
                    "LIGAR PARA O CANDIDATO".concat(getNomeCandidato().toUpperCase()).concat("COM CONTRA PROPOSTA"));
        } else {
            System.out.println("AGUARDANDo RESULTADO DEMAIS CANDIDATOS");
        }
    }

    public void cadastrarCandito() {
        int count = 0;
        do {
            if (count > 0) {
                System.out.println("Nome Invalido, informe novamente");
            }
            System.out.println("Qual o Nome completo do candidato:");
            setNomeCandidato(scanner.nextLine());
            count++;
        } while (getNomeCandidato().isEmpty() || getNomeCandidato().startsWith(" "));

        count = 0;
        do {
            if (count > 0) {
                System.out.println("Valor Invalido, informe um valor maior do que ZERO!!");
            }
            System.out.println("Informe a Pretensão salarial do candidato");
            setPretensaoSalarial(scanner.nextDouble());
            scanner.nextLine();
            count++;
        } while (getPretensaoSalarial() <= 0);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String sair = "N";
            boolean valido = true;
            do {
                System.out.println("\n" + i + " - Deseja sair do Sistema? \nS = para sair. \nN = para continuar.");
                sair = scanner.nextLine().toUpperCase();
                valido = sair.startsWith("S") || sair.startsWith("N");
            } while (!valido);
            if (sair.startsWith("S")) {
                i = 10;
                System.out.println("System fechado com sucesso");
                scanner.close();
            } else {
                Candidato can = new Candidato();
                can.cadastrarCandito();
                can.analisarPretensaoSalario(can.getPretensaoSalarial());
            }
        }
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setPretensaoSalarial(double pretensaoSalarial) {
        this.pretensaoSalarial = pretensaoSalarial;
    }

    public double getPretensaoSalarial() {
        return pretensaoSalarial;
    }

}
