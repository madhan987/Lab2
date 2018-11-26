package com.hp.example.lab2;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button context =  findViewById(R.id.button);
        Button dialog = findViewById(R.id.db);
        Button progress =  findViewById(R.id.pb);
        registerForContextMenu(context);


//*************************************ALERT DIALOG**********************************
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                build.setMessage("Do You Want tTo Close This APP");
                build.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });
                build.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = build.create();
                alert.setTitle("ALERT...!");
                alert.show();
            }
        });
//*************************************PROGRESS BAR**********************************/
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog prgrs = new ProgressDialog(MainActivity.this);
                prgrs.setTitle("Download");
                prgrs.setMessage("Downloading...");
                prgrs.setProgressStyle(prgrs.STYLE_SPINNER);
                prgrs.show();
            }
        });
//*************************************LIST VIEW**********************************/
       /* ListView list=findViewById(R.id.lv);
        String fruitsList[]={"APPLE","BANANA","GRAPE","ORANGE","MANGO","WATERMELON","AVOCADOS",
"CHERRY","BLUEBERRY","aaaaa","bbbbb","ccccc","ddddd","eeeee","ffffff","gggggg",};
        ArrayAdapter<String> arry= new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, fruitsList);
        list.setAdapter(arry);
*/
    }
    //*************************************OPTION MENU**********************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @SuppressLint({"WrongConstant", "ShowToast"})
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.t1:
                Toast.makeText(this," Item 1 Selected ",500).show();
                break;
            case R.id.t2:
                Toast.makeText(this,"Item 2 Selected ",500).show();
                break;
            case R.id.t3:
                Toast.makeText(this,";Item 3 Selected&quot",500).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //*************************************CONTEXT MENU**********************************/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo)
    {
        MenuInflater mii=getMenuInflater();
        mii.inflate(R.menu.my_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @SuppressLint({"ShowToast", "WrongConstant"})
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.t1:
                Toast.makeText(this," Item 1 Selected ",500).show();
                break;
            case R.id.t2:
                Toast.makeText(this,"Item 2 Selected ",500).show();
                break;
            case R.id.t3:
                Toast.makeText(this,";Item 3 Selected&quot",500).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
