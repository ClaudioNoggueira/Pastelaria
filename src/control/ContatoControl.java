/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.ContatoBEAN;
import model.dao.ContatoDAO;
import util.Conexao;

/**
 *
 * @author claud
 */
public class ContatoControl {

    Connection con = Conexao.abrirConexao();
    ContatoDAO contDAO = new ContatoDAO(con);

    public ContatoBEAN inserir(ContatoBEAN contBEAN) {
        return contDAO.inserir(contBEAN);
    }

    public ContatoBEAN consultarID(ContatoBEAN contBEAN) {
        return contDAO.consultarID(contBEAN);
    }

    public List<ContatoBEAN> consultarTelFixo(ContatoBEAN contBEAN) {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = contDAO.consultarTelFixo(contBEAN);
        return listaDeDados;
    }

    public List<ContatoBEAN> consultarTelCelular(ContatoBEAN contBEAN) {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = contDAO.consultarTelCelular(contBEAN);
        return listaDeDados;
    }

    public List<ContatoBEAN> consultarEmail(ContatoBEAN contBEAN) {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = contDAO.consultarEmail(contBEAN);
        return listaDeDados;
    }

    public ContatoBEAN alterar(ContatoBEAN contBEAN) {
        return contDAO.alterar(contBEAN);
    }

    public ContatoBEAN excluir(ContatoBEAN contBEAN) {
        return contDAO.excluir(contBEAN);
    }

    public List<ContatoBEAN> listar() {
        List<ContatoBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = contDAO.listar();
        return listaDeDados;
    }
}
