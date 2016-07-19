/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.repositorio;

import financasgenerica.Grupo;
import financasgenerica.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Otavio
 */
public class RepositorioGrupo {

    private static ArrayList<Grupo> grupos = new ArrayList<>();

    public static void cadastrarGrupo(Grupo grupo) {
        if (!grupos.contains(grupo)) {
            grupos.add(grupo);
        }
    }

    public static void removerGrupo(Grupo grupo) {
        if (!grupos.contains(grupo)) {
            grupos.remove(grupo);
        }
    }
    public static void removerUsuarioDoGrupo(Usuario usuario, Grupo grupo){
        if(grupos.contains(grupo)){
            //implements
        }
    }
}
