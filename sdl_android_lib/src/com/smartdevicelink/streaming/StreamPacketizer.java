package com.smartdevicelink.streaming;

import java.io.IOException;
import java.io.InputStream;

import com.smartdevicelink.SdlConnection.SdlConnection;
import com.smartdevicelink.protocol.ProtocolMessage;
import com.smartdevicelink.protocol.enums.SessionType;

public class StreamPacketizer extends AbstractPacketizer implements Runnable{

	public final static String TAG = "StreamPacketizer";
	private final static int BUFF_READ_SIZE = 1000000;
	
	private Thread t = null;

	public SdlConnection sdlConnection = null;

	public StreamPacketizer(IStreamListener streamListener, InputStream is, SessionType sType, byte rpcSessionID) throws IOException {
		super(streamListener, is, sType, rpcSessionID);
	}

	public void start() throws IOException {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

	public void stop() {

		if (t != null)
		{
			t.interrupt();
			t = null;
		}

	}

	public void run() {
		int length;

		try 
		{
			while (t != null && !t.isInterrupted()) 
			{
				length = is.read(buffer, 0, BUFF_READ_SIZE);
				
				if (length >= 0) 
				{
					ProtocolMessage pm = new ProtocolMessage();
					pm.setSessionID(_rpcSessionID);
					pm.setSessionType(_session);
					pm.setFunctionID(0);
					pm.setCorrID(0);
					pm.setData(buffer, length);
										
					if (t != null && !t.isInterrupted())
						_streamListener.sendStreamPacket(pm);
				}
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			 if (sdlConnection != null)
			 {
				 sdlConnection.endService(_session, _rpcSessionID);
			 }

		}
	}
}
