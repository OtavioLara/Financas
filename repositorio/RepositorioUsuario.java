/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.repositorio;

import financasgenerica.Usuario;
import java.util.HashMap;

/**
 *
 * @author Otavio
 */
public final class RepositorioUsuario {

    private static HashMap<String, Usuario> usuarios = new HashMap<>();

    public static void adicionarUsuario(Usuario usuario){
        if (!usuarios.containsKey(usuario)) {
            usuarios.put(usuario.getUserName(), usuario);
        }
    }
    
    public static Usuario getUsuario(String username) {
        return usuarios.get(username);
    }
}
