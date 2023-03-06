package ev3.projects.lineFollower;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.Font;
import lejos.hardware.lcd.TextLCD;;

public class Lcd
{
    private static Brick		brick = BrickFinder.getLocal();
    private static TextLCD		lcd = brick.getTextLCD(Font.getFont(0, 0, Font.SIZE_MEDIUM));
    

    public static final int MAXCHARS = lcd.getTextWidth();
    public static final int MAXLINES = lcd.getTextHeight();
    
	
	private Lcd()
	{
		
	}

	
	public static TextLCD getTextLCD()
	{
		return lcd;
	}
	
	
	public static void clear()
	{
		lcd.clear();
		lcd.refresh();
	}
	
	
	public static void scroll()
	{
		lcd.scroll();
	}
	
	
	public static void clear(int line)
	{
		lcd.clear(line - 1);
		lcd.refresh();
	}
	
	
	public static void clear(int line, int col, int len)
	{
		lcd.clear(col - 1, line - 1, len);
		lcd.refresh();
	}
	
	
	public static void print(int line, String message)
	{
		lcd.drawString(message, 0, line - 1);
		lcd.refresh();
	}
	
	
	public static void print(int line, String message, Object... parms)
	{
		lcd.drawString(String.format(message, parms), 0, line - 1);
		lcd.refresh();
	}
	
	
	public static void print(int line, int col, String message)
	{
		lcd.drawString(message, col - 1, line - 1);
		lcd.refresh();
	}
	
	
	public static void print(int line, int col, String message, Object... parms)
	{
		lcd.drawString(String.format(message, parms), col - 1, line - 1);
		lcd.refresh();
	}
}