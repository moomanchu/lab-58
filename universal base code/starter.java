import pkg.*;
import java.util.ArrayList;
import java.util.Random;

public class starter implements InputControl, InputKeyControl {

	public static void main(String args[]) {
		// please leave following line alone, necessary for keyboard/mouse input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());
		
		Car[] ac = new Car[30];
		int count = 0;
		for(Car c: ac){
		
			Color color = new Color(Canvas.rand(255),Canvas.rand(255),Canvas.rand(255));
		
			c = new Car(1,1,"AC/DC",color);
			c.setStep(0,0);
			c.draw();
			
			ac[count] = c;
			//ac[count+1].translate(-50+ac[count].getXLeft(),0);
			count++;
		}
		count = 0;
		while(count+1<ac.length){
			ac[count+1].translate(-120+ac[count].getXLeft(),0);
			System.out.println(ac[count+1].getXLeft());
			count++;
		}
		while(true){
			for(int n = 0;n<ac.length;n++){
				ac[n].Drive(5,0);
			}
		}
	}

	public void onMouseClick(double x, double y) {
		// enter code here

	}

	public void keyPress(String s) {
		// enter code here

	}
}
