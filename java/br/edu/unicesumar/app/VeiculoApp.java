package br.edu.unicesumar.app;

import br.edu.unicesumar.dao.VeiculoDAO;
import br.edu.unicesumar.tela.Tela;
import br.edu.unicesumar.view.View;
import java.util.Scanner;

public class VeiculoApp {

    public static void main(String[] args) {
        //Cria tabela no DB
        VeiculoDAO dao = new VeiculoDAO();
        dao.prepararDB();


        Scanner scan = new Scanner(System.in);
        Tela tl = new Tela();
        View vw = new View();
        int opcao = 1;
        int opAdicao = 0;
        int opPesquisar = 0;
        int opRemover = 0;

        System.out.println("-------------------------");
        System.out.println("###SISTEMA DE VEICULOS###");

        while (opcao != 0) {
            tl.menuPrincipal();
            System.out.print("Opcao: ");
            opcao = scan.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Saindo!");
                    break;
                case 1:
                    vw.listarVeiculos();
                    break;
                case 2:
                    tl.menuAdicionar();
                    System.out.print("Opcao: ");
                    opAdicao = scan.nextInt();
                    switch (opAdicao) {
                        case 1:
                            vw.carregarAutomovel();
                            break;
                        case 2:
                            vw.carregarCaminhao();
                            break;
                        case 3:
                            vw.carregarMotocicleta();
                            break;
                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
                    break;
                case 3:
                    tl.menuPesquisar();
                    opPesquisar = scan.nextInt();
                    switch (opPesquisar) {
                        case 1:
                            vw.pesquisarChassi();
                            break;
                        case 2:
                            vw.pesquisarPlaca();
                            break;
                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
                    break;
                case 4:
                    tl.menuRemover();
                    opRemover = scan.nextInt();
                    switch (opRemover) {
                        case 1:
                            vw.removerChassi();
                            break;
                        case 2:
                            vw.removerPlaca();
                            break;
                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
                    break;
                case 5:
                    vw.alterarVeiculo();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;

            }


        }

    }
}
