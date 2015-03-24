package com.carmel.ugt.client;

import com.sun.jersey.api.client.WebResource;

import com.carmel.ugt.common.*;

public class UgtOpInvoker {
	private WebResource mWebService;

	public UgtOpInvoker(WebResource webService)
	{
		mWebService = webService;
	}

	public void Invoke(OperationId.ID opId, OperationArgs opArgs)
	{
		System.out.println("Calling server dispatcher for " + opId.toString() + " " + opArgs.toString() + " ...");
		try {
			mWebService.path("UGT/op/" + opId + "/" + opArgs.GetOpArgs() + "/").method("GET");
		} catch (Exception e) {
			System.err.println("Error invoking remote dispatcher: " + e.toString());
			e.printStackTrace();
		}
	}
}
