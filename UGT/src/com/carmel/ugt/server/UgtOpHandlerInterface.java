package com.carmel.ugt.server;

import com.carmel.ugt.common.*;

public interface UgtOpHandlerInterface {
	// Initialize the handler
	void Initialize();
	
	// Execute the given operation on the application in foreground
	void Execute(OperationId opId, OperationArgs args);
	
}
