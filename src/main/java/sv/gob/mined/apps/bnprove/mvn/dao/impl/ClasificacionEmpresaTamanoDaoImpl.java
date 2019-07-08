/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.ClasificacionEmpresaTamanoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.ClasificacionEmpresaTamano;

/**
 *
 * @author Infosoft
 */
@Repository
public class ClasificacionEmpresaTamanoDaoImpl extends XJdbcTemplate implements ClasificacionEmpresaTamanoDao {

    public ClasificacionEmpresaTamanoDaoImpl() {
    }

    @Override
    public List<ClasificacionEmpresaTamano> findAll() {
        String sql = "SELECT * FROM CLASIFICACIONEMPRESATAMANO";
        List<ClasificacionEmpresaTamano> empresaTamano = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(ClasificacionEmpresaTamano.class));
        return empresaTamano;
    }
}