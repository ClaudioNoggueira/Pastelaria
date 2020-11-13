/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.PastelBEAN;
import model.dao.PastelDAO;
import util.Conexao;

public class PastelControl {

    Connection con = Conexao.abrirConexao();
    PastelDAO pastelDAO = new PastelDAO(con);

    public PastelBEAN inserir(PastelBEAN pastelBEAN) {
        return pastelDAO.inserir(pastelBEAN);
    }

    public PastelBEAN consultarID(PastelBEAN pastelBEAN) {
        return pastelDAO.consultarID(pastelBEAN);
    }

    public List<PastelBEAN> consultarNome(PastelBEAN pastelBEAN) {
        List<PastelBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = pastelDAO.consultarNome(pastelBEAN);
        return listaDeDados;
    }

    public PastelBEAN alterar(PastelBEAN pastelBEAN) {
        return pastelDAO.alterar(pastelBEAN);
    }

    public PastelBEAN excluir(PastelBEAN pastelBEAN) {
        return pastelDAO.excluir(pastelBEAN);
    }

    public List<PastelBEAN> listar() {
        List<PastelBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = pastelDAO.listar();
        return listaDeDados;
    }

}
