package com.stevanigmail.siska.uts;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stevanigmail.siska.uts.DB.AppDb;
import com.stevanigmail.siska.uts.Model.Kota;
import com.stevanigmail.siska.uts.RV.MyAdapter;

import java.util.List;

public class InputActivity extends AppCompatActivity {

    EditText kota;
    Button add, view;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

       final AppDb db = Room.databaseBuilder(getApplicationContext(), AppDb.class, "database-kota")
               .allowMainThreadQueries()
               .build();

        kota=findViewById(R.id.editKota);
        add=findViewById(R.id.buttonADD);
        view=findViewById(R.id.buttonView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InputActivity.this, ListRActivity.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kota.getText().toString().isEmpty()) {
                    kota.setError("Isi nama dulu");
                    kota.requestFocus();
                }
                else {
                    Kota kotam = new Kota(kota.getText().toString());
                    db.daoKota().insertAll(kotam);
                    kota.setText("");
                    List<Kota> kotaList = db.daoKota().getAll();
                    adapter = new MyAdapter(kotaList);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(InputActivity.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
