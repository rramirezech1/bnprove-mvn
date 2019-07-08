/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import java.util.List;
import sv.gob.mined.apps.bnprove.mvn.modelo.ClasificacionEmpresaEconomico;

/**
 *
 * @author Infosoft
 */
public interface ClasificacionEmpresaEconomicoDao {

    public int create();

    public int update();

    public ClasificacionEmpresaEconomico getClasificacion();

    public void setClasificacion(ClasificacionEmpresaEconomico clasificacion);

    public ClasificacionEmpresaEconomico findByClasificacionEmpresaEconomicoId(Integer custId);

    public List<ClasificacionEmpresaEconomico> findByClasificacionEmpresaEconomicoByEmpresaId(Integer custId);
}
