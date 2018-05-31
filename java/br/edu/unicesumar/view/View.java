package br.edu.unicesumar.view;

import java.util.List;
import java.util.Scanner;
import br.edu.unicesumar.model.*;
import br.edu.unicesumar.session.VeiculoSession;
import br.edu.unicesumar.tela.Tela;

public class View {
    private Scanner scan;
    private VeiculoSession session;
    private Tela tl;

    public View() {
        scan = new Scanner(System.in);
        session = new VeiculoSession();
        tl = new Tela();
    }

    public void carregarAutomovel() {
        Veiculo a = carregarVeiculo();

        System.out.print("Portas: ");
        int portas = scan.nextInt();
        System.out.print("Cavalos");
        int cavalos = scan.nextInt();

        Veiculo b = new Automovel(a.getChassi(), a.getPlaca(), a.getModelo(), a.getAno(), portas, cavalos);

        System.out.println("----------Automovel----------");
        System.out.println("Chassi: " + b.getChassi());
        System.out.println("Placa: " + b.getPlaca());
        System.out.println("Modelo: " + b.getModelo());
        System.out.println("Modelo: " + b.getAno());
        System.out.println("Portas: " + ((Automovel) b).getPortas());
        System.out.println("Cavalos: " + ((Automovel) b).getCavalos());

        if(tl.menuConfirmar() == true)
            session.inserirAutomovel(b);
        else
            System.out.println("Operacao cancelada");
    }

    public void carregarCaminhao() {
        Veiculo a = carregarVeiculo();

        System.out.print("Peso suportado: ");
        int peso = scan.nextInt();
        System.out.print("Tipo de carga: ");
        String tipo = scan.next();

        Veiculo b = new Caminhao(a.getChassi(), a.getPlaca(), a.getModelo(), a.getAno(), peso, tipo);

        System.out.println("----------Caminhão----------");
        System.out.println("Chassi: " + b.getChassi());
        System.out.println("Placa: " + b.getPlaca());
        System.out.println("Modelo: " + b.getModelo());
        System.out.println("Modelo: " + b.getAno());
        System.out.println("Peso suportado: " + ((Caminhao) b).getPeso());
        System.out.println("Tipo: " + ((Caminhao) b).getTipo());

        if(tl.menuConfirmar() == true)
            session.inserirCaminhao(b);
        else
            System.out.println("Operacao cancelada");
    }

    public void carregarMotocicleta() {
        Veiculo a = carregarVeiculo();

        System.out.print("Cilindradas: ");
        int cilindradas = scan.nextInt();

        Veiculo b = new Motocicleta(a.getChassi(), a.getPlaca(), a.getModelo(), a.getAno(), cilindradas);

        System.out.println("----------Motocicleta----------");
        System.out.println("Chassi: " + b.getChassi());
        System.out.println("Placa: " + b.getPlaca());
        System.out.println("Modelo: " + b.getModelo());
        System.out.println("Modelo: " + b.getAno());
        System.out.println("Cilindrada: " + ((Motocicleta) b).getCilindrada());

        if(tl.menuConfirmar() == true)
            session.inserirMotocicleta(b);
        else
            System.out.println("Operacao cancelada");
    }

    public void pesquisarChassi() {
        System.out.println("#####Pesquisar#####");
        System.out.print("Chassi: ");
        String chassi = scan.next();
        session.perquisarChassi(chassi);
    }

    public void pesquisarPlaca() {
        System.out.println("#####Pesquisar#####");
        System.out.print("Placa: ");
        String placa = scan.next();
        session.perquisarPlaca(placa);
    }

    public void removerChassi() {
        System.out.println("#####Remover#####");
        System.out.print("Chassi: ");
        String chassi = scan.next();
        session.removerChassi(chassi);
    }

    public void removerPlaca() {
        System.out.println("#####Remover#####");
        System.out.print("Placa: ");
        String placa = scan.next();
        session.removerPlaca(placa);
    }

    public void listarVeiculos() {

        List<Veiculo> lista = session.listarTudo();

        if(lista != null & lista.size() > 0){
            System.out.println("\n#####Veiculos cadastrados#####");
            for (Veiculo a : lista) {
                //System.out.println("");
                if (a instanceof Automovel) {
                    System.out.println("----------Automovel----------");
                    System.out.println("Chassi: " + a.getChassi());
                    System.out.println("Placa: " + a.getPlaca());
                    System.out.println("Modelo: " + a.getModelo());
                    System.out.println("Ano: " + a.getAno());
                    System.out.println("Portas: " + ((Automovel) a).getPortas());
                    System.out.println("Cavalos: " + ((Automovel) a).getCavalos());
                } else if (a instanceof Caminhao) {
                    System.out.println("----------Caminhão----------");
                    System.out.println("Chassi: " + a.getChassi());
                    System.out.println("Placa: " + a.getPlaca());
                    System.out.println("Modelo: " + a.getModelo());
                    System.out.println("Ano: " + a.getAno());
                    System.out.println("Peso suportado: " + ((Caminhao) a).getPeso());
                    System.out.println("Tipo: " + ((Caminhao) a).getTipo());
                } else if (a instanceof Motocicleta) {
                    System.out.println("----------Motocicleta----------");
                    System.out.println("Chassi: " + a.getChassi());
                    System.out.println("Placa: " + a.getPlaca());
                    System.out.println("Modelo: " + a.getModelo());
                    System.out.println("Ano: " + a.getAno());
                    System.out.println("Cilindrada: " + ((Motocicleta) a).getCilindrada());
                }
            }
        } else {
            System.out.println("Nenhum veiculo cadastrado!");
        }
    }

    public void alterarVeiculo() {
        tl.menuPesquisar();
        int opPesquisar = scan.nextInt();
        switch (opPesquisar) {
            case 1:
                System.out.println("#####Alterar#####");
                System.out.print("Chassi: ");
                String chassi = scan.next();
                session.alterarChassi(chassi);
                break;
            case 2:
                System.out.println("#####Alterar#####");
                System.out.print("Placa: ");
                String placa = scan.next();
                session.alterarPlaca(placa);
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
    }

    private Veiculo carregarVeiculo() {

        System.out.print("Chassi: ");
        String chassi = scan.next();
        System.out.print("Placa: ");
        String placa = scan.next();
        System.out.print("Modelo: ");
        String modelo = scan.next();
        System.out.print("Ano: ");
        int ano = scan.nextInt();

        Veiculo a = new Veiculo(chassi, placa, modelo, ano);
        return a;
    }
}
