package com.carmel.ugt.server;

import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.OperationId;

public class UgtOpDefaultHandler implements UgtOpHandlerInterface {
	// Initialize the handler
	public void Initialize() 
	{
		
	}
	
	// Execute the given operation on the application in foreground
	public void Execute(OperationId opId, OperationArgs args)
	{
		// Temporary
		if (opId == null)
		{
			System.out.println("Execute called");
		}
		
	}

}
