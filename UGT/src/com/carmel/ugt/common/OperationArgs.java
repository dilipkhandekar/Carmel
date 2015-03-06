package com.carmel.ugt.common;

import java.io.Serializable;

public class OperationArgs implements Serializable {
	// TODO: This is probably not the right way to implement args
	public OperationArgs(int arg) { opArgs = arg; }
	
	public int GetOpArgs() { return opArgs; }
	
	static final long serialVersionUID = 1001L;
	private int opArgs;
}
