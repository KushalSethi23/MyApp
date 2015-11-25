package com.simple.myapp;

import java.lang.reflect.Array;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

	//public final static String PATIENT_NAME = "com.simple.myapp.PATIENT_NAME";
	public final static String PATIENT_CONTACT = "com.simple.myapp.PATIENT_CONTACT";
	public final static String PATIENT_GENDER = "com.simple.myapp.PATIENT_GENDER";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Spinner spinner=(Spinner) findViewById(R.id.patGender);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        
        Spinner spinner1=(Spinner) findViewById(R.id.patCity);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void sendData(View view){
    	Intent intent=new Intent(this, PatientDetails.class);
    	
    	EditText patName = (EditText) findViewById(R.id.patientName);
    	String pname=patName.getText().toString();
    	intent.putExtra("PATIENT_NAME", pname);
    	
    	EditText patContact = (EditText) findViewById(R.id.patientContact);
    	String pcontact=patContact.getText().toString();
    	intent.putExtra("PATIENT_CONTACT", pcontact);
    	
    	Spinner patGender = (Spinner) findViewById(R.id.patGender);
    	String pgender=patGender.getSelectedItem().toString();
    	intent.putExtra("PATIENT_GENDER", pgender);
    	
    	Spinner patCity = (Spinner) findViewById(R.id.patCity);
    	String pcity=patCity.getSelectedItem().toString();
    	intent.putExtra("PATIENT_CITY", pcity);
    	
    	startActivity(intent);
    }
    
    
}
