package com.carmel.ugt.server;

import java.awt.*;
import java.awt.event.*;

import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.OperationId;

public class UgtOpDefaultHandler implements UgtOpHandlerInterface {
	// Initialize the handler
	public void Initialize() 
	{
		
	}
	
	// Execute the given operation on the application in foreground
	public void Execute(OperationId.ID opId, OperationArgs args)
	{
		switch (opId)
		{
		case OpIdZoom:
			try
			{
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				
				int percent = args.GetOpArgs();
				int wheelNotches = (100 - percent)/10;
				robot.mouseWheel(wheelNotches);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				
			}
			catch (AWTException awtException)
			{
			
			}
			break;
		case OpIdScroll:
			try
			{
				Robot robot = new Robot();
				
				int pixels = args.GetOpArgs();
				int wheelNotches = pixels/10;
				robot.mouseWheel(wheelNotches);
				
			}
			catch (AWTException awtException)
			{
			
			}
			break;
		default:
			break;
		}
	}
}
