package com.example.gl552vw.IAK3_SyarahNurLatifah_Taaruf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    // deklarasi variable yang dipakai
    private TextView nama, umur, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        nama = (TextView) findViewById(R.id.nama);
        umur = (TextView) findViewById(R.id.umur);
        status = (TextView) findViewById(R.id.status);

        // mengambil extra dari MainActivity
        String StringNama = intent.getStringExtra("Nama");
        String StringUmur = intent.getStringExtra("Umur");
        String gender = intent.getStringExtra("Gender");

        // menampilkan teks sesuai dari inputan pada MainActivity
        nama.setText(StringNama);
        umur.setText(StringUmur);

        //parse int ke string
        int intUmur = Integer.parseInt(StringUmur);

        // pengondisian untuk menampilkan status kelayakan
        switch (gender) {
            case "Laki-laki":
                int waitingLk = 21 - intUmur;
                if (intUmur < 21) {
                    status.setText("MOHON MAAF, status " +StringNama +" belum layak untuk melanjutkan proses taaruf. Tunggu " +waitingLk +" tahun lagi untuk mengikuti proses.");
                } else {
                    status.setText("SELAMAT status " +StringNama +" sudah layak untuk melanjutkan proses taaruf.");
                }
                break;
            case "Perempuan":
                int waitingPr = 18 - intUmur;
                if (intUmur < 18) {
                    status.setText("MOHON MAAF, status " +StringNama +" belum layak untuk melanjutkan proses taaruf. Tunggu " +waitingPr +" tahun lagi untuk mengikuti proses.");
                } else {
                    status.setText("SELAMAT status " +StringNama +" sudah layak untuk melanjutkan proses taaruf.");
                }
                break;
        }
    }
}
