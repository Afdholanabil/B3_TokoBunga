package pService;

import java.io.IOException;
import java.util.ArrayList;
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
import pModel.ModelBunga;


public class ServiceBunga {
      public static ArrayList<ModelBunga> getBunga() throws IOException, ParseException, JSONException {
        ArrayList<ModelBunga> list = new ArrayList<>();

        String url = linkUrl + "BungaRestful.php";

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
            String a = arr.getJSONObject(i).getString("idBunga");
            String b = arr.getJSONObject(i).getString("NamaBunga");
            String c = arr.getJSONObject(i).getString("HargaBunga");
            String d = arr.getJSONObject(i).getString("Gambar");
            String e = arr.getJSONObject(i).getString("Deskripsi");
            list.add(new ModelBunga(a , b, c, d, e));
        }
        return list;
    }
}
