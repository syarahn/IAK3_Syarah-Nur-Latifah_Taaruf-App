package com.example.gl552vw.IAK3_SyarahNurLatifah_Taaruf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variable yang akan dipakai
    EditText InputNama, InputUmur, InputAlamat;
    RadioGroup genderGroup;
    RadioButton genderButton;
    Button status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mengambil inputan sesuai id pada layout file
        InputNama = (EditText) findViewById(R.id.nama);
        InputUmur = (EditText) findViewById(R.id.umur);
        InputAlamat = (EditText) findViewById(R.id.alamat);
        genderGroup = (RadioGroup) findViewById(R.id.radioJk);
        status = (Button) findViewById(R.id.btn_status);
    }

    public void StatusKelayakan(View view) {
        // mengambil radio button yang dipilih dari radio group
        int selectedId = genderGroup.getCheckedRadioButtonId();

        // mengambil radio button sesuai id
        genderButton = (RadioButton) findViewById(selectedId);

        // menampung teks dari radio button
        String radioButtonText = genderButton.getText().toString();

        // pengondisian untuk memunculkan error ketika field tidak diisi
        if(InputNama.getText().toString().length() == 0){
            InputNama.setError("Wajib diisi!");
        }else if (InputUmur.getText().toString().length() == 0){
            InputUmur.setError("Wajib diisi!");
        }else if (InputAlamat.getText().toString().length() == 0){
            InputAlamat.setError("Wajib diisi!");
        }else if(radioButtonText.matches("")){
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
        }

        // menyimpan extra untuk diambil SecondActivity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Nama", InputNama.getText().toString());
        intent.putExtra("Umur", InputUmur.getText().toString());
        intent.putExtra( "Gender", genderButton.getText().toString());

        startActivity(intent);
    }
}
