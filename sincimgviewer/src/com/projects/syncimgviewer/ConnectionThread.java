package com.projects.syncimgviewer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.ErrorManager;

import android.os.AsyncTask;
import android.widget.Toast;

public class ConnectionThread extends AsyncTask<Void, Void, Boolean> {

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
	
	protected void onPostExecute(Boolean result)
	{
		
	}
	
	private void ConnectivityParamsInit(String _host, int _port)
	{
		host = _host;
		port = _port;
	}
}
