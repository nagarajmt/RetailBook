package com.example.emp2.expandablelistview;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by EMP2 on 3/30/2017.
 */

public class Create_Cash_Item  extends Fragment{
    Button btn;
   EditText et_item,et_price,et_qty,et_total;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View h = inflater.inflate(R.layout.create_cash_item_tab,container,false);
        btn = (Button)h.findViewById(R.id.ItemTabSubmitBtn);
        et_item=(EditText)h.findViewById(R.id.ET_item_CI);
        et_price=(EditText)h.findViewById(R.id.ET_price_CI);
        et_qty=(EditText)h.findViewById(R.id.ET_qty_CI);
        et_total=(EditText)h.findViewById(R.id.ET_total_CI);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(h.getContext(),"snn",Toast.LENGTH_LONG).show();
            }
        });
        return h;
    }


}
