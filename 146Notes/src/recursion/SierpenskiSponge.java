package recursion;
import java.applet.*;
import java.awt.*;

public class SierpenskiSponge extends Applet{
	private Image display;
	private Graphics drawingArea;
	
	public void init(){
		int height = getSize().height;
		int width = getSize().width;
		
		display = createImage(width,height);
		drawingArea = display.getGraphics();
		
		// draw sponge
		drawGasket(0,0,height,drawingArea);
	}
	public void paint(Graphics g){
		g.drawImage(display, 0, 0, null);
	}
	public static void drawGasket(int x,int y,int side,Graphics g){
		int sub = side/3;
		g.fillRect(x+sub,y+sub,sub,sub);
		//g.fillPolygon(xPoints, yPoints, nPoints);
		//g.setColor(GREEN);
		if(sub>=3){
			//topSquares
			drawGasket(x,y,sub,g);//top left
			drawGasket(x+sub,y,sub,g);//middle
			drawGasket(x+sub*2,y,sub,g); //right
			//middle squares
			drawGasket(x,y+sub,sub,g);//left
			drawGasket(x+sub*2,y+sub,sub,g);//right
			//bottom
			drawGasket(x,y+sub*2,sub,g);//top left
			drawGasket(x+sub,y+sub*2,sub,g);//middle
			drawGasket(x+sub*2,y+sub*2,sub,g); //right
		}
	}

}