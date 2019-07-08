/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.EmpresaDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.Empresa;
import sv.gob.mined.apps.bnprove.mvn.util.JsfUtil;

/**
 *
 * @author Infosoft
 */
@Repository
public class EmpresaDaoImpl extends XJdbcTemplate implements EmpresaDao {

    private Empresa empresa;

    public EmpresaDaoImpl() {
    }

    @Override
    public int create() {
        super.setObjeto(empresa);
        Integer idEmpresa = super.create();
        if (idEmpresa != JsfUtil.COD_ERROR) {
            getEmpresa().setIdentificadorPrimarioDeLaEmpresa(idEmpresa);
        }
        return idEmpresa;
    }

    @Override
    public int update() {
        super.setObjeto(empresa);
        return super.update();
    }

    @Override
    public Empresa findByEmpresaId(Integer custId) {
        String sql = "SELECT * FROM EMPRESA WHERE identificadorPrimarioDeLaEmpresa = " + custId;
        List<Empresa> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Empresa.class));
        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }
    }

    @Override
    public Empresa findByEmpresaIdOferente(Integer custId) {
        String sql = "SELECT * FROM EMPRESA WHERE identificadorPrimarioOferente = " + custId;
        List<Empresa> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Empresa.class));
        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }
    }

    @Override
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public Empresa getEmpresa() {
        return empresa;
    }
}