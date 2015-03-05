package com.carmel.ugt.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UgtOpDispatcherInterface extends Remote {

	// Dispatch the given operation to the corresponding UgtOpHandler
	void Dispatch(OperationId.ID opId, OperationArgs args) throws RemoteException;
	
}
