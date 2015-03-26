package com.carmel.ugt.client;

import com.carmel.ugt.common.OperationId;
import com.carmel.ugt.common.OperationArgs;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UgtClient {

	public void Initialize()
	{
		// Initialization of RMI stuff
	}
	
	public UgtOpInvoker Connect(String host)
	{
		// Connect to the server. Initialize the UgtOpInvoker. 
		if ((host == null) || (host == ""))
			host = "localhost";
		
		ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource("http://" + host + ":8080"); // TODO: Parameterize the port number
        UgtOpInvoker invoker = new UgtOpInvoker(service);
        return invoker;
	}
	
	public void Disconnect()
	{
		// Disconnect from the server
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Universal Gesture Translator Client v0.1.0");
		
		UgtClient client = new UgtClient();
		client.Initialize();

		try
		{  	
	    	String host = (args.length < 1) ? null : args[0];
	    	UgtOpInvoker invoker = client.Connect(host);
	
	        // Sample calls 
			int N=10;

			for (int i=0;i<N;i++)
			{
				invoker.Invoke(OperationId.ID.OpIdScroll, new OperationArgs(10));
				Thread.sleep(500);
			}
			for (int i=0;i<N;i++)
			{
				invoker.Invoke(OperationId.ID.OpIdScroll, new OperationArgs(-10));
				Thread.sleep(500);
			}
			for (int i=0;i<N;i++)
			{
				invoker.Invoke(OperationId.ID.OpIdZoom, new OperationArgs(110));
				Thread.sleep(500);
			}
			for (int i=0;i<N;i++)
			{
				invoker.Invoke(OperationId.ID.OpIdZoom, new OperationArgs(90));
				Thread.sleep(500);
			}

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

        client.Disconnect();
	}

}
