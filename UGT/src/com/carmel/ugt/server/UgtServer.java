package com.carmel.ugt.server;
import com.carmel.ugt.common.UgtOpDispatcherInterface;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
		
		try {
			
			UgtOpDispatcherInterface stub = (UgtOpDispatcherInterface) UnicastRemoteObject.exportObject(getOpDispatcher(), 0);
	
	        // Bind the remote object's stub in the registry
	        Registry registry = LocateRegistry.getRegistry();
	        registry.bind("UgtOpDispatcherInterface", stub);

		} catch (Exception e) {
	        System.err.println("Server exception: " + e.toString());
	        e.printStackTrace();
	    }
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
	        System.err.println("Server ready");		
		} catch (Exception e)
		{
			
		}

        // TODO: Clean exit from server loop. Until then, kill server process
        for (;;);
        
		// TODO: This is unreachable code because of above line
		//gUgtServer.Shutdown();
	}
	
	UgtOpDispatcher getOpDispatcher() { return mOpDispatcher; }
	
	private UgtOpDispatcher mOpDispatcher;
}
