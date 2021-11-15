/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.CtrlCliente;
import Modelo.Cliente;
import Modelo.ConsultasCliente;
import Vista.frmClientes;

/**
 *
 * @author Pau
 */
public class CRUDMVC {
    public static void main(String[] args){
        Cliente mod = new Cliente();
        ConsultasCliente modC = new ConsultasCliente();
        frmClientes frm = new frmClientes();
        
        CtrlCliente ctrl = new CtrlCliente(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
}
