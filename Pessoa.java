/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

/**
 *
 * @author Otavio
 */
public abstract class Pessoa {
    private String nome;
    private String email;

    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
}
