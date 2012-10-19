package com.projects.syncimgviewer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
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
        
        final String imgFolderName = "/sdcard/";
        final Button buttonConnect = (Button)findViewById(R.id.btnConnect);
       
        final File imageFile = new ImageFileGetter(imgFolderName).GetImage();
		//ShowImage(imageFile);
		
        buttonConnect.setOnClickListener(new View.OnClickListener() {
		
        final EditText txtPort = (EditText)findViewById(R.id.txtPort);
        final EditText txtIPAddress = (EditText)findViewById(R.id.txtIPAddress);
       
			//@Override
			public void onClick(View v) {
				
				DataOutputStream dataOutputStream = null;
					
				/*
				try
				{*/
					String sPort = txtPort.getText().toString();
					String sIPAddress = txtIPAddress.getText().toString();
			    	
					int port = Integer.parseInt(sPort);
					
					ConnectionThread ct = new ConnectionThread(sIPAddress, port);
					Thread connectionThread = new Thread(ct);
					
					connectionThread.start();
					
					/*
					SocketConnector connector = new SocketConnector(sIPAddress, port, 3000);
					if (!connector.Connect())
					{
						Toast.makeText(getApplicationContext(), connector.getErrorString(), Toast.LENGTH_LONG).show();
						return;
					}*/
					
					/*
					//1. Launch a thread for transfering image
					int fileSize = (int)imageFile.length();
					
					byte[] byteArray = new byte[fileSize];
					
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imageFile));
					bis.read(byteArray);
					
					dataOutputStream = new DataOutputStream(connector.getSocket().getOutputStream());
					
					dataOutputStream.writeInt(fileSize);
					
					dataOutputStream.flush();
					
					for (int i = 0; i < fileSize; i++)
					{
						int offset = i;
						dataOutputStream.write(byteArray, offset, 1);
						dataOutputStream.flush();
					}*/
					/*
				}
				catch(IOException e)
				{					
					e.printStackTrace();
				}*/
			}
		});
    }
    
    private void ShowImage(File imageFile)
    {
    	if (imageFile == null) return;
    		
    	ImageView imgViewBox = (ImageView)findViewById(R.id.imageView);

    	String fPath = imageFile.getAbsolutePath();
		Bitmap bmp = BitmapFactory.decodeFile(fPath);
		imgViewBox.setImageBitmap(bmp);
    }

}