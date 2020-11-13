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
public class LogradouroBEAN {

    private int idLogradouro;
    private String tipo, rua, numero, bairro, complemento, status;

    public LogradouroBEAN() {

    }

    public LogradouroBEAN(String rua) {
        this.rua = rua;
    }

    public LogradouroBEAN(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public int getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LogradouroBEAN{" + "idLogradouro=" + idLogradouro + ", tipo=" + tipo + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + '}';
    }

}
