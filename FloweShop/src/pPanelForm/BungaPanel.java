package pPanelForm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.hc.core5.http.ParseException;
import org.jdesktop.animation.timing.Animator;
import org.json.JSONException;
import pComponent.EventItem;
import pMasterBunga.ChildBungaPanel;
import pModel.ModelBunga;
import pService.ServiceBunga;

public class BungaPanel extends javax.swing.JPanel {

    private ChildBungaPanel home;
    private Animator animator;
    private Point animatePoint;
    private ModelBunga itemSelected;

    public BungaPanel() {
        initComponents();
        init();
        testData();
    }

    private void init() {
        home = new ChildBungaPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
    }

    private void testData(){
        try {
            home.setEvent(new EventItem() {
                @Override
                public void itemClick(Component com, ModelBunga item) {
                    if (itemSelected != null) {
                        ImageIcon icn = new ImageIcon();
                        ubahGambar(icn);
                        mainPanel.setImageOld(icn);
                    }
                    if (itemSelected != item) {
                        if (!animator.isRunning()) {
                            itemSelected = item;
                            animatePoint = getLocationOf(com);
                            ImageIcon icn = new ImageIcon();
                            ubahGambar(icn);
                            mainPanel.setImage(icn);
                            mainPanel.setImageLocation(animatePoint);
                            mainPanel.setImageSize(new Dimension(180, 120));
                            mainPanel.repaint();
                            home.setSelected(com);
                            home.showItem(item);
                            animator.start();
                        }
                    }
                }
            });
            for (ModelBunga mb : new ServiceBunga().getBunga()) {
                home.addItem(new ModelBunga(mb.getIdBunga(), mb.getNamaBunga(), mb.getHargaBunga(), mb.getGambar(), mb.getDeskripsi()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    private void ubahGambar(ImageIcon imageIcon) {
        BufferedImage imgUrl;
        try {
            imgUrl = ImageIO.read(new URL("https://dimazz.000webhostapp.com/ApiTokoBunga/images/" + itemSelected.getGambar()));
            imageIcon = new ImageIcon(
                    new ImageIcon(imgUrl)
                            .getImage()
                            .getScaledInstance(226, 171, Image.SCALE_SMOOTH));
            repaint();
        } catch (MalformedURLException ex) {
            Logger.getLogger(BungaPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BungaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new pSwing.MainPanel();

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 310, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pSwing.MainPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
