package pCell;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pDialogMessage.ErrorDialog;
import pDialogMessage.SuccessDialog;
import pModel.ModelBodyPembeli;
import pModel.ModelIdPembeli;
import pModel.ModelResponse;
import pService.ServicePembeli;

public class CellPembeli extends TableCustomCell {

    public CellPembeli() {
        initComponents();
        setOpaque(false);
        tfid.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfid = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        btsave = new javax.swing.JButton();

        tfid.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N

        lb.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        lb.setText("ID Pembeli");

        btsave.setBackground(new java.awt.Color(10, 93, 191));
        btsave.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btsave.setForeground(new java.awt.Color(255, 255, 255));
        btsave.setText("Save");
        btsave.setBorder(null);
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb)
                            .addComponent(btsave, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btsave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed

    }//GEN-LAST:event_btsaveActionPerformed

    private void addEventSave(TableCustom tbl) {
        btsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorDialog edl = new ErrorDialog(null, true);
                tbl.stopCellEditing();
                int row = getRow();
                String nama = tbl.getValueAt(row, 1).toString();
                String nohp = tbl.getValueAt(row, 2).toString();
                String user = tbl.getValueAt(row, 3).toString();
                String pass = tbl.getValueAt(row, 4).toString();
                if (nama.equals("") || user.equals("") || pass.equals("") || nohp.equals("")) {
                    edl.lblErrorDialog.setText("Mohon Lengkapi Data");
                    edl.show();
                } else {
                    ModelBodyPembeli mbp = (ModelBodyPembeli) tbl.getModelData(row);
                    ModelBodyPembeli data = new ModelBodyPembeli(mbp.getIdp(), nama, nohp, user, pass);
                    try {
                        ModelResponse mrp = new ModelResponse();
                        new ServicePembeli().updatePembeli(data, mrp);
                        if (mrp.getKode() == 1) {
                            tbl.updateModelData(row, data);
                            SuccessDialog sdl = new SuccessDialog(null, true);
                            sdl.lblSuccessDialog.setText("Data Telah Diubah");
                            sdl.show();
                            tbl.cancelEditRowAt(row);
                        } else {
                            edl.lblErrorDialog.setText("Gagal Menyimpan Data");
                            edl.show();
                        }
                    } catch (Exception exs) {
                        JOptionPane.showMessageDialog(null, "Update Gagal !\nMohon "
                                + "Perhatikan Kolom Sudah Terisi Dengan Benar ! \n "
                                + "Kode Error : " + exs.getMessage());
                    }
                }
            }
        });
    }

    @Override
    public void setData(Object o) {
        if (o != null) {
            ModelIdPembeli d = (ModelIdPembeli) o;
            tfid.setText(d.getIdPembeli());
        }
    }

    @Override
    public Object getData() {
        String idmin = tfid.getText().trim();
        return new ModelIdPembeli(idmin);
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellPembeli cell = new CellPembeli();
        cell.setData(o);
        cell.addEventSave(tc);
        return cell;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        ModelBodyPembeli na = (ModelBodyPembeli) data;
        return new CellPembeliRenderer(na.getIdp());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsave;
    private javax.swing.JLabel lb;
    private javax.swing.JTextField tfid;
    // End of variables declaration//GEN-END:variables
}
