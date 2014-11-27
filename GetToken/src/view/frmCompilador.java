/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Compilador;
import model.ConstansToken;
import model.DataCompiler;
import model.Serialize;
import model.TablaTrans;

/**
 *
 * @author ArmandoPC
 */
public class frmCompilador extends javax.swing.JInternalFrame {

    Serialize se;
    DataCompiler datacompiler;
    Compilador com;

    /**
     * Creates new form frmCompilador
     */
    public frmCompilador() {
        initComponents();
        se = new Serialize();
        datacompiler = new DataCompiler();
        llenarCombobox();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtfilename = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcad = new javax.swing.JTextArea();
        txtresult = new javax.swing.JTextField();

        jLabel1.setText("Cadena: ");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Archivo:");

        txtfilename.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtcad.setColumns(20);
        txtcad.setRows(5);
        jScrollPane2.setViewportView(txtcad);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfilename, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(txtresult))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtresult, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.preparate()) {
            datacompiler = se.ReadXml(txtfilename.getSelectedItem().toString());
            this.com = new Compilador(datacompiler, this.txtcad.getText());
            this.com.analzarLexico();
            String h = this.com.analizadorSintactico(new TablaTrans(this.convert(datacompiler.getTableTans())));
            this.com.MostarToken();
            this.txtresult.setText(h);
        } else {
            this.msg("Campos incompletos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public Boolean preparate() {
        if (this.txtcad.getText().length() != 0 && this.txtfilename.getSelectedItem().toString().length() != 0) {
            return true;
        }
        return false;

    }

    public void im(Object[][] g) {

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int[][] convert(Object[][] g) {
        int[][] gf = new int[g.length][g[0].length];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                gf[i][j] = Integer.parseInt(g[i][j] + "");
            }
        }
        return gf;
    }

    public void imLis(ArrayList<ConstansToken> g) {
        for (ConstansToken g1 : g) {
            System.out.println(g1.getSimbolo() + " " + g1.getMatch() + " " + g1.getValor());
        }
    }

    public void llenarCombobox() {
        String to = System.getProperty("user.dir"); // recupero el directorio del proyecto
        String separator = System.getProperty("file.separator"); //recupero el separador ex: Windows= '\' , Linux='/'
        to = to + separator + "src" + separator + "src" + separator; // concateno la ruta destino
        File f = new File(to);
        this.txtfilename.removeAllItems();
        if (f.exists()) { // Directorio existe 
            File[] ficheros = f.listFiles();
            for (int x = 0; x < ficheros.length; x++) {
                this.txtfilename.addItem(ficheros[x].getName());
            }
        } else { //Directorio no existe 

        }
    }

    public void msg(String message) {
        JOptionPane.showMessageDialog(this.getRootPane(), message);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtcad;
    private javax.swing.JComboBox txtfilename;
    private javax.swing.JTextField txtresult;
    // End of variables declaration//GEN-END:variables
}
