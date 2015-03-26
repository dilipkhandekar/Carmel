package com.carmel.ugt.uxremotecontrol;


import com.carmel.ugt.client.UgtClient;
import com.carmel.ugt.client.UgtOpInvoker;
import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.OperationId;
import com.carmel.ugt.uxremotecontrol.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends Activity {

	private UgtClient 		m_client;
	private UgtOpInvoker 	m_invoker;
	
	public UgtOpInvoker getInvoker()
	{
		return this.m_invoker;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
	}

	public void OnClickConnectButton(View view) 
	{
		try
		{
            System.out.println("Connect Button Clicked");
            EditText sEdit = (EditText) findViewById(R.id.serverIpAddress);
            EditText uEdit = (EditText) findViewById(R.id.username);
            EditText pEdit = (EditText) findViewById(R.id.password);
            System.out.println("IP Address = " + sEdit.getText());
            System.out.println("Username = " + uEdit.getText());
            System.out.println("Password = " + pEdit.getText());

            ConnectionManager instance = ConnectionManager.getInstance();
            
            boolean result = instance.Connect(sEdit.getText().toString(), "", "");
    		//m_client = new UgtClient();

    		//m_client.Initialize();

    		//String serverIp = sEdit.getText().toString();
    		
	    	//m_invoker = m_client.Connect(serverIp);
    	
            Intent appViewI = new Intent(this, AppView.class);

            startActivity(appViewI);

		} catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}	
}
