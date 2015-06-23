package com.example.hermawan.mahasiswaonline;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hermawan.mahasiswaonline.entities.Kos;
import com.example.hermawan.mahasiswaonline.server.ServerRequest;
import org.apache.http.HttpStatus;
import com.example.hermawan.mahasiswaonline.entities.Mahasiswa;

public class FormKos extends Activity {
    //private EditText textNim, textNama, textTelp, textAlamat;
    private EditText textNamaPemilik, textAlamat, textHarga, textNoHP,textLongitude, textLatitude, textFasilitas;
    private ProgressDialog progressDialog;
    private ServerRequest server;
    private int replyCode;
    //private Mahasiswa mahasiswa;
    private Kos kos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kos);
        initView();
        server = new ServerRequest();
        kos = new Kos();
        if(getIntent().hasExtra("id")){
            String id = getIntent().getStringExtra("id");
            String namaPemilik = getIntent().getStringExtra("namaPemilik");
            String alamat = getIntent().getStringExtra("alamat");
            String harga = getIntent().getStringExtra("harga");
            String noHP = getIntent().getStringExtra("noHP");
            String longitude = getIntent().getStringExtra("longitude");
            String latitude = getIntent().getStringExtra("latitude");
            String fasilitas = getIntent().getStringExtra("fasilitas");
            textNamaPemilik.setText(namaPemilik);
            textAlamat.setText(alamat);
            textHarga.setText(harga);
            textNoHP.setText(noHP);
            textLongitude.setText(longitude);
            textLatitude.setText(latitude);
            textFasilitas.setText(fasilitas);
            kos.setId(Integer.valueOf(id));
        }else{
            kos.setId(0);
        }
    }

    private void initView(){
        textNamaPemilik = (EditText) findViewById(R.id.add_new_namaPemilik);
        textAlamat = (EditText) findViewById(R.id.add_new_alamat);
        textHarga= (EditText) findViewById(R.id.add_new_harga);
        textNoHP = (EditText) findViewById(R.id.add_new_noHP);
        textLongitude = (EditText) findViewById(R.id.add_new_latitude) ;
        textLatitude = (EditText) findViewById(R.id.add_new_longitude);
        textFasilitas= (EditText) findViewById(R.id.add_new_fasilitas);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form_kos, menu);
        return true;
    }
    private void goToMainActivity(){
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()){
            case android.R.id.home:
                goToMainActivity();
                break;

            case R.id.option_menu_save:
                if(textNamaPemilik.getText().toString().trim().isEmpty() || textNoHP.getText().toString().trim().isEmpty() || textHarga.getText().toString().trim().isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Nama Pemilik, nomor handphone, dan harga tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    new FormKosAsync().execute();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendRequest(){
        String namaPemilik = textNamaPemilik.getText().toString();
        String alamat = textAlamat.getText().toString();
        String harga = textHarga.getText().toString();
        String noHP = textNoHP.getText().toString();
        String longitude = textLongitude.getText().toString();
        String latitude = textLatitude.getText().toString();
        String fasilitas = textFasilitas.getText().toString();
        kos.setNamaPemilik(namaPemilik);
        kos.setAlamat(alamat);
        kos.setHarga(harga);
        kos.setNoHP(noHP);
        kos.setLongitude(longitude);
        kos.setLatitude(latitude);
        kos.setFasilitas(fasilitas);
        /**Mengirimkan POST reques*/
        replyCode = server.sendPostRequest(kos, ServerRequest.urlSubmit);
    }

    private class FormKosAsync extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(FormKos.this);
            progressDialog.setMessage("saving data...");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected String doInBackground(String... params) {
            sendRequest();
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            if(replyCode == HttpStatus.SC_OK){
                goToMainActivity();
            }else{
                Toast.makeText(getApplicationContext(), "save data problem", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
