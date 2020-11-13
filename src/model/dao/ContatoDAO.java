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
import model.bean.ContatoBEAN;
import util.Conexao;

/**
 *
 * @author claud
 */
public class ContatoDAO {

    private Connection con;

    public ContatoDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public ContatoBEAN inserir(ContatoBEAN contBEAN) {
        String sql = "insert into contato(tel_celular, tel_fixo, email) values (?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, contBEAN.getTel_fixo());
            ps.setString(2, contBEAN.getTel_celular());
            ps.setString(3, contBEAN.getEmail());

            if (ps.executeUpdate() > 0) {
                contBEAN.setStatus("Contato " + contBEAN.getIdContato() + " inserido com sucesso");
                return contBEAN;
            } else {
                contBEAN.setStatus("Erro ao inserir contato" + contBEAN.getIdContato());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            contBEAN.setStatus("Erro: " + e.getMessage());
        }
        return contBEAN;
    }

    public ContatoBEAN consultarID(ContatoBEAN contBEAN) {
        String sql = "select tel_celular, tel_fixo, email from contato where idContato = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, contBEAN.getIdContato());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    contBEAN.setTel_celular(rs.getString(1));
                    contBEAN.setTel_fixo(rs.getString(2));
                    contBEAN.setEmail(rs.getString(3));
                }
                return contBEAN;
            } else {
                contBEAN.setStatus("Sem resultados para contato com ID = '" + contBEAN.getIdContato() + "'");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            contBEAN.setStatus("Erro\n" + e.getMessage());
        }
        return contBEAN;
    }

    public List<ContatoBEAN> consultarTelFixo(ContatoBEAN contBEAN) {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        String sql = "select * from contato where tel_fixo like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, contBEAN.getTel_fixo());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ContatoBEAN contLista = new ContatoBEAN();
                    contLista.setIdContato(rs.getInt(1));
                    contLista.setTel_fixo(rs.getString(2));
                    contLista.setTel_celular(rs.getString(3));
                    contLista.setEmail(rs.getString(4));
                    contLista.setStatus("Resultado da pesquisa:");
                    listaDeDados.add(contLista);
                }
                ps.close();
                con.close();
                return listaDeDados;
            } else {
                contBEAN.setStatus("Sem resultados para telefone-fíxo: " + contBEAN.getTel_fixo() + "");
            }
        } catch (SQLException e) {
            contBEAN.setStatus("Erro: " + e.getMessage());
        }
        return null;
    }

    public List<ContatoBEAN> consultarTelCelular(ContatoBEAN contBEAN) {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        String sql = "select * from contato where tel_celular like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, contBEAN.getTel_celular());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ContatoBEAN contLista = new ContatoBEAN();
                    contLista.setIdContato(rs.getInt(1));
                    contLista.setTel_fixo(rs.getString(2));
                    contLista.setTel_celular(rs.getString(3));
                    contLista.setEmail(rs.getString(4));
                    contLista.setStatus("Resultado da pesquisa:");
                    listaDeDados.add(contLista);
                }
                ps.close();
                con.close();
                return listaDeDados;
            } else {
                contBEAN.setStatus("Sem resultados para telefone-celular: " + contBEAN.getTel_celular() + "");
            }
        } catch (SQLException e) {
            contBEAN.setStatus("Erro: " + e.getMessage());
        }
        return null;
    }

    public List<ContatoBEAN> consultarEmail(ContatoBEAN contBEAN) {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        String sql = "select * from contato where email like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, contBEAN.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ContatoBEAN contLista = new ContatoBEAN();
                    contLista.setIdContato(rs.getInt(1));
                    contLista.setTel_fixo(rs.getString(2));
                    contLista.setTel_celular(rs.getString(3));
                    contLista.setEmail(rs.getString(4));
                    contLista.setStatus("Resultado da pesquisa:");
                    listaDeDados.add(contLista);
                }
                ps.close();
                con.close();
                return listaDeDados;
            } else {
                contBEAN.setStatus("Sem resultados para telefone-fíxo: " + contBEAN.getEmail() + "");
            }
        } catch (SQLException e) {
            contBEAN.setStatus("Erro: " + e.getMessage());
        }
        return null;
    }

    public ContatoBEAN alterar(ContatoBEAN contBEAN) {
        String sql = "update from contato set tel_celular = ?, tel_fixo = ?, email = ? where idContato = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, contBEAN.getTel_celular());
            ps.setString(2, contBEAN.getTel_fixo());
            ps.setString(3, contBEAN.getEmail());
            ps.setInt(4, contBEAN.getIdContato());
            if (ps.executeUpdate() > 0) {
                contBEAN.setStatus("Contato " + contBEAN.getIdContato() + " alterado com sucesso");
                return contBEAN;
            } else {
                contBEAN.setStatus("Erro ao alterar contato" + contBEAN.getIdContato());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            contBEAN.setStatus("Erro: " + e.getMessage());
        }
        return contBEAN;
    }

    public ContatoBEAN excluir(ContatoBEAN contBEAN) {
        String sql = "delete from contato where idContato = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, contBEAN.getIdContato());
            if (ps.executeUpdate() > 0) {
                contBEAN.setStatus("Contato " + contBEAN.getIdContato() + " excluído com sucesso");
            } else {
                contBEAN.setStatus("Erro ao excluir contato" + contBEAN.getIdContato());
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            contBEAN.setStatus("Erro: " + e.getMessage());
        }
        return contBEAN;
    }

    public List<ContatoBEAN> listar() {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        String sql = "select select tel_celular, tel_fixo, email from contato";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ContatoBEAN contBEAN = new ContatoBEAN();
                    contBEAN.setTel_celular(rs.getString(1));
                    contBEAN.setTel_fixo(rs.getString(2));
                    contBEAN.setEmail(rs.getString(3));
                    listaDeDados.add(contBEAN);
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
