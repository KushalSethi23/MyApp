package com.simple.myapp;


import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowPatientDetails extends ActionBarActivity {

	//Patient patient;
	DBHelper db1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_patient_details);
		
		Intent intentShow=getIntent();
		
		Log.d("ShowAllPatients", "In the show all patients...");
		db1=new DBHelper(this);
		db1.showPatientDetails();
		Log.d("Inside show", "Will start showing");
		
		String msg = intentShow.getStringExtra("MESSAGE");
		TextView tvMessage=(TextView)findViewById(R.id.tvMessage);
		tvMessage.setText(msg);
		tvMessage.setTextSize(20);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_patient_details, menu);
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
