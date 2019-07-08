/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import sv.gob.mined.apps.bnprove.mvn.dao.UsuarioDao;
import sv.gob.mined.apps.bnprove.mvn.dao.XJdbcTemplate;
import sv.gob.mined.apps.bnprove.mvn.modelo.Usuario;

/**
 *
 * @author Infosoft
 */
@Repository
public class UsuarioDaoImpl extends XJdbcTemplate implements UsuarioDao {

    public UsuarioDaoImpl() {
    }

    @Override
    public int save(Usuario usr) {
        return getJdbcTemplate().update(usr.generarInsertSQL(), usr.getDatosInsert());
    }

    @Override
    public Boolean findUsuario(String userName) {
        String sql = "SELECT * FROM USUARIO WHERE userName = '" + userName + "'";
        List<Usuario> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Usuario.class));
        return !lst.isEmpty();
    }

    @Override
    public Boolean comprobarRespuestas(String userName, String respuesta1, String respuesta2) {
        String sql = "SELECT * FROM USUARIO WHERE userName = '" + userName + "' and respuesta1 = '"+respuesta1+"' OR respuesta2 = '"+respuesta2+"'";
        List<Usuario> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Usuario.class));
        return !lst.isEmpty();
    }

    @Override
    public Usuario findUsuarioByDui(String numeroDeDui) {
        String sql = "SELECT     dbo.usuario.* "
                + "FROM         dbo.usuario INNER JOIN  dbo.Persona ON dbo.usuario.userName = dbo.Persona.userName "
                + "WHERE     (dbo.Persona.numeroDocumentoLegal = '" + numeroDeDui + "')";
        List<Usuario> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Usuario.class));
        if(lst !=null && lst.size()>0){
            return lst.get(0);
        }else{ 
            return null;
        }
    }
    
    @Override
    public Usuario findUsuarioByEmail(String mail) {
        String sql = "SELECT     dbo.usuario.* "
                + "FROM         dbo.usuario INNER JOIN  dbo.Persona ON dbo.usuario.userName = dbo.Persona.userName "
                + "WHERE     (dbo.Persona.Email = '" + mail + "')";
        List<Usuario> lst = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Usuario.class));
        if(lst !=null && lst.size()>0){
            return lst.get(0);
        }else{ 
            return null;
        }
    }
}