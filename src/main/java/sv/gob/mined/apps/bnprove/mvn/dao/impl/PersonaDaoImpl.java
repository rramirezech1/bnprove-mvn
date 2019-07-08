/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.PersonaDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.OferenteDeBienesYServicios;
import sv.gob.mined.apps.bnprove.mvn.modelo.Persona;
import sv.gob.mined.apps.bnprove.mvn.modelo.Usuario;
import sv.gob.mined.apps.bnprove.mvn.util.JsfUtil;

/**
 *
 * @author Infosoft
 */
@Repository
public class PersonaDaoImpl extends XJdbcTemplate implements PersonaDao {

    private OferenteDeBienesYServicios oferente = new OferenteDeBienesYServicios();
    private Persona persona;

    public PersonaDaoImpl() {
    }

    @Override
    public int create() {
        oferente.setEstadoDeEliminacion(0);
        oferente.setFechaDeInsercion(new Date());
        oferente.setName("ADMIN");
        oferente.setPrincipalesProductosSuministra(" s ");
        super.setObjeto(oferente);

        Integer id = super.create();
        if (id != JsfUtil.COD_ERROR) {
            persona.setIdentificadorPrimarioOferente(id);
            super.setObjeto(persona);
            return super.create();
        } else {
            return JsfUtil.COD_ERROR;
        }
    }

    @Override
    public int update() {
        persona.setFechaDeModificacion(new Date());
        super.setObjeto(persona);
        return super.update();
    }

    @Override
    public Persona findByPersonaId(Integer custId) {
        String sql = "SELECT * FROM PERSONA WHERE identificadorDeLaPersona = " + custId;
        List<Persona> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Persona.class));
        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }
    }

    @Override
    public Persona findPersonaByUsuarioClave(String usuario, String clave) {
        String sql = "SELECT * FROM usuario WHERE userName  = '" + usuario + "' AND password = '" + clave + "'";
        List<Usuario> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Usuario.class));
        if (lst.isEmpty()) {
            return null;
        } else {
            sql = "SELECT * FROM PERSONA WHERE userName = '" + usuario + "'";
            List<Persona> lstPersona = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Persona.class));
            return lstPersona.get(0);
        }
    }

    @Override
    public Boolean findPersonaByUsuario(String usuario) {
        String sql = "SELECT * FROM PERSONA WHERE usuarioDeLaPersona = '" + usuario + "'";
        List<Persona> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Persona.class));
        if (lst.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setPersona(Persona per) {
        this.persona = per;
    }

    @Override
    public Persona getPersona() {
        return persona;
    }

    public OferenteDeBienesYServicios getOferente() {
        return oferente;
    }

    public void setOferente(OferenteDeBienesYServicios oferente) {
        this.oferente = oferente;
    }
}