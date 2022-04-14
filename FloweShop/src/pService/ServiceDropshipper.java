package pService;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static pConnection.ConnectionClass.linkUrl;
import pDialogMessage.ErrorDialog;
import pModel.ModelBodyDropshipper;
import pModel.ModelIdDropshipper;
import pModel.ModelResponse;
import static pPanelForm.DropshipperPanel.btRefreshDropshipper;

public class ServiceDropshipper {

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static ArrayList<ModelBodyDropshipper> getDropshipper() throws IOException, ParseException, JSONException {
        ArrayList<ModelBodyDropshipper> list = new ArrayList<>();

        String url = linkUrl + "DropshipperRestful.php";

        //thread untuk menghindari hang saat proses berjalan
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        //ambil response
        CloseableHttpResponse response;
        response = httpClient.execute(httpGet);
        String responseBody = EntityUtils.toString(response.getEntity());
        //olah json
        JSONObject obj = new JSONObject(responseBody);
        JSONArray arr = obj.getJSONArray("data");
        for (int i = 0; i < arr.length(); i++) {
            String a = arr.getJSONObject(i).getString("idDropshipper");
            String b = arr.getJSONObject(i).getString("NamaDropshipper");
            String c = arr.getJSONObject(i).getString("NoHP");
            String d = arr.getJSONObject(i).getString("Alamat");
            String f = arr.getJSONObject(i).getString("Username");
            String g = arr.getJSONObject(i).getString("Password");
            list.add(new ModelBodyDropshipper(new ModelIdDropshipper(a), b, c, d, f, g));
        }
        return list;
    }

    public void insertDropshipper(ModelBodyDropshipper mbd, ModelResponse mrp) {
        try {
            String post_data = "Username=" + mbd.getUsername() + "&Password=" + mbd.getPassword() + "&NamaDropshipper="
                    + mbd.getNamaDropshipper() + "&NoHP=" + mbd.getNoHP() + "&Alamat=" + mbd.getAlamat();
            URL url = new URL(linkUrl + "DropshipperRestful.php");

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
            JSONObject obj = new JSONObject(response.toString());
            String pesan = obj.getString("kode");
            if (pesan.equals("2")) {
                mrp.setKode(2);
                ErrorDialog edl = new ErrorDialog(null, true);
                edl.lblErrorDialog.setText("Nama User Telah Digunakan");
                edl.show();
            } else {
                if (pesan.equals("1")) {
                    mrp.setKode(1);
                } else {
                    mrp.setKode(0);
                }
            }
        } catch (IOException | JSONException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateDropshipper(ModelBodyDropshipper mbd, ModelResponse mrp) {
        try {
            String post_data = "Username=" + mbd.getUsername() + "&Password=" + mbd.getPassword()
                    + "&NamaDropshipper=" + mbd.getNamaDropshipper()+ "&NoHP=" + mbd.getNoHP()
                    + "&Alamat=" + mbd.getAlamat();
            URL url = new URL(linkUrl + "DropshipperUpdate.php?idDropshipper=" + mbd.getIdDropshipper());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            os.write(post_data.getBytes());
            os.flush();
            os.close();

            String line = "";
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
            JSONObject obj = new JSONObject(response.toString());
            String pesan = obj.getString("kode");
            if (pesan.equals("1")) {
                mrp.setKode(1);
            } else {
                mrp.setKode(0);
            }
        } catch (IOException | JSONException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteDropshipper(String idDropshipper, ModelResponse mrp) {
        try {
            ServiceDropshipper a = new ServiceDropshipper();
            String user = a.getSaltString();
            ServiceDropshipper b = new ServiceDropshipper();
            String pass = b.getSaltString();
            String post_data = "Username=" + user + "&Password=" + pass;
            URL url = new URL(linkUrl + "DropshipperDelete.php?idDropshipper=" + idDropshipper);

            HttpURLConnection htc = (HttpURLConnection) url.openConnection();
            htc.setRequestMethod("POST");
            htc.setDoOutput(true);

            OutputStream os = htc.getOutputStream();
            os.write(post_data.getBytes());
            os.flush();
            os.close();

            String line = "";
            InputStreamReader isr = new InputStreamReader(htc.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
            JSONObject obj = new JSONObject(response.toString());
            String pesan = obj.getString("kode");
            if (pesan.equals("1")) {
                mrp.setKode(1);
            } else {
                mrp.setKode(0);
            }
        } catch (IOException | JSONException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ArrayList<ModelBodyDropshipper> searchDropshipper(String search, ModelResponse mrp) throws UnsupportedEncodingException, IOException, ParseException, JSONException {
        ArrayList<ModelBodyDropshipper> list = new ArrayList<>();
        try {
            String url = linkUrl + "DropshipperSearch.php?filter=" + URLEncoder.encode(search, "UTF-8");
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response;
            response = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject obj = new JSONObject(responseBody);
            JSONArray arr = obj.getJSONArray("data");
            for (int i = 0; i < arr.length(); i++) {
                String a = arr.getJSONObject(i).getString("idDropshipper");
                String b = arr.getJSONObject(i).getString("NamaDropshipper");
                String c = arr.getJSONObject(i).getString("NoHP");
                String d = arr.getJSONObject(i).getString("Alamat");
                String e = arr.getJSONObject(i).getString("Username");
                String f = arr.getJSONObject(i).getString("Password");

                list.add(new ModelBodyDropshipper(new ModelIdDropshipper(a), b, c, d, e, f));
            }
        } catch (HeadlessException | IOException | JSONException e) {
            ErrorDialog edl = new ErrorDialog(null, true);
            edl.lblErrorDialog.setText("Data Yang Anda Cari Tidak Ada");
            edl.show();
            btRefreshDropshipper.doClick();
        }
        return list;
    }
}
