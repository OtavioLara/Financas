/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.controler;

import financasgenerica.repositorio.RepositorioUsuario;
import financasgenerica.Usuario;

/**
 * @author Otavio
 */
public class ControlerUsuario {

    public static void cadastrarUsuario(String nome, String email, String userName, String senha) {
        RepositorioUsuario.adicionarUsuario(new Usuario(nome, email, userName, senha));
    }

}
