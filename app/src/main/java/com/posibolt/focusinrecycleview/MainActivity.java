package com.posibolt.focusinrecycleview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.posibolt.focusinrecycleview.adapter.MyAdapter;
import com.posibolt.focusinrecycleview.modelclass.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Item> listItem;
    RecyclerView recyclerView;
    public MyAdapter adapter;
    LinearLayoutManager layoutManager;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_name) {
            openCustomDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        listItem = addDataInToList();
        adapter = new MyAdapter(listItem);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private List<Item> addDataInToList(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Arjun",10));
        itemList.add(new Item("Bipin",20));
        itemList.add(new Item("Askar",30));
        itemList.add(new Item("Raju",40));
        itemList.add(new Item("Vikraman",50));
        itemList.add(new Item("Muthu",60));
        itemList.add(new Item("Dogu",70));
        itemList.add(new Item("Vigil",80));
        itemList.add(new Item("Kevin",90));
        itemList.add(new Item("Hazard",100));
        itemList.add(new Item("Lukaku",110));
        return itemList;
    }

    private void openCustomDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_dialog, null);
        dialogBuilder.setView(dialogView);
        final EditText editText = dialogView.findViewById(R.id.editText);
        final Button submitButton = dialogView.findViewById(R.id.submitButton);
        Dialog customDialog = dialogBuilder.create();
        customDialog.show();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                System.out.println(text);
                layoutManager.scrollToPosition(Integer.parseInt(text));
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                customDialog.dismiss();
            }
        });
    }
}