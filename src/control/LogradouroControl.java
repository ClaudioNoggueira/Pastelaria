/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.LogradouroBEAN;
import model.dao.LogradouroDAO;
import util.Conexao;

/**
 *
 * @author claud
 */
public class LogradouroControl {

    Connection con = Conexao.abrirConexao();
    LogradouroDAO logDAO = new LogradouroDAO(con);

    public LogradouroBEAN inserir(LogradouroBEAN logBEAN) {
        return logDAO.inserir(logBEAN);
    }

    public LogradouroBEAN consultarID(LogradouroBEAN logBEAN) {
        return logDAO.consultarID(logBEAN);
    }

    public List<LogradouroBEAN> consultarRua(LogradouroBEAN logBEAN) {
        List<LogradouroBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = logDAO.consultarRua(logBEAN);
        return listaDeDados;
    }

    public LogradouroBEAN alterar(LogradouroBEAN logBEAN) {
        return logDAO.alterar(logBEAN);
    }

    public LogradouroBEAN excluir(LogradouroBEAN logBEAN) {
        return logDAO.excluir(logBEAN);
    }

    public List<LogradouroBEAN> listar() {
        List<LogradouroBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = logDAO.listar();
        return listaDeDados;
    }
}
