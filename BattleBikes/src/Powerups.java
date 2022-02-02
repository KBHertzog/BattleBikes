import java.awt.Color;
import java.awt.Graphics;

public class Powerups {
	private int x;
	private int y;
	private int w;
	private int h;
	private Color z;
	public Powerups(int a,int b,int c,int d,Color e){
		x=a;
		y=b;
		w=c;
		h=d;
		z=e;
	}
	public void drawPowerup(Graphics g){
		g.setColor(z);
		g.fillRect(x, y, w, h);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
	public Color getColor(){
		return z;
	}
}
