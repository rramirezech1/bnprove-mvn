/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

/**
 *
 * @author Infosoft
 */
public class RegimenDeAdministracion {

    private Integer identificadorDelRegimenDeAdmon;
    private String descripcionDelRegimenAdmon;

    public RegimenDeAdministracion() {
    }

    public Integer getIdentificadorDelRegimenDeAdmon() {
        return identificadorDelRegimenDeAdmon;
    }

    public void setIdentificadorDelRegimenDeAdmon(Integer identificadorDelRegimenDeAdmon) {
        this.identificadorDelRegimenDeAdmon = identificadorDelRegimenDeAdmon;
    }

    public String getDescripcionDelRegimenAdmon() {
        return descripcionDelRegimenAdmon;
    }

    public void setDescripcionDelRegimenAdmon(String descripcionDelRegimenAdmon) {
        this.descripcionDelRegimenAdmon = descripcionDelRegimenAdmon;
    }

    @Override
    public String toString() {
        return descripcionDelRegimenAdmon;
    }
}