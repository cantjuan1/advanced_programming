/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utadeo.programacion.avanzada.exposicion.graphviz;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Route implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7041735063481987880L;
    private int vertex;
    private boolean known;
    private int distance;
    private String previousVertex;

    public Route(int vertex, boolean known, int distance,
            String previousVertex) {
        this.vertex = vertex;
        this.known = known;
        this.distance = distance;
        this.previousVertex = previousVertex;
    }

    /**
     * @return the vertex
     */
    public int getVertex() {
        return vertex;
    }

    /**
     * @param vertex the vertex to set
     */
    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    /**
     * @return the know
     */
    public boolean isKnown() {
        return known;
    }

    /**
     * @param known the know to set
     */
    public void setKnown(boolean known) {
        this.known = known;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return the previousVertex
     */
    public String getPreviousVertex() {
        return previousVertex;
    }

    /**
     * @param previousVertex the previousVertex to set
     */
    public void setPreviousVertex(String previousVertex) {
        this.previousVertex = previousVertex;
    }
}
