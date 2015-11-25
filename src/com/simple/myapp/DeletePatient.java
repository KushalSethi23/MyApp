package com.simple.myapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DeletePatient extends ActionBarActivity {

	String patient_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete_patient);
		Intent intent=getIntent();
		String delete_msg=intent.getStringExtra("DELETE");
		TextView tvDelete=(TextView) findViewById(R.id.textViewD);
		tvDelete.setText(delete_msg);
		tvDelete.setTextSize(25);
		Log.d("IN Delete","Patient activity");

		EditText tvPatientID=(EditText) findViewById(R.id.patid);
		patient_id=tvPatientID.getText().toString();
	}

	public void deletePatient(View view){
		DBHelper db=new DBHelper(this);
		if(db.deletePatientEntry(patient_id)){
			Log.d("Deleted","Record deleted");
		}
		else{
			Log.d("Error","Not deleted");
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete_patient, menu);
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
