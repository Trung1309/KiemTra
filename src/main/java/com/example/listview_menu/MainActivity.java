package com.example.listview_menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<SanPham> ArrayThucAn;
    Menu_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        adapter = new Menu_Adapter(this,R.layout.dong_menu,ArrayThucAn);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int item = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Bạn có xoá không ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ArrayThucAn.remove(item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }

    private void anhXa() {
        listView = findViewById(R.id.listMenu);
        ArrayThucAn = new ArrayList<>();
        ArrayThucAn.add(new SanPham("Cua Hoàng Đế", "Cua AlatKa 3kg", "200$", R.drawable.cuahoangde));
        ArrayThucAn.add(new SanPham("Tôm Hùm Hấp", "Tôm AlatKa 2kg", "200$", R.drawable.tomhum));
        ArrayThucAn.add(new SanPham("Mực Hấp", "Mực 1kg", "30$", R.drawable.muchap));
        ArrayThucAn.add(new SanPham("Tôm Sú Sốt Thái", "Tôm Sú 1kg", "70$", R.drawable.tomtai));
        ArrayThucAn.add(new SanPham("Mực Nướng", "Mực lá 1kg", "70$", R.drawable.mucnuong));
        ArrayThucAn.add(new SanPham("Cá kho", "Cá ngừ", "10$", R.drawable.cakho));

    }
}