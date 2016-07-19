/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica;

import java.util.Date;

/**
 *
 * @author Otavio
 */
public abstract class Despesa {
    private double valor;
    private String nome;
    private String descricao;
    private Date data;
    private long id;
    public static long totalDespesas;
    
    public Despesa(String nome, double valor, Date data, String descricao){
        this(nome, valor, data);
        this.descricao = descricao;
    }
    public Despesa(String nome, double valor, Date data){
        this.nome = nome;
        this.valor = valor;
        this.data = data;
        totalDespesas++;
        id = totalDespesas+1;
    }
    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Despesa other = (Despesa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public abstract boolean isParticipante(Pessoa pessoa);
    
}
