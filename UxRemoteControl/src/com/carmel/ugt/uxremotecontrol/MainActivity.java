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

public class MainActivity extends Activity {

	private UgtClient 		m_client;
	private UgtOpInvoker 	m_invoker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		try
		{ 
	//		m_client = new UgtClient();
	//    	String host = "";
	//    	m_invoker = m_client.Connect(host);
	
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

       // m_client.Disconnect();

	}
	
	public void OnClickScroll(View view) 
	{
		try
		{
            System.out.print("OnScrollClicked");

/*			for (int i=0; i < 10; i++)
			{
				m_invoker.Invoke(OperationId.ID.OpIdScroll, new OperationArgs(10));
				Thread.sleep(200);
			}
			
			for (int i=0;i< 10;i++)
			{
				m_invoker.Invoke(OperationId.ID.OpIdScroll, new OperationArgs(-10));
				Thread.sleep(200);
			}
 */       } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}	
}
