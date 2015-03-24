package com.carmel.ugt.server;

import com.carmel.ugt.common.OperationId;
import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.UgtOpDispatcherInterface;

public class UgtOpDispatcher implements UgtOpDispatcherInterface {
	// Need to add the following data members:
	// RMI Stuff
	// Operations Dispatch Table

	void Initialize()
	{
		// Initialize RMI stuff
		mUgtOpDefaultHandler = new UgtOpDefaultHandler();
		mUgtOpDefaultHandler.Initialize();
	}
	
	void Start()
	{
		// Start dispatch threads, initialize queues, etc.
	
	}
	
	public void Dispatch(OperationId.ID opId, OperationArgs args)
	{
		// Dispatch the given operation to the corresponding UgtOpHandler
		System.out.println("Dispatching " + opId.toString() + " " + args.toString() + "...");
		getDefaultOpHandler().Execute(opId, args);
	}
	
	void Shutdown()
	{
		// Stop all the dispatch threads, free up queues, etc.
	}
	
	UgtOpDefaultHandler getDefaultOpHandler() { return mUgtOpDefaultHandler; }
	
	private UgtOpDefaultHandler mUgtOpDefaultHandler;
}
