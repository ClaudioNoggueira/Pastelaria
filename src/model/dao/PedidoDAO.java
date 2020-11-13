/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.PedidoBEAN;

/**
 *
 * @author claud
 */
public class PedidoDAO {

    private Connection con;

    public PedidoDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public PedidoBEAN inserir(PedidoBEAN pedBEAN) {
        String sql = "insert into pedido(qtdePastel, qtdeBebida, idPastel, idBebida) values(?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pedBEAN.getQtdePastel());
            ps.setInt(2, pedBEAN.getQtdeBebida());
            ps.setInt(3, pedBEAN.getIdPastel());
            ps.setInt(4, pedBEAN.getIdBebida());
            if (ps.executeUpdate() > 0) {
                pedBEAN.setStatus("Pedido adicionado com sucesso.");
            } else {
                pedBEAN.setStatus("Erro ao adicionar pedido.");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pedBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pedBEAN;
    }

    public PedidoBEAN consultarID(PedidoBEAN pedBEAN) {
        String sql = "select * from pedido where idPedido = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pedBEAN.getIdPedido());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    pedBEAN.setIdPedido(rs.getInt(1));
                    pedBEAN.setQtdePastel(rs.getInt(2));
                    pedBEAN.setQtdeBebida(rs.getInt(3));
                    pedBEAN.setIdPastel(rs.getInt(4));
                    pedBEAN.setIdBebida(rs.getInt(5));
                }
                return pedBEAN;
            } else {
                pedBEAN.setStatus("Sem resultados para pedido " + pedBEAN.getIdPedido());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pedBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pedBEAN;
    }

    public PedidoBEAN alterar(PedidoBEAN pedBEAN) {
        String sql = "update pedido set qtdePastel = ?, qtdeBebida = ?, "
                + "idPastel = ?, idBebida = ? where idPedido = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pedBEAN.getQtdePastel());
            ps.setInt(2, pedBEAN.getQtdeBebida());
            ps.setInt(3, pedBEAN.getIdPastel());
            ps.setInt(4, pedBEAN.getIdBebida());
            ps.setInt(5, pedBEAN.getIdPedido());
            if (ps.executeUpdate() > 0) {
                pedBEAN.setStatus("Pedido alterado com sucesso.");
            } else {
                pedBEAN.setStatus("Erro ao alterar pedido.");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pedBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pedBEAN;
    }

    public PedidoBEAN excluir(PedidoBEAN pedBEAN) {
        String sql = "delete from pedido where idPedido = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pedBEAN.getIdPedido());
            if (ps.executeUpdate() > 0) {
                pedBEAN.setStatus("Pedido excluído com sucesso");
            } else {
                pedBEAN.setStatus("Erro ao excluír pedido");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pedBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pedBEAN;
    }

    public List<PedidoBEAN> listar() {
        List<PedidoBEAN> listaDeDados = new ArrayList<>();
        String sql = "select * from pedido";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PedidoBEAN pedBEAN = new PedidoBEAN();
                    pedBEAN.setIdPedido(rs.getInt(1));
                    pedBEAN.setQtdePastel(rs.getInt(2));
                    pedBEAN.setQtdeBebida(rs.getInt(3));
                    pedBEAN.setIdPastel(rs.getInt(4));
                    pedBEAN.setIdBebida(rs.getInt(5));
                    listaDeDados.add(pedBEAN);
                }
            }

        } catch (SQLException e) {

        }
        return listaDeDados;
    }
}
