package com.carmel.ugt.client;

import com.sun.jersey.api.client.WebResource;

import com.carmel.ugt.common.*;

public class UgtOpInvoker {
	private WebResource mWebService;

	private String mLastErrorMsg;
	public UgtOpInvoker(WebResource webService)
	{
		mWebService = webService;
	}

	public boolean Invoke(OperationId.ID opId, OperationArgs opArgs)
	{
		boolean result = true;
		mLastErrorMsg = "";
		System.out.println("Calling server dispatcher for " + opId.toString() + " " + opArgs.toString() + " ...");
		try {
			mWebService.path("UGT/op/" + opId + "/" + opArgs.GetOpArgs() + "/").method("GET");
		} catch (Exception e) {
			result = false;
			System.err.println("Error invoking remote dispatcher: " + e.toString());
			mLastErrorMsg = e.toString();
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String GetLastErrorMsg()
	{
		return mLastErrorMsg;
	}
}
