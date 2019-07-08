/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

/**
 *
 * @author Infosoft
 */
public class EstadoDeRegistro {
    private Integer IdentificadorDelEstadoDeRegistro;
    private String descripcionDeEstado;

    public EstadoDeRegistro() {
    }

    public Integer getIdentificadorDelEstadoDeRegistro() {
        return IdentificadorDelEstadoDeRegistro;
    }

    public void setIdentificadorDelEstadoDeRegistro(Integer IdentificadorDelEstadoDeRegistro) {
        this.IdentificadorDelEstadoDeRegistro = IdentificadorDelEstadoDeRegistro;
    }

    public String getDescripcionDeEstado() {
        return descripcionDeEstado;
    }

    public void setDescripcionDeEstado(String descripcionDeEstado) {
        this.descripcionDeEstado = descripcionDeEstado;
    }

    @Override
    public String toString() {
        return descripcionDeEstado;
    }
    
    
    
}
