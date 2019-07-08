/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.PreguntaValidaUsuarioDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.PreguntaValidaUsuario;

/**
 *
 * @author Infosoft
 */
@Repository
public class PreguntaValidaUsuarioDaoImpl extends XJdbcTemplate implements PreguntaValidaUsuarioDao {

    public PreguntaValidaUsuarioDaoImpl() {
    }

    @Override
    public List<PreguntaValidaUsuario> findAll() {
        String sql = "SELECT * FROM preguntaValidaUsuario";
        List<PreguntaValidaUsuario> lstPreguntas = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PreguntaValidaUsuario.class));
        return lstPreguntas;
    }

    @Override
    public List<PreguntaValidaUsuario> findAllExcepto(Integer id) {
        String sql = "SELECT * FROM preguntaValidaUsuario where idPregunta not in (" + id + ")";
        List<PreguntaValidaUsuario> lstPreguntas = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PreguntaValidaUsuario.class));
        return lstPreguntas;
    }

    @Override
    public List<PreguntaValidaUsuario> findAllByDui(String dui) {
        String sqlCant = "SELECT     count(1) "
                + "FROM         dbo.Persona INNER JOIN "
                + "                      dbo.usuario ON dbo.Persona.userName = dbo.usuario.userName "
                + "WHERE     (dbo.Persona.numeroDocumentoLegal= '" + dui + "')";
        
        
        String sql = "SELECT     dbo.usuario.idPregunta1 "
                + "FROM         dbo.Persona INNER JOIN "
                + "                      dbo.usuario ON dbo.Persona.userName = dbo.usuario.userName "
                + "WHERE     (dbo.Persona.numeroDocumentoLegal = '" + dui + "')";

        String sql2 = "SELECT     dbo.usuario.idPregunta2 "
                + "FROM         dbo.Persona INNER JOIN "
                + "                      dbo.usuario ON dbo.Persona.userName = dbo.usuario.userName "
                + "WHERE     (dbo.Persona.numeroDocumentoLegal= '" + dui + "')";
        
        int cant = getJdbcTemplate().queryForInt(sqlCant);
        
        if(cant == 1){
            int pregunta1 = getJdbcTemplate().queryForInt(sql);
            int pregunta2 = getJdbcTemplate().queryForInt(sql2);

            sql = "SELECT * FROM preguntaValidaUsuario where idPregunta in (" + pregunta1 + "," + pregunta2 + ")";
            List<PreguntaValidaUsuario> lstPreguntas = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PreguntaValidaUsuario.class));
            return lstPreguntas;
            
        }else{
            return null;
        }
    }
    @Override
    public List<PreguntaValidaUsuario> findAllByEmail(String email) {
        
        String sqlCant = "SELECT count(1) "
                + "FROM dbo.Persona INNER JOIN "
                + "     dbo.usuario ON dbo.Persona.userName = dbo.usuario.userName "
                + "WHERE (dbo.Persona.eMail= '" + email + "')";
        
        
        String sql = "SELECT  dbo.usuario.idPregunta1 "
                + "FROM dbo.Persona INNER JOIN "
                + "     dbo.usuario ON dbo.Persona.userName = dbo.usuario.userName "
                + "WHERE     (dbo.Persona.eMail = '" + email + "')";

        String sql2 = "SELECT dbo.usuario.idPregunta2 "
                + "FROM       dbo.Persona INNER JOIN "
                + "           dbo.usuario ON dbo.Persona.userName = dbo.usuario.userName "
                + "WHERE     (dbo.Persona.eMail= '" + email + "')";
        
        int cant = getJdbcTemplate().queryForInt(sqlCant);
        
        if(cant == 1){
            int pregunta1 = getJdbcTemplate().queryForInt(sql);
            int pregunta2 = getJdbcTemplate().queryForInt(sql2);

            sql = "SELECT * FROM preguntaValidaUsuario where idPregunta in (" + pregunta1 + "," + pregunta2 + ")";
            List<PreguntaValidaUsuario> lstPreguntas = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PreguntaValidaUsuario.class));
            return lstPreguntas;
            
        }else{
            return null;
        }
    }
}