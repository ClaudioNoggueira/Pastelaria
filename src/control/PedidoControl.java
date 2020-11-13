/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.PedidoBEAN;
import model.dao.PedidoDAO;
import util.Conexao;

/**
 *
 * @author claud
 */
public class PedidoControl {
    Connection con = Conexao.abrirConexao();
    PedidoDAO pedDAO = new PedidoDAO(con);
    
    
    public PedidoBEAN inserir(PedidoBEAN pedBEAN){
        return pedDAO.inserir(pedBEAN);
    }
    public PedidoBEAN consultarID(PedidoBEAN pedBEAN){
        return pedDAO.consultarID(pedBEAN);
    }
    public PedidoBEAN alterar(PedidoBEAN pedBEAN){
        return pedDAO.alterar(pedBEAN);
    }
    public PedidoBEAN excluir(PedidoBEAN pedBEAN){
        return pedDAO.excluir(pedBEAN);
    }
    public List<PedidoBEAN> listar(){
        List<PedidoBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = pedDAO.listar();
        return listaDeDados;
    }
}
