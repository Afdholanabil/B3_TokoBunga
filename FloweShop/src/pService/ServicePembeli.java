package pService;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import pModel.ModelBodyPembeli;
import static pConnection.ConnectionClass.linkUrl;
import pDialogMessage.ErrorDialog;
import pModel.ModelIdPembeli;
import pModel.ModelResponse;
import static pPanelForm.PembeliPanel.btRefreshPembeli;

public class ServicePembeli {

    public static ArrayList<ModelBodyPembeli> getPembeli() throws IOException, ParseException, JSONException {
        ArrayList<ModelBodyPembeli> list = new ArrayList<>();

        String url = linkUrl + "PembeliRestful.php";

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
            String a = arr.getJSONObject(i).getString("idPembeli");
            String b = arr.getJSONObject(i).getString("NamaPembeli");
            String c = arr.getJSONObject(i).getString("NoHP");
            String d = arr.getJSONObject(i).getString("UsernamePembeli");
            String e = arr.getJSONObject(i).getString("PasswordPembeli");
            list.add(new ModelBodyPembeli(new ModelIdPembeli(a), b, c, d, e));
        }
        return list;
    }

    public void insertPembeli(ModelBodyPembeli mbp, ModelResponse mrp) {
        try {
            String post_data = "NamaPembeli=" + mbp.getNamaPembeli() + "&NoHP=" + mbp.getNoHP() + "&UsernamePembeli="
                    + mbp.getUsernamePembeli() + "&PasswordPembeli=" + mbp.getPasswordPembeli();
            URL url = new URL(linkUrl + "PembeliRestful.php");

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
            if (pesan.equals("1")) {
                mrp.setKode(1);
            } else {
                mrp.setKode(0);
            }
        } catch (IOException | JSONException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updatePembeli(ModelBodyPembeli mbp, ModelResponse mrp) {
        try {
            String post_data = "NamaPembeli=" + mbp.getNamaPembeli() + "&NoHP=" + mbp.getNoHP() + "&UsernamePembeli="
                    + mbp.getUsernamePembeli() + "&PasswordPembeli=" + mbp.getPasswordPembeli();
            URL url = new URL(linkUrl + "PembeliUpdate.php?idPembeli=" + mbp.getIdp());

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
            if (pesan.equals("1")) {
                mrp.setKode(1);
            } else {
                mrp.setKode(0);
                JOptionPane.showMessageDialog(null, "Pesan Error : " + response.toString());
            }
        } catch (HeadlessException | IOException | JSONException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deletePembeli(String idPembeli, ModelResponse mrp) {
        try {

            URL url = new URL(linkUrl + "PembeliDelete.php?idPembeli=" + idPembeli);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);

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
            if (pesan.equals("1")) {
                mrp.setKode(1);
            } else {
                mrp.setKode(0);
            }
        } catch (HeadlessException | IOException | JSONException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ArrayList<ModelBodyPembeli> searchPembeli(String search, ModelResponse mrp) throws IOException, ParseException {

        ArrayList<ModelBodyPembeli> list = new ArrayList<>();
        try {
            String url = linkUrl + "PembeliSearch.php?filter=" + URLEncoder.encode(search, "UTF-8");

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
                String a = arr.getJSONObject(i).getString("idPembeli");
                String b = arr.getJSONObject(i).getString("NamaPembeli");
                String c = arr.getJSONObject(i).getString("NoHP");
                String d = arr.getJSONObject(i).getString("UsernamePembeli");
                String e = arr.getJSONObject(i).getString("PasswordPembeli");
                list.add(new ModelBodyPembeli(new ModelIdPembeli(a), b, c, d, e));
            }
        } catch (HeadlessException | IOException | JSONException e) {
            ErrorDialog edl = new ErrorDialog(null, true);
            edl.lblErrorDialog.setText("Data Yang Anda Cari Tidak Ada");
            edl.show();
            btRefreshPembeli.doClick();
        }
        return list;

    }
}
