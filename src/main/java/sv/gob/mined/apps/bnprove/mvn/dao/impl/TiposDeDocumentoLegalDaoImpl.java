/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.TiposDeDocumentoLegalDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.TiposDeDocumentoLegal;

/**
 *
 * @author Infosoft
 */
@Repository
public class TiposDeDocumentoLegalDaoImpl extends XJdbcTemplate implements TiposDeDocumentoLegalDao{

    public TiposDeDocumentoLegalDaoImpl() {
    }

    @Override
    public List<TiposDeDocumentoLegal> findAll() {
        String sql = "SELECT * FROM TIPOSDEDOCUMENTOLEGAL";
        List<TiposDeDocumentoLegal> tipoDoc = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(TiposDeDocumentoLegal.class));
        return tipoDoc;
    }
}