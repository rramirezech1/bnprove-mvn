/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.RegimenDeAdministracionDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.RegimenDeAdministracion;

/**
 *
 * @author Infosoft
 */
@Repository
public class RegimenDeAdministracionDaoImpl extends XJdbcTemplate implements RegimenDeAdministracionDao{

    public RegimenDeAdministracionDaoImpl() {
    }

    @Override
    public List<RegimenDeAdministracion> findAll() {
        String sql = "SELECT * FROM REGIMENDEADMINISTRACION";
        List<RegimenDeAdministracion> pais = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(RegimenDeAdministracion.class));
        return pais;
    }
}