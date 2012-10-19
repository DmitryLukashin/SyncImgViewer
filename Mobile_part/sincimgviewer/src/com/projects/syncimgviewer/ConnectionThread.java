package com.projects.syncimgviewer;

import android.widget.Toast;

public class ConnectionThread implements Runnable {

	String 	host;
	int 	port;
	
	public ConnectionThread(String _host, int _port)
	{
		host = _host;
		port = _port;
	}
	
	public void run()
	{
		SocketConnector connector = new SocketConnector(host, port, 3000);
		
		if (!connector.Connect())
		{
			//Toast.makeText(getApplicationContext(), connector.getErrorString(), Toast.LENGTH_LONG).show();
			return;
		}
	}
}
