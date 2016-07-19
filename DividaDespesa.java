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
public class DividaDespesa extends Divida {
    private double valorPago;

    public DividaDespesa(double valorTotal,double valorPago) {
        super(valorTotal);
        this.valorPago = valorPago;
    }

    /**
     * @return the valorPago
     */
    public boolean isMaior(DividaDespesa outra){
        return this.getValor() == outra.getValor();
    }
    public double getValorPago() {
        return valorPago;
    }
    public double valorApagar(){
        return getValor() - valorPago;
    }
    public double valorAreceber(){
        return valorPago - getValor();
    }
}
