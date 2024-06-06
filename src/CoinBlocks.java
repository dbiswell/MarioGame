import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.util.Iterator;
import java.util.Random;

public class CoinBlocks extends Sprite {
	static Image[] coinblock_images = null;
	int coinsRemain;


	CoinBlocks(int xx, int yy, Model m) {

		super(m);
		type = "CoinBlocks";
		x = xx;
		y = yy;
		w = 100;
		h = 100;
		vert_vel = 0;
		coinsRemain = 5;

		if (coinblock_images == null) {
			coinblock_images = new Image[2];
			try {
				coinblock_images[0] = ImageIO.read(new File("coinblock1.png"));
				coinblock_images[1] = ImageIO.read(new File("coinblock2.png"));
			} catch (Exception e) {
				e.printStackTrace(System.err);
				System.exit(1);
			}
		}
	}

	CoinBlocks(Json ob, Model m) {
		super(m);
		type = (String) ob.getString("type");
		x = (int) ob.getLong("x");
		y = (int) ob.getLong("y");
		w = (int) ob.getLong("w");
		h = (int) ob.getLong("h");
		m.addCoinBlocks(x, y);

		if (coinblock_images == null) {
			coinblock_images = new Image[2];
			try {
				coinblock_images[0] = ImageIO.read(new File("coinblock1.png"));
				coinblock_images[1] = ImageIO.read(new File("coinblock2.png"));
			} catch (Exception e) {
				e.printStackTrace(System.err);
				System.exit(1);
			}
		}

	}

	Json marshal() {
		Json ob = Json.newObject();
		ob.add("type", type);
		ob.add("x", x);
		ob.add("y", y);
		ob.add("w", w);
		ob.add("h", h);
		return ob;
	}

	boolean amCoinBlock() {
		return true;
	}

	

	void pop_out_coin(Sprite that) {
		if(that.y + that.h >= this.y && that.prev_y + that.h <= this.y)// coming from the top
		{
			that.vert_vel = 0;
			that.y = this.y - that.h;
			that.frm_cnt = 0;
		}

		else if(that.y <= this.y + this.h && that.prev_y >= this.y + that.h) //coming from the bottom.
		{
			that.y = this.y + this.h -26;
			that.vert_vel = 1;
			coinsRemain -= 1;
			model.addCoin(x, y);
		}
			
		else if(that.x + that.w >= this.x && that.prev_x + that.w <= this.x) //coming in from the left
		{
			that.x = this.x - that.w;
		}

		else if( that.x <= this.x + this.w && that.prev_x >= this.x + this.w)
		{
			that.x = this.x + this.w;
		}
	}

	void draw(Graphics g) {
		if (coinsRemain == 0) {
			g.drawImage(coinblock_images[1], x - model.scrollPost, y, null);
		} else {
			g.drawImage(coinblock_images[0], x - model.scrollPost, y, null);
		}
	}
	boolean collides(Sprite that)
	{
		if (that.x + that.w <= this.x)
			return false;
		if (that.x >= this.x + this.w)
			return false;
		if (that.y + that.h <= this.y)
			return false;
		if (that.y >= this.y + this.h)
			return false;
		return true;
	}

	void update()
	{
		Iterator<Sprite> it = model.sprites.iterator();
		while(it.hasNext())
		{
			Sprite s = it.next();
			if(s.type == "Mario")
			{
				if(collides(s))
					pop_out_coin(s);	
			}
			if(s.type == "Coin")
			{

			}
		}

		if(coinsRemain <= 0)
			coinsRemain = 0;
	}
}
