package pModel;


public class ModelIdPembeli {
    String idPembeli;

    public ModelIdPembeli() {
    }

    public ModelIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
    }

    public String getIdPembeli() {
        return idPembeli;
    }

    public void setIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
    }
    
    @Override
    public String toString(){
        return idPembeli;
    }
}
