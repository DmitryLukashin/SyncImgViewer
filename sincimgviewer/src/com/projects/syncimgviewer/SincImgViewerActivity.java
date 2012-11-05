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
	private ConnectionProgressDialog dialog;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button buttonConnect = (Button)findViewById(R.id.btnConnect);        
        buttonConnect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
    	switch (v.getId())
    	{
    		case R.id.btnConnect:
    			//Connect();
    			ShowDialog();
    		break;
    	}
    }
    
    private void ShowDialog()
    {
    	dialog = new ConnectionProgressDialog(this);
    	dialog.show();
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
    }    
}