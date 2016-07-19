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
public abstract class Divida  {
    private double valor;
    
    public Divida(double valor){
        this.valor = valor;
    }

    /**
     * @return the valorTotal
     */
    public double getValor(){
        return this.valor;
    }
}
