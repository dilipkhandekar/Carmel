package com.carmel.ugt.server;

public class UgtServer {

	void Initialize()
	{
		// Initialization of RMI stuff
		mOpDispatcher = new UgtOpDispatcher();
		mOpDispatcher.Initialize();
	}
	
	void Start()
	{
		// Start the OpDispatcher
		getOpDispatcher().Start();
	}
	
	void Shutdown()
	{
		// Shut down the dispatcher
		getOpDispatcher().Shutdown();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Universal Gesture Translator Server v0.1.0");
		
		UgtServer gUgtServer = new UgtServer();
		
		gUgtServer.Initialize();
		
		try {
			Thread.sleep(3*1000);
			gUgtServer.Start();
		} catch (Exception e)
		{
			
		}
		gUgtServer.Shutdown();
	}
	
	UgtOpDispatcher getOpDispatcher() { return mOpDispatcher; }
	
	private UgtOpDispatcher mOpDispatcher;
}
