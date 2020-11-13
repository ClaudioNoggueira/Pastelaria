package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.BebidaBEAN;

public class BebidaDAO {

    private Connection con;

    public BebidaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public BebidaBEAN inserir(BebidaBEAN bebidaBEAN) {
        String sql = "insert into bebida(nome_bebida, descricao, preco, img_bebida) values(?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, bebidaBEAN.getNome_bebida());
            ps.setString(2, bebidaBEAN.getDescricao());
            ps.setFloat(3, bebidaBEAN.getPreco());
            ps.setString(4, bebidaBEAN.getImg_bebida());

            if (ps.executeUpdate() > 0) {
                bebidaBEAN.setStatus("Bebida " + bebidaBEAN.getNome_bebida() + " inserida com sucesso");
                ps.close();
                con.close();
                return bebidaBEAN;
            } else {
                bebidaBEAN.setStatus("Erro ao inserir bebida '" + bebidaBEAN.getNome_bebida() + "'");
                ps.close();
                con.close();
                return bebidaBEAN;
            }
        } catch (SQLException e) {
            bebidaBEAN.setStatus("Erro: " + e.getMessage());
            return bebidaBEAN;
        }
    }

    public BebidaBEAN consultarID(BebidaBEAN bebidaBEAN) {
        String sql = "select * from bebida where idBebida = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, bebidaBEAN.getIdBebida());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    bebidaBEAN.setIdBebida(rs.getInt(1));
                    bebidaBEAN.setNome_bebida(rs.getString(2));
                    bebidaBEAN.setDescricao(rs.getString(3));
                    bebidaBEAN.setPreco(rs.getFloat(4));
                    bebidaBEAN.setImg_bebida(rs.getString(5));
                    bebidaBEAN.setStatus("Resultado da pesquisa:");
                }
                return bebidaBEAN;
            } else {
                bebidaBEAN.setStatus("Sem resultados para bebida com ID '" + bebidaBEAN.getIdBebida() + "'");
            }
        } catch (SQLException e) {
            bebidaBEAN.setStatus(e.getMessage());
        }
        return bebidaBEAN;
    }

    public List<BebidaBEAN> consultarNome(BebidaBEAN bebidaBEAN) {
        List<BebidaBEAN> listaDeDados = new ArrayList<>();
        String sql = "Select * from bebida where nome_bebida like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, "%" + bebidaBEAN.getNome_bebida() + "%");

            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BebidaBEAN bebida = new BebidaBEAN();
                    bebida.setIdBebida(rs.getInt(1));
                    bebida.setNome_bebida(rs.getString(2));
                    bebida.setDescricao(rs.getString(3));
                    bebida.setPreco(rs.getFloat(4));
                    bebida.setImg_bebida(rs.getString(5));
                    bebida.setStatus("Resultado da consulta:");
                    listaDeDados.add(bebida);
                }
                ps.close();
                con.close();
                return listaDeDados;
            } else {
                bebidaBEAN.setStatus("Sem resultados para bebida '" + bebidaBEAN.getNome_bebida() + "'");
                listaDeDados.add(bebidaBEAN);
                return listaDeDados;
            }
        } catch (SQLException e) {
            bebidaBEAN.setStatus("Erro: " + e.getMessage());
            return null;
        }
    }

    public BebidaBEAN alterar(BebidaBEAN bebidaBEAN) {
        String sql = "update bebida set nome_bebida = ?, descricao = ?, preco = ?, img_bebida = ? where idBebida = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, bebidaBEAN.getNome_bebida());
            ps.setString(2, bebidaBEAN.getDescricao());
            ps.setFloat(3, bebidaBEAN.getPreco());
            ps.setString(4, bebidaBEAN.getImg_bebida());
            ps.setInt(5, bebidaBEAN.getIdBebida());

            if (ps.executeUpdate() > 0) {
                bebidaBEAN.setStatus("Bebida '" + bebidaBEAN.getNome_bebida() + "' alterada com sucesso");

            } else {
                bebidaBEAN.setStatus("Erro ao alterar bebida: " + bebidaBEAN.getNome_bebida());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                bebidaBEAN.setStatus("Impossível alterar "
                        + bebidaBEAN.getNome_bebida()
                        + " pois está relacionada com um registro de venda,\n e não é possível alterar registro de venda.");
                bebidaBEAN.setDescricao(" - ");
                bebidaBEAN.setNome_bebida(" - ");
                bebidaBEAN.setImg_bebida(" - ");
                bebidaBEAN.setPreco(0);
            } else {
                bebidaBEAN.setStatus("Erro: " + e.getMessage() + "\n" + e.getErrorCode());
            }
        }
        return bebidaBEAN;
    }

    public BebidaBEAN excluir(BebidaBEAN bebidaBEAN) {
        String sql = "delete from bebida where nome_bebida = ? and descricao = ? and preco = ? and idBebida = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, bebidaBEAN.getNome_bebida());
            ps.setString(2, bebidaBEAN.getDescricao());
            ps.setFloat(3, bebidaBEAN.getPreco());
            ps.setInt(4, bebidaBEAN.getIdBebida());

            if (ps.executeUpdate() > 0) {
                bebidaBEAN.setStatus("Bebida '" + bebidaBEAN.getNome_bebida() + "' excluída com sucesso");
            } else {
                bebidaBEAN.setStatus("Erro ao excluir bebida: " + bebidaBEAN.getNome_bebida());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                bebidaBEAN.setStatus("Impossível excluir "
                        + bebidaBEAN.getNome_bebida()
                        + " pois está relacionada com um registro de venda,\n e não é possível excluir registro de venda.");
                bebidaBEAN.setDescricao(" - ");
                bebidaBEAN.setNome_bebida(" - ");
                bebidaBEAN.setImg_bebida(" - ");
                bebidaBEAN.setPreco(0);
            } else {
                bebidaBEAN.setStatus("Erro: " + e.getMessage() + "\n" + e.getErrorCode());
            }
        }
        return bebidaBEAN;
    }

    public List<BebidaBEAN> listar() {
        List<BebidaBEAN> listaDeDados = new ArrayList<>();
        String sql = "Select * from bebida";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BebidaBEAN bebida = new BebidaBEAN();
                    bebida.setIdBebida(rs.getInt(1));
                    bebida.setNome_bebida(rs.getString(2));
                    bebida.setDescricao(rs.getString(3));
                    bebida.setPreco(rs.getFloat(4));
                    bebida.setImg_bebida(rs.getString(5));
                    listaDeDados.add(bebida);
                }
                ps.close();
                con.close();
                return listaDeDados;
            } else {
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
