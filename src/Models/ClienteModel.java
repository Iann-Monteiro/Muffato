package Models;

import Enums.UsuarioEnums;

public class ClienteModel extends UsuarioModel{
    public ClienteModel(String nome, String cpf, String rg, String email, String telefone, int id) {
        super(nome, cpf, rg, email, telefone, id);
        this.tipo = UsuarioEnums.CLIENTE;
    }

    public ClienteModel() {
        this.tipo = UsuarioEnums.CLIENTE;
    }
}
