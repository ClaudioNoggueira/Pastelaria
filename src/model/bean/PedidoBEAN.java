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
public class PedidoBEAN {

    private int idPedido, qtdePastel, qtdeBebida, idPastel, idBebida;
    private String status;

    public PedidoBEAN() {
    }

    public PedidoBEAN(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQtdePastel() {
        return qtdePastel;
    }

    public void setQtdePastel(int qtdePastel) {
        this.qtdePastel = qtdePastel;
    }

    public int getQtdeBebida() {
        return qtdeBebida;
    }

    public void setQtdeBebida(int qtdeBebida) {
        this.qtdeBebida = qtdeBebida;
    }

    public int getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(int idPastel) {
        this.idPastel = idPastel;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
