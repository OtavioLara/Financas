/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financasgenerica.exceptions;

/**
 *
 * @author Otavio
 */
public class SomaNaoCorrespondeAValorException extends RuntimeException {
    
    public SomaNaoCorrespondeAValorException(double soma, double valor) {
        super("Valor da soma (" + soma + ") é diferente do valor recebido (" + valor + ").");
    }

}
