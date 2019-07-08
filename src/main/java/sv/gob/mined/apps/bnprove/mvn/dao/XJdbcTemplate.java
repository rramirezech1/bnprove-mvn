/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sv.gob.mined.apps.bnprove.mvn.util.JsfUtil;

/**
 *
 * @author Infosoft
 */
public class XJdbcTemplate {

    private PersistenciaDao Objeto;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int update() {
        return getJdbcTemplate().update(getObjeto().generarUpdateSQL(), getObjeto().getDatosUpdate());
    }

    public int create() {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int valor = getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
                PreparedStatement ps = cnctn.prepareStatement(getObjeto().generarInsertSQL(), Statement.RETURN_GENERATED_KEYS);
                ps = JsfUtil.setValuesPreparedStatement(ps, getObjeto().getDatosInsert());
                return ps;
            }
        }, keyHolder);

        if (valor > 0) {
            return keyHolder.getKey().intValue();
        } else {
            return JsfUtil.COD_ERROR;
        }
    }
    
    public int createIdString() {
        int valor = getJdbcTemplate().update(getObjeto().generarInsertSQL(), getObjeto().getDatosInsert());
            
        if (valor > 0) {
            return valor;
        } else {
            return JsfUtil.COD_ERROR;
        }
    }

    public PersistenciaDao getObjeto() {
        return Objeto;
    }

    public void setObjeto(PersistenciaDao Objeto) {
        this.Objeto = Objeto;
    }
}