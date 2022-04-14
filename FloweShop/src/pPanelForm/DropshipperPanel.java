package pPanelForm;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import pCell.CellAlamat;
import pCell.CellDropshipper;
import pCell.CellDropshipperAction;
import pCell.CellNama;
import pCell.CellNoHp;
import pCell.CellPassword;
import pCell.CellUsername;
import pInsert.InsertDropshipperDl;
import pModel.ModelBodyDropshipper;
import pModel.ModelResponse;
import pService.ServiceDropshipper;

public class DropshipperPanel extends javax.swing.JPanel {

    public DropshipperPanel() {
        initComponents();
        tableMasterDropshipper.addTabStyle(jScrollPane1);
        tampilData();
        tableMasterDropshipper.addTableCell(new CellDropshipper(), 0);
        tableMasterDropshipper.addTableCell(new CellNama(), 1);
        tableMasterDropshipper.addTableCell(new CellNoHp(), 2);
        tableMasterDropshipper.addTableCell(new CellAlamat(), 3);
        tableMasterDropshipper.addTableCell(new CellUsername(), 4);
        tableMasterDropshipper.addTableCell(new CellPassword(), 5);
        tableMasterDropshipper.addTableCell(new CellDropshipperAction(), 6);
    }

    private void tampilData() {
        try {
            for (ModelBodyDropshipper mbd : new ServiceDropshipper().getDropshipper()) {
                tableMasterDropshipper.addRow(mbd, false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void cleartable() {
        int b = tableMasterDropshipper.getRowCount();
        if (b == 0) {

        } else {
            b -= 1;
            rekur(b);
            tableMasterDropshipper.deleteRowAt(0, false);
        }
    }

    private int rekur(int n) {
        if (n == 0) {
            return 0;
        } else {
            tableMasterDropshipper.deleteRowAt(n, false);
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
        tableMasterDropshipper = new pSwing.csTable();
        jLabel1 = new javax.swing.JLabel();
        btRefreshDropshipper = new javax.swing.JButton();
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

        tableMasterDropshipper.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Dropshipper", "Nama Dropshipper", "No Telp", "Alamat", "Username", "Password", "Action"
            }
        ));
        jScrollPane1.setViewportView(tableMasterDropshipper);
        if (tableMasterDropshipper.getColumnModel().getColumnCount() > 0) {
            tableMasterDropshipper.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableMasterDropshipper.getColumnModel().getColumn(6).setPreferredWidth(15);
        }

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Informasi Dropshipper :");

        btRefreshDropshipper.setBackground(new java.awt.Color(20, 209, 113));
        btRefreshDropshipper.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        btRefreshDropshipper.setForeground(new java.awt.Color(255, 255, 255));
        btRefreshDropshipper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pImages/refresh.png"))); // NOI18N
        btRefreshDropshipper.setText("Refresh");
        btRefreshDropshipper.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btRefreshDropshipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshDropshipperActionPerformed(evt);
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
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(btadd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRefreshDropshipper, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btadd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(btRefreshDropshipper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(panelBorder2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btRefreshDropshipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshDropshipperActionPerformed
        cleartable();
        tampilData();
    }//GEN-LAST:event_btRefreshDropshipperActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        new InsertDropshipperDl(null, true).show();
    }//GEN-LAST:event_btaddActionPerformed

    private void tfsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btsearch.doClick();
        }
    }//GEN-LAST:event_tfsearchKeyPressed

    private void btsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsearchActionPerformed
        try {
            cleartable();
            ModelResponse mrp = new ModelResponse();
            for (ModelBodyDropshipper mbd : new ServiceDropshipper().searchDropshipper(tfsearch.getText().trim().toString(), mrp)) {
                tableMasterDropshipper.addRow(mbd, false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btsearchActionPerformed

    private void btsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsearchMouseExited
        btsearch.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btsearchMouseExited

    private void btsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsearchMouseEntered
        btsearch.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_btsearchMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btRefreshDropshipper;
    public static javax.swing.JButton btadd;
    private javax.swing.JButton btsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private pSwing.PanelBorder panelBorder2;
    private pSwing.csTable tableMasterDropshipper;
    private javax.swing.JTextField tfsearch;
    // End of variables declaration//GEN-END:variables
}
