/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.CoberturaTerritorioDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.CoberturaTerritorio;

/**
 *
 * @author Infosoft
 */
@Repository
public class CoberturaTerritorioDaoImpl extends XJdbcTemplate implements CoberturaTerritorioDao {

    private CoberturaTerritorio cobertura;

    public CoberturaTerritorioDaoImpl() {
    }

    @Override
    public int create() {
        super.setObjeto(cobertura);
        return super.create();
    }

    @Override
    public int update() {
        super.setObjeto(cobertura);
        return super.update();
    }

    @Override
    public List<CoberturaTerritorio> findByCoberturaTerritorioId(Integer custId) {
        String sql = "SELECT * FROM CoberturaTerritorio WHERE identificadorPrimarioDeLaEmpresa = " + custId +" AND EstadoDeEliminacion = 0";
        List<CoberturaTerritorio> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(CoberturaTerritorio.class));
        if (lst.isEmpty()) {
            return null;
        } else {
            return lst;
        }
    }

    @Override
    public void setCoberturaTerritorio(CoberturaTerritorio cobertura) {
        this.cobertura = cobertura;
    }

    @Override
    public CoberturaTerritorio getCoberturaTerritorio() {
        return cobertura;
    }
}