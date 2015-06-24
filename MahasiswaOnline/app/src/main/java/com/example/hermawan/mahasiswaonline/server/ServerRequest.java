package com.example.hermawan.mahasiswaonline.server;

/**
 * Created by hermawan on 12/06/2015.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.example.hermawan.mahasiswaonline.entities.Kos;
import com.example.hermawan.mahasiswaonline.entities.Mahasiswa;
import android.util.Log;

public class ServerRequest {
    private final static String TAG = "ServerRequest";
    private final String serverUri = "http://findkos.hol.es";
    public static final String urlSelectAll = "kos_all.php";
    public static final String urlDelete = "delete_mahasiswa.php";
    public static final String urlSubmit = "submit_mahasiswa.php";

    public ServerRequest() {
        super();
    }

    /** Mengirimkan GET request */
    public String sendGetRequest(String reqUrl){
        HttpClient httpClient;
        HttpGet httpGet = new HttpGet(serverUri+"/"+reqUrl);
        InputStream is = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpParams params = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(params, 3000);
            HttpConnectionParams.setSoTimeout(params, 3000);
            httpClient = new DefaultHttpClient(params);
            Log.d(TAG, "executing...");
            HttpResponse httpResponse = httpClient.execute(httpGet);
            StatusLine status = httpResponse.getStatusLine();
            if(status.getStatusCode() == HttpStatus.SC_OK && httpResponse != null){
                /** mengambil response string dari server */
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = null;
                while((line = reader.readLine()) != null){
                    stringBuilder.append(line+"\n");
                }
                is.close();
            }
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }

        return stringBuilder.toString();
    }

    /** Mengirimkan POST request */
    public int sendPostRequest(Kos kos, String url){
        int replyCode = 99;
        HttpClient httpClient;
        HttpPost post = new HttpPost(this.serverUri+"/"+url);
        /** menambahkan parameter ke dalam request */
        List<NameValuePair> value = new ArrayList<NameValuePair>();
        value.add(new BasicNameValuePair("id", kos.getId().toString()));
        value.add(new BasicNameValuePair("harga", kos.getHarga()));
        value.add(new BasicNameValuePair("latitude", kos.getLatitude()));
        value.add(new BasicNameValuePair("longtitude", kos.getLongitude()));
        value.add(new BasicNameValuePair("alamat", kos.getAlamat()));
        value.add(new BasicNameValuePair("namaPemilik", kos.getNamaPemilik()));
        value.add(new BasicNameValuePair("noHP", kos.getNoHP()));
        value.add(new BasicNameValuePair("fasilitas", kos.getFasilitas()));

        try {
            HttpParams params = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(params, 3000);
            HttpConnectionParams.setSoTimeout(params, 3000);
            httpClient = new DefaultHttpClient(params);
            post.setEntity(new UrlEncodedFormEntity(value));
            Log.d(TAG, "executing post...");
            HttpResponse httpResponse = httpClient.execute(post);
            StatusLine status = httpResponse.getStatusLine();
            if(status.getStatusCode() == HttpStatus.SC_OK){
                Log.d(TAG, "submitted sucessfully...");
                //Log.d(TAG, "id" +  kos.getId().toString());
                replyCode = status.getStatusCode();
            }
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
        return replyCode;
    }
}
