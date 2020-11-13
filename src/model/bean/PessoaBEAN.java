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
public class PessoaBEAN {

    private int idPessoa;
    private String nome;
    private String CPF;
    private String tipo;
    private String status;
    private int idContato;
    private int idLogradouro;

    public PessoaBEAN() {
    }

    public PessoaBEAN(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public PessoaBEAN(String nomeOUcpf) {
        this.nome = nomeOUcpf;
        this.CPF = nomeOUcpf;
    }
    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public int getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PessoaBEAN{" + "idPessoa=" + idPessoa + ", nome=" + nome + ", CPF=" + CPF + ", tipo=" + tipo + ", idLogradouro=" + idLogradouro + ", idContato=" + idContato +'}';
    }

}
