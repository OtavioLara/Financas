/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.controler;

import financasgenerica.Grupo;
import financasgenerica.Usuario;
import financasgenerica.repositorio.RepositorioGrupo;
import financasgenerica.repositorio.RepositorioUsuario;

/**
 *
 * @author Otavio
 */
public class ControlerGrupo {

    public static void adicionarGrupo(String nome, Usuario usuarioAdministrador) {
        RepositorioGrupo.cadastrarGrupo(new Grupo(nome, usuarioAdministrador));
    }
}
