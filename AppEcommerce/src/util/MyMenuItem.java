/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import formularios.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author yzeballos
 */
public class MyMenuItem extends javax.swing.JMenuItem implements ActionListener{

    private static final long serialVersionUID = -1909273293784759710L;

    private String frm;
    FrmMenu frmMenu;

    public MyMenuItem(String text, String frm,FrmMenu menu) {
     super(text);
     this.frm = frm;
     this.frmMenu = menu;
     }

     public String getFrm() {
	return this.frm;
    }

    public void setFrm(String frm) {
	this.frm = frm;
    }

		
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MyMenuItem) {
		String frm = ((MyMenuItem)e.getSource()).getFrm();
		
            try {
                
                JInternalFrame ventana =  ((JInternalFrame) Class.forName(frm).newInstance());
                this.frmMenu.escritorio.add(ventana);
                ventana.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
	}
    }
    
}
