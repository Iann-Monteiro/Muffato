package Models;

import Enums.UsuarioEnums;

public class UsuarioModel {
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private Integer id;
    protected UsuarioEnums tipo;

    public UsuarioModel(String nome, String cpf, String rg, String email, String telefone, Integer id) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
        this.tipo = UsuarioEnums.CLIENTE;
    }

    public UsuarioModel() {
        this.tipo = UsuarioEnums.CLIENTE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(UsuarioEnums tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nome: "+getNome()+" Cpf: "+getCpf()+" Rg: "+getRg()+" Email: "+getEmail()+
                " Telefone: "+getTelefone()+" Id: "+getId()+" Tipo: "+this.tipo+"\n";
    }
}
