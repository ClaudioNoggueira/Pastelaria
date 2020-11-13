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
import model.bean.PessoaBEAN;

/**
 *
 * @author claud
 */
public class PessoaDAO {

    private Connection con;

    public PessoaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public PessoaBEAN inserir(PessoaBEAN pesBEAN) {
        String sql = "insert into pessoa(nome_pessoa, cpf, tipo, idContato, idLogradouro) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pesBEAN.getNome());
            ps.setString(2, pesBEAN.getCPF());
            ps.setString(3, pesBEAN.getTipo());
            ps.setInt(4, pesBEAN.getIdContato());
            ps.setInt(5, pesBEAN.getIdLogradouro());
            if (ps.executeUpdate() > 0) {
                pesBEAN.setStatus(pesBEAN.getNome() + " inserido com sucesso.");
            } else {
                pesBEAN.setStatus("Erro ao inserir " + pesBEAN.getNome());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pesBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pesBEAN;
    }

    public PessoaBEAN consultarID(PessoaBEAN pesBEAN) {
        String sql = "select * from pessoa where idPessoa = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pesBEAN.getIdPessoa());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    pesBEAN.setIdPessoa(rs.getInt(1));
                    pesBEAN.setNome(rs.getString(2));
                    pesBEAN.setCPF(rs.getString(3));
                    pesBEAN.setTipo(rs.getString(4));
                    pesBEAN.setIdContato(rs.getInt(5));
                    pesBEAN.setIdLogradouro(rs.getInt(6));
                }
                return pesBEAN;
            } else {
                pesBEAN.setStatus("Não há ninguém com ID " + pesBEAN.getIdPessoa() + " cadastrado no banco");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pesBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pesBEAN;
    }

    public List<PessoaBEAN> consultarNome(PessoaBEAN pesBEAN) {
        List<PessoaBEAN> listaDeDados = new ArrayList<>();
        String sql = "select * from pessoa where nome_pessoa like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, "%" + pesBEAN.getNome() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PessoaBEAN pesLista = new PessoaBEAN();
                    pesLista.setIdPessoa(rs.getInt(1));
                    pesLista.setNome(rs.getString(2));
                    pesLista.setCPF(rs.getString(3));
                    pesLista.setTipo(rs.getString(4));
                    pesLista.setIdContato(rs.getInt(5));
                    pesLista.setIdLogradouro(rs.getInt(6));
                    listaDeDados.add(pesLista);
                }
                ps.close();
                con.close();
                return listaDeDados;
            }
            pesBEAN.setStatus("Sem resultados para '" + pesBEAN.getNome() + "'");
            ps.close();
            con.close();
        } catch (SQLException e) {
            pesBEAN.setStatus("Erro: " + e.getMessage());
        }
        listaDeDados.add(pesBEAN);
        return listaDeDados;
    }

    public PessoaBEAN consultarCPF(PessoaBEAN pesBEAN) {
        String sql = "select * from pessoa where cpf = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pesBEAN.getCPF());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    pesBEAN.setIdPessoa(rs.getInt(1));
                    pesBEAN.setNome(rs.getString(2));
                    pesBEAN.setCPF(rs.getString(3));
                    pesBEAN.setTipo(rs.getString(4));
                    pesBEAN.setIdContato(rs.getInt(5));
                    pesBEAN.setIdLogradouro(rs.getInt(6));
                    pesBEAN.setStatus("Resultado da pesquisa: ");
                }
                ps.close();
                con.close();
                return pesBEAN;
            }
            pesBEAN.setStatus("Não há ninguém com CPF " + pesBEAN.getIdPessoa() + " cadastrado no banco");
            ps.close();
            con.close();
        } catch (SQLException e) {
            pesBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pesBEAN;
    }

    public PessoaBEAN alterar(PessoaBEAN pesBEAN) {
        String sql = "update from pessoa set nome_pessoa = ?, cpf = ?, tipo = ? where idPessoa = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pesBEAN.getNome());
            ps.setString(2, pesBEAN.getCPF());
            ps.setString(3, pesBEAN.getTipo());
            ps.setInt(4, pesBEAN.getIdPessoa());
            if (ps.executeUpdate() > 0) {
                pesBEAN.setStatus(pesBEAN.getNome() + " alterado com sucesso.");
            } else {
                pesBEAN.setStatus("Erro ao alterar dados de " + pesBEAN.getNome());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pesBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pesBEAN;
    }

    public PessoaBEAN excluir(PessoaBEAN pesBEAN) {
        String sql = "delete from pessoa where idPessoa = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, pesBEAN.getIdPessoa());
            if (ps.executeUpdate() > 0) {
                pesBEAN.setStatus(pesBEAN.getNome() + " excluído com sucesso.");
            } else {
                pesBEAN.setStatus("Erro ao excluír " + pesBEAN.getNome());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            pesBEAN.setStatus("Erro: " + e.getMessage());
        }
        return pesBEAN;
    }

    public List<PessoaBEAN> listar() {
        List<PessoaBEAN> listaDeDados = new ArrayList<>();
        String sql = "select nome_pessoa, cpf, tipo, idContato, idLogradouro from pessoa";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PessoaBEAN pesBEAN = new PessoaBEAN();
                    pesBEAN.setNome(rs.getString(1));
                    pesBEAN.setCPF(rs.getString(2));
                    pesBEAN.setTipo(rs.getString(3));
                    pesBEAN.setIdContato(rs.getInt(4));
                    pesBEAN.setIdLogradouro(rs.getInt(5));
                    listaDeDados.add(pesBEAN);
                }
                ps.close();
                con.close();
                return listaDeDados;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
