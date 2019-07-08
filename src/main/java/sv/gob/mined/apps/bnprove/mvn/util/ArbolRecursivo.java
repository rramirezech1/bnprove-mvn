/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.util;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Infosoft
 */
public class ArbolRecursivo {

    public static DefaultTreeNode getArbolTblRecursiva(List<?> lst, Class clase, String methodId, String methodSubId) {
        DefaultTreeNode arbol = new DefaultTreeNode("Menu", null);
        Class[] param = new Class[]{};


        try {
            for (Object padre : lst) {
                Object obj = clase.cast(padre);
                Object id = obj.getClass().getMethod(methodSubId, param).invoke(padre, new Object[0]);
                if (id == null) {
                    TreeNode nodo = new DefaultTreeNode(clase.cast(padre), arbol);
                }
            }

            List<TreeNode> lstSub = arbol.getChildren();
            for (TreeNode treeNode : lstSub) {
                lst.remove(treeNode.getData());
            }

            setSubArbolTblRecursiva(lst, clase, methodId, methodSubId, arbol);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArbolRecursivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ArbolRecursivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ArbolRecursivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ArbolRecursivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ArbolRecursivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arbol;
    }

    public static void setSubArbolTblRecursiva(List<?> lstSub, Class clase, String methodId, String methodSubId, TreeNode padre) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<TreeNode> lst = padre.getChildren();
        Class[] param = new Class[]{};

        for (TreeNode treeNode : lst) {
            for (Object hijo : lstSub) {
                Object obj = clase.cast(hijo);
                Object idHijo = obj.getClass().getMethod(methodSubId, param).invoke(hijo, new Object[0]);
                Object idPadre = obj.getClass().getMethod(methodId, param).invoke(treeNode.getData(), new Object[0]);
                if (idHijo.equals(idPadre)) {
                    TreeNode nodo = new DefaultTreeNode(clase.cast(hijo), treeNode);
                }
            }

            List<TreeNode> lstSubSub = treeNode.getChildren();
            for (TreeNode treeNodeSub : lstSubSub) {
                lstSub.remove(treeNodeSub.getData());
            }

            setSubArbolTblRecursiva(lstSub, clase, methodId, methodSubId, treeNode);
        }
    }
}
