/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.dao;

import sv.gob.mined.apps.bnprove.mvn.modelo.Empresa;

/**
 *
 * @author Infosoft
 */
public interface EmpresaDao {

    public void setEmpresa(Empresa empresa);

    public Empresa getEmpresa();

    public int create();

    public int update();

    public Empresa findByEmpresaId(Integer custId);

    public Empresa findByEmpresaIdOferente(Integer custId);
}
