package recursion;

import java.applet.*;
import java.awt.*;
import java.util.*;

public class RandomFractal extends Applet {
	private Image display;
	private Graphics drawingArea;
	
	public void init(){//initialization, can be considered like a constructor
		int height = getSize().height;
		int width = getSize().width;
		
		display = createImage(width, height);
		
		drawingArea = display.getGraphics();
		//call the fractal/recursive thing
		randomFractal(0,height/2,width,height/2,drawingArea);
	}
	public void paint(Graphics g){//called by applet
		g.drawImage(display, 0, 0, null);
	}
	public static void randomFractal(int leftX, int leftY, int rightX, int rightY, Graphics drawingArea){
		final int STOP = 4;
		final int MAX = 12;//y pixels
		int midX;
		int midY;
		Random r = new Random();
		
		if(rightX-leftX<=STOP){//stopping condition
			drawingArea.drawLine(leftX, leftY, rightX, rightY);
		}
		else{
			midX = (leftX+rightX)/2;
			midY = (leftY+rightY)/2;
			
			midY += r.nextInt(MAX);
			
			randomFractal(leftX,leftY,midX,midY,drawingArea);//left side
			randomFractal(midX,midY,rightX,rightY,drawingArea);//right side
		}
	}
}
























