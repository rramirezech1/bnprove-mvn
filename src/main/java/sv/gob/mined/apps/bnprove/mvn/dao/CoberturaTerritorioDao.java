/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import java.util.List;
import sv.gob.mined.apps.bnprove.mvn.modelo.CoberturaTerritorio;

/**
 *
 * @author Infosoft
 */
public interface CoberturaTerritorioDao {
    public void setCoberturaTerritorio(CoberturaTerritorio cobertura);
    public CoberturaTerritorio getCoberturaTerritorio();
    public int create();
    public int update();
    public List<CoberturaTerritorio> findByCoberturaTerritorioId(Integer custId);
}
