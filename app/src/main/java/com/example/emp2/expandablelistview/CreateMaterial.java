package com.example.emp2.expandablelistview;

import android.graphics.PorterDuff;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateMaterial extends AppCompatActivity {

    EditText ET_item_Name,ET_item_Desc,ET_item_Cost,ET_item_qty;
    Button submit_items;

    private CreateMaterialDataBase db;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_material);
        ET_item_Name =(EditText)findViewById(R.id.etItemName);
        ET_item_Desc =(EditText)findViewById(R.id.etDescription);
        ET_item_Cost =(EditText)findViewById(R.id.itemcost);
        ET_item_qty = (EditText)findViewById(R.id.itemQty);
        submit_items =(Button)findViewById(R.id.submitBtn);
        db = new CreateMaterialDataBase(CreateMaterial.this);

        //back button implementation
        ActionBar actionBar = getSupportActionBar();
        if(getSupportActionBar()!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }


        ET_item_Cost.getBackground().setColorFilter(R.color.black, PorterDuff.Mode.SCREEN);

        submit_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(ET_item_Name.getText().toString().length()==0){
                   ET_item_Name.setError("Item Name is required");
                   return;

               }if(ET_item_Cost.getText().toString().length()==0){
                    ET_item_Cost.setError("item cost is required");
                    return;
                }if(ET_item_qty.getText().toString().length()==0){
                    ET_item_qty.setError("required");
                    return;
                }
                else {
                    /*Realm.init(CreateMaterial.this);
                    boolean b = CreateMaterialDataBase.addItems(itemName,itemDesc,itemCost);*/

                    insert();
                    ET_item_Name.setText(null);
                    ET_item_Desc.setText(null);
                    ET_item_Cost.setText(null);
                    ET_item_qty.setText(null);
               }
            }
        });

    }
    public void insert(){

        String itemName = ET_item_Name.getText().toString();
        String itemDesc = ET_item_Desc.getText().toString();
        String itemCost = ET_item_Cost.getText().toString();
        int itemQty = Integer.parseInt(ET_item_qty.getText().toString());

        boolean b = db.addItems(new CreateMaterialDTO(itemName,itemDesc,itemCost,itemQty));

        if(b==true) {
            Toast.makeText(CreateMaterial.this, "Item Added", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(CreateMaterial.this,"Not Added",Toast.LENGTH_LONG).show();
        }
    }

    //back button action or operation

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
