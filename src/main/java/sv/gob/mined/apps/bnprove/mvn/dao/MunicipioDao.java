/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import java.util.List;
import sv.gob.mined.apps.bnprove.mvn.modelo.Municipio;

/**
 *
 * @author Infosoft
 */
public interface MunicipioDao {

    public List<Municipio> findAll();

    public List<Municipio> findAllByDepartamento(Integer codigoDepartamento);
}
