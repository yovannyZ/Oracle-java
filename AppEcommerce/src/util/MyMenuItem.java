/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author yzeballos
 */
public class MyMenuItem extends javax.swing.JMenuItem implements ActionListener{

    private static final long serialVersionUID = -1909273293784759710L;

    private String message;

    public MyMenuItem(String text, String message) {
	super(text);
     this.message = message;
     }

     public String getMessage() {
	return this.message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

		
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MyMenuItem) {
		String message = ((MyMenuItem)e.getSource()).getMessage();
		javax.swing.JOptionPane.showMessageDialog(null, message);
	}
    }
    
}
