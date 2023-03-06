package ev3.projects.lineFollower;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.SampleProvider;

public class UltraSonicSensor implements RangeFinder
{
	EV3UltrasonicSensor Usensor;
	SampleProvider sp;
    	float [] Usample;

    
	public UltraSonicSensor(Port port)
	{
		Usensor = new EV3UltrasonicSensor(port);
		sp = Usensor.getDistanceMode();
	    	Usample = new float[sp.sampleSize()];
	}

	
	public EV3UltrasonicSensor getSensor()
	{
		return Usensor;
	}

	public float getRange()
	{
       		sp.fetchSample(Usample, 0);

       		return Usample[0];
	}

	public float[] getRanges()
	{
       		sp.fetchSample(Usample, 0);

       		return Usample;
	}
	
	public boolean isEnabled()
	{
		return Usensor.isEnabled();
	}
	
	public void enable()
	{
		Usensor.enable();
	}
	
	public void disable()
	{
		Usensor.disable();
	}
	
	public void close()
	{
		Usensor.close();
	}
}