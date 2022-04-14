package pComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MenuItem extends javax.swing.JPanel {

    private boolean selected;
    private boolean over;

    public MenuItem(ModelMenu data) {
        initComponents();
        setOpaque(false);
        
        if (data.getType()==ModelMenu.MenuType.MENU){
            lblicon.setIcon(data.tooIcon());
            lblname.setText(data.getName());
            lblname.setFont(new Font("sansserif", Font.PLAIN, 14));
            lblname.setForeground(Color.WHITE);
        }else if(data.getType()==ModelMenu.MenuType.TITLE){
            lblicon.setText("  " + data.getName());
            lblicon.setFont(new Font("sansserif", Font.PLAIN, 14));
            lblicon.setForeground(Color.WHITE);
            lblname.setVisible(false);
        }else{
            lblname.setText(" ");
        }
        
    }
        public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

        public void setOver(boolean over){
            this.over=over;
            repaint();
        }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblicon = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        lblicon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblname.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblname.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblicon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(lblicon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grp) {
        if (selected || over){
            Graphics2D g2 = (Graphics2D) grp;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected){
            g2.setColor(new Color(255,255,255,80));
            }
            else{
             g2.setColor(new Color(255,255,255,20));   
            }
            g2.fillRoundRect(10, 0, getWidth()-20, getHeight(), 5, 5);       
        }    
        super.paintComponent(grp);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblicon;
    private javax.swing.JLabel lblname;
    // End of variables declaration//GEN-END:variables
}
