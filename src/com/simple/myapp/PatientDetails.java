package com.simple.myapp;



import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PatientDetails extends ActionBarActivity {

	String name, contact, gender, city;
	Patient patient;
	DBHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_details);
		
		Intent intent=getIntent();

		name = intent.getStringExtra("PATIENT_NAME");
		TextView tvName=(TextView)findViewById(R.id.tvName);
		tvName.append(": "+name);
		tvName.setTextSize(20);
		
		contact = intent.getStringExtra("PATIENT_CONTACT");
		TextView tvCont=(TextView)findViewById(R.id.tvCont);
		tvCont.append(": "+contact);
		tvCont.setTextSize(20);
		
		gender = intent.getStringExtra("PATIENT_GENDER");
		TextView tvGender=(TextView)findViewById(R.id.tvGender);
		tvGender.append(": "+gender);
		tvGender.setTextSize(20);
		
		city=intent.getStringExtra("PATIENT_CITY");
		TextView tvCity=(TextView)findViewById(R.id.tvCity);
		tvCity.append(": "+city);
		tvCity.setTextSize(20);
			
		
		Log.d("In  details","patient details.....");

	}
	
	public void saveToDB(View view){
		patient=new Patient(name, contact, gender, city);
		db=new DBHelper(this);
	
		Log.d("Before","The hdk");
		db.insertPatient(patient);
		Log.d("After","The patient");
	
		
		Log.d("ShowAllPatients", "In the show all patients...");
		
		List<Patient> pat=db.showAllPatient();
		Log.d("Inside show", "Will start showing");
		for(Patient p: pat){
			String log="Name: "+p.getName()+ " Contact: "+p.getPhone()+" Gender: "+p.getGender()+" City: "+p.getCity();
			Log.d("Record: ",log);
		}
		
		
		Intent intentShow=new Intent(this, ShowPatientDetails.class);
		intentShow.putExtra("MESSAGE", "Showing all patients");
		startActivity(intentShow);
	}
	
	public void deletePatient(View view){
		Log.d("In","deletePatient");
		Intent inte=new Intent(this, DeletePatient.class);
		inte.putExtra("DELETE", "Please enter the id of the patient to delete:");
		startActivity(inte);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
