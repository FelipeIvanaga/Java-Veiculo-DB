package br.edu.unicesumar.tela;

import java.util.Scanner;

public class Tela {
    public void menuPrincipal() {
        System.out.println("\n--------MENU--------");
        System.out.println("1 - Listar veiculos");
        System.out.println("2 - Adicionar veiculo");
        System.out.println("3 - Pesquisar veiculo");
        System.out.println("4 - Remover veiculo");
        System.out.println("5 - Alterar veiculo");
        System.out.println("0 - Sair");
    }

    public void menuAdicionar() {
        System.out.println("1 - Automovel");
        System.out.println("2 - Caminhao");
        System.out.println("3 - Motocicleta");
    }

    public void menuPesquisar() {
        System.out.println("1 - Pesquisar por chassi");
        System.out.println("2 - Pesquisar por placa");
    }

    public void menuRemover() {
        System.out.println("1 - Remover por chassi");
        System.out.println("2 - Remover por placa");
    }

    public Boolean menuConfirmar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Confirmar a acao (s ou n): ");
        String acao = scan.next();
        if(acao.equals("s"))
            return true;
        return false;
    }
}
