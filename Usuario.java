/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

import java.util.Objects;

/**
 *
 * @author Otavio
 */
public class Usuario extends Pessoa implements Comparable<Usuario>{

    private String userName;
    private String senha;

    public Usuario(String nome, String email, String userName, String senha) {
        super(nome, email);
        this.userName = userName;
        this.senha = senha;
    }

    public boolean logar(String userName, String senha) {
        if (this.userName.equals(userName)) {
            return this.senha.equals(senha);
        } else {
            return false;
        }
    }

    public boolean alterarSenha(String senhaAntiga, String novaSenha) {
        if (senhaAntiga.equals(this.senha)) {
            this.senha = novaSenha;
            return true;
        } else {
            return false;
        }

    }

    public boolean alterarUserName(String novoUserName, String senha) {
        if (senha.equals(this.senha)) {
            this.userName = novoUserName;
            return true;
        } else {
            return false;
        }

    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(){
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Usuario o) {
        return userName.compareTo(o.userName);
    }
    
    
}
