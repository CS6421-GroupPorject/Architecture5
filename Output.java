/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mehmet
 */
public class Output extends javax.swing.JPanel {
    
    private JPanel jPanel = new javax.swing.JPanel();
    private JLabel jLabel = new javax.swing.JLabel();
    private String OUTPUT;
    public String STATUS="1"; //0: BUSY 1:AVAIBLE
    
    public Output() {
        
       OUTPUT = "";
       
       initComponents();
        
      //jLabel.setText("<html>");
      
    }
    
    
    public void GetData(String s) {
        STATUS = "0";
        OUTPUT += s + "<br>";
        jLabel.setText("<html>" + OUTPUT + "</html>");
        STATUS = "1";
     
    }
    
    public void initComponents() {
        
        this.add(jPanel);
        this.add(jLabel);
         
        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Printer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14), java.awt.Color.blue)); // NOI18N
        jPanel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addComponent(jLabel)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel)
        );
        
         jPanel.setPreferredSize(new Dimension(180, 410));
        
        
 
       
         
     }
    
}
