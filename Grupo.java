/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

import financasgenerica.exceptions.UsuarioNotInGrupoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Otavio
 */
public class Grupo {

    /**
     * HashMap onde a chave (key) é um usuário e o valor (value) é um boolean
     * representando se o usuário é administrador ou não.
     */
    private HashMap<Usuario, Boolean> participantes;
    private String nome;
    private static long totalGrupos;
    private long id;

    public Grupo(String nome, Usuario usuarioAdministrador) {
        this.nome = nome;
        addParticipante(usuarioAdministrador,true);
        totalGrupos++;
        id = totalGrupos+1;
    }
    public Grupo(String nome, Usuario usuarioAdministrador, ArrayList<Usuario> usuarios) {
        this(nome, usuarioAdministrador);
        addParticipantes(usuarios);
        
    }
    public void addParticipantes(ArrayList<Usuario> participantes){
        for (Usuario participante : participantes) {
            addParticipante(participante,false);
        }
    }
    public void addParticipante(Usuario u) {
        participantes.put(u, false);
    }

    public void addParticipante(Usuario u, boolean isAdm) {
        participantes.put(u, isAdm);
    }

    public void setAdministrador(Usuario u, boolean newAdmState) throws UsuarioNotInGrupoException {
        if (participantes.containsKey(u)) {
            participantes.put(u, newAdmState);
        } else {
            throw new UsuarioNotInGrupoException(u.getNome(), nome);
        }
    }
    public boolean isAdministrador(Usuario u){
        if(isParticipante(u)){
            return participantes.get(u);
        }
        return false;
    }
    public boolean isParticipante(Usuario u){
        return participantes.containsKey(u);
    }
    public void removeParticipante(Usuario removedor, Usuario aRemover)  {
        if(isAdministrador(removedor)){
            if(isParticipante(aRemover)){
                participantes.remove(aRemover);
            }
        }
    }
    public void removeParticipante(Usuario usuario){
        if(isParticipante(usuario)){
            participantes.remove(usuario);
        }
    }
    public String getNome(){
        return this.nome;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
        
}
