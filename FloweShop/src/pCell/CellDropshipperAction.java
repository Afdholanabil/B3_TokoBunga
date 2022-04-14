package pCell;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pDialogMessage.ErrorDialog;
import pModel.ModelBodyPembeli;
import pModel.ModelResponse;
import pService.ServicePembeli;
import static pModel.ModelResponse.checkDataStatic;
import static pForm.Dashboard.btConfirmData;
import pModel.ModelBodyDropshipper;
import pService.ServiceDropshipper;

public class CellDropshipperAction extends TableCustomCell {

    public CellDropshipperAction() {
        initComponents();

    }

    private void addEvent(TableCustom table, TableRowData data, int row) {
        btEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (data.isEditing()) {
                    table.cancelEditRowAt(row);
                    btEdit.setIcon(new ImageIcon(getClass().getResource("/pImages/edit.png")));
                } else {
                    table.editRowAt(row);
                    btEdit.setIcon(new ImageIcon(getClass().getResource("/pImages/close.png")));
                }
            }
        });

        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btConfirmData.doClick();
                    if (checkDataStatic == true) {
                        ModelResponse mrp = new ModelResponse();
                        String idDropshipper = ((ModelBodyDropshipper) data).getIdDropshipper().getIdDropshipper();
                        new ServiceDropshipper().deleteDropshipper(idDropshipper, mrp);
                        if (mrp.getKode() == 1) {
                            table.deleteRowAt(getRow(), true);
                        } else {
                            ErrorDialog edl = new ErrorDialog(null, true);
                            edl.lblErrorDialog.setText("Gagal Menghapus Data");
                            edl.show();
                        }
                    }
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Penghapusan Gagal " + ee.getMessage());
                }
            }
        }
        );
    }

    private void checkIcon(TableRowData data) {
        if (data.isEditing()) {
            btEdit.setIcon(new ImageIcon(getClass().getResource("/pImages/close.png")));
        } else {
            btEdit.setIcon(new ImageIcon(getClass().getResource("/pImages/edit.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btDelete = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pImages/delete.png"))); // NOI18N
        btDelete.setBorder(null);
        btDelete.setContentAreaFilled(false);

        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pImages/edit.png"))); // NOI18N
        btEdit.setBorder(null);
        btEdit.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btEdit)
                    .addComponent(btDelete))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setData(Object o) {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellDropshipperAction cell = new CellDropshipperAction();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        return null;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellDropshipperAction cell = new CellDropshipperAction();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }
}
