package br.edu.unicesumar.session;

import br.edu.unicesumar.dao.VeiculoDAO;
import br.edu.unicesumar.model.*;
import br.edu.unicesumar.tela.Tela;

import java.util.List;
import java.util.Scanner;

public class VeiculoSession {
    private VeiculoDAO dao;
    private Tela tl;
    private Scanner scan;

    public VeiculoSession() {
        dao = new VeiculoDAO();
        tl = new Tela();
        scan = new Scanner(System.in);
    }

    public List<Veiculo> listarTudo() {
        List<Veiculo> lista = dao.listaTodos();
        return lista;
    }

    public void inserirAutomovel(Veiculo a) {
        if(a.getChassi() != null
                & a.getPlaca() != null
                & a.getModelo() != null
                & a.getAno() > 1900
                & ((Automovel) a).getPortas() > 0
                & ((Automovel) a).getCavalos() > 1) {
            if(dao.pesquisarChassi(a.getChassi()) == null & dao.pesquisarPlaca(a.getPlaca()) == null)
                dao.inserir(a);
            else
                System.out.println("Veiculo ja cadastrado!");
        } else {
            System.out.println("Dados incompletos ou invalidos!");
            System.out.println("Verifique os dados");
        }
    }

    public void inserirCaminhao(Veiculo a) {
        if(a.getChassi() != null
                & a.getPlaca() != null
                & a.getModelo() != null
                & a.getAno() > 1900
                & ((Caminhao) a).getPeso() > 0
                & ((Caminhao) a).getTipo() != null) {
            if(dao.pesquisarChassi(a.getChassi()) == null & dao.pesquisarPlaca(a.getPlaca()) == null)
                dao.inserir(a);
            else
                System.out.println("Veiculo ja cadastrado!");
        } else {
            System.out.println("Dados incompletos ou invalidos");
            System.out.println("Verifique os dados");
        }
    }

    public void inserirMotocicleta(Veiculo a) {
        if(a.getChassi() != null
                & a.getPlaca() != null
                & a.getModelo() != null
                & a.getAno() > 1900
                & ((Motocicleta) a).getCilindrada() > 0) {
            if(dao.pesquisarChassi(a.getChassi()) == null & dao.pesquisarPlaca(a.getPlaca()) == null)
                dao.inserir(a);
            else
                System.out.println("Veiculo ja cadastrado!");
        } else {
            System.out.println("Dados incompletos ou invalidos");
            System.out.println("Verifique os dados");
        }
    }

