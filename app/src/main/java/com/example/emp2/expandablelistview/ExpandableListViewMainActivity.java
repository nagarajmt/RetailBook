package com.example.emp2.expandablelistview;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewMainActivity extends AppCompatActivity {

    ExpandableListView ex_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view_main);
        ex_listView = (ExpandableListView)findViewById(R.id.ex_list);
        List<String> Headings = new ArrayList<String>();
        List<String> L2  = new ArrayList<String>();
        List<String> L3 = new ArrayList<String>();
        List<String> L4 = new ArrayList<String>();
        List<String> L5 = new ArrayList<String>();
        List<String> L6 = new ArrayList<String>();
        List<String> L7 = new ArrayList<String>();
        List<String> L8 = new ArrayList<String>();
        HashMap<String,List<String>> ChildList = new HashMap<String, List<String>>();
        String h_items[] = getResources().getStringArray(R.array.header_titles);
        String l2_items[] = getResources().getStringArray(R.array.h2_items);
        String l3_items[] = getResources().getStringArray(R.array.h3_items);
        String l4_items[] = getResources().getStringArray(R.array.h4_items);
        String l5_items[] = getResources().getStringArray(R.array.h5_items);
        String l6_items[] = getResources().getStringArray(R.array.h6_items);
        String l7_items[] = getResources().getStringArray(R.array.h7_items);
        String l8_items[] = getResources().getStringArray(R.array.h8_items);
        for(String title : h_items){
            Headings.add(title);
        }
        for(String title : l2_items){
            L2.add(title);
        }
        for(String title : l3_items){
            L3.add(title);
        }
        for(String title : l4_items){
            L4.add(title);
        }
        for(String title : l5_items){
            L5.add(title);
        }
        for(String title : l6_items){
            L6.add(title);
        }
        for(String title : l7_items){
            L7.add(title);
        }
        for(String title : l8_items){
            L8.add(title);
        }
        /*ChildList.put(Headings.get(0),L1);*/
        ChildList.put(Headings.get(1),L2);
        ChildList.put(Headings.get(2),L3);
        ChildList.put(Headings.get(3),L4);
        ChildList.put(Headings.get(4),L5);
        ChildList.put(Headings.get(5),L6);
        ChildList.put(Headings.get(6),L7);
        ChildList.put(Headings.get(7),L8);

        final MyAdapter adapter = new MyAdapter(this,Headings,ChildList);
        ex_listView.setAdapter(adapter);

        ex_listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            private int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    ex_listView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        //CHILD ITEM ONCLICK---------------
        ex_listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final String selected = (String) adapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_SHORT).show();

                switch (groupPosition) {          // the First you must know the group position
                    case 1:                       // Here your Group position the first Group
                        switch (childPosition) {
                            case 0:                   // Here your Child position
                                startActivity(new Intent(getApplicationContext(),
                                Create_Cash_Invoice_MainActivity.class));
                                break;                // this break for Child
                        }
                        break;                    // this break for Group

                    case 5:                       // Here your Group position the first Group
                        switch (childPosition) {
                            case 0:                   // Here your Child position
                                startActivity(new Intent(getApplicationContext(),
                                        CreateMaterial.class));
                                break;                // this break for Child
                            case 1:
                                startActivity(new Intent(getApplicationContext(),
                                        CheckStock.class));
                        }
                        break;

                }
                return false;


            }
        });



    }

}
