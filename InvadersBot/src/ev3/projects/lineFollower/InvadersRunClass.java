package ev3.projects.lineFollower;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.Color;
import lejos.utility.Delay;


public class InvadersRunClass {
	
	static UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	static UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	static ColorSensor color = new ColorSensor(SensorPort.S2);
	
	
	public static void main(String[] args) {
		float range;			
		float colorValue;
		UltraSonicSensor uss = new UltraSonicSensor(SensorPort.S1);
        

		System.out.println("Hello World, I am Natural Invaders robot");

		color.setRedMode();
		color.setFloodLight(Color.RED);
		color.setFloodLight(true);

		Button.LEDPattern(4); 
		Sound.beepSequenceUp();

		
		System.out.println("Press any key to start");

		Button.waitForAnyPress();
		
		range = uss.getRange();
		
		motorA.setPower(30);
		motorB.setPower(30);

		
		while (Button.ESCAPE.isUp()) {
			colorValue = color.getRed();
			range = uss.getRange();
			Lcd.clear(7);
			Lcd.print(7, "value=%.3f", colorValue);
			
			
			if (colorValue > .100 && colorValue < .130 && range > 0.10) {
				motorA.setPower(30);
				motorB.setPower(10);
			} 
			
			else if (colorValue > .130 && range > 0.10){
				motorA.setPower(60);
				motorB.setPower(10);
			}
						
			else if (range > 0.10){
				motorA.setPower(10);
				motorB.setPower(30);
			}
			else if (range < 0.10){
				motorA.setPower(0);
				motorB.setPower(0);
				Delay.msDelay(2000);
				motorA.setPower(-30);
				motorB.setPower(-30);
				Delay.msDelay(1000);
				motorA.setPower(0);
				motorB.setPower(0);
				
			}
			
		}

		motorA.stop();
		motorB.stop();

		motorA.close();
		motorB.close();
		color.close();
		uss.close();
		
		Sound.beepSequence();
	}
}