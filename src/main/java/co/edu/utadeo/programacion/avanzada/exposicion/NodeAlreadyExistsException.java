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
public class NodeAlreadyExistsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -2081501227051900268L;

    public NodeAlreadyExistsException(String message) {
        super(message);
    }
}
