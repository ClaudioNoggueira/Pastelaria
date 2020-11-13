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
public class PastelBEAN {

    private int idPastel;
    private String nome_pastel, descricao, img_pastel, status;
    private float preco;

    public PastelBEAN() {

    }

    public PastelBEAN(int idPastel) {
        this.idPastel = idPastel;
    }

    public PastelBEAN(String nome_pastel) {
        this.nome_pastel = nome_pastel;
    }

    public int getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(int idPastel) {
        this.idPastel = idPastel;
    }

    public String getNome_pastel() {
        return nome_pastel;
    }

    public void setNome_pastel(String nome_pastel) {
        this.nome_pastel = nome_pastel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImg_pastel() {
        return img_pastel;
    }

    public void setImg_pastel(String img_pastel) {
        this.img_pastel = img_pastel;
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
