import pkg.*;

public class Car{
	private Rectangle body1;
	private Rectangle body2;
	private Ellipse w1;
	private Ellipse w2;
	private Ellipse front;
	private Color c1;
	private Color c2;
	private Color c3;
	private Text label;
	
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;
	
	private int stepX;
	private int stepY;
	
	private int sg; //stop and go variable
	
	private Line road;
	private int roady;
	
	public Car(double x, double y, String text){
		body1 = new Rectangle(x,y,100,40);
		body2 = new Rectangle(x+25,y-20,50,20);
		w1 = new Ellipse(x,y+30,25,25);
		w2 = new Ellipse(x+75,y+30,25,25);
		front = new Ellipse(x+80,y,30,40);
		
		//c1 = new Color(255,0,0);
		//c2 = new Color(0,0,255);
		c3 = new Color(100,100,100);
		
		//body1.setColor(c1);
		//body2.setColor(c2);
		front.setColor(c3);
		
		l1 = new Line(x,y-20,x+110,y-20); //top
		l2 = new Line(x+110,y-20,x+110,y+55); //right
		l3 = new Line(x,y+55,x+110,y+55); // bottom
		l4 = new Line(x,y-20,x,y+55); //left
		
		stepX = Canvas.rand(4);
		stepY = Canvas.rand(5);
		
		label = new Text(x+35,y+10,text);
		
	}
	
	public Car(double x, double y, String text, Color c){
		this(x,y,text);//refers to all of the text in previous car constructor
		body1.setColor(c);
		body2.setColor(c);
	}
	
	public void translate(int x, int y){
		body1.translate(x,y);
		body2.translate(x,y);
		w1.translate(x,y);
		w2.translate(x,y);
		front.translate(x,y);
		l1.translate(x,y);
		l2.translate(x,y);
		l3.translate(x,y);
		l4.translate(x,y);
		label.translate(x,y);
	}
	
	//
	public int getXLeft(){
		return l1.getX();
	}
	public int getXRight(){
		return l2.getX();
	}
	public int getYTop(){
		return l1.getY();
	}
	public int getYBottom(){
		return l3.getY();
	}//hitbox of car
	
	//
	public void setStep(int stx, int sty){
		stepX = stx;
		stepY = sty;
	}
	//overrrides the random stepX,Y above
	
	public int getStepX(){
		return stepX;
	}
	public int getStepY(){
		return stepY;
		
	}
	
	public void Drive(int speed, int time){
		body1.translate(speed,0);
		body2.translate(speed,0);
		w1.translate(speed,0);
		w2.translate(speed,0);
		front.translate(speed,0);
		l1.translate(speed,0);
		l2.translate(speed,0);
		l3.translate(speed,0);
		l4.translate(speed,0);
		label.translate(speed,0);
			
		Canvas.pause(time);
		
		int farthest = 725;
			
		if(l1.getX()>farthest-100){
			body1.translate(-farthest,100);
			body2.translate(-farthest,100);
			w1.translate(-farthest,100);
			w2.translate(-farthest,100);
			front.translate(-farthest,100);
			l1.translate(-farthest,100);
			l2.translate(-farthest,100);
			l3.translate(-farthest,100);
			l4.translate(-farthest,100);
			label.translate(-farthest,100);
		}
		if(l1.getY()>519){
			body1.translate(0,-600);
			body2.translate(0,-600);
			w1.translate(0,-600);
			w2.translate(0,-600);
			front.translate(0,-600);
			l1.translate(0,-600);
			l2.translate(0,-600);
			l3.translate(0,-600);
			l4.translate(0,-600);
			label.translate(0,-600);
		}
		
	}
	
	public void draw(){
		front.fill();
		body1.fill();
		body2.fill();
		w1.fill();
		w2.fill();
		l1.draw();
		l2.draw();
		l3.draw();
		l4.draw();
		label.draw();
		//draws car
		
		if(stepX == 0){
			stepX = 0;
		}
		if (stepX == 1){
			stepX = 100;
		}
		if (stepX == 2){
			stepX = 300;
		}
		if (stepX == 3){
			stepX = 500;
		}
		
		for(int n = 0; n<5; n++){
			if(stepY == n){
				stepY = stepY + n*100 + 33;
			}
		}
		
		body1.translate(stepX,stepY);
		body2.translate(stepX,stepY);
		w1.translate(stepX,stepY);
		w2.translate(stepX,stepY);
		front.translate(stepX,stepY);
		l1.translate(stepX,stepY);
		l2.translate(stepX,stepY);
		l3.translate(stepX,stepY);
		l4.translate(stepX,stepY);
		label.translate(stepX,stepY);
		//step function
		
		roady = 1;
		for(int z = 0; z<7; z++){
			road = new Line(0,roady,1000,roady);
			road.draw();
			roady = roady+100;
		}
		//draws roads
		
	}
	 
}