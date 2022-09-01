/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.bo.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.gob.mined.apps.bnprove.mvn.bo.ProveedoresBo;
import sv.gob.mined.apps.bnprove.mvn.dao.ClasificacionEmpresaEconomicoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.ClasificacionEmpresaTamanoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.CoberturaTerritorioDao;
import sv.gob.mined.apps.bnprove.mvn.dao.DepartamentoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.EmpresaDao;
import sv.gob.mined.apps.bnprove.mvn.dao.EstadoDeRegistroDao;
import sv.gob.mined.apps.bnprove.mvn.dao.GeneroDao;
import sv.gob.mined.apps.bnprove.mvn.dao.MunicipioDao;
import sv.gob.mined.apps.bnprove.mvn.dao.OrigenDelCiudadanoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.PaisDao;
import sv.gob.mined.apps.bnprove.mvn.dao.PersonaDao;
import sv.gob.mined.apps.bnprove.mvn.dao.PreguntaValidaUsuarioDao;
import sv.gob.mined.apps.bnprove.mvn.dao.RegimenDeAdministracionDao;
import sv.gob.mined.apps.bnprove.mvn.dao.SectorEconomicoDao;
import sv.gob.mined.apps.bnprove.mvn.dao.TipoDePersoneriaDao;
import sv.gob.mined.apps.bnprove.mvn.dao.TiposDeDocumentoLegalDao;
import sv.gob.mined.apps.bnprove.mvn.dao.UsuarioDao;
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
@Service
public class ProveedoresBoImpl implements ProveedoresBo {

    @Autowired
    DepartamentoDao departamento;
    @Autowired
    EstadoDeRegistroDao estadoregistro;
    @Autowired
    GeneroDao genero;
    @Autowired
    MunicipioDao municipio;
    @Autowired
    OrigenDelCiudadanoDao origen;
    @Autowired
    PaisDao pais;
    @Autowired
    SectorEconomicoDao sector;
    @Autowired
    TipoDePersoneriaDao personeria;
    @Autowired
    ClasificacionEmpresaTamanoDao empresaTamano;
    @Autowired
    TiposDeDocumentoLegalDao tipoDoc;
    @Autowired
    RegimenDeAdministracionDao regAdmon;
    @Autowired
    EmpresaDao empresa;
    @Autowired
    PersonaDao persona;
    @Autowired
    CoberturaTerritorioDao cobertura;
    @Autowired
    ClasificacionEmpresaEconomicoDao clasificacionEmpresa;
    @Autowired
    PreguntaValidaUsuarioDao preguntaValida;
    @Autowired
    UsuarioDao usuario;

    @Override
    public List<Departamento> findAllDepartamentos() {
        return departamento.findAll();
    }

    @Override
    public List<EstadoDeRegistro> findAllEstadoRegistro() {
        return estadoregistro.findAll();
    }

    @Override
    public List<Genero> findAllGeneros() {
        return genero.findAll();
    }

    @Override
    public List<Municipio> findAllMunicipio() {
        return municipio.findAll();
    }

    @Override
    public List<OrigenDelCiudadano> findAllOrigenDelCiudadano() {
        return origen.findAll();
    }

    @Override
    public List<Pais> findAllPais() {
        return pais.findAll();
    }

    @Override
    public List<SectorEconomico> findAllSectorEconomico() {
        return sector.findAll();
    }

    @Override
    public SectorEconomico findSectorEconomico(Integer idSubSector) {
        return sector.findByIdSector(idSubSector);
    }
    
    @Override
    public List<SectorEconomico> findAllSubSectorEconomico(Integer idSector) {
        return sector.findAllSub(idSector);
    }

    @Override
    public List<TipoDePersoneria> findAllTipoDePersoneria() {
        return personeria.findAll();
    }
    
     @Override
    public List<ClasificacionEmpresaTamano> findAllEmpresaTamano() {
        return empresaTamano.findAll();
    }

    @Override
    public List<TiposDeDocumentoLegal> findAllTiposDeDocumentoLegal() {
        return tipoDoc.findAll();
    }

