package com.example.fin;

import android.R.integer;
import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Context;
public class MainActivity extends Activity {

int i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent  = new Intent();
		intent.setClass(this, MyIntentService.class);
		startService(intent);
		Log.e("wxp", "startService");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public  class MyIntentService extends IntentService {
		
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		public MyIntentService() {
			super("MyIntentService");

		}


		@Override
		protected void onHandleIntent(Intent intent) {
			Log.e("wxp", "onHandleIntent");
			
		}
	}
	
	class MyService extends Service{

		@Override
		public void onCreate() {
			// TODO Auto-generated method stub
			super.onCreate();
			Log.e("wxp", "onCreate");
		}
		@Override
		@Deprecated
		public void onStart(Intent intent, int startId) {
			// TODO Auto-generated method stub
			super.onStart(intent, startId);
			Log.e("wxp", "onStart");
		}
		
		@Override
		public IBinder onBind(Intent intent) {
			// TODO Auto-generated method stub
			return null;
		}
		
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
