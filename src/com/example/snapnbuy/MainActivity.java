package com.example.snapnbuy;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	private Button scanBtn;
	private TextView formatTxt, contentTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		scanBtn = (Button)findViewById(R.id.scan_button);
		formatTxt = (TextView)findViewById(R.id.scan_format);
		contentTxt = (TextView)findViewById(R.id.scan_content);
		scanBtn.setOnClickListener(this);
		
	}
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		//retrieve scan result
		/*IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanningResult != null) {
			//we have a result
			String scanContent = scanningResult.getContents();
			String scanFormat = scanningResult.getFormatName();
			formatTxt.setText("FORMAT: " + scanFormat);
			contentTxt.setText("CONTENT: " + scanContent);
			}
		else{
		    Toast toast = Toast.makeText(getApplicationContext(), 
		        "No scan data received!", Toast.LENGTH_SHORT);
		    toast.show();
		}*/
		if(resultCode == RESULT_OK)   
		{  String contents = intent.getStringExtra("SCAN_RESULT"); 
		   String format = intent.getStringExtra("SCAN_RESULT_FORMAT"); 
			formatTxt.setText("FORMAT: " + format);
			contentTxt.setText("CONTENT: " + contents);
		   //Log.i("xZing", "contents: "+contents+" format: "+format); 
        }         
		   else if(resultCode == RESULT_CANCELED)     
		   {              // Handle cancel             Log.i("xZing", "Cancelled");       
			   
		   }     
	}
	
	public void onClick(View v){
		//respond to clicks
		//if(v.getId()==R.id.scan_button){
			//scan
		/*	IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan(); */

			//}
		Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
		intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE"); 
		startActivityForResult(intent, 0);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
