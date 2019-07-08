/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.EstadoDeRegistroDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.EstadoDeRegistro;

/**
 *
 * @author Infosoft
 */
@Repository
public class EstadoDeRegistroDaoImpl extends XJdbcTemplate implements EstadoDeRegistroDao{

    public EstadoDeRegistroDaoImpl() {
    }

    @Override
    public List<EstadoDeRegistro> findAll() {
       String sql = "SELECT * FROM ESTADODEREGISTRO";
        List<EstadoDeRegistro> estados = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(EstadoDeRegistro.class));
        return estados;
    }
}