import java.awt.*;
public class Bike implements Draw {
	// start location values
	private int sX=0;
	private int sY=0;
	//rectangle size
	private int sS;
	//move values
	private int mX;
	private int mY;
	//bike color
	private Color c;
	
	//frame values
	/*private int width;
	private int height;*/
	//opacity
	private int o;
	
	public Bike(int x, int y, int q, Color d, int p){
		sX=x;
		sY=y;
		sS=q;
		c=d;
		o=p;
	}
	public void drawStuff(Graphics g){
		g.setColor(c);
		g.fillRect(sX, sY, sS, sS);
	}
	public void setLoc(int x, int y){
		sX=x;
		sY=y;
	}
	public void setX(int x){
		sX=x;
	}
	public void setY(int y){
		sY=y;
	}
	public void setColor(Color g){
		c=g;
	}
	public void setSize(int s){
		sS= s;
	}
	public void setMoveX(int m){
		mX=m;
	}
	public void setMoveY(int m){
		mY=m;
	}
	public void move(){
		sX+=mX;
		sY+=mY;
	}
	public Color getColor(){
		return c;
	}
	public int getX(){
		return sX;
	}
	public int getY(){
		return sY;
	}
	public int getS(){
		return sS;
	}
	public int getMX(){
		return mX;
	}
	public int getMY(){
		return mY;
	}
	public int getO(){
		return o;
	}
	public void setO(int a){
		o=a;
	}
}
