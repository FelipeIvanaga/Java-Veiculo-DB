package br.edu.unicesumar.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicesumar.model.*;

public class VeiculoDAO extends DAO {
    private String SQL_TABLE = "CREATE TABLE `yourcodelab`.`TB_VEICULO` ( `chassi` VARCHAR(20) NOT NULL , `placa` VARCHAR(10) NOT NULL , `modelo` VARCHAR(20) NOT NULL , `ano` INT NOT NULL , `portas` INT NULL DEFAULT NULL , `cavalos` INT NULL DEFAULT NULL , `peso` INT NULL DEFAULT NULL , `tipo` VARCHAR(20) NULL DEFAULT NULL , `cilindradas` INT NULL DEFAULT NULL , PRIMARY KEY (`chassi`), UNIQUE (`placa`)) ENGINE = InnoDB;";

    private String teste = "CREATE TABLE 'TESTE', 'TESTE' ";
    private String SQL_INSERT = "INSERT INTO TB_VEICULO(chassi, placa, modelo, ano, portas, cavalos, peso, tipo, cilindrada) values (?,?,?,?,?,?,?,?,?);";
    private String SQL_UPDATE = "UPDATE TB_VEICULO SET placa = ?, modelo = ?, ano = ?, portas = ?, cavalos = ?, peso = ?, tipo = ?, cilindrada = ? WHERE chassi = ?;";
    private String SQL_SELECT = "SELECT * FROM TB_VEICULO;";
    private String SQL_SEARCH1 = "SELECT * FROM TB_VEICULO WHERE chassi = ?";
    private String SQL_SEARCH2 = "SELECT * FROM TB_VEICULO WHERE placa = ?";
    private String SQL_DELETE1 = "DELETE FROM TB_VEICULO WHERE chassi = ?";
    private String SQL_DELETE2 = "DELETE FROM TB_VEICULO WHERE placa = ?";

    public void prepararDB() {
        try {
            conectar();
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_TABLE);
            ps.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir(Veiculo a) {
        try {
            conectar();

            PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, a.getChassi());
            ps.setString(2, a.getPlaca());
            ps.setString(3, a.getModelo());
            ps.setInt(4, a.getAno());

            if (a instanceof Automovel) {
                ps.setInt(5,((Automovel) a).getPortas());
                ps.setInt(6, ((Automovel) a). getCavalos());
                ps.setString(7,null);
                ps.setString(8,null);
                ps.setString(9,null);
            } else if (a instanceof Caminhao) {
                ps.setString(5,null);
                ps.setString(6,null);
                ps.setInt(7, ((Caminhao) a).getPeso());
                ps.setString(8, ((Caminhao) a).getTipo());
                ps.setString(9,null);
            } else if (a instanceof Motocicleta) {
                ps.setString(5,null);
                ps.setString(6,null);
                ps.setString(7,null);
                ps.setString(8,null);
                ps.setInt(9, ((Motocicleta) a).getCilindrada());
            }

            ps.executeUpdate();
            desconectar();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Veiculo> listaTodos() {
        List<Veiculo> lista = new ArrayList<Veiculo>();

        try {
            conectar();

            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo a;
                if(rs.getBoolean("portas")) {
                    a = new Automovel(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("portas"),
                            rs.getInt("cavalos"));
                } else if (rs.getBoolean("peso")) {
                    a = new Caminhao(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("peso"),
                            rs.getString("tipo"));
                } else {
                    a = new Motocicleta(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("cilindrada"));
                }

                lista.add(a);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return lista;
    }

    public Veiculo pesquisarChassi(String chassi) {
        try{
            conectar();
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SEARCH1);
            ps.setString(1, chassi);

            ResultSet rs = ps.executeQuery();

            Veiculo a = null;
            while (rs.next()) {
                if(rs.getBoolean("portas")) {
                    a = new Automovel(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("portas"),
                            rs.getInt("cavalos"));
                } else if (rs.getBoolean("peso")) {
                    a = new Caminhao(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("peso"),
                            rs.getString("tipo"));
                } else {
                    a = new Motocicleta(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("cilindrada"));
                }
            }

            desconectar();
            return a;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public Veiculo pesquisarPlaca(String placa) {
        try{
            conectar();
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SEARCH2);
            ps.setString(1, placa);

            ResultSet rs = ps.executeQuery();

            Veiculo a = null;
            while (rs.next()) {
                if(rs.getBoolean("portas")) {
                    a = new Automovel(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("portas"),
                            rs.getInt("cavalos"));
                } else if (rs.getBoolean("peso")) {
                    a = new Caminhao(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("peso"),
                            rs.getString("tipo"));
                } else {
                    a = new Motocicleta(rs.getString("chassi"),
                            rs.getString("placa"),
                            rs.getString("modelo"),
                            rs.getInt("ano"),
                            rs.getInt("cilindrada"));
                }
            }

            desconectar();
            return a;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void removeChassi(String chassi) {
        try {
            conectar();
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE1);

            ps.setString(1,chassi);
            ps.executeUpdate();

            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removePlaca(String placa) {
        try {
            conectar();
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE2);

            ps.setString(1,placa);
            ps.executeUpdate();

            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alteracao(Veiculo a) {
        try {
            conectar();
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, a.getPlaca());
            ps.setString(2, a.getModelo());
            ps.setInt(3, a.getAno());
            ps.setString(9,a.getChassi());

            if (a instanceof Automovel) {
                ps.setInt(4,((Automovel) a).getPortas());
                ps.setInt(5, ((Automovel) a). getCavalos());
                ps.setString(6,null);
                ps.setString(7,null);
                ps.setString(8,null);
            } else if (a instanceof Caminhao) {
                ps.setString(4,null);
                ps.setString(5,null);
                ps.setInt(6, ((Caminhao) a).getPeso());
                ps.setString(7, ((Caminhao) a).getTipo());
                ps.setString(8,null);
            } else if (a instanceof Motocicleta) {
                ps.setString(4,null);
                ps.setString(5,null);
                ps.setString(6,null);
                ps.setString(7,null);
                ps.setInt(8, ((Motocicleta) a).getCilindrada());
            }

            ps.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
