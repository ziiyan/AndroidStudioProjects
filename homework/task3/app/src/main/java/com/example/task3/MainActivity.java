package com.example.task3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] groups={"group1","group2"};
    private String[][] childs={{"item1","item2","item3"},{"item11","item22","item33"}};
    android.widget.ExpandableListView ExpandableListView;
    MyExpandableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("dialog");
                builder.setMessage("This is a message");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
            case R.id.menu:
                ExpandableListView= (ExpandableListView) findViewById(R.id.expand_listview);
                adapter=new MyExpandableAdapter(getBaseContext(),groups,childs);
                ExpandableListView.setAdapter(adapter);
                //设置子项布局监听
                ExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        Toast.makeText(MainActivity.this,
                                "选中"+childs[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                break;
            default:
        }
        return true;
    }

}
