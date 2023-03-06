package ev3.projects.lineFollower;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensor {
	
	EV3ColorSensor	sensor;
	float[]		sample;
	
	public ColorSensor(Port port)
	{
		sensor = new EV3ColorSensor(port);
		setRedMode();
		setFloodLight(false);
	}
	
	public void setRedMode()
	{
		sensor.setCurrentMode("Red");
		sample = new float[sensor.sampleSize()];
	}
	public float getRed()
	{
		sensor.fetchSample(sample, 0);
		
		return sample[0];
	}
	public void setFloodLight(boolean on)
	{
		sensor.setFloodlight(on);
	}
		
	public void setFloodLight(int color)
	{
		sensor.setFloodlight(color);
	}
	public void close()
	{
		sensor.close();
	}
}
