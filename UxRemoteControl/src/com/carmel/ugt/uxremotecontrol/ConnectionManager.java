package com.carmel.ugt.uxremotecontrol;

import java.io.Serializable;

import com.carmel.ugt.client.UgtClient;
import com.carmel.ugt.client.UgtOpInvoker;
import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.OperationId;

public class ConnectionManager {
	private static ConnectionManager m_instance;
	private UgtClient 		m_client;
	private UgtOpInvoker 	m_invoker;

	private String 			m_lastErrorMsg;
	
	static public ConnectionManager getInstance()
	{
		if (m_instance == null)
			m_instance = new ConnectionManager();
		
		return m_instance;
	}

	public boolean Connect(String host, String userName, String pwd)
	{
		if (m_client == null)
		{
			m_client = new UgtClient();
	
			m_client.Initialize();

		}
		
    	m_invoker = m_client.Connect(host);

    	if (m_invoker == null)
    		return false;
    	
		return true;
	}
	
	public boolean SendCommand(OperationId.ID id, OperationArgs opArgs)
	{
		m_lastErrorMsg = "";

		if (m_invoker == null)
		{
			m_lastErrorMsg = "Invalid connection";
			return false;
		}
		
		if (!m_invoker.Invoke(id, opArgs))
		{
			m_lastErrorMsg = m_invoker.GetLastErrorMsg();
			return false;
		}
		
		return true;
	}
	
	public String GetLastErrorMessage()
	{
		return m_lastErrorMsg;
	}
}
