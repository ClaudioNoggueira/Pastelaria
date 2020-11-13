/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.UsuarioBEAN;
import model.dao.UsuarioDAO;
import util.Conexao;

/**
 *
 * @author claud
 */
public class UsuarioControl {

    Connection con = Conexao.abrirConexao();
    UsuarioDAO usuDAO = new UsuarioDAO(con);

    public UsuarioBEAN inserir(UsuarioBEAN usuBEAN) {
        return usuDAO.inserir(usuBEAN);
    }

    public UsuarioBEAN consultarID(UsuarioBEAN usuBEAN) {
        return usuDAO.consultarID(usuBEAN);
    }

    public List<UsuarioBEAN> consultarLogin(UsuarioBEAN usuBEAN) {
        List<UsuarioBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = usuDAO.consultarLogin(usuBEAN);
        return listaDeDados;
    }
    public UsuarioBEAN validarUsuario(UsuarioBEAN usuBEAN){
        return usuDAO.validarUsuario(usuBEAN);
    }
    public UsuarioBEAN alterar(UsuarioBEAN usuBEAN) {
        return usuDAO.alterar(usuBEAN);
    }

    public UsuarioBEAN excluir(UsuarioBEAN usuBEAN) {
        return usuDAO.excluir(usuBEAN);
    }

    public List<UsuarioBEAN> listar() {
        List<UsuarioBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = usuDAO.listar();
        return listaDeDados;
    }
}
