/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import java.util.List;
import sv.gob.mined.apps.bnprove.mvn.modelo.SectorEconomico;

/**
 *
 * @author Infosoft
 */
public interface SectorEconomicoDao {

    public List<SectorEconomico> findAll();
    public List<SectorEconomico> findAllSub(Integer idSector);
}
