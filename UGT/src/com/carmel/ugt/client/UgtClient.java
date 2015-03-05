package com.carmel.ugt.client;
import com.carmel.ugt.common.UgtOpDispatcherInterface;
import com.carmel.ugt.common.OperationId;
import com.carmel.ugt.common.OperationArgs;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UgtClient {

	void Initialize()
	{
		// Initialization of RMI stuff
	}
	
	UgtOpInvoker Connect(String host) throws RemoteException, NotBoundException
	{
		// Connect to the server. Initialize the UgtOpInvoker. 
        Registry registry = LocateRegistry.getRegistry(host);
        UgtOpDispatcherInterface stub = (UgtOpDispatcherInterface) registry.lookup("UgtOpDispatcherInterface");
        UgtOpInvoker invoker = new UgtOpInvoker();
        invoker.SetDispatcher(stub);
        return invoker;
	}
	
	void Disconnect()
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
