package Models;

import Enums.UsuarioEnums;
import Models.Interfaces.UsuarioInterfaces;

import java.util.Scanner;

public class AdminModel extends UsuarioModel implements UsuarioInterfaces {
    Scanner sc = new Scanner(System.in);
    protected String senha = "softfocus123";

    public AdminModel(String nome, String cpf, String rg, String email, String telefone, Integer id) {
        super(nome, cpf, rg, email, telefone, id);
        this.tipo = UsuarioEnums.ADMIN;
    }

    public AdminModel() {
        this.tipo = UsuarioEnums.ADMIN;
    }

    @Override
    public void mudatipo(UsuarioModel usuario, String senha_usuario) {
        if(senha_usuario.equals(this.senha)){
            System.out.println("""
                        SELECIONE O TIPO QUE DESEJA ATRIBUIR AO USUARIO:\s
                        1- ADMIN
                        2- CLIENTE""");
            int opc = sc.nextInt();

            if(opc==1){
                usuario.setTipo(UsuarioEnums.ADMIN);
            }else{
                usuario.setTipo(UsuarioEnums.CLIENTE);
            }
        }else{
            System.out.println("SENHA INCORRETA!");
        }
    }
}
