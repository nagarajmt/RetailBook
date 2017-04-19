package com.example.emp2.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class CheckStock extends AppCompatActivity {

    private ArrayList<CreateMaterialDTO> checkStock;
    private CreateMaterialDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_stock);
        checkStock = new ArrayList<>();
        ListView listView = (ListView)findViewById(R.id.listview);
        Item_ListViewAdapter adapter= new Item_ListViewAdapter(this,checkStock);
        listView.setAdapter(adapter);
//        db.getArrayList();
        populatelist();
    }

   private void populatelist(){
       CreateMaterialDTO i1,i2,i3,i4;
       i1 = new CreateMaterialDTO("sugar","50",100);
       checkStock.add(i1);

       i2 = new CreateMaterialDTO("vinegar","100",2500);
       checkStock.add(i2);

       i3=new CreateMaterialDTO("chilli","200",200);
       checkStock.add(i3);

       /*ArrayList li = new ArrayList();
        li=db.getAllItems();
       for(int i=0;i<=li.size();i++);
       {


       }*/
   }
}
