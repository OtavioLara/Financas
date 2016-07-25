/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.repositorio;

import financasgenerica.Grupo;
import financasgenerica.Usuario;
import financasgenerica.UsuarioLogado;
import financasgenerica.beans.GrupoBeans;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio
 */
public class RepositorioGrupo {

    private static ArrayList<Grupo> grupos;

    public static void adicionarGrupo(Grupo grupo) {
        carregarGrupoBeans();
        grupos.add(grupo);
        gravarGrupos(gruposToGruposBeans());
    }

    private static void gravarGrupos(ArrayList<GrupoBeans> gruposBeans) {
        try {
            FileOutputStream fo = new FileOutputStream("grupos.fgd");
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            oo.writeObject(gruposBeans);
            oo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepositorioGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static ArrayList<GrupoBeans> gruposToGruposBeans() {
        ArrayList<GrupoBeans> gruposBeans = new ArrayList<>();
        for (Grupo grupo : grupos) {
            GrupoBeans grupoBeans = new GrupoBeans();
            grupoBeans.setId(grupo.getId());
            grupoBeans.setNome(grupo.getNome());
            grupoBeans.setParticipantes(participanteToParticipantesBeans(grupo.getParticipantes()));
            gruposBeans.add(grupoBeans);
        }
        return gruposBeans;
    }

    private static HashMap<String, Boolean> participanteToParticipantesBeans(HashMap<Usuario, Boolean> participantes) {
        HashMap<String, Boolean> participantesBeans = new HashMap<>();
        for (Map.Entry<Usuario, Boolean> entry : participantes.entrySet()) {
            Usuario key = entry.getKey();
            Boolean value = entry.getValue();
            participantesBeans.put(key.getUserName(), value);
        }
        return participantesBeans;
    }

    private static void carregarGrupoBeans() {
        try {
            FileInputStream fi = new FileInputStream("grupos.fgd");
            ObjectInputStream oi = new ObjectInputStream(fi);
            carregarGrupos((ArrayList<GrupoBeans>) oi.readObject());
            oi.close();
        } catch (FileNotFoundException ex) {
            grupos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void carregarGrupos(ArrayList<GrupoBeans> gruposBeans) {
        grupos = new ArrayList<>();
        for (GrupoBeans grupoBeans : gruposBeans) {
            grupos.add(new Grupo(grupoBeans.getNome(), participantesBeansToParticipantes(grupoBeans.getParticipantes())));
        }
    }

    private static HashMap<Usuario, Boolean> participantesBeansToParticipantes(HashMap<String, Boolean> participantesBeans) {
        HashMap<Usuario, Boolean> participantes = new HashMap<>();
        for (Map.Entry<String, Boolean> entry : participantesBeans.entrySet()) {
            String username = entry.getKey();
            Boolean value = entry.getValue();
            Usuario usuario = RepositorioUsuario.getUsuario(username);
            participantes.put(usuario, value);
        }
        return participantes;
    }

    public static void removerGrupo(Grupo grupo) {
        carregarGrupoBeans();
        if (grupos.contains(grupo)) {
            grupos.remove(grupo);
        }
    }

    public static void removerUsuarioDoGrupo(Usuario usuario, Grupo grupoAserRemovido) {
        carregarGrupoBeans();
        for (Grupo grupo : grupos) {
            grupo.removeParticipante(UsuarioLogado.getInstance().getUsuario(), usuario.getUserName());
        }
    }

    public static ArrayList<Grupo> gruposDoUsuarioLogado() {
        carregarGrupoBeans();
        ArrayList<Grupo> gruposDoUsuario = new ArrayList<>();
        for (Grupo grupo : grupos) {
            if (grupo.isParticipante(UsuarioLogado.getInstance().getUsuario())) {
                gruposDoUsuario.add(grupo);
            }
        }
        return gruposDoUsuario;
    }
}
