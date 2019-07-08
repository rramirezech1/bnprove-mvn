/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.MunicipioDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.Municipio;

/**
 *
 * @author Infosoft
 */
@Repository
public class MunicipioDaoImpl extends XJdbcTemplate implements MunicipioDao {
    
    public MunicipioDaoImpl() {
    }

    @Override
    public List<Municipio> findAll() {
        String sql = "SELECT * FROM MUNICIPIO";
        List<Municipio> municipios = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Municipio.class));
        return municipios;
    }

    @Override
    public List<Municipio> findAllByDepartamento(Integer codigoDepartamento) {
        String sql = "SELECT * FROM MUNICIPIO WHERE identificadorDelDepartamento="+codigoDepartamento+"";
        List<Municipio> municipios = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Municipio.class));
        return municipios;
    }
}