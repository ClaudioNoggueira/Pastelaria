/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.ClienteBEAN;
import model.dao.ClienteDAO;
import util.Conexao;

/**
 *
 * @author claud
 */
public class ClienteControl {

    Connection con = Conexao.abrirConexao();
    ClienteDAO cliDAO = new ClienteDAO(con);

    public ClienteBEAN inserir(ClienteBEAN cliBEAN) {
        return cliDAO.inserir(cliBEAN);
    }

    public ClienteBEAN consultarIDCliente(ClienteBEAN cliBEAN) {
        return cliDAO.consultarIDCliente(cliBEAN);
    }

    public ClienteBEAN consultarIDPessoa(ClienteBEAN cliBEAN) {
        return cliDAO.consultarIDPessoa(cliBEAN);
    }
    
    public ClienteBEAN excluir(ClienteBEAN cliBEAN){
        return cliDAO.excluir(cliBEAN);
    }
    public List<ClienteBEAN> listar(){
        List<ClienteBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = cliDAO.listar();
        return listaDeDados;
    }
}
