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
import model.bean.UsuarioBEAN;

/**
 *
 * @author claud
 */
public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public UsuarioBEAN inserir(UsuarioBEAN usuBEAN) {
        String sql = "insert into usuario(login, senha, idPessoa) values(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuBEAN.getLogin());
            ps.setString(2, usuBEAN.getSenha());
            ps.setInt(3, usuBEAN.getIdPessoa());
            if (ps.executeUpdate() > 0) {
                usuBEAN.setStatus("Usuario inserido com sucesso.");
                ps.close();
                con.close();
                return usuBEAN;
            } else {
                usuBEAN.setStatus("Erro ao inserir usuário.");
            }
        } catch (SQLException e) {
            usuBEAN.setStatus(e.getMessage());
        }
        return usuBEAN;
    }

    public UsuarioBEAN consultarID(UsuarioBEAN usuBEAN) {
        String sql = "select login, senha, idPessoa from usuario where idUsuario = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, usuBEAN.getIdUsuario());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    usuBEAN.setLogin(rs.getString(1));
                    usuBEAN.setSenha(rs.getString(2));
                    usuBEAN.setIdPessoa(rs.getInt(3));
                }
                ps.close();
                con.close();
                return usuBEAN;
            } else {
                usuBEAN.setStatus("Sem resultados para usuario com ID '" + usuBEAN.getIdPessoa() + "'");
            }
        } catch (SQLException e) {
            usuBEAN.setStatus(e.getMessage());
        }
        return usuBEAN;
    }

    public List<UsuarioBEAN> consultarLogin(UsuarioBEAN usuBEAN) {
        String sql = "select * from usuario where login like ?";
        List<UsuarioBEAN> listaDeDados = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, "%" + usuBEAN.getLogin() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    UsuarioBEAN usuLista = new UsuarioBEAN();
                    usuLista.setIdUsuario(rs.getInt(1));
                    usuLista.setLogin(rs.getString(2));
                    usuLista.setSenha(rs.getString(3));
                    usuLista.setIdPessoa(rs.getInt(4));
                    listaDeDados.add(usuLista);
                }
                ps.close();
                con.close();
                return listaDeDados;
            } else {
                usuBEAN.setStatus("Sem resultados para login '" + usuBEAN.getLogin() + "'");
            }
        } catch (SQLException e) {
            usuBEAN.setStatus("Erro: " + e.getMessage());
        }
        listaDeDados.add(usuBEAN);
        return listaDeDados;
    }

    public UsuarioBEAN validarUsuario(UsuarioBEAN usuBEAN) {
        String sql = "select * from usuario where login like ? and senha like ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuBEAN.getLogin());
            ps.setString(2, usuBEAN.getSenha());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    usuBEAN.setIdUsuario(rs.getInt(1));
                    usuBEAN.setLogin(rs.getString(2));
                    usuBEAN.setSenha(rs.getString(3));
                    usuBEAN.setIdPessoa(rs.getInt(4));
                    usuBEAN.setStatus("Bem-vindo(a) " + usuBEAN.getLogin());
                }
                ps.close();
                con.close();
                return usuBEAN;
            }
            usuBEAN.setStatus("Usuário ou senha inválidos.");
            ps.close();
            con.close();
        } catch (SQLException e) {
            usuBEAN.setStatus("Erro: " + e.getMessage());
        }
        return usuBEAN;
    }

    public UsuarioBEAN alterar(UsuarioBEAN usuBEAN) {
        String sql = "update from usuario set login = ?, senha = ? where idUsuario = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuBEAN.getLogin());
            ps.setString(2, usuBEAN.getSenha());
            ps.setInt(3, usuBEAN.getIdUsuario());
            if (ps.executeUpdate() > 0) {
                usuBEAN.setStatus("Usuario alterado com sucesso.");
                ps.close();
                con.close();
                return usuBEAN;
            } else {
                usuBEAN.setStatus("Erro ao alterar usuário.");
            }
        } catch (SQLException e) {
            usuBEAN.setStatus(e.getMessage());
        }
        return usuBEAN;
    }

    public UsuarioBEAN excluir(UsuarioBEAN usuBEAN) {
        String sql = "delete from usuario where idUsuario = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, usuBEAN.getIdUsuario());
            if (ps.executeUpdate() > 0) {
                usuBEAN.setStatus("Usuario excluído com sucesso.");
                ps.close();
                con.close();
                return usuBEAN;
            } else {
                usuBEAN.setStatus("Erro ao excluír usuário.");
            }
        } catch (SQLException e) {
            usuBEAN.setStatus(e.getMessage());
        }
        return usuBEAN;
    }

    public List<UsuarioBEAN> listar() {
        String sql = "select login, senha, idPessoa from usuario";
        List<UsuarioBEAN> listaDeDados = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    UsuarioBEAN usuBEAN = new UsuarioBEAN();
                    usuBEAN.setLogin(rs.getString(1));
                    usuBEAN.setSenha(rs.getString(2));
                    usuBEAN.setIdPessoa(rs.getInt(3));
                    listaDeDados.add(usuBEAN);
                }
                ps.close();
                con.close();
            }
            return listaDeDados;
        } catch (SQLException e) {

        }
        return null;
    }
}
