package com.projects.syncimgviewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ConnectionActivity extends Activity implements android.view.View.OnClickListener 
{

	ConnectionThread ct = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conprogressview);	
		
		String host = getIntent().getStringExtra("@string/host");
		int port = getIntent().getIntExtra("@string/port", 4000);
		
		ct = new ConnectionThread(host, port);
		ct.execute(null);
	}
	
	@Override
	public void onClick(View v)
	{
		switch (v.getId())
    	{
			case R.id.btnCancel:
				ct.cancel(true);
			break;
    	}
	}
}
