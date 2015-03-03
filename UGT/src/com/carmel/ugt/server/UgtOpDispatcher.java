package com.carmel.ugt.server;

import com.carmel.ugt.common.OperationId;
import com.carmel.ugt.common.OperationArgs;

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
		int N=10;
		try
		{
			for (int i=0;i<N;i++)
			{
				getDefaultOpHandler().Execute(OperationId.ID.OpIdScroll, new OperationArgs(10));
				Thread.sleep(500);
			}
			for (int i=0;i<N;i++)
			{
				getDefaultOpHandler().Execute(OperationId.ID.OpIdScroll, new OperationArgs(-10));
				Thread.sleep(500);
			}
			for (int i=0;i<N;i++)
			{
				getDefaultOpHandler().Execute(OperationId.ID.OpIdZoom, new OperationArgs(110));
				Thread.sleep(500);
			}
			for (int i=0;i<N;i++)
			{
				getDefaultOpHandler().Execute(OperationId.ID.OpIdZoom, new OperationArgs(90));
				Thread.sleep(500);
			}
		} catch (Exception e)
		{
		
		}
	}
	
	void Shutdown()
	{
		// Stop all the dispatch threads, free up queues, etc.
	}
	
	UgtOpDefaultHandler getDefaultOpHandler() { return mUgtOpDefaultHandler; }
	
	private UgtOpDefaultHandler mUgtOpDefaultHandler;
}
