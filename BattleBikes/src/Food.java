import java.awt.*;
public class Food {
	int a;
	int b;
	int c;
	int d;
	public Food(int x,int y,int w,int h){
		a=x;
		b=y;
		c=w;
		d=h;
	}
	public void spawnFood(Graphics g){
		g.setColor(new Color(255,125,125));
		g.fillRect(a, b, c, d);
	}
	
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
}
