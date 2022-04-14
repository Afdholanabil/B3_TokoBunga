package pModel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ModelBunga {

    private String idBunga;
    private String NamaBunga;
    private String HargaBunga;
    private String Gambar;
    private String Deskripsi;
    private ImageIcon realImage;

//    public ImageIcon getRealImage() {
//        return realImage;
//        repaint();
//    }
//
//    public void setRealImage(ImageIcon realImage) {
//
//        try {
//            this.realImage = realImage;
//            BufferedImage imgUrl;
//            imgUrl = ImageIO.read(new URL("https://dimazz.000webhostapp.com/ApiTokoBunga/images/" + getGambar()));
//            realImage = new ImageIcon(
//                    new ImageIcon(imgUrl)
//                            .getImage()
//                            .getScaledInstance(226, 171, Image.SCALE_SMOOTH));
//        } catch (Exception ex) {
//
//        }
//    }

    public String getIdBunga() {
        return idBunga;
    }

    public void setIdBunga(String idBunga) {
        this.idBunga = idBunga;
    }

    public String getNamaBunga() {
        return NamaBunga;
    }

    public void setNamaBunga(String NamaBunga) {
        this.NamaBunga = NamaBunga;
    }

    public String getHargaBunga() {
        return HargaBunga;
    }

    public void setHargaBunga(String HargaBunga) {
        this.HargaBunga = HargaBunga;
    }

    public String getGambar() {
        return Gambar;
    }

    public void setGambar(String Gambar) {
        this.Gambar = Gambar;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String Deskripsi) {
        this.Deskripsi = Deskripsi;
    }

    public ModelBunga() {
    }

    public ModelBunga(String idBunga, String NamaBunga, String HargaBunga, String Gambar, String Deskripsi) {
        this.idBunga = idBunga;
        this.NamaBunga = NamaBunga;
        this.HargaBunga = HargaBunga;
        this.Gambar = Gambar;
        this.Deskripsi = Deskripsi;
    }
}
