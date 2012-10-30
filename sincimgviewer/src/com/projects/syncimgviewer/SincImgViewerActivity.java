package com.projects.syncimgviewer;

import android.app.Activity;
import android.content.Intent;

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

public class SincImgViewerActivity extends Activity implements android.view.View.OnClickListener
{
	
    //ConnectionThread ct = null;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button buttonConnect = (Button)findViewById(R.id.btnConnect);
        //final Button buttonCancel = (Button)findViewById(R.id.btnCancel);
        
        buttonConnect.setOnClickListener(this);
        //buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
    	switch (v.getId())
    	{
    		case R.id.btnConnect:
    			Connect();
    		break;
    			
    		/*
    		case R.id.btnCancel:
    			Cancel();
    		break;*/
    	}
    }
    
    private void Connect()
    {
    	EditText txtPort = (EditText)findViewById(R.id.txtPort);
        EditText txtIPAddress = (EditText)findViewById(R.id.txtIPAddress);
        
		String sPort = txtPort.getText().toString();
		String sIPAddress = txtIPAddress.getText().toString();
    	
		int port = Integer.parseInt(sPort);
		
		Intent i = new Intent(this,  ConnectionActivity.class);	
		i.putExtra("@string/host", sIPAddress);
		i.putExtra("@string/port", port);
		startActivity(i);
		
		//
		
    }
    
    /*
    private void Cancel()
    {
    	if (ct != null)
    	{
    		ct.cancel(true);
    	}
    }*/
        /*
        final String imgFolderName = "/sdcard/";
        final Button buttonConnect = (Button)findViewById(R.id.btnConnect);
        final Button buttonCancel = (Button)findViewById(R.id.btnCancel);*/
        
        //final ConnectionThread ct = null;
        //final File imageFile = new ImageFileGetter(imgFolderName).GetImage();
		//ShowImage(imageFile);

        /*
        buttonConnect.setOnClickListener(new View.OnClickListener() {

       
			//@Override
			public void onClick(View v) {
				
				//DataOutputStream dataOutputStream = null;
					
				/*
				try
				{*/

					
					/*Thread connectionThread = new Thread(ct);
					
					connectionThread.start();*/
					
					
					
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
        /*
			}
		});*/
    //}
    
    /*
    */
    
    /*
    private void Connect()
    {
		String sPort = txtPort.getText().toString();
		String sIPAddress = txtIPAddress.getText().toString();
    	
		int port = Integer.parseInt(sPort);
		
		setContentView(R.layout.conprogressview);

		/*
		ct = new ConnectionThread(sIPAddress, port,3);
		ct.execute(null);*/
    //}*/
    
    /*
    private void Cancel()
    {
    	if (ct != null)
    	{
    		ct.cancel(true);
    	}
    }*/
    /*
    private void ShowImage(File imageFile)
    {
    	if (imageFile == null) return;
    		
    	ImageView imgViewBox = (ImageView)findViewById(R.id.imageView);

    	String fPath = imageFile.getAbsolutePath();
		Bitmap bmp = BitmapFactory.decodeFile(fPath);
		imgViewBox.setImageBitmap(bmp);
    }*/

}