/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.bo;

import java.util.List;
import sv.gob.mined.apps.bnprove.mvn.modelo.ClasificacionEmpresaEconomico;
import sv.gob.mined.apps.bnprove.mvn.modelo.ClasificacionEmpresaTamano;
import sv.gob.mined.apps.bnprove.mvn.modelo.CoberturaTerritorio;
import sv.gob.mined.apps.bnprove.mvn.modelo.Departamento;
import sv.gob.mined.apps.bnprove.mvn.modelo.Empresa;
import sv.gob.mined.apps.bnprove.mvn.modelo.EstadoDeRegistro;
import sv.gob.mined.apps.bnprove.mvn.modelo.Genero;
import sv.gob.mined.apps.bnprove.mvn.modelo.Municipio;
import sv.gob.mined.apps.bnprove.mvn.modelo.OrigenDelCiudadano;
import sv.gob.mined.apps.bnprove.mvn.modelo.Pais;
import sv.gob.mined.apps.bnprove.mvn.modelo.Persona;
import sv.gob.mined.apps.bnprove.mvn.modelo.PreguntaValidaUsuario;
import sv.gob.mined.apps.bnprove.mvn.modelo.RegimenDeAdministracion;
import sv.gob.mined.apps.bnprove.mvn.modelo.SectorEconomico;
import sv.gob.mined.apps.bnprove.mvn.modelo.TipoDePersoneria;
import sv.gob.mined.apps.bnprove.mvn.modelo.TiposDeDocumentoLegal;
import sv.gob.mined.apps.bnprove.mvn.modelo.Usuario;

/**
 *
 * @author Infosoft
 */
public interface ProveedoresBo {

    public List<Departamento> findAllDepartamentos();

    public List<EstadoDeRegistro> findAllEstadoRegistro();

    public List<Genero> findAllGeneros();

    public List<Municipio> findAllMunicipio();
    
    public List<Municipio> findAllMunicipioByDepartamento(Integer codigoDepartamento);

    public List<OrigenDelCiudadano> findAllOrigenDelCiudadano();

    public List<Pais> findAllPais();
    
    public Boolean comprobarRespuestas(String userName, String respuesta1, String respuesta2);
    
    public Usuario findUsuarioByDui(String dui);

    public Usuario findUsuarioByEmail(String mail);
    
    public List<SectorEconomico> findAllSectorEconomico();
    
    public SectorEconomico findSectorEconomico(Integer idSubSector);
    
    public List<SectorEconomico> findAllSubSectorEconomico(Integer idSector);

    public List<TipoDePersoneria> findAllTipoDePersoneria();
    
    public List<ClasificacionEmpresaTamano> findAllEmpresaTamano();
    
    public List<TiposDeDocumentoLegal> findAllTiposDeDocumentoLegal();
    
    public List<RegimenDeAdministracion> findAllRegimenAdministracion();
    
    public List<CoberturaTerritorio> findAllCobertura(Integer idEmpresa);
    
    public List<ClasificacionEmpresaEconomico> findAllClasificacion(Integer idEmpresa);
    
    public List<PreguntaValidaUsuario> findAllPreguntas();
    
    public List<PreguntaValidaUsuario> findAllPreguntasExcepto(Integer id);
    
    public List<PreguntaValidaUsuario> findAllByDui(String dui);
    
    public List<PreguntaValidaUsuario> findAllByEmail(String email);
    
    public int savePersona(Persona per);
    
    public int saveUsuario(Usuario usr);
    
    public int saveEmpresa(Empresa emp);
    
    public int saveCobertura(CoberturaTerritorio cobertura);
    
    public int saveClasificacionEmpresa(ClasificacionEmpresaEconomico clasificacion);
    
    public Persona findPersonaByUsuarioClave(String usuario, String clave);
    
    public Persona findPersonaById(Integer idPersona);
    
    public Empresa findEmpresaByIdOferente(Integer idOferente);
    
    public Boolean isExistPersonaByUsuario(String usuario);
    
    Usuario buscarPorUsuario(String usuaName);
    
    Persona buscarPorDui(String numeroDocumentoLegal);
    
    Persona buscarPorUserName(String userName);
    
    public int updateUsuario(Usuario usu);
    
    
}