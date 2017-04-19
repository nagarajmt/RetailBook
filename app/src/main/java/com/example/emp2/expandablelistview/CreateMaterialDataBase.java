package com.example.emp2.expandablelistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by EMP2 on 4/3/2017.
 */

public class CreateMaterialDataBase extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RETAILBOOK_DB";
    public static final String TABLE_NAME = "materials";
    public static final String COLUMN_SNO = ("slno");
    public static final String COLUMN_ITEM = "item_name";
    public static final String COLUMN_DESC = "item_desc";
    public static final String COLUMN_COST = "item_cost";
    public static final String COLUMN_QTY = ("item_qty");
    public static String FILE_DIR ="db";
    public static final String LOGCAT = null;

    public CreateMaterialDataBase(Context context) {
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);
        super(context, Environment.getExternalStorageDirectory()
          + File.separator+FILE_DIR
        +File.separator+DATABASE_NAME,null,DATABASE_VERSION);
        Log.d(LOGCAT,"created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME
                +"(" +COLUMN_SNO+
                " INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_ITEM+
                " TEXT UNIQUE, "+COLUMN_DESC+" TEXT, "+COLUMN_COST+
                " TEXT, "+COLUMN_QTY+" INTEGER );";
        sqLiteDatabase.execSQL(query);
        Log.d(LOGCAT,"create_material Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME+";");
        onCreate(sqLiteDatabase);
    }

   /* public boolean addItems(String item_name,String item_desc,String item_cost,int item_qty){

        if(item_name.length()!=0&&item_cost.length()!=0){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEM, item_name);
            values.put(COLUMN_DESC, item_desc);
            values.put(COLUMN_COST, item_cost);
            values.put(COLUMN_QTY,item_qty);
            db.insert(TABLE_NAME, null, values);
            db.close();
            Log.d(LOGCAT,"Addeed");
            return true;
        }else{
            return false;
        }
    }*/

   public boolean addItems(CreateMaterialDTO dto){

       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(COLUMN_ITEM,dto.getItem_name());
       values.put(COLUMN_DESC,dto.getItem_desc());
       values.put(COLUMN_COST,dto.getItem_cost());
       values.put(COLUMN_QTY,dto.getItem_qty());

           db.insert(TABLE_NAME, null, values);

       return true;
}

    public ArrayList<CreateMaterialDTO> getAllItems(){

        ArrayList<CreateMaterialDTO> all_Items = new ArrayList<>();
        //1.build query
        String query = "SELECT "+COLUMN_ITEM+","+COLUMN_COST+","+COLUMN_QTY+ "FROM " + TABLE_NAME ;

        //2.get rteference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        //3.build CreateMaterialDTO and add items to list
        CreateMaterialDTO dto = null;

        if(cursor.moveToFirst()){
            do{
                dto = new CreateMaterialDTO();
                dto.setItem_name(cursor.getString(1));
                dto.setItem_cost(cursor.getString(3));
                dto.setItem_qty(Integer.parseInt(cursor.getString(4)));
                /*dto.setItem_name(String.valueOf(cursor.getColumnIndex(COLUMN_ITEM)));
                dto.setItem_cost(String.valueOf(cursor.getColumnIndex(COLUMN_COST)));
                dto.setItem_qty(cursor.getColumnIndex(COLUMN_QTY));*/
               /* String name=cursor.getString(1);
                String cost = cursor.getString(3);
                String qty = cursor.getString(4);*/
            }while(cursor.moveToNext());
        }
        Log.d(LOGCAT,"getting");
        return all_Items;

    }

    public ArrayList<String> getArrayList() {

        ArrayList<String> namesList = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            String query = "SELECT "+COLUMN_ITEM+","+COLUMN_COST+","+COLUMN_QTY+ "FROM "+ TABLE_NAME;//your query here
            cursor = db.rawQuery(query,null);
            if (cursor != null && cursor.moveToFirst()) {
                namesList = new ArrayList<String>();
                do {
                    namesList.add(cursor.getString(1));
                    namesList.add(cursor.getString(3));
                    namesList.add(cursor.getString(4));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            namesList = null;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.deactivate();
                cursor.close();
                cursor = null;
            }
            close();
        }
        return namesList;
    }



}
