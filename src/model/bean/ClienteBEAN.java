/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author claud
 */
public class ClienteBEAN {

    private int idCliente, idPedido, idPessoa;
    private String status;

    public ClienteBEAN() {
    }

    public ClienteBEAN(int idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteBEAN(int idCliente, int idPedido, int idPessoa) {
        this.idCliente = idCliente;
        this.idPedido = idPedido;
        this.idPessoa = idPessoa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
