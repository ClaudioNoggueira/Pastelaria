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
public class ContatoBEAN {

    private int idContato;
    private String tel_celular, tel_fixo, email, status;

    public ContatoBEAN() {
    }

    public ContatoBEAN(int idContato) {
        this.idContato = idContato;
    }

    public ContatoBEAN(String telefoneOUemail) {
        this.tel_celular = telefoneOUemail;
        this.tel_fixo = telefoneOUemail;
        this.email = telefoneOUemail;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }

    public String getTel_fixo() {
        return tel_fixo;
    }

    public void setTel_fixo(String tel_fixo) {
        this.tel_fixo = tel_fixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContatoBEAN{" + "idContato=" + idContato + ", tel_celular=" + tel_celular + ", tel_fixo=" + tel_fixo + ", email=" + email + '}';
    }

}
