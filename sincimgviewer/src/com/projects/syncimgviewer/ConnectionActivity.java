package com.projects.syncimgviewer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConnectionActivity extends Activity implements android.view.View.OnClickListener 
{

	//ConnectionThread ct = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conprogressview);	
		
		
		String host = getIntent().getStringExtra("@string/host");
		int port = getIntent().getIntExtra("@string/port", 4000);
		new ConnectionThread(host, port, 5).execute();
		
		/*
		ct = new ConnectionThread(host, port, txtView);
		ct.execute(null);*/
		
	}
	
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
    	{
			case R.id.btnCancel:
				//ct.cancel(true);
				Intent i = new Intent(this,  SincImgViewerActivity.class);	
				startActivity(i);
			break;
    	}
	}
	
	
	private class ConnectionThread extends AsyncTask<Void, Void, Boolean> 
	{
		String 	host;
		int 	port;
		int 	secTimeout = 1;
		
		private Socket	socket = null;
		private String  errorMessage;
		
		
		public ConnectionThread(String _host, int _port)
		{
			ConnectivityParamsInit(_host, _port);
		}
		
		public ConnectionThread(String _host, int _port, int seconds)
		{			
			ConnectivityParamsInit(_host, _port);
			secTimeout = seconds;
		}
		
		protected Boolean doInBackground(Void...voids)
		{
			socket = new Socket();
			boolean result = true; 
			
			try
			{
				SocketAddress sa = new InetSocketAddress(host, port);
				for (int i = 0; i < secTimeout; i++)
				{
					try
					{
						socket.connect(sa,1000);
						if (isCancelled())
						{
							result = false;	
							break;
						}
						errorMessage = "";
						result = true;
					}
					catch(IOException ioe)
					{
						errorMessage = ioe.getMessage();
						result = false;
					}
				}
			}
			catch(IllegalArgumentException iae)
			{
				errorMessage = iae.getMessage();
				result = false;
			}
			
			return result;		
		}

		@Override
		protected void onPostExecute(Boolean result)
		{
			try
			{
				TextView txtOutput = (TextView)findViewById(R.id.tvOutput);
				txtOutput.setText("Failed...");
				Thread.sleep(3000);
				Intent i = new Intent(ConnectionActivity.this,  SincImgViewerActivity.class);
				startActivity(i);
				
			}
			catch(InterruptedException ie)
			{
				
			}
			
		}
		
		private void ConnectivityParamsInit(String _host, int _port)
		{
			host = _host;
			port = _port;
		}
		
	}		
}	
