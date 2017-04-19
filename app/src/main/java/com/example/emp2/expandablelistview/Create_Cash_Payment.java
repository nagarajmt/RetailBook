package com.example.emp2.expandablelistview;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by EMP2 on 3/30/2017.
 */

public class Create_Cash_Payment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*if(container==null){
            return null;
        }*/

        return inflater.inflate(R.layout.create_cash_payment_tab,container,false);
    }
}
