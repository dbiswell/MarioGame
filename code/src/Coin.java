import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

 public class Coin extends Sprite
{
	
	static Image[] coin_images = null;
	
	Coin(int xx, int yy,Model m)
	{
		super(m);
		type = "Coin_Blocks";
		prev_x = 0;
		prev_y = 0;
		x = xx;
		y = yy;
		w = 60;
		h = 60;
		vert_vel = 0;
		frm_cnt = 0;
	
		if(coin_images == null)
		{
			 coin_images = new Image[5];
			try
			{

				coin_images[0] = ImageIO.read(new File("coin.png"));
				coin_images[1] = ImageIO.read(new File("coin.png"));
				coin_images[2] = ImageIO.read(new File("coin.png"));
				coin_images[3] = ImageIO.read(new File("coin.png"));
				coin_images[4] = ImageIO.read(new File("coin.png"));
					
			} catch(Exception e) {
				e.printStackTrace(System.err);
				System.exit(1);
			}
		}
	}

	Coin(Json ob, Model m)
	{
		 super(m);
		 type = (String)ob.getString("type");
         x = (int)ob.getLong("x");
		 y = (int)ob.getLong("y");
		 w = (int)ob.getLong("w");
		 h = (int)ob.getLong("h");
		 vert_vel = (double)ob.getDouble("vert_vel");
		 m.addCoin(x,y);
		

		 if(coin_images == null)
		{
			 coin_images = new Image[5];
			try
			{
				
					coin_images[0] = ImageIO.read(new File("coin.png"));
					coin_images[1] = ImageIO.read(new File("coin.png"));
					coin_images[2] = ImageIO.read(new File("coin.png"));
					coin_images[3] = ImageIO.read(new File("coin.png"));
					coin_images[4] = ImageIO.read(new File("coin.png"));
					
			} catch(Exception e) {
				e.printStackTrace(System.err);
				System.exit(1);
			}
		}
	}

	Json marshal()
	{
         Json ob = Json.newObject();
         ob.add("type", type);
         ob.add("x", x);  
		 ob.add("y", y);
		 ob.add("w", w);
		 ob.add("h", h);
		 ob.add("vert_vel", vert_vel);
         return ob;
	}

	void draw(Graphics g)
	{
		g.drawImage(coin_images[0], x - model.scrollPost, y, null);
	}
	
	boolean collides(Sprite that)
	{
		if (this.x + this.w <= that.x)
			return false;
		if (this.x >= that.x + that.w)
			return false;
		if (this.y + this.h <= that.y)
			return false;
		if (this.y >= that.y + that.h)
			return false;
		return true;
	}
	void  update()
	{
		vert_vel += 3;
		y += vert_vel;
		if(y >= 600){

		}
	}
	
}
