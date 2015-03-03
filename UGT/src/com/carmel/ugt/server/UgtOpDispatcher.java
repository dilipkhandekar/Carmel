package com.carmel.ugt.server;

public class UgtOpDispatcher {
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
	
		// This is temporary, until we have the dispatch framework in place
		getDefaultOpHandler().Execute(null, null);
	}
	
	void Shutdown()
	{
		// Stop all the dispatch threads, free up queues, etc.
	}
	
	UgtOpDefaultHandler getDefaultOpHandler() { return mUgtOpDefaultHandler; }
	
	private UgtOpDefaultHandler mUgtOpDefaultHandler;
}
