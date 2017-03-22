/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utadeo.programacion.avanzada.exposicion;

/**
 *
 * @author juan.cantor
 */
public class EdgeDoesNotExistException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1064878699823438640L;

    public EdgeDoesNotExistException(String message) {
        super(message);
    }
}
