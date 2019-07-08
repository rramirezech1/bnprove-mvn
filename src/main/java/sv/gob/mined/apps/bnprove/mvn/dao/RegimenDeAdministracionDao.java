/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import java.util.List;
import sv.gob.mined.apps.bnprove.mvn.modelo.RegimenDeAdministracion;

/**
 *
 * @author Infosoft
 */
public interface RegimenDeAdministracionDao {
    public List<RegimenDeAdministracion> findAll();
}
