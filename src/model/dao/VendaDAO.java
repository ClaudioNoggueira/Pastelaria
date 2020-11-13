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
import model.bean.VendaBEAN;

/**
 *
 * @author claud
 */
public class VendaDAO {

    private Connection con;

    public VendaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public VendaBEAN inserir(VendaBEAN vendaBEAN) {
        String sql = "insert into venda(dataVenda, subTotal, idPedido) values (?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, vendaBEAN.getDataVenda());
            ps.setFloat(2, vendaBEAN.getSubTotal());
            ps.setInt(3, vendaBEAN.getIdPedido());
            if (ps.executeUpdate() > 0) {
                vendaBEAN.setStatus("Venda efetuada com sucesso");
            } else {
                vendaBEAN.setStatus("Erro ao efetuar venda");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            vendaBEAN.setStatus("Erro: " + e.getMessage());
        }
        return vendaBEAN;
    }

    public VendaBEAN consultarIDPedido(VendaBEAN vendaBEAN) {
        String sql = "select * from venda where idPedido = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, vendaBEAN.getIdPedido());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                vendaBEAN.setIdVenda(rs.getInt(1));
                vendaBEAN.setDataVenda(rs.getString(2));
                vendaBEAN.setSubTotal(rs.getFloat(3));
                vendaBEAN.setIdPedido(rs.getInt(4));
            } else {
                System.out.println("Não foi possível encontrar uma venda com ID '" + vendaBEAN.getIdVenda() + "'");
            }
            ps.close();
            con.close();
            return vendaBEAN;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vendaBEAN;
    }

    public VendaBEAN excluir(VendaBEAN vendaBEAN) {
        String sql = "delete from venda where idVenda = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, vendaBEAN.getIdVenda());
            if (ps.executeUpdate() > 0) {
                vendaBEAN.setStatus("Registro de venda '" + vendaBEAN.getIdVenda() + "' excluído com sucesso");
            } else {
                vendaBEAN.setStatus("Erro ao excluir registro de venda");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            vendaBEAN.setStatus("Erro: " + e.getMessage());
        }
        return vendaBEAN;
    }

    public List<VendaBEAN> listar() {
        List<VendaBEAN> listaDeDados = new ArrayList<>();
        String sql = "select dataVenda, subTotal, idPedido from venda";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VendaBEAN vendaBEAN = new VendaBEAN();
                    vendaBEAN.setDataVenda(rs.getString(1));
                    vendaBEAN.setSubTotal(rs.getFloat(2));
                    vendaBEAN.setIdPedido(rs.getInt(3));
                    vendaBEAN.setStatus("Resultado da pesquisa:");
                    listaDeDados.add(vendaBEAN);
                }
            }
            ps.close();
            con.close();
            return listaDeDados;
        } catch (SQLException e) {
        }
        return null;
    }
}