    public void perquisarChassi(String chassi) {
        Veiculo a = dao.pesquisarChassi(chassi);

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
        } else {
            System.out.println("Veiculo nao cadastrado!");
        }
    }

    public void perquisarPlaca(String placa) {
        Veiculo a = dao.pesquisarPlaca(placa);

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
        } else {
            System.out.println("Veiculo nao cadastrado!");
        }
    }

    public void removerChassi(String chassi) {
        if(dao.pesquisarChassi(chassi) != null) {
            perquisarChassi(chassi);
            System.out.println("Remover este veiculo?");
            if(tl.menuConfirmar() == true)
                dao.removeChassi(chassi);
            else
                System.out.println("Operacao cancelada!");
        } else {
            System.out.println("Veiculo nao cadastrado");
        }
    }

    public void removerPlaca(String placa) {
        if(dao.pesquisarPlaca(placa) != null) {
            perquisarPlaca(placa);
            System.out.println("Remover este veiculo?");
            if(tl.menuConfirmar() == true)
                dao.removePlaca(placa);
            else
                System.out.println("Operacao cancelada!");
        } else {
            System.out.println("Veiculo nao cadastrado");
        }
    }

    public void alterarChassi(String chassi) {
        Veiculo a = dao.pesquisarChassi(chassi);
        if(a != null) {
            String auxPlaca = a.getPlaca();
            System.out.println("#####Valores atuais#####");
            System.out.println("Chassi: " + a.getChassi());
            System.out.println("Placa: " + a.getPlaca());
            System.out.println("Modelo: " + a.getModelo());
            System.out.println("Ano: " + a.getAno());
            if(a instanceof Automovel) {
                System.out.println("Portas: " + ((Automovel) a).getPortas());
                System.out.println("Cavalos: " + ((Automovel) a).getCavalos());

                System.out.println("#####Novos valores#####");
                System.out.println("Chassi: " + a.getChassi());
                System.out.print("Placa: ");
                a.setPlaca(scan.next());
                System.out.print("Modelo: ");
                a.setModelo(scan.next());
                System.out.print("Ano: ");
                a.setAno(scan.nextInt());
                System.out.print("Portas: ");
                ((Automovel) a).setPortas(scan.nextInt());
                System.out.print("Cavalos: ");
                ((Automovel) a).setCavalos(scan.nextInt());

            } else if (a instanceof Caminhao) {
                System.out.println("Peso suportado: " + ((Caminhao) a).getPeso());
                System.out.println("Tipo: " + ((Caminhao) a).getTipo());

                System.out.println("#####Novos valores#####");
                System.out.println("Chassi: " + a.getChassi());
                System.out.print("Placa: ");
                a.setPlaca(scan.next());
                System.out.print("Modelo: ");
                a.setModelo(scan.next());
                System.out.print("Ano: ");
                a.setAno(scan.nextInt());
                System.out.print("Peso: ");
                ((Caminhao) a).setPeso(scan.nextInt());
                System.out.print("Tipo de carga: ");
                ((Caminhao) a).setTipo(scan.next());
            } else if (a instanceof Motocicleta) {
                System.out.println("Cilindrada: " + ((Motocicleta) a).getCilindrada());

                System.out.println("#####Novos valores#####");
                System.out.println("Chassi: " + a.getChassi());
                System.out.print("Placa: ");
                a.setPlaca(scan.next());
                System.out.print("Modelo: ");
                a.setModelo(scan.next());
                System.out.print("Ano: ");
                a.setAno(scan.nextInt());
                System.out.print("Cilindrada: ");
                ((Motocicleta) a).setCilindrada(scan.nextInt());
            }
            if (tl.menuConfirmar() == true) {
                if(dao.pesquisarPlaca(a.getPlaca()) == null | auxPlaca.equals(a.getPlaca())) {
                    dao.alteracao(a);
                } else {
                    System.out.println("Placa ja cadastrada!");
                }
            }



        } else {
            System.out.println("Veiculo nao cadastrado!");
        }
    }

    public void alterarPlaca(String placa) {
        Veiculo a = dao.pesquisarPlaca(placa);
        if(a != null) {
            String auxPlaca = a.getPlaca();
            System.out.println("#####Valores atuais#####");
            System.out.println("Chassi: " + a.getChassi());
            System.out.println("Placa: " + a.getPlaca());
            System.out.println("Modelo: " + a.getModelo());
            System.out.println("Ano: " + a.getAno());
            if(a instanceof Automovel) {
                System.out.println("Portas: " + ((Automovel) a).getPortas());
                System.out.println("Cavalos: " + ((Automovel) a).getCavalos());

                System.out.println("#####Novos valores#####");
                System.out.println("Chassi: " + a.getChassi());
                System.out.print("Placa: ");
                a.setPlaca(scan.next());
                System.out.print("Modelo: ");
                a.setModelo(scan.next());
                System.out.print("Ano: ");
                a.setAno(scan.nextInt());
                System.out.print("Portas: ");
                ((Automovel) a).setPortas(scan.nextInt());
                System.out.print("Cavalos: ");
                ((Automovel) a).setCavalos(scan.nextInt());

            } else if (a instanceof Caminhao) {
                System.out.println("Peso suportado: " + ((Caminhao) a).getPeso());
                System.out.println("Tipo: " + ((Caminhao) a).getTipo());

                System.out.println("#####Novos valores#####");
                System.out.println("Chassi: " + a.getChassi());
                System.out.print("Placa: ");
                a.setPlaca(scan.next());
                System.out.print("Modelo: ");
                a.setModelo(scan.next());
                System.out.print("Ano: ");
                a.setAno(scan.nextInt());
                System.out.print("Peso: ");
                ((Caminhao) a).setPeso(scan.nextInt());
                System.out.print("Tipo de carga: ");
                ((Caminhao) a).setTipo(scan.next());
            } else if (a instanceof Motocicleta) {
                System.out.println("Cilindrada: " + ((Motocicleta) a).getCilindrada());

                System.out.println("#####Novos valores#####");
                System.out.println("Chassi: " + a.getChassi());
                System.out.print("Placa: ");
                a.setPlaca(scan.next());
                System.out.print("Modelo: ");
                a.setModelo(scan.next());
                System.out.print("Ano: ");
                a.setAno(scan.nextInt());
                System.out.print("Cilindrada: ");
                ((Motocicleta) a).setCilindrada(scan.nextInt());
            }
            if (tl.menuConfirmar() == true) {
                if(dao.pesquisarPlaca(a.getPlaca()) == null | auxPlaca.equals(a.getPlaca())) {
                    dao.alteracao(a);
                } else {
                    System.out.println("Placa ja cadastrada!");
                }
            }



        } else {
            System.out.println("Veiculo nao cadastrado!");
        }
    }
}
