import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
abstract class Sprite
{
	double vert_vel;
	Model model;
    int groundcount;
	int prevx;
	int prevy;
	int x;
	int y;
	int w;
	int h;
	int prev_x;
	int prev_y;
	int frm_cnt;
	String type;

	Sprite(Model m)
	{
		model = m;
	}
 	

 	String SpriteType()
 	{
 		return type;
 	}
 	boolean doesCollide(Sprite a)
 	{ 
 		//this.update();
 		if(x + w <= a.x)
			return false;
		if(x >= a.x + a.w)
			return false;
		if( y + h <= a.y)
			return false;
		if(y >= a.y + a.h)
			return false;
		return true;

 	}
 	 

    boolean amBrick()
  	{
  		return false;
  	}
  	
  	boolean amCoinBlock()
  	{
  		return false;
  	}
  	boolean amMario()
  	{
  		return false;
  	}
	abstract void update();

	abstract void draw(Graphics g);

	// Sprite(Json ob)
	// {
		
	// 	this.x = (int)ob.getLong("x");
	//    	this.y = (int)ob.getLong("y");
	//     this.w = (int)ob.getLong("w");
	//     this.h = (int)ob.getLong("h");
	        
	      
	// }
	abstract Json marshal();
	// {
	// 	Json ob = Json.newObject();
	//         ob.add("x", x);
	//         ob.add("y", y);
	//         ob.add("w", w);
	//         ob.add("h", h);
	//         return ob;
	// }
}