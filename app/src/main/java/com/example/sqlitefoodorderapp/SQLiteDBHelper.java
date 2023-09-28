package com.example.sqlitefoodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.sqlitefoodorderapp.Model.CartModel;

import java.util.ArrayList;

public class SQLiteDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "foodDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "order_foods";

    private static final String FOODS_ID = "id";
    private static final String FOODS_NAME = "food_name";
    private static final String FOODS_PRICE = "food_price";
    private static final String FOODS_DESCRIPTION = "food_des";
    private static final String FOODS_IMG = "food_img";
    private static final String FOOD_QUANTITY = "food_quantity";

    private static final String USER_NAME = "user_name";
    private static final String USER_PHONE_NO = "user_phone_no";


    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME
                        + "(" + FOODS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + USER_NAME + " TEXT, "
                        + USER_PHONE_NO + " TEXT, "
                        + FOODS_NAME + " TEXT, "
                        + FOODS_PRICE + " INTEGER, "
                        + FOODS_IMG + " INTEGER, "
                        + FOODS_DESCRIPTION + " TEXT, "
                        + FOOD_QUANTITY + " INTEGER);"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData( String orderuserName, String orderuserPhoneNo,String foodName,int foodPrice,  int foodImg,int foodQuantity, String foodDes,  Context context) {
        /*
        * id 0
        * name 1
        * phone 2
        * foodName 3
        * price 4
        * img 5
        * des 6
        * qty 7*/
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, orderuserName);
        values.put(USER_PHONE_NO, orderuserPhoneNo);
        values.put(FOODS_NAME, foodName);
        values.put(FOODS_PRICE, foodPrice);
        values.put(FOODS_IMG, foodImg);
        values.put(FOOD_QUANTITY, foodQuantity);
        values.put(FOODS_DESCRIPTION, foodDes);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully! ", Toast.LENGTH_SHORT).show();

         }
    }


    public ArrayList<CartModel> getOrders() {
        ArrayList<CartModel> orders = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT "
                +FOODS_ID+","
                +FOODS_NAME+","
                +FOODS_IMG+","
                +FOODS_PRICE+" FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                CartModel cartModel = new CartModel();
                cartModel.setOrderNumber(cursor.getInt(0) + "");
                cartModel.setOrderFoodName(cursor.getString(1));
                cartModel.setOrderImg(cursor.getInt(2));
                cartModel.setOrderPrice(cursor.getInt(3)+"");
                orders.add(cartModel);
            }
        }
        cursor.close();
        db.close();
        return  orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+FOODS_ID+"= "+id,null);
        if(cursor!=null)
            cursor.moveToFirst();
        return cursor;
    }
    public void updateData( String orderuserName, String orderuserPhoneNo,String foodName,int foodPrice,  int foodImg,int foodQuantity, String foodDes,  Context context,int id) {
        /*
         * id 0
         * name 1
         * phone 2
         * foodName 3
         * price 4
         * img 5
         * des 6
         * qty 7*/
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, orderuserName);
        values.put(USER_PHONE_NO, orderuserPhoneNo);
        values.put(FOODS_NAME, foodName);
        values.put(FOODS_PRICE, foodPrice);
        values.put(FOODS_IMG, foodImg);
        values.put(FOOD_QUANTITY, foodQuantity);
        values.put(FOODS_DESCRIPTION, foodDes);
        long result = db.update(TABLE_NAME,  values,"id="+id,null);
        if (result == -1) {
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully! ", Toast.LENGTH_SHORT).show();
        }
    }

    public int deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME," id="+id,null);
    }
}
