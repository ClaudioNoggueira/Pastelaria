package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.PastelBEAN;

public class PastelDAO {

    private Connection con;

    public PastelDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PastelBEAN inserir(PastelBEAN pastelBEAN) {
        String sql = "insert into pastel(nome_pastel, descricao, preco, img_pastel) values(?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pastelBEAN.getNome_pastel());
            ps.setString(2, pastelBEAN.getDescricao());
            ps.setFloat(3, pastelBEAN.getPreco());
            ps.setString(4, pastelBEAN.getImg_pastel());

            if (ps.executeUpdate() > 0) {
                pastelBEAN.setStatus(pastelBEAN.getNome_pastel() + " inserido com sucesso");
                con.close();
                return pastelBEAN;
            } else {
                pastelBEAN.setStatus("Erro ao inserir '" + pastelBEAN.getNome_pastel() + "'");
                con.close();
                return pastelBEAN;
            }
        } catch (SQLException e) {
            pastelBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pastelBEAN;
    }

    public PastelBEAN consultarID(PastelBEAN pastelBEAN) {
        String sql = "select * from pastel where idPastel = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pastelBEAN.getIdPastel());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    pastelBEAN.setIdPastel(rs.getInt(1));
                    pastelBEAN.setNome_pastel(rs.getString(2));
                    pastelBEAN.setDescricao(rs.getString(3));
                    pastelBEAN.setPreco(rs.getFloat(4));
                    pastelBEAN.setImg_pastel(rs.getString(5));
                    pastelBEAN.setStatus("Resultado da pesquisa:");
                }
                return pastelBEAN;
            }
            if (pastelBEAN.getNome_pastel() == null) {
                pastelBEAN.setStatus("Sem resultados para pastel com ID '" + pastelBEAN.getIdPastel() + "'");
                pastelBEAN.setNome_pastel(" - ");
                pastelBEAN.setDescricao(" - ");
                pastelBEAN.setImg_pastel(" - ");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pastelBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pastelBEAN;
    }

    public List<PastelBEAN> consultarNome(PastelBEAN pastelBEAN) {
        List<PastelBEAN> listaDeDados = new ArrayList<>();
        String sql = "Select * from pastel where nome_pastel like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, "%" + pastelBEAN.getNome_pastel() + "%");

            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PastelBEAN pastel = new PastelBEAN();
                    pastel.setIdPastel(rs.getInt(1));
                    pastel.setNome_pastel(rs.getString(2));
                    pastel.setDescricao(rs.getString(3));
                    pastel.setPreco(rs.getFloat(4));
                    pastel.setImg_pastel(rs.getString(5));
                    listaDeDados.add(pastel);
                }
                ps.close();
                con.close();
                return listaDeDados;
            }
            pastelBEAN.setStatus("Sem resultados para '" + pastelBEAN.getNome_pastel() + "'");
            ps.close();
            con.close();
        } catch (SQLException e) {
            pastelBEAN.setStatus("Erro: " + e.getMessage());
        }
        listaDeDados.add(pastelBEAN);
        return listaDeDados;
    }

    public PastelBEAN alterar(PastelBEAN pastelBEAN) {
        String sql = "update pastel set nome_pastel = ?, descricao = ?, preco = ?, img_pastel = ? where idPastel = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pastelBEAN.getNome_pastel());
            ps.setString(2, pastelBEAN.getDescricao());
            ps.setFloat(3, pastelBEAN.getPreco());
            ps.setString(4, pastelBEAN.getImg_pastel());
            ps.setInt(5, pastelBEAN.getIdPastel());

            if (ps.executeUpdate() > 0) {
                pastelBEAN.setStatus(pastelBEAN.getNome_pastel() + " alterado com sucesso");
                con.close();
                return pastelBEAN;
            } else {
                pastelBEAN.setStatus("Erro ao alterar '" + pastelBEAN.getNome_pastel() + "'");
                con.close();
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                pastelBEAN.setStatus("Impossível alterar "
                        + pastelBEAN.getNome_pastel()
                        + " pois está relacionado com um registro de venda,\n e não é possível alterar um registro de venda.");
                pastelBEAN.setDescricao(" - ");
                pastelBEAN.setNome_pastel(" - ");
                pastelBEAN.setImg_pastel(" - ");
                pastelBEAN.setPreco(0);
            } else {
                pastelBEAN.setStatus("Erro: " + e.getMessage() + "\n" + e.getErrorCode());
            }
        }
        return pastelBEAN;
    }

    public PastelBEAN excluir(PastelBEAN pastelBEAN) {
        String sql = "delete from pastel where nome_pastel = ? and descricao = ? and preco = ? and idPastel = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pastelBEAN.getNome_pastel());
            ps.setString(2, pastelBEAN.getDescricao());
            ps.setFloat(3, pastelBEAN.getPreco());
            ps.setInt(4, pastelBEAN.getIdPastel());

            if (ps.executeUpdate() > 0) {
                pastelBEAN.setStatus(pastelBEAN.getNome_pastel() + " excluído com sucesso");
                con.close();
                return pastelBEAN;
            } else {
                pastelBEAN.setStatus("Erro ao excluír '" + pastelBEAN.getNome_pastel() + "'");
                con.close();
                return pastelBEAN;
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                pastelBEAN.setStatus("Impossível excluir "
                        + pastelBEAN.getNome_pastel()
                        + " pois está relacionado com um registro de venda,\n e não é possível excluir registro de venda.");
                pastelBEAN.setDescricao(" - ");
                pastelBEAN.setNome_pastel(" - ");
                pastelBEAN.setImg_pastel(" - ");
                pastelBEAN.setPreco(0);
            } else {
                pastelBEAN.setStatus("Erro: " + e.getMessage() + "\n" + e.getErrorCode());
            }
        }
        return pastelBEAN;
    }

    public List<PastelBEAN> listar() {
        List<PastelBEAN> listaDeDados = new ArrayList<>();
        String sql = "Select * from pastel";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PastelBEAN pastel = new PastelBEAN();
                    pastel.setIdPastel(rs.getInt(1));
                    pastel.setNome_pastel(rs.getString(2));
                    pastel.setDescricao(rs.getString(3));
                    pastel.setPreco(rs.getFloat(4));
                    pastel.setImg_pastel(rs.getString(5));
                    listaDeDados.add(pastel);
                }
                ps.close();
                con.close();
                return listaDeDados;
            } else {
                ps.close();
                con.close();
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
