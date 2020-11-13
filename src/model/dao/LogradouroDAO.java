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
import model.bean.LogradouroBEAN;
import util.Conexao;

/**
 *
 * @author claud
 */
public class LogradouroDAO {

    Conexao c = new Conexao();
    private Connection con;

    public LogradouroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public LogradouroBEAN inserir(LogradouroBEAN logBEAN) {
        String sql = "insert into logradouro(tipo, rua, numero, bairro, complemento) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, logBEAN.getTipo());
            ps.setString(2, logBEAN.getRua());
            ps.setString(3, logBEAN.getNumero());
            ps.setString(4, logBEAN.getBairro());
            ps.setString(5, logBEAN.getComplemento());
            if (ps.executeUpdate() > 0) {
                logBEAN.setStatus("Logradouro '"
                        + logBEAN.getTipo() + " - "
                        + logBEAN.getRua() + ", nº"
                        + logBEAN.getNumero() + ", "
                        + logBEAN.getBairro()
                        + "' inserido com sucesso.");
            } else {
                logBEAN.setStatus("Erro ao inserir logradouro: "
                        + logBEAN.getTipo() + " - "
                        + logBEAN.getRua() + ", nº"
                        + logBEAN.getNumero() + ", "
                        + logBEAN.getBairro());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {

        }

        return logBEAN;
    }

    public LogradouroBEAN consultarID(LogradouroBEAN logBEAN) {
        String sql = "select tipo, rua, numero, bairro, complemento from logradouro where idLogradouro = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, logBEAN.getIdLogradouro());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    logBEAN.setTipo(rs.getString(1));
                    logBEAN.setRua(rs.getString(2));
                    logBEAN.setNumero(rs.getString(3));
                    logBEAN.setBairro(rs.getString(4));
                    logBEAN.setComplemento(rs.getString(5));
                }
                return logBEAN;
            } else {
                logBEAN.setStatus("Sem resultados para logradouro com ID: " + logBEAN.getIdLogradouro());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {

        }
        c.fecharConexao(con);
        return logBEAN;
    }

    public List<LogradouroBEAN> consultarRua(LogradouroBEAN logBEAN) {
        List<LogradouroBEAN> listaDeDados = new ArrayList<>();
        String sql = "select * from logradouro where rua like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, "%" + logBEAN.getRua() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    LogradouroBEAN logLista = new LogradouroBEAN();
                    logLista.setIdLogradouro(rs.getInt(1));
                    logLista.setTipo(rs.getString(2));
                    logLista.setRua(rs.getString(3));
                    logLista.setNumero(rs.getString(4));
                    logLista.setBairro(rs.getString(5));
                    logLista.setComplemento(rs.getString(6));
                    listaDeDados.add(logLista);
                }
                return listaDeDados;
            } else {
                logBEAN.setStatus("Sem resultados para rua '" + logBEAN.getRua() + "'");
                listaDeDados.add(logBEAN);
                return listaDeDados;
            }
        } catch (SQLException e) {
            logBEAN.setStatus("Erro: " + e.getMessage());
        }
        listaDeDados.add(logBEAN);
        return listaDeDados;
    }

    public LogradouroBEAN alterar(LogradouroBEAN logBEAN) {
        String sql = "update from logradouro "
                + " set tipo = ?, rua = ?, numero = ?, bairro = ?, complemento = ? "
                + " where idLogradouro = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, logBEAN.getTipo());
            ps.setString(2, logBEAN.getRua());
            ps.setString(3, logBEAN.getNumero());
            ps.setString(4, logBEAN.getBairro());
            ps.setString(5, logBEAN.getComplemento());
            ps.setInt(6, logBEAN.getIdLogradouro());
            if (ps.executeUpdate() > 0) {
                logBEAN.setStatus("Logradouro '"
                        + logBEAN.getTipo() + " - "
                        + logBEAN.getRua() + ", nº"
                        + logBEAN.getNumero() + ", "
                        + logBEAN.getBairro()
                        + "' alterado com sucesso.");
            } else {
                logBEAN.setStatus("Erro ao alterar logradouro: "
                        + logBEAN.getTipo() + " - "
                        + logBEAN.getRua() + ", nº"
                        + logBEAN.getNumero() + ", "
                        + logBEAN.getBairro());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {

        }
        return logBEAN;
    }

    public LogradouroBEAN excluir(LogradouroBEAN logBEAN) {
        String sql = "delete from logradouro where idLogradouro = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, logBEAN.getIdLogradouro());
            if (ps.executeUpdate() > 0) {
                logBEAN.setStatus("Logradouro '"
                        + logBEAN.getTipo() + " - "
                        + logBEAN.getRua() + ", nº"
                        + logBEAN.getNumero() + ", "
                        + logBEAN.getBairro()
                        + "' excluído com sucesso.");
            } else {
                logBEAN.setStatus("Erro ao excluír logradouro: "
                        + logBEAN.getTipo() + " - "
                        + logBEAN.getRua() + ", nº"
                        + logBEAN.getNumero() + ", "
                        + logBEAN.getBairro());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {

        }

        return logBEAN;
    }

    public List<LogradouroBEAN> listar() {
        List<LogradouroBEAN> listaDeDados = new ArrayList<>();
        String sql = "select tipo, rua, numero, bairro, complemento from logradouro";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    LogradouroBEAN logBEAN = new LogradouroBEAN();
                    logBEAN.setTipo(rs.getString(1));
                    logBEAN.setRua(rs.getString(2));
                    logBEAN.setNumero(rs.getString(3));
                    logBEAN.setBairro(rs.getString(4));
                    logBEAN.setComplemento(rs.getString(5));
                    listaDeDados.add(logBEAN);
                }
                return listaDeDados;
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
