package com.simple.myapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	//Database Name changed
	public static final String DATABASE_NAME="PatientDatabase";
	//Table Name
	public static final String TABLE_NAME="Patients";
	//Column Names
	public static final String Patient_Column_ID="id";
	public static final String Patient_Column_Name="name";
	public static final String Patient_column_Phone="phone";
	public static final String Patient_column_Gender="gender";
	public static final String Patient_column_City="city";
	
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME+ " (id integer primary key autoincrement, name varchar, phone varchar, gender varchar, city varchar)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 db.execSQL("DROP TABLE IF EXISTS Patients");
		 onCreate(db);
	}
	
	public void insertPatient(Patient p){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(Patient_Column_Name, p.getName());
		values.put(Patient_column_Phone, p.getPhone());
		values.put(Patient_column_Gender, p.getGender());
		values.put(Patient_column_City, p.getCity());
		
		//inserting row into database
		db.insert(TABLE_NAME, null, values);
		db.close();
		Log.d("Records:","inserted");
	}
	
	public List<Patient> showAllPatient(){
		Log.d("In DBHelper", "Showing process");
		List<Patient> patientList=new ArrayList<Patient>();
		String selectQuery="select * from Patients";
		SQLiteDatabase db = this.getWritableDatabase();
        Cursor rs = db.rawQuery(selectQuery, null);
        if(rs.moveToFirst()){
        	do{
	        	Patient p=new Patient();
	        	p.setName(rs.getString(1));
	        	p.setPhone(rs.getString(2));
	        	p.setGender(rs.getString(3));
	        	p.setCity(rs.getString(4));
	        	
	        	patientList.add(p);
        	}while(rs.moveToNext());
        }	
		return patientList;
	}
	
	public void showPatientDetails(){
		Log.d("In DBHelper", "Showing another Process for patient");
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery("Select * from Patients", null);
		if(cursor.moveToFirst()){
			do{
				String PatientDetail="";
				PatientDetail+="Name: "+cursor.getString(1)+" Phone: "+cursor.getString(2)+" Gender: "+cursor.getString(3)+" City: "+cursor.getString(4);
				Log.d("Record: ", PatientDetail);
			}while(cursor.moveToNext());
		}
	}

	public boolean deletePatientEntry(String  patient_id) {
		// TODO Auto-generated method stub
		try{
			SQLiteDatabase db = this.getWritableDatabase();
			db.delete(TABLE_NAME, "id=?", new String[]{patient_id});
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
