/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.VendaBEAN;
import model.dao.VendaDAO;
import util.Conexao;

/**
 *
 * @author claud
 */
public class VendaControl {

    Connection con = Conexao.abrirConexao();
    VendaDAO vendaDAO = new VendaDAO(con);

    public VendaBEAN inserir(VendaBEAN vendaBEAN) {
        return vendaDAO.inserir(vendaBEAN);
    }

    public VendaBEAN consultarIDPedido(VendaBEAN vendaBEAN) {
        return vendaDAO.consultarIDPedido(vendaBEAN);
    }

    public VendaBEAN excluir(VendaBEAN vendaBEAN) {
        return vendaDAO.excluir(vendaBEAN);
    }

    public List<VendaBEAN> listar() {
        List<VendaBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = vendaDAO.listar();
        return listaDeDados;
    }

}
