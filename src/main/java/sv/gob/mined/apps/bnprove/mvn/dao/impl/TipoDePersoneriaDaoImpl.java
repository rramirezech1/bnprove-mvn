/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.TipoDePersoneriaDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.TipoDePersoneria;

/**
 *
 * @author Infosoft
 */
@Repository
public class TipoDePersoneriaDaoImpl extends XJdbcTemplate implements TipoDePersoneriaDao {

    public TipoDePersoneriaDaoImpl() {
    }

    @Override
    public List<TipoDePersoneria> findAll() {
        String sql = "SELECT * FROM TIPODEPERSONERIA";
        List<TipoDePersoneria> personerias = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(TipoDePersoneria.class));
        return personerias;
    }
}