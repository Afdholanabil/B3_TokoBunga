package pModel;


public class ModelResponse {
    
    public static boolean checkDataStatic;
    private int kode;

    public ModelResponse() {
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public ModelResponse(int kode) {
        this.kode = kode;
    }
}
