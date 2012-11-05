package com.projects.syncimgviewer;

import android.app.*;
import android.app.Dialog;
import android.view.View;

public class ConnectionProgressDialog implements android.view.View.OnClickListener {

	private Dialog dialog;
	
	public ConnectionProgressDialog(Activity activity)
	{
		dialog = new Dialog(activity);
		dialog.setTitle("Custom dialog title");
        dialog.setContentView(R.layout.connectionprogressdialog);		

        /*
		dialogEditBox = (EditText) dialog.findViewById( R.id.dialog_edit_box );
		dialogInfo = (TextView) dialog.findViewById( R.id.dialog_info );
		dialogButton = (Button) dialog.findViewById( R.id.dialog_button );
		dialogButton.setOnClickListener( this );*/
	}
	
	public void show()
	{
		dialog.setTitle("Connecting...");
		
		dialog.show();
	}
	
	@Override
	public void onClick(View v){
		
	}
	
}
