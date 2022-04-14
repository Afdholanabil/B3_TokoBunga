package pMasterBunga;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import pModel.ModelBunga;

public class ItemBunga extends javax.swing.JPanel {

    private boolean selected;

    ModelBunga data;

    public ModelBunga getData() {
        return data;
    }

    public void setData(ModelBunga data) {
        this.data = data;
        lblId.setText(data.getIdBunga());
        lblNama.setText(data.getNamaBunga());
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        lblHarga.setText(data.getHargaBunga());
        lblGambar.setText("https://dimazz.000webhostapp.com/ApiTokoBunga/images/" + data.getGambar());
        lblDesk.setText(data.getDeskripsi());
        try {
            BufferedImage imgUrl = ImageIO.read(new URL("https://dimazz.000webhostapp.com/ApiTokoBunga/images/" + data.getGambar()));
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon(imgUrl)
                            .getImage()
                            .getScaledInstance(226, 171, Image.SCALE_SMOOTH));
            pic.setImage(imageIcon);
        } catch (Exception e) {
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public ItemBunga() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDesk = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblGambar = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        pic = new pSwing.PictureBox();

        lblDesk.setText("jLabel1");

        lblId.setText("jLabel1");

        lblGambar.setText("jLabel1");

        lblNama.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblNama.setForeground(new java.awt.Color(73, 73, 73));
        lblNama.setText("Item Name");

        lblHarga.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(73, 73, 73));
        lblHarga.setText("$0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblHarga)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNama)
                .addGap(18, 18, 18)
                .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHarga)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDesk;
    private javax.swing.JLabel lblGambar;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNama;
    private pSwing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