    @Override
    public List<Municipio> findAllMunicipioByDepartamento(Integer codigoDepartamento) {
        return municipio.findAllByDepartamento(codigoDepartamento);
    }

    @Override
    public List<RegimenDeAdministracion> findAllRegimenAdministracion() {
        return regAdmon.findAll();
    }

    @Override
    public int saveEmpresa(Empresa emp) {
        empresa.setEmpresa(emp);

        if (emp.getIdentificadorPrimarioDeLaEmpresa() != null) {
            return empresa.update();
        } else {
            return empresa.create();
        }
    }

    @Override
    public int savePersona(Persona per) {
        persona.setPersona(per);
        if (per.getIdentificadorDeLaPersona() != null) {
            return persona.update();
        } else {
            return persona.create();
        }
    }

    @Override
    public Persona findPersonaByUsuarioClave(String usuario, String clave) {
        return persona.findPersonaByUsuarioClave(usuario, clave);
    }

    @Override
    public Boolean isExistPersonaByUsuario(String usuario) {
        return this.usuario.findUsuario(usuario);
    }

    @Override
    public Persona findPersonaById(Integer idPersona) {
        return persona.findByPersonaId(idPersona);
    }

    @Override
    public Empresa findEmpresaByIdOferente(Integer idOferente) {
        return empresa.findByEmpresaIdOferente(idOferente);
    }

    @Override
    public List<CoberturaTerritorio> findAllCobertura(Integer idEmpresa) {
        return cobertura.findByCoberturaTerritorioId(idEmpresa);
    }

    @Override
    public int saveCobertura(CoberturaTerritorio cob) {
        cobertura.setCoberturaTerritorio(cob);
        if (cob.getIdentificadorDeCobertura() != null) {
            return cobertura.update();
        } else {
            return cobertura.create();
        }
    }

    @Override
    public int saveClasificacionEmpresa(ClasificacionEmpresaEconomico clasificacion) {
        clasificacionEmpresa.setClasificacion(clasificacion);
        if (clasificacion.getIdentificadorClasificacionSectorEconomico() != null) {
            return clasificacionEmpresa.update();
        } else {
            return clasificacionEmpresa.create();
        }
    }

    @Override
    public List<ClasificacionEmpresaEconomico> findAllClasificacion(Integer idEmpresa) {
        return clasificacionEmpresa.findByClasificacionEmpresaEconomicoByEmpresaId(idEmpresa);
    }

    @Override
    public List<PreguntaValidaUsuario> findAllPreguntas() {
        return preguntaValida.findAll();
    }

    @Override
    public int saveUsuario(Usuario usr) {
        int i = usuario.save(usr);
        Persona per = new Persona();
        
        per.setPrimerApellido(usr.getPrimerApellido());
        per.setSegundoApellido(usr.getSegundoApellido());
        per.setPrimerNombre(usr.getPrimerNombre());
        per.setSegundoNombre(usr.getSegundoNombre());
        per.setEMail(usr.getEMail());
        per.setUserName(usr.getUserName());
        per.setNumeroTelefono(usr.getTelefono());
        per.setFechaDeInsercion(new Date());
        per.setName("ADMIN");
        per.setEstadoDeEliminacion(0);
        persona.setPersona(per);
        
        return persona.create();
    }

    @Override
    public List<PreguntaValidaUsuario> findAllPreguntasExcepto(Integer id) {
        return preguntaValida.findAllExcepto(id);
    }

    @Override
    public List<PreguntaValidaUsuario> findAllByDui(String dui) {
        return preguntaValida.findAllByDui(dui);
    }

    @Override
    public List<PreguntaValidaUsuario> findAllByEmail(String email) {
        return preguntaValida.findAllByEmail(email);
    }
    
    @Override
    public Boolean comprobarRespuestas(String userName, String respuesta1, String respuesta2) {
        return usuario.comprobarRespuestas(userName, respuesta1, respuesta2);
    }

    @Override
    public Usuario findUsuarioByDui(String dui) {
        return usuario.findUsuarioByDui(dui);
    }
    
    @Override
    public Usuario findUsuarioByEmail(String mail) {
        return usuario.findUsuarioByEmail(mail);
    }
}