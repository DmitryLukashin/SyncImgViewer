package com.projects.syncimgviewer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

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

			//@Override
			public void onClick(View v) {
				
				DataOutputStream dataOutputStream = null;
				
				try
				{
					String sPort = txtPort.getText().toString();
					String sIPAddress = txtIPAddress.getText().toString();
			    	
					int port = Integer.parseInt(sPort);
					
					File imageFile = new File("/sdcard/IMG_0062.JPG");
					int fileSize = (int)imageFile.length();
					
					byte[] byteArray = new byte[fileSize];
					
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imageFile));
					bis.read(byteArray);
					
					Socket socket = new Socket(sIPAddress, port);
					dataOutputStream = new DataOutputStream(socket.getOutputStream());
					
					dataOutputStream.writeInt(fileSize);
					
					//dataOutputStream.write(byteArray);
					
					dataOutputStream.flush();
					//dataOutputStream.write()
					//writeUTF("Hello from Android...");
					
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