/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.GeneroDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.Genero;

/**
 *
 * @author Infosoft
 */
@Repository
public class GeneroDaoImpl extends XJdbcTemplate implements GeneroDao{

    public GeneroDaoImpl() {
    }

    @Override
    public List<Genero> findAll() {
        String sql = "SELECT * FROM GENERO";
        List<Genero> generos = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Genero.class));
        return generos;
    }
}