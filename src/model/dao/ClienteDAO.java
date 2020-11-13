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
import model.bean.ClienteBEAN;

/**
 *
 * @author claud
 */
public class ClienteDAO {

    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public ClienteBEAN inserir(ClienteBEAN cliBEAN) {
        String sql = "insert into cliente(idPedido, idPessoa) values(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, cliBEAN.getIdPedido());
            ps.setInt(2, cliBEAN.getIdPessoa());
            if (ps.executeUpdate() > 0) {
                cliBEAN.setStatus("Cliente inserido com sucesso.");
                ps.close();
                con.close();
                return cliBEAN;
            } else {
                cliBEAN.setStatus("Erro ao inserir cliente;");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            cliBEAN.setStatus("Erro: " + e.getMessage());
        }
        return cliBEAN;
    }

    public ClienteBEAN consultarIDCliente(ClienteBEAN cliBEAN) {
        String sql = "select idPedido, idPessoa from cliente where idCliente = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, cliBEAN.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    cliBEAN.setIdPedido(rs.getInt(1));
                    cliBEAN.setIdPessoa(rs.getInt(2));
                }
                cliBEAN.setStatus("Resultado da pesquisa:");
                ps.close();
                con.close();
                return cliBEAN;
            } else {
                cliBEAN.setStatus("Sem resultados para cliente com ID " + cliBEAN.getIdCliente());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            cliBEAN.setStatus("Erro: " + e.getMessage());
        }
        return cliBEAN;
    }
    public ClienteBEAN consultarIDPessoa(ClienteBEAN cliBEAN){
        String sql = "Select * from cliente where idPessoa = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, cliBEAN.getIdPessoa());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    cliBEAN.setIdCliente(rs.getInt(1));
                    cliBEAN.setIdPedido(rs.getInt(2));
                    cliBEAN.setIdPessoa(rs.getInt(3));
                }
                cliBEAN.setStatus("Resultado da pesquisa:");
                ps.close();
                con.close();
                return cliBEAN;
            } else {
                cliBEAN.setStatus("Sem resultados para cliente com ID-Pessoa: " + cliBEAN.getIdCliente());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            cliBEAN.setStatus("Erro: " + e.getMessage());
        }
        return cliBEAN;
    }
    public ClienteBEAN excluir(ClienteBEAN cliBEAN){
        String sql = "delete from cliente where idCliente = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, cliBEAN.getIdCliente());
            if (ps.executeUpdate() > 0) {
                cliBEAN.setStatus("Cliente excluído com sucesso.");
                ps.close();
                con.close();
                return cliBEAN;
            } else {
                cliBEAN.setStatus("Erro ao excluír cliente;");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            cliBEAN.setStatus("Erro: " + e.getMessage());
        }
        return cliBEAN;
    }
    public List<ClienteBEAN> listar(){
        List<ClienteBEAN> listaDeDados = new ArrayList<>();
        String sql = "select * from clientes";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    ClienteBEAN cliBEAN = new ClienteBEAN();
                    cliBEAN.setIdCliente(rs.getInt(1));
                    cliBEAN.setIdPedido(rs.getInt(2));
                    cliBEAN.setIdPessoa(rs.getInt(3));
                    listaDeDados.add(cliBEAN);
                }
                ps.close();
                con.close();
                return listaDeDados;
            }
        }catch(SQLException e){
            
        }
        return listaDeDados;
    }
}
