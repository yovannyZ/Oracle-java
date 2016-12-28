/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import dao.MenuDAO;
import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import modelo.Menu;
import util.MyMenuItem;

/**
 *
 * @author yzeballos
 */
public class FrmMenu extends javax.swing.JFrame {

    JMenu menu;
    public  int perfil;

    
    private static final long serialVersionUID = 4436990274867781357L;
    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        IconMenuItem(FrmUsuario, "/img/comprobado.png");
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnTabla = new javax.swing.JMenu();
        FrmUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        FrmProducto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 204, 255));
        escritorio.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        escritorio.setFocusCycleRoot(false);
        escritorio.setName("escritorio"); // NOI18N
        escritorio.setOpaque(false);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        mnTabla.setText("Tablas");
        mnTabla.setName("Tablas"); // NOI18N

        FrmUsuario.setText("Usuarios");
        FrmUsuario.setName("FrmUsuario"); // NOI18N
        FrmUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrmUsuarioActionPerformed(evt);
            }
        });
        mnTabla.add(FrmUsuario);

        jMenu2.setText("Almacen");

        FrmProducto.setText("Producto");
        FrmProducto.setName("FrmProducto"); // NOI18N
        jMenu2.add(FrmProducto);

        mnTabla.add(jMenu2);

        jMenuBar2.add(mnTabla);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FrmUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrmUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FrmUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem FrmProducto;
    private javax.swing.JMenuItem FrmUsuario;
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu mnTabla;
    // End of variables declaration//GEN-END:variables

    public void CargarMenus(){
        MenuDAO menuDao= new MenuDAO();
        List<Menu> listaMenus = menuDao.ListarMenus(perfil);//Perfil del usuario
        for (int i = 0; i < listaMenus.size(); i++) {
            
            if(listaMenus.size() > 0){
                
                if(listaMenus.get(i).getIdMenuPadre() == 0){
                 menu = new JMenu(listaMenus.get(i).getDescripcion());
                 menu.setName(""+listaMenus.get(i).getIdMenu());
                 }
                 for (int j = 0; j < listaMenus.size(); j++) {
                     
                     if(listaMenus.get(i).getIdMenu() == listaMenus.get(j).getIdMenuPadre()){
                         addMenuItems(menu,listaMenus.get(j).getDescripcion(),listaMenus.get(j).getUrlMenu(),listaMenus.get(j).isHabilitado());
                     }   
                }  
            }
            jMenuBar2.add(menu); ///Agrego Menus
        }
    }
    
    private void addMenuItems(JMenu menu, String texto , String frm, boolean habilitado) {
		
            MyMenuItem m = new MyMenuItem(texto, frm,this);
            m.setEnabled(habilitado);
            menu.add(m);  //Agrego MenuItems
            m.addActionListener(m);

	}
    
    private void IconMenuItem(javax.swing.JMenuItem menuItem , String url){
        
        ImageIcon icono = new ImageIcon(getClass().getResource(url));
        
        menuItem.setIcon(icono);
        menuItem.setIconTextGap(2);
        menuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuItem.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        menuItem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuItem.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

    }
    
    private void enableFields(boolean option, JComponent jCompo) {
        MenuDAO menuDao= new MenuDAO();
        List<Menu> listaMenus = menuDao.ListarMenus(perfil);
	Component [] arrayCompo = jCompo.getComponents();
	for (Component component : arrayCompo) {
		if(component instanceof JMenu){
                    if((JMenu) component).getName() == )
                    ((JMenu) component).setEnabled(option);
                }
		if(component instanceof JMenuItem){
                    ((JMenuItem) component).setEnabled(option);
                }
		if(component instanceof JComponent)  {
                    enableFields(option, (JComponent)component);
                }
	}
}
    
   
}
