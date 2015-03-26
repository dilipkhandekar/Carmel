package com.carmel.ugt.uxremotecontrol;

import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.OperationId;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AppView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_view);
	}
	
	public void OnClickScroll(View view)
	{

		ConnectionManager cm = ConnectionManager.getInstance();
		
		boolean result = cm.SendCommand(OperationId.ID.OpIdScroll, new OperationArgs(10));

		EditText sStatus =  (EditText) findViewById(R.id.status);
		
		String statusMsg = result ? "success" : cm.GetLastErrorMessage();
		
		sStatus.setText(statusMsg);
	}
	
}
