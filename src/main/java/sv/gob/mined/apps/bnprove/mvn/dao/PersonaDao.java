/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import sv.gob.mined.apps.bnprove.mvn.modelo.Persona;

/**
 *
 * @author Infosoft
 */
public interface PersonaDao {

    public void setPersona(Persona per);

    public Persona getPersona();

    public int create();

    public int update();

    public Persona findByPersonaId(Integer custId);

    public Persona findPersonaByUsuarioClave(String usuario, String clave);

    public Boolean findPersonaByUsuario(String usuario);
}
