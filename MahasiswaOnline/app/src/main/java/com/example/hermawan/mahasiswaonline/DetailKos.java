package com.example.hermawan.mahasiswaonline;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hermawan.mahasiswaonline.entities.Kos;
import com.example.hermawan.mahasiswaonline.entities.Mahasiswa;
import com.example.hermawan.mahasiswaonline.server.ServerRequest;


public class DetailKos extends Activity {

    private EditText textNamaPemilik, textAlamat, textHarga, textNoHP,textLongitude, textLatitude, textFasilitas;
    private Kos kos;
    private ServerRequest server;
    private Button goPeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kos);
        kos = new Kos();
        server = new ServerRequest();
        initView();
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        //listener button peta
        goPeta = (Button)findViewById(R.id.btn_goMaps);
        goPeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sumbuX = textLatitude.getText().toString();
                String sumbuY = textLongitude.getText().toString();
                int latitude = Integer.parseInt(sumbuX);
                int longitude = Integer.parseInt(sumbuY);


                Uri gmmIntentUri = Uri.parse("geo:"+latitude+","+longitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

    private void initView(){
        textNamaPemilik = (EditText) findViewById(R.id.add_new_namaPemilik);
        textHarga = (EditText) findViewById(R.id.add_new_harga);
        textNoHP = (EditText) findViewById(R.id.add_new_noHP);
        textAlamat = (EditText) findViewById(R.id.add_new_alamat);
        textLongitude = (EditText) findViewById(R.id.add_new_longitude);
        textLatitude = (EditText) findViewById(R.id.add_new_latitude);
        textFasilitas = (EditText) findViewById(R.id.add_new_fasilitas);

        String id = getIntent().getStringExtra("id");
        String namaPemilik = getIntent().getStringExtra("namaPemilik");
        String alamat = getIntent().getStringExtra("alamat");
        String harga = getIntent().getStringExtra("harga");
        String noHP = getIntent().getStringExtra("noHP");
        String longtitude = getIntent().getStringExtra("longtitude");
        String latitude = getIntent().getStringExtra("latitude");
        String fasilitas = getIntent().getStringExtra("fasilitas");

        textNamaPemilik.setText(namaPemilik);
        textHarga.setText(harga);
        textNoHP.setText(noHP);
        textAlamat.setText(alamat);
        textLongitude.setText(longtitude);
        textLatitude.setText(latitude);
        textFasilitas.setText(fasilitas);

        kos.setId(Integer.valueOf(id));
        kos.setNamaPemilik(namaPemilik);
        kos.setHarga(harga);
        kos.setNoHP(noHP);
        kos.setAlamat(alamat);
        kos.setLongitude(longtitude);
        kos.setLatitude(latitude);
        kos.setFasilitas(fasilitas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                goToMainActivity();
                break;

            case R.id.action_menu_edit:
                Intent in = new Intent(getApplicationContext(), FormKos.class);
                in.putExtra("id", kos.getId().toString());
                in.putExtra("namaPemilik", kos.getNamaPemilik().toString());
                //in.putExtra("nim", kos.getNim());
                //in.putExtra("nama", kos.getNama());
                //in.putExtra("telp", kos.getTelp());
                in.putExtra("alamat", kos.getAlamat().toString());
                in.putExtra("harga", kos.getHarga().toString());
                in.putExtra("noHP", kos.getNoHP().toString());
                in.putExtra("longitude", kos.getLongitude().toString());
                in.putExtra("latitude", kos.getLatitude().toString());
                in.putExtra("fasilitas", kos.getFasilitas().toString());
                startActivity(in);
                break;

            case R.id.action_menu_delete:
                delete();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToMainActivity(){
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
    }

    private void delete(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete "+kos.getNamaPemilik()+" ?");
        builder.setTitle("Delete");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                new DetailMahasiswaAsync().execute();
                Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.setIcon(android.R.drawable.ic_menu_delete);
        alert.show();
    }
    private class DetailMahasiswaAsync extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            server.sendGetRequest(ServerRequest.urlDelete+"?id="+kos.getId().toString());
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Intent in = new Intent(getApplicationContext(), MainActivity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(in);
        }

    }
}
