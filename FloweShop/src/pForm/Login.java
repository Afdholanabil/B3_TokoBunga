package pForm;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import static pConnection.ConnectionClass.linkUrl;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        tpass.setEchoChar((char) 0);
        tpass.setText("Password");
        btlogin.requestFocus();
    }

    private void methodLogin() {
        try {
            String strrole;
            if (rbpemilik.isSelected()) {
                strrole = "1";
            } else {
                strrole = "2";
            }
            String post_data = "Username=" + tuser.getText().toString() + "&Password=" + tpass.getText().toString() + "&User_Role=" + strrole.toString();
            String pathurl = linkUrl + "LoginUser.php";
            URL url = new URL(pathurl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(post_data.getBytes());
            outputStream.flush();
            outputStream.close();
            String line = "";

            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            bufferedReader.close();
            //JOptionPane.showMessageDialog(null, response);
            JSONObject obj = new JSONObject(response.toString());
            String pesan = obj.getString("kode");
            if (pesan.equals("1")) {
                new Dashboard().show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Login");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbpemilik = new javax.swing.JRadioButton();
        rbdrop = new javax.swing.JRadioButton();
        tuser = new pSwing.RoundJTextField();
        tpass = new pSwing.RoundJPasswordField();
        btlogin = new pSwing.RoundJButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pImages/gambarLoginmini.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(223, 72, 72));
        jLabel2.setText("Masuk Flower Shop");

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(223, 72, 72));
        jLabel3.setText("Silahkan Login");

        rbpemilik.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbpemilik);
        rbpemilik.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        rbpemilik.setText("Pemilik");

        rbdrop.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbdrop);
        rbdrop.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        rbdrop.setText("Dropshipper");

        tuser.setForeground(new java.awt.Color(102, 102, 102));
        tuser.setText("Username");
        tuser.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        tuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tuserFocusLost(evt);
            }
        });

        tpass.setForeground(new java.awt.Color(102, 102, 102));
        tpass.setText("Password");
        tpass.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        tpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tpassFocusLost(evt);
            }
        });

        btlogin.setBackground(new java.awt.Color(60, 94, 237));
        btlogin.setForeground(new java.awt.Color(255, 255, 255));
        btlogin.setText("Login");
        btlogin.setContentAreaFilled(false);
        btlogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbpemilik)
                        .addGap(66, 66, 66)
                        .addComponent(rbdrop))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btlogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tuser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(57, 57, 57)
                .addComponent(tuser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(tpass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbdrop)
                    .addComponent(rbpemilik))
                .addGap(48, 48, 48)
                .addComponent(btlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tuserFocusGained
        if (tuser.getText().equals("Username")) {
            tuser.setText("");
            tuser.setForeground(Color.black);
        }
    }//GEN-LAST:event_tuserFocusGained

    private void tuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tuserFocusLost
        if (tuser.getText().equals("")) {
            tuser.setText("Username");
            tuser.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tuserFocusLost

    private void tpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpassFocusGained
        if (tpass.getText().equals("Password")) {
            tpass.setText("");
            tpass.setEchoChar('*');
            tpass.setForeground(Color.black);
        }
    }//GEN-LAST:event_tpassFocusGained

    private void tpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpassFocusLost
        if (tpass.getText().equals("")) {
            tpass.setText("Password");
            tpass.setEchoChar((char) 0);
            tpass.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tpassFocusLost

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed
        methodLogin();
    }//GEN-LAST:event_btloginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pSwing.RoundJButton btlogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbdrop;
    private javax.swing.JRadioButton rbpemilik;
    private pSwing.RoundJPasswordField tpass;
    private pSwing.RoundJTextField tuser;
    // End of variables declaration//GEN-END:variables
}
