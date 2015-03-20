package com.carmel.ugt.uxremotecontrol;


import com.carmel.ugt.client.UgtClient;
import com.carmel.ugt.client.UgtOpInvoker;
import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.OperationId;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;

public class MainActivity extends Activity {

	private UgtClient 		m_client;
	private UgtOpInvoker 	m_invoker;
	
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

		} catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}	
}
