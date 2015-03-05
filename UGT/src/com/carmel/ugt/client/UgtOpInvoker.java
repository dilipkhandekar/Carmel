package com.carmel.ugt.client;

import java.rmi.RemoteException;

import com.carmel.ugt.common.*;

public class UgtOpInvoker {
	// Need to add RMI related data members
	private UgtOpDispatcherInterface dispatcher;
	
	void SetDispatcher(UgtOpDispatcherInterface stub)
	{
		dispatcher = stub;
	}

	void Invoke(OperationId.ID opId, OperationArgs opArgs)
	{
		System.out.println("Calling server dispatcher for " + opId.toString() + " " + opArgs.toString() + " ...");
		try {
			dispatcher.Dispatch(opId, opArgs);
		} catch (RemoteException e) {
			System.err.println("Error invoking remote dispatcher: " + e.toString());
			e.printStackTrace();
		}
	}
}
