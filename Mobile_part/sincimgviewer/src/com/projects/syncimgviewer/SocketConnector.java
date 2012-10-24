package com.projects.syncimgviewer;

import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.util.Calendar;


import android.widget.Toast;

public class SocketConnector {
	
	private String 	host;
	private int 	port;
	private int 	timeout;
	
	private Socket	socket = null;
	private String  errorMessage;
	
	public SocketConnector(String _host, int _port)
	{
		host = _host;
		port = _port;
		timeout = 1000;
	}
	
	public SocketConnector(String _host, int _port, int _timeout)
	{
		host = _host;
		port = _port;
		timeout = _timeout;
	}
	
	public boolean Connect()
	{
		socket = new Socket();
		boolean result = true; 
		
		try
		{
			SocketAddress sa = new InetSocketAddress(host, port);
			for (int i = 0; i < 3; i++)
			{
				try
				{
					socket.connect(sa,1000);
					result = true;
				}
				catch(IOException ioe)
				{
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
	
	public Socket getSocket()
	{
		return socket;
	}
	
	public String getErrorString()
	{
		return errorMessage;
	}
}
