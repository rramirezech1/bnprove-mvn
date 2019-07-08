/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import sv.gob.mined.apps.bnprove.mvn.modelo.Usuario;

/**
 *
 * @author Infosoft
 */
public interface UsuarioDao {

    public int save(Usuario usr);

    public Boolean findUsuario(String userName);
    
    public Usuario findUsuarioByDui(String numeroDeDui);
    
    public Usuario findUsuarioByEmail(String mail);
    
    public Boolean comprobarRespuestas(String userName, String respuesta1, String respuesta2);
}
