/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.DepartamentoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.Departamento;

/**
 *
 * @author Infosoft
 */
@Repository
public class DepartamentoDaoImpl extends XJdbcTemplate implements DepartamentoDao {

    public DepartamentoDaoImpl() {
    }    

    @Override
    public List<Departamento> findAll() {
        String sql = "SELECT * FROM DEPARTAMENTO";
        List<Departamento> departamentos = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Departamento.class));
        return departamentos;
    }
}
