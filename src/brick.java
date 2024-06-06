import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class Brick extends Sprite
{
	String type = "Brick";
	void update()
	{}
	Brick(int _x, int _y, int _w, int _h,Model m)
	{ 
		super(m);
		x = _x; 
		y = _y;
		w = _w;
		h = _h;
	}
	Brick(Json ob, Model m)
	{
		super(m);
	 	x = (int)ob.getLong("x");
		y = (int)ob.getLong("y");
		w = (int)ob.getLong("w");
		h = (int)ob.getLong("h");
	}
	
	
	void draw(Graphics g)
	{
		//bricks
		g.setColor(new Color(250, 11, 60));
		g.fillRect (x - model.scrollPost, y, w, h);
	}

Json marshal()
    {
         Json ob = Json.newObject();
         ob.add("type", type);
         ob.add("x", x);  
		 ob.add("y", y);
		 ob.add("w", w);
		 ob.add("h", h);
         return ob;
    }
	boolean amBrick()
  	{
  		return true;	
  	}
}