package com.example.emp2.expandablelistview;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by EMP2 on 4/14/2017.
 */

public class Item_ListViewAdapter extends BaseAdapter
{
    public ArrayList<CreateMaterialDTO> item_list;
    Activity activity;

    public Item_ListViewAdapter(Activity activity,ArrayList<CreateMaterialDTO> item_list){
       super();
        this.activity=activity;
        this.item_list=item_list;
    }
    @Override
    public int getCount() {
        return item_list.size();
    }

    @Override
    public Object getItem(int i) {
        return item_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        TextView itemName;
        TextView itemPrice;
        TextView itemQty;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if(convertView==null){
            convertView=inflater.inflate(R.layout.listview_row,null);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row,viewGroup,false);
            holder=new ViewHolder();
           // holder.sno=(TextView)convertView.findViewById(R.id.List_sNo);
            holder.itemName=(TextView)convertView.findViewById(R.id.LisIitemName);
            holder.itemPrice=(TextView)convertView.findViewById(R.id.LisIitemPrice);
            holder.itemQty=(TextView)convertView.findViewById(R.id.LisIitemQty);
            //holder.itemTotal=(TextView)convertView.findViewById(R.id.LisIitemTotal);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        CreateMaterialDTO dto = (CreateMaterialDTO)this.getItem(i);
//        holder.sno.setText(dto.getId());
        holder.itemName.setText(dto.getItem_name().toString());
        holder.itemPrice.setText(dto.getItem_cost().toString());
        holder.itemQty.setText(String.valueOf(dto.getItem_qty()).toString());
        return convertView;
    }
}
