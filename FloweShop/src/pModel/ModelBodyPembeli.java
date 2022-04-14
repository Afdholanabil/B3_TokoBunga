package pModel;

import com.raven.table.model.TableRowData;


public class ModelBodyPembeli extends TableRowData{
    private ModelIdPembeli idp;
    private String NamaPembeli;
    private String NoHP;
    private String UsernamePembeli;
    private String PasswordPembeli;

    public ModelBodyPembeli() {
    }

    public ModelBodyPembeli(ModelIdPembeli idp, String NamaPembeli, String NoHP, String UsernamePembeli, String PasswordPembeli) {
        this.idp = idp;
        this.NamaPembeli = NamaPembeli;
        this.NoHP = NoHP;
        this.UsernamePembeli = UsernamePembeli;
        this.PasswordPembeli = PasswordPembeli;
    }

    public ModelIdPembeli getIdp() {
        return idp;
    }

    public void setIdp(ModelIdPembeli idp) {
        this.idp = idp;
    }

    public String getNamaPembeli() {
        return NamaPembeli;
    }

    public void setNamaPembeli(String NamaPembeli) {
        this.NamaPembeli = NamaPembeli;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String NoHP) {
        this.NoHP = NoHP;
    }

    public String getUsernamePembeli() {
        return UsernamePembeli;
    }

    public void setUsernamePembeli(String UsernamePembeli) {
        this.UsernamePembeli = UsernamePembeli;
    }

    public String getPasswordPembeli() {
        return PasswordPembeli;
    }

    public void setPasswordPembeli(String PasswordPembeli) {
        this.PasswordPembeli = PasswordPembeli;
    }

    @Override
    public Object[] toTableRow() {
        return new Object[]{idp, NamaPembeli, NoHP, UsernamePembeli, PasswordPembeli};
    }
    
}
