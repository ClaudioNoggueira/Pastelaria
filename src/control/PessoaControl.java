/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.PessoaBEAN;
import model.dao.PessoaDAO;
import util.Conexao;

/**
 *
 * @author claud
 */
public class PessoaControl {

    Connection con = Conexao.abrirConexao();
    PessoaDAO pesDAO = new PessoaDAO(con);

    public PessoaBEAN inserir(PessoaBEAN pesBEAN) {
        return pesDAO.inserir(pesBEAN);
    }

    public PessoaBEAN consultarID(PessoaBEAN pesBEAN) {
        return pesDAO.consultarID(pesBEAN);
    }

    public List<PessoaBEAN> consultarNome(PessoaBEAN pesBEAN) {
        List<PessoaBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = pesDAO.consultarNome(pesBEAN);
        return listaDeDados;
    }

    public PessoaBEAN consultarCPF(PessoaBEAN pesBEAN) {
        return pesDAO.consultarCPF(pesBEAN);
    }

    public PessoaBEAN alterar(PessoaBEAN pesBEAN) {
        return pesDAO.alterar(pesBEAN);
    }

    public PessoaBEAN excluir(PessoaBEAN pesBEAN) {
        return pesDAO.excluir(pesBEAN);
    }

    public List<PessoaBEAN> listar() {
        List<PessoaBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = pesDAO.listar();
        return listaDeDados;
    }
}
