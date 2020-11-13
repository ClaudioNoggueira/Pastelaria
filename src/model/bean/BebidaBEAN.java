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
public class BebidaBEAN {

    private int idBebida;
    private String nome_bebida, descricao, img_bebida, status;
    private float preco;

    public BebidaBEAN() {
    }

    public BebidaBEAN(int idBebida) {
        this.idBebida = idBebida;
    }

    public BebidaBEAN(String nome_bebida) {
        this.nome_bebida = nome_bebida;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public String getNome_bebida() {
        return nome_bebida;
    }

    public void setNome_bebida(String nome_bebida) {
        this.nome_bebida = nome_bebida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImg_bebida() {
        return img_bebida;
    }

    public void setImg_bebida(String img_bebida) {
        this.img_bebida = img_bebida;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
