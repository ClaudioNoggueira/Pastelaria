package control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.bean.BebidaBEAN;
import model.dao.BebidaDAO;
import util.Conexao;

public class BebidaControl {

    Connection con = Conexao.abrirConexao();
    BebidaDAO bebidaDAO = new BebidaDAO(con);

    public BebidaBEAN inserir(BebidaBEAN bebidaBEAN) {
        return bebidaDAO.inserir(bebidaBEAN);
    }

    public List<BebidaBEAN> consultarNome(BebidaBEAN bebidaBEAN) {
        List<BebidaBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = bebidaDAO.consultarNome(bebidaBEAN);
        return listaDeDados;
    }
    public BebidaBEAN consultarID(BebidaBEAN bebidaBEAN){
        return bebidaDAO.consultarID(bebidaBEAN);
    }

    public BebidaBEAN alterar(BebidaBEAN bebidaBEAN) {
        return bebidaDAO.alterar(bebidaBEAN);
    }

    public BebidaBEAN excluir(BebidaBEAN bebidaBEAN) {
        return bebidaDAO.excluir(bebidaBEAN);
    }

    public List<BebidaBEAN> listar() {
        List<BebidaBEAN> listaDeDados = new ArrayList<>();
        listaDeDados = bebidaDAO.listar();
        return listaDeDados;
    }
}
