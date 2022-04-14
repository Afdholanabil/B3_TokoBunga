package pModel;

import com.raven.table.model.TableRowData;


public class ModelBodyDropshipper extends TableRowData{
    private ModelIdDropshipper idDropshipper;
    private String NamaDropshipper;
    private String NoHP;
    private String Alamat;
    private String Username;
    private String Password;

    public ModelIdDropshipper getIdDropshipper() {
        return idDropshipper;
    }

    public void setIdDropshipper(ModelIdDropshipper idDropshipper) {
        this.idDropshipper = idDropshipper;
    }

    public String getNamaDropshipper() {
        return NamaDropshipper;
    }

    public void setNamaDropshipper(String NamaDropshipper) {
        this.NamaDropshipper = NamaDropshipper;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String NoHP) {
        this.NoHP = NoHP;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public ModelBodyDropshipper() {
    }

    public ModelBodyDropshipper(ModelIdDropshipper idDropshipper, String NamaDropshipper, String NoHP, String Alamat, String Username, String Password) {
        this.idDropshipper = idDropshipper;
        this.NamaDropshipper = NamaDropshipper;
        this.NoHP = NoHP;
        this.Alamat = Alamat;
        this.Username = Username;
        this.Password = Password;
    }


    @Override
    public Object[] toTableRow() {
        return new Object[]{idDropshipper, NamaDropshipper, NoHP, Alamat,  Username, Password};
    }
    
}
