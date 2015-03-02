package com.carmel.ugt.server;

public class UgtServer {

	void Initialize()
	{
		// Initialization of RMI stuff
	}
	
	void Start()
	{
		// Start the OpDispatcher
	}
	
	void Shutdown()
	{
		// Shut down the dispatcher
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Universal Gesture Translator Server v0.1.0");
		
		UgtServer gUgtServer = new UgtServer();
		
		gUgtServer.Initialize();
		
		gUgtServer.Start();
		
		gUgtServer.Shutdown();
	}
	

}
