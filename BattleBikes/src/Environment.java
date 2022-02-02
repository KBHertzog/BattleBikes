import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class Environment extends JPanel implements ActionListener, KeyListener {
	
	// for names
	private String name1;
	private String name2;
	//screens
	public static final int intro = 1;
	public static final int game = 2;
	public static final int end = 3;
	public static final int credits = 4;
	public static int screen = intro;
	//start button
	private JButton start = new JButton("Start");
	//restart button
	private JButton restart = new JButton("Restart");
	//credits button
	private JButton credit = new JButton("Credits");
	private JButton home = new JButton("Home");
	//labels
	private JLabel creditText = new JLabel("Credits");
	private JLabel creditMe = new JLabel("Kenton Hertzog ----------------------------------------------------------------------------Head Developer");
	private JLabel creditMe1 = new JLabel("Kenton Hertzog ----------------------------------------------------------------------------Primary Coder");
	private JLabel creditMe2 = new JLabel("Kenton Hertzog ----------------------------------------------------------------------------Level Designer");
	private JLabel creditMe3 = new JLabel("Kenton Hertzog ----------------------------------------------------------------------------Graphic Artist");
	private JLabel creditMe4 = new JLabel("Kenton Hertzog ----------------------------------------------------------------------------Project Manager");
	private JLabel creditMax = new JLabel("Max Olree --------------------------------------------------------------------------------Idea Generator");
	private JLabel creditKody = new JLabel("Kody Bruhn -------------------------------------------------------------------------------Title Screen Artist");
	private JLabel creditWile = new JLabel("Mr. Wile ----------------------------------------------------------------------------------Helper&Motivator");
	private JLabel creditTest = new JLabel("Kenton Hertzog ----------------------------------------------------------------------------Beta Tester 1");
	private JLabel creditTest1 = new JLabel("Max Olree --------------------------------------------------------------------------------Beta Tester 2");
	private JLabel creditTest2 = new JLabel("Mr. Wile ----------------------------------------------------------------------------------Beta Tester 3");
	//modes
	private JToggleButton vanish = new JToggleButton("Vanishing Walls");
	private JToggleButton random = new JToggleButton("Random Spawns");
	private JToggleButton snake = new JToggleButton("Snake mode");
	private JToggleButton blink = new JToggleButton("Strobe mode");
	private JToggleButton hard = new JToggleButton("Hard Mode");
	private JToggleButton paint = new JToggleButton("Paint Party");
	//text field names
	private JTextField nameA = new JTextField("Player 1");
	private JTextField nameB = new JTextField("Player 2");
	//color arrays
	private String[] colorsA = {"red","orange","yellow","cyan","pink","purple","green","blue","mint"};
	private String[] colorsB = {"cyan","red","orange","yellow","pink","purple","green","blue","mint"};
	//color select
	private JComboBox aColor = new JComboBox(colorsA);
	private JComboBox bColor = new JComboBox(colorsB);
	//users
	private Bike a;
	private Bike b;
	//timer
	Timer timer;
	//start timer
	private int starter=0;
	private int startTimer=3;
	//bike colors
	private Color r=new Color(255,0,0);
	private Color c = new Color(51,255,255);
	//movement booleans
	public static int up=0;
	public static int d=1;
	public static int ri=2;
	public static int l=3;
	public static int s=4;
	private int aM;
	private int bM;
	//Arrays
	private ArrayList<Wall> wallsA = new ArrayList<Wall>();
	private ArrayList<Wall> wallsB = new ArrayList<Wall>();
	private ArrayList<Food> food = new ArrayList<Food>();
	private ArrayList<Delete> delete = new ArrayList<Delete>();
	private ArrayList<StopUp> stop = new ArrayList<StopUp>();
	private ArrayList<Invincible> invi = new ArrayList<Invincible>();
	//food limit
	private int limitA;
	private int limitB;
	//Booleans
	private boolean isAliveA = true;
	private boolean isAliveB = true;
	private boolean cSwap = false;
	private boolean deleteA=false;
	private boolean deleteB=false;
	private boolean stopA=false;
	private boolean stopB=false;
	private boolean inviA=false;
	private boolean inviB=false;
	//timers
	private int cTime = 0;
	private double pTime = 40;
	private DecimalFormat timerFormat = new DecimalFormat("#.00");
	private int stopIt = 0;
	private int inv = 0;
	//background image
	URL url = Environment.class.getResource("/resources/bikes2.png");
	private ImageIcon bg = new ImageIcon(url);
	private Image background = bg.getImage();
	//frame and container
	JFrame frame = new JFrame("BATTLE BIKES");
	Container can = frame.getContentPane();
	public Environment(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		can.add(this);
		setPreferredSize(new Dimension(1200,650));	
		
		//listeners
		frame.addKeyListener(this);
		
		this.setLayout(null);
		
		updateScreen();
		
		start.addActionListener(this);
		nameA.addActionListener(this);
		nameB.addActionListener(this);
		aColor.addActionListener(this);
		bColor.addActionListener(this);
		restart.addActionListener(this);
		credit.addActionListener(this);
		home.addActionListener(this);
		vanish.addActionListener(this);
		random.addActionListener(this);
		blink.addActionListener(this);
		hard.addActionListener(this);
		paint.addActionListener(this);
		
		frame.pack();
		
		a = new Bike(0,0,25,r,215);
		b = new Bike(1175,625,25,c,215);
		frame.setVisible(true);
		timer = new Timer(1000/60,this);
		timer.start();
	}
	
	public static void main(String[]args){
		new Environment();
	}
	
	private void updateScreen(){
		if(screen==intro){
			homeScreen();
		}
		if(screen==game){
			frame.setBackground(Color.BLACK);
			setBackground(Color.BLACK);
		}
		if(screen==end){
			frame.setBackground(Color.BLACK);
			setBackground(Color.BLACK);
			restart.setBounds(550, 400, 100, 50);
			add(restart);
		}
		if(screen==credits){
			creditScreen();
		}
	}
	
	private void homeScreen(){
		frame.setBackground(Color.BLACK);
		start.setBounds(550,450,100,50);
		nameA.setBounds(350,475,200,50);
		nameB.setBounds(650,475,200,50);
		aColor.setBounds(250,475,100,50);
		bColor.setBounds(850, 475, 100, 50);
		credit.setBounds(1100,600,100,50);
		vanish.setBounds(0,600,140,50);
		random.setBounds(150,600,130,50);
		snake.setBounds(290,600,100,50);
		blink.setBounds(400,600,100,50);
		hard.setBounds(510,600,100,50);
		paint.setBounds(620,600,100,50);
		this.add(start);
		this.add(nameA);
		this.add(nameB);
		this.add(aColor);
		this.add(bColor);
		this.add(credit);
		this.add(vanish);
		this.add(random);
		this.add(snake);
		this.add(blink);
		this.add(hard);
		this.add(paint);
	}
	
	private void creditScreen(){
		frame.setBackground(Color.LIGHT_GRAY);
		this.setBackground(Color.LIGHT_GRAY);
		home.setBounds(1100,600,100,50);
		creditText.setBounds(50,20,1000,20);
		creditMe.setBounds(200,50,1000,20);
		creditMe1.setBounds(200,80,1000,20);
		creditMe2.setBounds(200,110,1000,20);
		creditMe3.setBounds(200,140,1000,20);
		creditMe4.setBounds(200,170,1000,20);
		creditMax.setBounds(200,200,1000,20);
		creditKody.setBounds(200,230,1000,20);
		creditWile.setBounds(200,260,1000,20);
		creditTest.setBounds(200,290,1000,20);
		creditTest1.setBounds(200,320,1000,20);
		creditTest2.setBounds(200,350,1000,20);
		this.add(home);
		this.add(creditText);
		this.add(creditMe);
		this.add(creditMe1);
		this.add(creditMe2);
		this.add(creditMe3);
		this.add(creditMe4);
		this.add(creditMax);
		this.add(creditKody);
		this.add(creditWile);
		this.add(creditTest);
		this.add(creditTest1);
		this.add(creditTest2);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(screen == intro){
			g.drawImage(background,0,0,getWidth(),getHeight(),this);
		}
		
		
		if(screen == game){
			g.setColor(Color.WHITE);
			if(!hard.isSelected()){
				drawGrid(g);
			}
			if(startTimer>=0){
				g.setColor(Color.WHITE);
				g.drawString(""+startTimer,getWidth()/2-10,getHeight()/2);
			}
			if(snake.isSelected()){
				for(int x = 0;x<food.size();x++){
					food.get(x).spawnFood(g);
				}
			}
			for(int x = 0;x<wallsA.size();x++){
				wallsA.get(x).drawStuff(g);
			}
			for(int x = 0;x<wallsB.size();x++){
				wallsB.get(x).drawStuff(g);
			}
			a.drawStuff(g);
			b.drawStuff(g);
			if(startTimer<0&&paint.isSelected()){
				paintPaint(g);
			}
		}	
		if(screen == end){
			deathScreen(g);
		}
	}
	
	private void deathScreen(Graphics g){
		g.setColor(Color.WHITE);
		if(snake.isSelected()){
			if(!isAliveA&&isAliveB){
				g.drawString( name2 + " WINS",getWidth()/2-50,getHeight()/2);
			}
			else if(!isAliveB&&isAliveA){
				g.drawString( name1 + " WINS", getWidth()/2-50, getHeight()/2);
			}
			else if(!isAliveA&&!isAliveB&&limitA>limitB){
				g.drawString( name1 + " WINS",getWidth()/2-50,getHeight()/2);
			}
			else if(!isAliveA&&!isAliveB&&limitA<limitB){
				g.drawString( name2 + " WINS",getWidth()/2-50,getHeight()/2);

			}
			else{
				g.drawString(name1+" and "+name2+" tie!", getWidth()/2-90, getHeight()/2);

			}
		}
		else{
			if(!isAliveA&&isAliveB){
				g.drawString( name2 + " WINS",getWidth()/2-50,getHeight()/2);
			}
			else if(!isAliveB&&isAliveA){
				g.drawString( name1 + " WINS", getWidth()/2-50, getHeight()/2);
			}
			else{
				g.drawString(name1 +" and " + name2 + " LOSE", getWidth()/2-100, getHeight()/2);
			}
		}
		
	}
	
	private void drawTimer(Graphics g){
		g.setColor(Color.WHITE);
		if(pTime>10){
			g.drawString(""+timerFormat.format(pTime),getWidth()/2-16,20);
		}
		if(pTime<10&&pTime>1){
			g.drawString(""+timerFormat.format(pTime),getWidth()/2-10,20);
		}
		if(pTime<1){
			g.drawString(""+timerFormat.format(pTime),getWidth()/2-2,20);
		}
	}
	
	private void drawGrid(Graphics g){
		for(int x = 0; x<getWidth(); x+=25){
			g.drawLine(x,0,x,getHeight());
		}
		for(int y = 0; y<getHeight(); y+=25){
			g.drawLine(0,y,getWidth(),y);
		}
	}
	
	private void paintPaint(Graphics g){
		drawTimer(g);
		for(int x = 0;x<delete.size();x++){
			delete.get(x).drawPowerup(g);
		}
		for(int x = 0;x<stop.size();x++){
			stop.get(x).drawPowerup(g);
		}
		for(int x = 0;x<invi.size();x++){
			invi.get(x).drawPowerup(g);
		}
	}
	
	private void setStart(){
		if(random.isSelected()){
			a.setLoc((int)(((getWidth()/2-a.getS())-0+1) *Math.random()+0), (int)(((getHeight()-a.getS())-0+1) *Math.random()+0));
			b.setLoc((int)((getWidth()-(getWidth()/2-b.getS())+1) *Math.random()+(getWidth()/2-b.getS())), (int)(((getHeight()-b.getS())-0+1) *Math.random()+0));
		}
		else{
			a.setLoc(50,getHeight()/2);
			b.setLoc(getWidth()-75,getHeight()/2);
		}
		startTimer=3;
		limitA=5;
		limitB=5;
		cTime=0;
		pTime=40;
		wallsA = new ArrayList<Wall>();
		wallsB = new ArrayList<Wall>();
		food = new ArrayList<Food>();
		delete = new ArrayList<Delete>();
		stop = new ArrayList<StopUp>();
		isAliveA=true;
		isAliveB=true;
		aM=ri;
		bM=l;
		stopIt=0;
		a.setO(215);
		b.setO(215);
	}
	
	private void buildWallA(int x,int y, int w, int h,Color c,int a){
		wallsA.add(new Wall(x,y,w,h,c,a));
	}
	private void buildWallB(int x,int y, int w, int h,Color c,int a){
		wallsB.add(new Wall(x,y,w,h,c,a));
	}
	
	private boolean wallCollision(Rectangle u, Rectangle w){
		return u.intersects(w);
	}
	
	private boolean eatingFood(Rectangle u,Rectangle f){
		return u.intersects(f);
	}
	//runs the active part of the game
	public void actionPerformed(ActionEvent z) {
		//Title Screen
		Object source = z.getSource();
		name1 = nameA.getText();
		name2 = nameB.getText();
		//color Select
		colorSelect(z);
		
		//secret bdingas code
		secretCode();
		
		//timer
		if(screen == game){
			starter = starter +1;
			cTime++;
			if(starter%30==0){
				startTimer=startTimer-1;
				repaint();
			}
		}
		//actual game
		if(timer.isRunning()){
			if(screen==intro){
				buttonRestrict();
			}
			if(screen==game){
				if(startTimer==0&&!snake.isSelected()){
					aM=ri;
					bM=l;
				}
	
				//hard mode
				if(hard.isSelected()){
					a.setO(8);
					b.setO(8);
				}
				if(startTimer<0){
					//movement
					movement();
					//colorswap
					colorSwap();
	
				}
				wallsCollision();
				vanishWalls();
				if(snake.isSelected()){
					snakeMode();
				}
				if(paint.isSelected()&&startTimer<0){
					timerFormat.format(pTime-=1.0/60.0);
				}
				paintDeath();
				borderCollision();
				//powerup sections
				if(paint.isSelected()){
					invincibility();
					deletePower();
					stoppingPower();
					
				}
			}
		}
		if (!isAliveA||!isAliveB){
			death();
		}
		//buttons
		if(source == start){
			buttons();
		}
		else if(source==restart){
			restarter();
		}
		else if(source == credit){
			crediter();
		}
		else if(source == home){
			homer();
		}
	}

	private void buttons(){
		setStart();
		remove(start);
		remove(nameA);
		remove(nameB);
		remove(aColor);
		remove(bColor);
		remove(credit);
		remove(vanish);
		remove(random);
		remove(snake);
		remove(blink);
		remove(hard);
		remove(paint);
		revalidate();
		repaint();
		frame.requestFocus();
		screen = game;
		updateScreen();
	}
	
	private void restarter(){
			remove(restart);
			revalidate();
			repaint();
			screen = intro;
			setStart();
			updateScreen();
			frame.requestFocus();
			timer.start();
	}
	private void crediter(){
		remove(credit);
		remove(start);
		remove(nameA);
		remove(nameB);
		remove(aColor);
		remove(bColor);
		remove(vanish);
		remove(random);
		remove(snake);
		remove(blink);
		remove(hard);
		remove(paint);
		revalidate();
		repaint();
		frame.requestFocus();
		screen = credits;
		updateScreen();
	}
	
	private void homer(){
		remove(home);
		remove(creditText);
		remove(creditMe);
		remove(creditMe1);
		remove(creditMe2);
		remove(creditMe3);
		remove(creditMe4);
		remove(creditMax);
		remove(creditKody);
		remove(creditWile);
		remove(creditTest);
		remove(creditTest1);
		remove(creditTest2);
		revalidate();
		repaint();
		frame.requestFocus();
		screen = intro;
		updateScreen();
	}
	
	private void colorSelect(ActionEvent z){
		String colorA = (String) aColor.getSelectedItem();
		String colorB = (String) bColor.getSelectedItem();
		Object source = z.getSource();

		if(source == aColor){
			if(colorA == "red"){
				r = new Color(255,0,0);
				a.setColor(r);
			}
			else if(colorA == "yellow"){
				r = new Color(255,255,0);
				a.setColor(r);
			}
			else if(colorA == "orange"){
				r = new Color(255,119,0);
				a.setColor(r);
			}
			else if(colorA == "pink"){
				r = new Color(255,0,255);
				a.setColor(r);
			}
			else if(colorA == "green"){
				r = new Color(0,255,0);
				a.setColor(r);
			}
			else if(colorA == "cyan"){
				r = new Color(51,255,255);
				a.setColor(r);
			}
			else if(colorA == "purple"){
				r = new Color(127,0,255);
				a.setColor(r);
			}
			else if(colorA == "blue"){
				r= new Color(0,0,255);
				a.setColor(r);
			}
			else if(colorA == "mint"){
				r= new Color(51,255,153);
				a.setColor(r);
			}
		}
		
		
		if(source == bColor){
			if(colorB == "red"){
				c = new Color(255,0,0);
				b.setColor(c);
			}
			else if(colorB == "yellow"){
				c = new Color(255,255,0);
				b.setColor(c);
			}
			else if(colorB == "orange"){
				c = new Color(255,119,0);
				b.setColor(c);
			}
			else if(colorB == "pink"){
				c = new Color(255,0,255);
				b.setColor(c);
			}
			else if(colorB == "green"){
				c = new Color(0,255,0);
				b.setColor(c);
			}
			else if(colorB == "cyan"){
				c = new Color(51,255,255);
				b.setColor(c);
			}
			else if(colorB == "purple"){
				c = new Color(127,0,255);
				b.setColor(c);
			}
			else if(colorB == "blue"){
				c = new Color(0,0,255);
				b.setColor(c);
			}
			else if(colorB == "mint"){
				c= new Color(51,255,153);
				b.setColor(c);
			}
			
		}
	}
	
	private void secretCode(){
		String bding=nameA.getText();
		if(bding.equals("Bdingas")){
			Color q = new Color(0,0,0);
			a.setColor(q);
			if(inviA==false){
				inviA=true;
			}
		}
		String as=nameB.getText();
		if(as.equals("Bdingas")){
			Color q = new Color(0,0,0);
			b.setColor(q);
			if(inviB==false){
				inviB=true;
			}
		}
	}
	
	private void vanishWalls(){
		if(!snake.isSelected()&&vanish.isSelected()){
			while(wallsA.size()>=400){
				wallsA.remove(0);
			}
			while(wallsB.size()>=400){
				wallsB.remove(0);
			}
		}
	}
	
	private void movement(){
		if(!stopA){
			if(aM==up){
				a.setMoveX(0);
				a.setMoveY(-5);
				a.move();
				buildWallA(a.getX(),a.getY()+a.getS(),a.getS(),a.getS()/5,a.getColor(),a.getO());
				repaint();
			}
			else if(aM==ri){
				a.setMoveX(5);
				a.setMoveY(0);
				a.move();
				buildWallA(a.getX()-a.getS()/5,a.getY(),a.getS()/5,a.getS(),a.getColor(),a.getO());
				repaint();
			}
			else if(aM==d){
				a.setMoveX(0);
				a.setMoveY(5);
				a.move();
				buildWallA(a.getX(),a.getY()-a.getS()/5,a.getS(),a.getS()/5,a.getColor(),a.getO());
				repaint();
			}
			else if(aM==l){
				a.setMoveX(-5);
				a.setMoveY(0);
				a.move();
				buildWallA(a.getX()+a.getS(),a.getY(),a.getS()/5,a.getS(),a.getColor(),a.getO());
				repaint();
			}
		}
		if(!stopB){
			if(bM==up){
				b.setMoveX(0);
				b.setMoveY(-5);
				b.move();
				buildWallB(b.getX(),b.getY()+b.getS(),b.getS(),b.getS()/5,b.getColor(),b.getO());
				repaint();
			}	
			else if(bM==ri){
				b.setMoveX(5);
				b.setMoveY(0);
				b.move();
				buildWallB(b.getX()-b.getS()/5,b.getY(),b.getS()/5,b.getS(),b.getColor(),b.getO());
				repaint();
			}
			else if(bM==d){
				b.setMoveX(0);
				b.setMoveY(5);
				b.move();
				buildWallB(b.getX(),b.getY()-b.getS()/5,b.getS(),b.getS()/5,b.getColor(),b.getO());
				repaint();
			}
			else if(bM==l){
				b.setMoveX(-5);
				b.setMoveY(0);
				b.move();
				buildWallB(b.getX()+b.getS(),b.getY(),b.getS()/5,b.getS(),b.getColor(),b.getO());
				repaint();
			}
		}
	}
	
	private void colorSwap(){
		if(blink.isSelected()&&cTime%120==0){
			if(cSwap==false){
				setBackground(b.getColor());
				cSwap=true;
			}
			else if(cSwap==true){
				setBackground(a.getColor());
				cSwap=false;
			}
		}
	}
	
	private void buttonRestrict(){
		if(snake.isSelected()||vanish.isSelected()){
			paint.setEnabled(false);
		}
		else{
			paint.setEnabled(true);
		}
		if(paint.isSelected()||vanish.isSelected()){
			snake.setEnabled(false);
		}
		else{
			snake.setEnabled(true);
		}
		if(snake.isSelected()||paint.isSelected()){
			vanish.setEnabled(false);
		}
		else{
			vanish.setEnabled(true);
		}
	}
	
	private void borderCollision(){
		if(!paint.isSelected()){		
			if(a.getX()<0||a.getX()+a.getS()>getWidth()||a.getY()+a.getS()>getHeight()||a.getY()<0){
				isAliveA=false;
			}
			if(b.getX()<0||b.getX()+b.getS()>getWidth()||b.getY()+b.getS()>getHeight()||b.getY()<0){
				isAliveB=false;
			}
		}
		if(paint.isSelected()){
			if(a.getX()<0){
				a.setX(0);
			}
			if(a.getX()+a.getS()>getWidth()){
				a.setX(getWidth()-a.getS());
			}
			if(a.getY()<0){
				a.setY(0);
			}
			if(a.getY()+a.getS()>getHeight()){
				a.setY(getHeight()-a.getS());
			}
			
			if(b.getX()<0){
				b.setX(0);
			}
			if(b.getX()+b.getS()>getWidth()){
				b.setX(getWidth()-a.getS());
			}
			if(b.getY()<0){
				b.setY(0);
			}
			if(b.getY()+b.getS()>getHeight()){
				b.setY(getHeight()-a.getS());
			}
		}
	}
	
	private void wallsCollision(){
		Rectangle user1 = new Rectangle(a.getX(),a.getY(),a.getS(),a.getS());
		Rectangle user2 = new Rectangle(b.getX(),b.getY(),b.getS(),b.getS());
		if(!paint.isSelected()){
			for(Wall w : wallsA){		
				Rectangle wall = new Rectangle(w.getX(),w.getY(),w.getW(),w.getH());
				if(wallCollision(user1, wall)){
					isAliveA= false;
				}
				if(wallCollision(user2, wall)){
					isAliveB = false;
				}
			}
			for(Wall w : wallsB){
			
				Rectangle wall = new Rectangle(w.getX(),w.getY(),w.getW(),w.getH());
				if(wallCollision(user1, wall)){
					isAliveA= false;
				//	playSound("Bonk.wav");
				}
				if(wallCollision(user2, wall)){
					isAliveB = false;
					//playSound("Bonk.wav");
				}
			}
			if (wallCollision(user1, user2)){
				isAliveA = false;
				isAliveB = false;
				//playSound("Bonk.wav");
				//playSound("Bonk.wav");
			}
		}
		if(paint.isSelected()){
			//wall collision paint
			for(int w = 0; w<wallsA.size();w++){		
				Rectangle wall = new Rectangle(wallsA.get(w).getX(),wallsA.get(w).getY(),wallsA.get(w).getW(),wallsA.get(w).getH());
				if(wallCollision(user1, wall)){
					wallsA.remove(w);
				}
				if(wallCollision(user2, wall)){
					wallsA.remove(w);
				}
			}
			for(int w = 0; w<wallsB.size();w++){
				Rectangle wall = new Rectangle(wallsB.get(w).getX(),wallsB.get(w).getY(),wallsB.get(w).getW(),wallsB.get(w).getH());
				if(wallCollision(user1, wall)){
					wallsB.remove(w);
				}
				if(wallCollision(user2, wall)){
					wallsB.remove(w);
				}
			}
		}
	}
	
	private void snakeMode(){
		while(wallsA.size()>=limitA){
			wallsA.remove(0);
		}
		while(wallsB.size()>=limitB){
			wallsB.remove(0);
		}
		if(food.size()==0){
			food.add(new Food((int)(((getWidth()-50)-0+1) *Math.random()+0),(int)(((getHeight()-50)-0+1) *Math.random()+0),25,25));
			repaint();
		}
		foodCollision();
	}
	
	private void paintDeath(){
		if(pTime<=0&&paint.isSelected()){
			if(wallsA.size()>wallsB.size()){
				isAliveB=false;
			}
			if(wallsA.size()<wallsB.size()){
				isAliveA=false;
			}
			if(wallsA.size()==wallsB.size()){
				isAliveA=false;
				isAliveB=false;
			}
		}
	}
	
	private void foodCollision(){
		Rectangle user1 = new Rectangle(a.getX(),a.getY(),a.getS(),a.getS());
		Rectangle user2 = new Rectangle(b.getX(),b.getY(),b.getS(),b.getS());
		if(snake.isSelected()){
			for(int x=0;x<food.size();x++){
				Rectangle foods = new Rectangle(food.get(x).getX(),food.get(x).getY(),food.get(x).getW(),food.get(x).getH());
				if(eatingFood(user1,foods)){
					limitA=limitA+5;
					for(x= 0;x<food.size();x++){
						food.remove(0);
					}
				}
				if(eatingFood(user2,foods)){
					limitB=limitB+5;
					for(x=0;x<food.size();x++){
						food.remove(0);
					}
				}
			}
		}
	}
	
	private void deletePower(){
		Rectangle user1 = new Rectangle(a.getX(),a.getY(),a.getS(),a.getS());
		Rectangle user2 = new Rectangle(b.getX(),b.getY(),b.getS(),b.getS());
		//delete
		for(int w = 0; w<delete.size();w++){
			Rectangle deleter = new Rectangle(delete.get(w).getX(),delete.get(w).getY(),delete.get(w).getW(),delete.get(w).getH());
			if(wallCollision(user1,deleter)){
				if(!inviB){
					deleteA=true;
				}
				delete.remove(w);
			}
			else if(wallCollision(user2,deleter)){
				if(!inviA){
					deleteB=true;
				}
				delete.remove(w);
			}
		}
		if(Math.random()<.01&&delete.size()<4){
			delete.add(new Delete(((int)((getWidth()-0+1) *Math.random()+0)), (int)((getHeight()+1) *Math.random()+0),25,25,Color.WHITE));
		}
		if(deleteA){
			int wallSize = wallsB.size();
			for(int x=0;x<Math.min(wallSize,25);x++){
				wallsB.remove(0);
			}
			deleteA=false;
		}
		else if(deleteB){
			int wallSize = wallsA.size();
			for(int x=0;x<Math.min(wallSize,25);x++){
				wallsA.remove(0);
			}
			deleteB=false;
		}
	}
	
	private void stoppingPower(){
		Rectangle user1 = new Rectangle(a.getX(),a.getY(),a.getS(),a.getS());
		Rectangle user2 = new Rectangle(b.getX(),b.getY(),b.getS(),b.getS());
		for(int s = 0; s<stop.size();s++){
			Rectangle stopper = new Rectangle(stop.get(s).getX(),stop.get(s).getY(),stop.get(s).getW(),stop.get(s).getH());
			if(wallCollision(user1,stopper)){
				stopIt=0;
				stop.remove(s);
				if(!inviB){
					stopB=true;
				}
			}
			if(wallCollision(user2,stopper)){
				stopIt=0;
				stop.remove(s);
				if(!inviA){
					stopA=true;
				}
			}
		}
		if(Math.random()<.005&&stop.size()<2){
			Color stahp = new Color(255,20,20);
			stop.add(new StopUp(((int)((getWidth()-0+1) *Math.random()+0)), (int)((getHeight()+1) *Math.random()+0),25,25,stahp));
		}
		if(stopA){
			stopIt++;
			if(stopIt==60){
				stopA=false;
				stopIt=0;
			}
		}
		if(stopB){
			stopIt++;
			if(stopIt==60){
				stopB=false;
				stopIt=0;
			}
		}
	}
	
	private void invincibility(){
		Rectangle user1 = new Rectangle(a.getX(),a.getY(),a.getS(),a.getS());
		Rectangle user2 = new Rectangle(b.getX(),b.getY(),b.getS(),b.getS());
		
		for(int s = 0; s<invi.size();s++){
			Rectangle ncible = new Rectangle(invi.get(s).getX(),invi.get(s).getY(),invi.get(s).getW(),invi.get(s).getH());
			if(wallCollision(user1,ncible)){
				inv=0;
				inviA=true;
				invi.remove(s);
			}
			if(wallCollision(user2,ncible)){
				inv=0;
				inviB=true;
				invi.remove(s);
			}
		}
		if(Math.random()<.005&&invi.size()<2){
			Color gold = new Color(153,101,21);
			invi.add(new Invincible(((int)((getWidth()-0+1) *Math.random()+0)), (int)((getHeight()+1) *Math.random()+0),25,25,gold));
		}
		if(inviA){
			inv++;
			if(inv==240){
				inv=0;
				inviA=false;
			}
		}
		if(inviB){
			inv++;
			if(inv==240){
				inv=0;
				inviB=false;
			}
		}
	}
	
	private void death(){
		timer.stop();
		screen=end;
		updateScreen();
	}
	
	public void keyPressed(KeyEvent c) {
		int k = c.getKeyCode();
		if(k == KeyEvent.VK_W&&aM!=d){
			aM=up;
		}
		else if(k == KeyEvent.VK_D&&aM!=l){
			aM=ri;
		}
		else if(k == KeyEvent.VK_S&&aM!=up){
			aM=d;
		}
		else if(k == KeyEvent.VK_A&&aM!=ri){
			aM=l;
		}
		if(k == KeyEvent.VK_UP&&bM!=d){
			bM=up;
		}
		else if(k == KeyEvent.VK_RIGHT&&bM!=l){
			bM=ri;
		}
		else if(k == KeyEvent.VK_DOWN&&bM!=up){
			bM=d;
		}
		else if(k == KeyEvent.VK_LEFT&&bM!=ri){
			bM=l;
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}