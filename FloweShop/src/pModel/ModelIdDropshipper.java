package pModel;


public class ModelIdDropshipper {
    String idDropshipper;

    public String getIdDropshipper() {
        return idDropshipper;
    }

    public void setIdDropshipper(String idDropshipper) {
        this.idDropshipper = idDropshipper;
    }

    public ModelIdDropshipper(String idDropshipper) {
        this.idDropshipper = idDropshipper;
    }

    public ModelIdDropshipper() {
    }
    
    @Override
    public String toString(){
        return idDropshipper;
    }
}
