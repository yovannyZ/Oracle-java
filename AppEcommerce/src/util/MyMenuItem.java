/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author yzeballos
 */
public class MyMenuItem extends javax.swing.JMenuItem implements ActionListener{

    private static final long serialVersionUID = -1909273293784759710L;

    private String message;

    public MyMenuItem(String text, String frm) {
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
		
            try {
                ((JFrame) Class.forName(message).newInstance()).setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyMenuItem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(MyMenuItem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(MyMenuItem.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
    }
    
}
