import java.util.ArrayList;

public class Level {
	public ArrayList<Platform> platforms;
	private int level;
	public int backx_one = 0;
	public int backx_two = 1250;
	private Protagonist bb8;
	
	public ArrayList<Enemy> enemies;
	
	public int getBackx_one() {
		return backx_one;
	}

	public void setBackx_one(int backx_one) {
		this.backx_one = backx_one;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public int getBackx_two() {
		return backx_two;
	}

	public void setBackx_two(int backx_two) {
		this.backx_two = backx_two;
	}
	
	private int getNewY(Platform oldplat, int variance) {
		int newY;
		
		if ((oldplat.getY() + variance) > (GameFrame.HEIGHT - 150)) {	// make next platform higher if they are near screen bottom
			newY = oldplat.getY() - variance;
		} else if ((oldplat.getY() - variance) < 200) {	// make next platform lower if they are near screen top
			newY = oldplat.getY() + variance;
		} else {	// else randomly decide whether next platform is higher or lower
			int random = (int) (Math.random()* 2);
			if (random == 1) {
				newY = oldplat.getY() - variance;
			} else {
				newY = oldplat.getY() + variance;
			}
		}
		
		return newY;
	}
	
	private int getNewX(Platform oldplat, int farX) {
		int newX;
		newX = farX + (int) ( oldplat.getCollisionBox().getMaxX() );
		return newX;
	}
	
	public Level(int level) {
		
		this.level = level;
		backx_one = 0;
		backx_two = 1250;
		platforms = new ArrayList<Platform>();
		enemies = new ArrayList<Enemy>();
		
		if (level == 1)
		{
			Platform firstplat = new Platform(1, 540, 10);
			platforms.add(firstplat);
			Platform secondplat = new Platform(700, 540);
			platforms.add(secondplat);
	
			int farX = 750;
			Platform oldplat = secondplat;
			
			int variance = 80;
			
			for(int i = 0; i < 25; i++){
				if (i>1)
				{
					oldplat = platforms.get(i-1);
					int newX = farX + (64*oldplat.getNumBlocks());
					int newY = getNewY(oldplat, variance);
					
					Platform platter = new Platform(newX, newY);
					platforms.add(platter);
					
					farX = newX + 50;
				} 
			}
			
			//add goal platform
			int goalY = getNewY(oldplat, variance);
			int goalX = farX + (64*oldplat.getNumBlocks());
			
			Platform goalPlat = new Platform(goalX, goalY);
			goalPlat.setEnd(true);
			platforms.add(goalPlat);
			
		}
		
		if (level == 2)
		{
			Platform firstplat = new Platform(1, 540, 10);
			platforms.add(firstplat);
			Platform secondplat = new Platform(700, 540);
			platforms.add(secondplat);
	
			int farX = 750;
			Platform oldplat = secondplat;
			
			int variance = 100;	// variance increased for level 2
			
			for(int i = 0; i < 35; i++){
				if (i>1)
				{
					oldplat = (Platform) platforms.get((i-1));
					int newX = farX + (64*oldplat.getNumBlocks());
					int newY = getNewY(oldplat, variance);
					
					Platform platter = new Platform(newX, newY);
					platforms.add(platter);
					
					farX += (64*oldplat.getNumBlocks())+25;
					
				} 
				
			}
			
			//add goal platform
			int goalY = getNewY(oldplat, variance);
			int goalX = farX + (64*oldplat.getNumBlocks());
			
			Platform goalPlat = new Platform(goalX, goalY);
			goalPlat.setEnd(true);
			platforms.add(goalPlat);
		}
		
		if (level == 3)
		{
			
			Platform firstplat = new Platform(1, 540, 10);
			platforms.add(firstplat);
			Platform secondplat = new Platform(700, 540);
			platforms.add(secondplat);
	
			int farX = 750;
			Platform oldplat = secondplat;
	

			int variance = 120; //variance increased for level 3
			
			for(int i = 0; i < 50; i++){
				if (i>1)
				{
					oldplat = (Platform) platforms.get((i-1));
					int newX = farX + (64*oldplat.getNumBlocks());
					int newY = getNewY(oldplat, variance);
					
					Platform platter = new Platform(newX, newY);
					platforms.add(platter);
					
					farX += (64*oldplat.getNumBlocks())+25;
				}
			}
			
			//add goal platform
			int goalY = getNewY(oldplat, variance);
			int goalX = farX + (64*oldplat.getNumBlocks());
			
			Platform goalPlat = new Platform(goalX, goalY);
			goalPlat.setEnd(true);
			platforms.add(goalPlat);
		
		}
		
	}
	
	public void addEnemy() {
		int random = (int)(Math.random()*75+1);
		if (random == 75)	{
			Enemy enemy = new Enemy(bb8);
			enemy.setDiffY(level-1);
			enemies.add(enemy);
		}
	}

	public ArrayList<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(ArrayList<Platform> platforms) {
		this.platforms = platforms;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void addProtagonist(Protagonist bb8) {
		this.bb8=bb8;
	}
}
