/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.controler;

import financasgenerica.Grupo;
import financasgenerica.Usuario;
import financasgenerica.repositorio.RepositorioGrupo;
import java.util.ArrayList;

/**
 *
 * @author Otavio
 */
public class ControlerGrupo {

    public static void adicionarGrupo(String nome, Usuario usuarioAdministrador) {
        RepositorioGrupo.adicionarGrupo(new Grupo(nome, usuarioAdministrador));
    }
    public static void adicionarGrupo(String nome, Usuario usuarioAdministrador,ArrayList<Usuario> integrantes) {
        
        RepositorioGrupo.adicionarGrupo(new Grupo(nome, usuarioAdministrador,integrantes));
    }
    public static ArrayList<Grupo> gruposDoUsuarioLogado(){
        return RepositorioGrupo.gruposDoUsuarioLogado();
    }
}
