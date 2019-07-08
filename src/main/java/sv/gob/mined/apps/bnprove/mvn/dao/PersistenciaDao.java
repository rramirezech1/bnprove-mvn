/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

/**
 *
 * @author Infosoft
 */
public interface PersistenciaDao {

    public String generarInsertSQL();

    public Object[] getDatosInsert();

    public String generarUpdateSQL();

    public Object[] getDatosUpdate();
}
