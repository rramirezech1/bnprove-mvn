/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

/**
 *
 * @author Infosoft
 */
public class Genero {
    private Integer identificadorDeGenero;
    private String codigoDeGenero;
    private String descripcionDelGenero;

    public Genero() {
    }

    public String getCodigoDeGenero() {
        return codigoDeGenero;
    }

    public void setCodigoDeGenero(String codigoDeGenero) {
        this.codigoDeGenero = codigoDeGenero;
    }

    public String getDescripcionDelGenero() {
        return descripcionDelGenero;
    }

    public void setDescripcionDelGenero(String descripcionDelGenero) {
        this.descripcionDelGenero = descripcionDelGenero;
    }

    public Integer getIdentificadorDeGenero() {
        return identificadorDeGenero;
    }

    public void setIdentificadorDeGenero(Integer identificadorDeGenero) {
        this.identificadorDeGenero = identificadorDeGenero;
    }

    @Override
    public String toString() {
        return descripcionDelGenero;
    }
    
    
    
}
