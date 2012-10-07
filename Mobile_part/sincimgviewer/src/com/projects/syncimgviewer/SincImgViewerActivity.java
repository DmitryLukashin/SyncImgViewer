package com.projects.syncimgviewer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import java.io.IOException;
import java.net.*;

public class SincImgViewerActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button buttonConnect = (Button)findViewById(R.id.btnConnect);
        buttonConnect.setOnClickListener(new View.OnClickListener() {
		
        final EditText txtPort = (EditText)findViewById(R.id.txtPort);
        final EditText txtIPAddress = (EditText)findViewById(R.id.txtIPAddress);
        
        
			@Override
			public void onClick(View v) {

				try
				{
					String sPort = txtPort.getText().toString();
					String sIPAddress = txtIPAddress.getText().toString();
			    	
					int port = Integer.parseInt(sPort);
									
					Socket socket = new Socket();
					SocketAddress socketAddress = new InetSocketAddress(sIPAddress, port);
					socket.connect(socketAddress);
					socket.sendUrgentData(9);			//What this method exactly does?
				}
				catch(IOException e)
				{
					int n = 0;
					n = n + 9;
				}
			}
		});
    }
    
}