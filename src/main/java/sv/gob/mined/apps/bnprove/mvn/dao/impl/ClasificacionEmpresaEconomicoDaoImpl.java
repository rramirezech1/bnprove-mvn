/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.ClasificacionEmpresaEconomicoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.ClasificacionEmpresaEconomico;
import sv.gob.mined.apps.bnprove.mvn.util.JsfUtil;

/**
 *
 * @author Infosoft
 */
@Repository
public class ClasificacionEmpresaEconomicoDaoImpl extends XJdbcTemplate implements ClasificacionEmpresaEconomicoDao {

    private ClasificacionEmpresaEconomico clasificacion;

    public ClasificacionEmpresaEconomicoDaoImpl() {
    }

    @Override
    public int create() {
        /*KeyHolder key = new GeneratedKeyHolder();
         int valor = jdbcTemplate.update(new PreparedStatementCreator() {

         @Override
         public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
         PreparedStatement ps = cnctn.prepareStatement(getClasificacion().generarInsertSQL(), Statement.RETURN_GENERATED_KEYS);
         ps = JsfUtil.setValuesPreparedStatement(ps, clasificacion.getDatosInsert());
         return ps;
         }
         }, key);
         Integer idGenerado = key.getKey().intValue();*/
        super.setObjeto(clasificacion);
        Integer idGenerado = super.create();
        if (idGenerado != JsfUtil.COD_ERROR) {
            clasificacion.setIdentificadorClasificacionSectorEconomico(idGenerado);    
        }
        return idGenerado;
    }

    @Override
    public int update() {
        super.setObjeto(clasificacion);
        return super.update();
    }

    @Override
    public ClasificacionEmpresaEconomico findByClasificacionEmpresaEconomicoId(Integer custId) {
        String sql = "SELECT * FROM ClasificacionEmpresaEconomico WHERE identificadorClasificacionSectorEconomico = " + custId;
        List<ClasificacionEmpresaEconomico> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(ClasificacionEmpresaEconomico.class));
        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }
    }

    @Override
    public List<ClasificacionEmpresaEconomico> findByClasificacionEmpresaEconomicoByEmpresaId(Integer custId) {
        String sql = "SELECT * FROM ClasificacionEmpresaEconomico WHERE identificadorPrimarioDeLaEmpresa = " + custId;
        List<ClasificacionEmpresaEconomico> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(ClasificacionEmpresaEconomico.class));
        if (lst.isEmpty()) {
            return null;
        } else {
            return lst;
        }
    }

    @Override
    public ClasificacionEmpresaEconomico getClasificacion() {
        return clasificacion;
    }

    @Override
    public void setClasificacion(ClasificacionEmpresaEconomico clasificacion) {
        this.clasificacion = clasificacion;
    }
}