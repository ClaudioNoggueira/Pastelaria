/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ContatoControl;
import control.LogradouroControl;
import control.PessoaControl;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.ContatoBEAN;
import model.bean.LogradouroBEAN;
import model.bean.PessoaBEAN;

/**
 *
 * @author claud
 */
public class PessoaView {

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa"));
        PessoaBEAN pesBEAN = new PessoaBEAN(idPessoa);
        PessoaControl contPes = new PessoaControl();
        pesBEAN = contPes.consultarID(pesBEAN);
        ContatoBEAN contBEAN = new ContatoBEAN(pesBEAN.getIdContato());
        ContatoControl contContato = new ContatoControl();
        contBEAN = contContato.consultarID(contBEAN);
        LogradouroBEAN logBEAN = new LogradouroBEAN(pesBEAN.getIdLogradouro());
        LogradouroControl contLog = new LogradouroControl();
        logBEAN = contLog.consultarID(logBEAN);
        JOptionPane.showMessageDialog(null, pesBEAN.toString());
        JOptionPane.showMessageDialog(null, contBEAN.toString());
        JOptionPane.showMessageDialog(null, logBEAN.toString());

    }
}
