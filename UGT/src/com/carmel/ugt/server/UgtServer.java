package com.carmel.ugt.server;

import java.io.IOException;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

public class UgtServer { 

	void Initialize()
	{
		// Initialization of RMI stuff
		if (gOpDispatcher == null)
		{
			gOpDispatcher = new UgtOpDispatcher();
			gOpDispatcher.Initialize();
		}
		
		ResourceConfig rc = new DefaultResourceConfig(UgtRESTServer.class);
		try {
			mWebServer = HttpServerFactory.create(BASE_URI,rc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void Start()
	{
		// Start the OpDispatcher
		getOpDispatcher().Start();
		
		try {
			if (mWebServer != null)
				mWebServer.start(); 
            
		} catch (Exception e) {
	        System.err.println("Server exception: " + e.toString());
	        e.printStackTrace();
	    }
	}
	
	void Shutdown()
	{
		// Shut down the dispatcher
		getOpDispatcher().Shutdown();
		if (mWebServer != null)
			mWebServer.stop(0);
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Universal Gesture Translator Server v0.1.0");
		
		UgtServer gUgtServer = new UgtServer();
		
		gUgtServer.Initialize();
		
		try {
			Thread.sleep(3*1000);
			gUgtServer.Start();
	        System.out.println("Server ready");
	        
			System.out.println("Press ENTER to stop the server.");
			System.in.read();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Shutting down the server.");
		gUgtServer.Shutdown();
	}
	
	public static UgtOpDispatcher getOpDispatcher() { return gOpDispatcher; }
	
	private static UgtOpDispatcher gOpDispatcher = null;
	private HttpServer mWebServer;
	static final String BASE_URI = "http://localhost:8080/"; // TODO: Get port number from command line
}
