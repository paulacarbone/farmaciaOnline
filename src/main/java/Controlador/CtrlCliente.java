    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ConsultasCliente;
import Vista.frmClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pau
 */
public class CtrlCliente implements ActionListener {
    
    private Cliente mod;
    private ConsultasCliente modC;
    private frmClientes frm; 
    
    public CtrlCliente(Cliente mod, ConsultasCliente modC, frmClientes frm){
    this.mod = mod;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnGuardar.addActionListener(this);
    this.frm.btnModificar.addActionListener(this); 
    this.frm.btnEliminar.addActionListener(this);
    this.frm.btnLimpiar.addActionListener(this);
    this.frm.btnBuscar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Clientes");
        frm.setLocationRelativeTo(null);
        frm.txtID.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == frm.btnGuardar){
            mod.setNombre(frm.txtNombre.getText());
             mod.setApellido(frm.txtApellido.getText());
              mod.setDni(Integer.parseInt(frm.txtDNI.getText()));
               mod.setEmail(frm.txtEmail.getText());
                mod.setTelefono(Integer.parseInt(frm.txtTelefono.getText()));
               mod.setFecha_nacimiento(frm.txtFechaNacimiento.getText());
             mod.setCobertura_medica(frm.txtCoberturaMedica.getText());
             
             if(modC.registrar(mod)){
                 JOptionPane.showMessageDialog(null, "Registro guardado");
                 limpiar();
             } else{
                 JOptionPane.showMessageDialog(null, "Error al guardar");
                 limpiar();
             }

        }
        
         if(e.getSource() == frm.btnModificar){
             mod.setId_cliente(Integer.parseInt(frm.txtID.getText()));
            mod.setNombre(frm.txtNombre.getText());
             mod.setApellido(frm.txtApellido.getText());
              mod.setDni(Integer.parseInt(frm.txtDNI.getText()));
               mod.setEmail(frm.txtEmail.getText());
                mod.setTelefono(Integer.parseInt(frm.txtTelefono.getText()));
               mod.setFecha_nacimiento(frm.txtFechaNacimiento.getText());
             mod.setCobertura_medica(frm.txtCoberturaMedica.getText());
             
             if(modC.modificar(mod)){
                 JOptionPane.showMessageDialog(null, "Registro modificado");
                 limpiar();
             } else{
                 JOptionPane.showMessageDialog(null, "Error al modificar");
                 limpiar();
             }

        }
         
           if(e.getSource() == frm.btnEliminar){
             mod.setId_cliente(Integer.parseInt(frm.txtID.getText()));
            
             
             if(modC.eliminar(mod)){
                 JOptionPane.showMessageDialog(null, "Registro eliminado");
                 limpiar();
             } else{
                 JOptionPane.showMessageDialog(null, "Error al eliminar");
                 limpiar();
             }

        }  
           if(e.getSource() == frm.btnBuscar){
             mod.setDni(Integer.parseInt(frm.txtDNI.getText()));
            
             
             if(modC.buscar(mod)){
                 frm.txtDNI.setText(String.valueOf(mod.getDni()));
                 frm.txtNombre.setText(mod.getNombre());
                 frm.txtApellido.setText(mod.getApellido());
                 
             } else{
                 JOptionPane.showMessageDialog(null, "No se encontró registro");
                 limpiar();
             }

        }
           
            if(e.getSource() == frm.btnLimpiar){
            limpiar();
            }
    }
    
    
    
    public void limpiar(){
    frm.txtID.setText(null);
    frm.txtNombre.setText(null);
    frm.txtApellido.setText(null);
    frm.txtDNI.setText(null);
    frm.txtEmail.setText(null);
    frm.txtTelefono.setText(null);
    frm.txtFechaNacimiento.setText(null);
    frm.txtCoberturaMedica.setText(null);
    
    
}
}
