import java.awt.Color;
import java.awt.Graphics;


public class Wall implements Draw {

	//6 var
	private int a;
	private int b;
	private int c;
	private int d;
	private Color z;
	private int o;
	
	public Wall(int e,int f,int g,int h,Color q,int p){
		a=e;
		b=f;
		c=g;
		d=h;
		z=q;
		o=p;
	}
	
	/*public void drawWall(Graphics g){
		g.setColor(new Color(z.getRed(), z.getGreen(), z.getBlue(), o));
		g.fillRect(a,b,c,d);
	}*/
	public int getX(){
		return a;
	}
	public int getY(){
		return b;
	}
	public int getW(){
		return c;
	}
	public int getH(){
		return d;
	}

	public void drawStuff(Graphics g) {
		g.setColor(new Color(z.getRed(), z.getGreen(), z.getBlue(), o));
		g.fillRect(a,b,c,d);		
	}
}
