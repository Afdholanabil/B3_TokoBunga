package pPanelForm;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import pCell.CellPembeli;
import pCell.CellPembeliAction;
import pCell.CellNama;
import pCell.CellNoHp;
import pCell.CellPassword;
import pCell.CellUsername;
import pInsert.InsertPembeliDl;
import pModel.ModelBodyPembeli;
import pModel.ModelResponse;
import pService.ServicePembeli;

public class PembeliPanel extends javax.swing.JPanel {

    public PembeliPanel() {
        initComponents();
        tableMasterPembeli.addTabStyle(jScrollPane1);
        tampilData();
        tableMasterPembeli.addTableCell(new CellPembeli(), 0);
        tableMasterPembeli.addTableCell(new CellNama(), 1);
        tableMasterPembeli.addTableCell(new CellNoHp(), 2);
        tableMasterPembeli.addTableCell(new CellUsername(), 3);
        tableMasterPembeli.addTableCell(new CellPassword(), 4);
        tableMasterPembeli.addTableCell(new CellPembeliAction(), 5);
    }

    private void tampilData() {
        try {
            for (ModelBodyPembeli mbp : new ServicePembeli().getPembeli()) {
                tableMasterPembeli.addRow(mbp, false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void cleartable() {
        int b = tableMasterPembeli.getRowCount();
        if (b == 0) {

        } else {
            b -= 1;
            rekur(b);
            tableMasterPembeli.deleteRowAt(0, false);
        }
    }

    private int rekur(int n) {
        if (n == 0) {
            return 0;
        } else {
            tableMasterPembeli.deleteRowAt(n, false);
            return rekur(n - 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new pSwing.PanelBorder();
        jPanel1 = new javax.swing.JPanel();
        tfsearch = new javax.swing.JTextField();
        btsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMasterPembeli = new pSwing.csTable();
        jLabel1 = new javax.swing.JLabel();
        btRefreshPembeli = new javax.swing.JButton();
        btadd = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 0, 204));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tfsearch.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        tfsearch.setForeground(new java.awt.Color(153, 153, 153));
        tfsearch.setText("Search...");
        tfsearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfsearch.setOpaque(false);
        tfsearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfsearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfsearchFocusLost(evt);
            }
        });
        tfsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfsearchKeyPressed(evt);
            }
        });

        btsearch.setBackground(new java.awt.Color(255, 255, 255));
        btsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pImages/search.png"))); // NOI18N
        btsearch.setContentAreaFilled(false);
        btsearch.setOpaque(true);
        btsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btsearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btsearchMouseExited(evt);
            }
        });
        btsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfsearch)
            .addComponent(btsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        tableMasterPembeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pembeli", "Nama Pembeli", "No Telp", "Username", "Password", "Action"
            }
        ));
        jScrollPane1.setViewportView(tableMasterPembeli);
        if (tableMasterPembeli.getColumnModel().getColumnCount() > 0) {
            tableMasterPembeli.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableMasterPembeli.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Informasi Pembeli :");

        btRefreshPembeli.setBackground(new java.awt.Color(20, 209, 113));
        btRefreshPembeli.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        btRefreshPembeli.setForeground(new java.awt.Color(255, 255, 255));
        btRefreshPembeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pImages/refresh.png"))); // NOI18N
        btRefreshPembeli.setText("Refresh");
        btRefreshPembeli.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btRefreshPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshPembeliActionPerformed(evt);
            }
        });

        btadd.setBackground(new java.awt.Color(47, 77, 232));
        btadd.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        btadd.setForeground(new java.awt.Color(255, 255, 255));
        btadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pImages/plus.png"))); // NOI18N
        btadd.setText("AddNew");
        btadd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(btadd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRefreshPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btadd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRefreshPembeli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfsearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfsearchFocusGained
        if (tfsearch.getText().equals("Search...")) {
            tfsearch.setText("");
            tfsearch.setForeground(Color.black);
        }
    }//GEN-LAST:event_tfsearchFocusGained

    private void tfsearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfsearchFocusLost
        if (tfsearch.getText().equals("")) {
            tfsearch.setText("Search...");
            tfsearch.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tfsearchFocusLost

    private void btRefreshPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshPembeliActionPerformed
        cleartable();
        tampilData();
    }//GEN-LAST:event_btRefreshPembeliActionPerformed

    private void btsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsearchMouseEntered
        btsearch.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_btsearchMouseEntered

    private void btsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsearchMouseExited
        btsearch.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btsearchMouseExited

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        new InsertPembeliDl(null, true).show();
    }//GEN-LAST:event_btaddActionPerformed

    private void btsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsearchActionPerformed
        try {
            cleartable();
            ModelResponse mrp = new ModelResponse();
            for (ModelBodyPembeli mbp : new ServicePembeli().searchPembeli(tfsearch.getText().trim().toString(), mrp)) {
                tableMasterPembeli.addRow(mbp, false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btsearchActionPerformed

    private void tfsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsearchKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btsearch.doClick();
        }
    }//GEN-LAST:event_tfsearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btRefreshPembeli;
    public static javax.swing.JButton btadd;
    private javax.swing.JButton btsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private pSwing.PanelBorder panelBorder2;
    private pSwing.csTable tableMasterPembeli;
    private javax.swing.JTextField tfsearch;
    // End of variables declaration//GEN-END:variables
}
