package object;

import java.util.Timer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import logic.Player;
import logic.Sound;
import main.GamePanel;

public class SuperObject implements Interactable{
	public Image image;
	public String name;
	public boolean collision = false;
	public int worldX,worldY;
	long startTime = System.nanoTime();
	
	Sound sound = new Sound();

	// SET OBJECT RANGE
	public Rectangle solidArea = new Rectangle(0,0,64,64);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;

	public SuperObject() {
		
	}
	
	public void draw(GraphicsContext gc, GamePanel gp) {
		
		int screenX = worldX - gp.getPlayer().worldX + gp.getPlayer().screenX;
		int screenY = worldY - gp.getPlayer().worldY + gp.getPlayer().screenY;
		
		if (worldX + gp.getTileSize() > gp.getPlayer().worldX - gp.getPlayer().screenX && 
			worldX - gp.getTileSize() < gp.getPlayer().worldX + gp.getPlayer().screenX &&
			worldY + gp.getTileSize() > gp.getPlayer().worldY - gp.getPlayer().screenY &&
			worldY - gp.getTileSize() < gp.getPlayer().worldY + gp.getPlayer().screenY) {
			
			gc.drawImage(image, screenX, screenY , gp.getTileSize() , gp.getTileSize() );
		}
	}

	@Override
	public void interact(Player player) {
		
	}

}
