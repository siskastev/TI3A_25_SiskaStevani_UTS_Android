package com.stevanigmail.siska.uts;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stevanigmail.siska.uts.DB.AppDb;
import com.stevanigmail.siska.uts.Model.Kota;
import com.stevanigmail.siska.uts.RV.MyAdapter;
import com.stevanigmail.siska.uts.RV.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ListRActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyAdapter adapter;

    private TextView txt_resultadapter;
    private List<Kota> kotaList ;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_r);

        kotaList = new ArrayList<>();

        final AppDb db = Room.databaseBuilder(getApplicationContext(), AppDb.class, "database-kota")
                .allowMainThreadQueries()
                .build();

        initComponents();

        recyclerView = (RecyclerView) findViewById(R.id.rv_kota);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        kotaList = db.daoKota().getAll();
        adapter = new MyAdapter(kotaList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        cekDataRecyclerView();

        back = findViewById(R.id.buttonback2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListRActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initComponents(){
        txt_resultadapter = (TextView) findViewById(R.id.txt_resultadapter);
    }

    private void cekDataRecyclerView() {
        if (adapter.getItemCount() == 0) {
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Kota kota = kotaList.get(position);
                            String nama = kota.getKota();

                            Toast.makeText(ListRActivity.this, "Klik  " + nama, Toast.LENGTH_SHORT).show();
                        }
                    })
            );
        }
    }
}
