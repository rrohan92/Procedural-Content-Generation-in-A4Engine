
public class TwoDTile 
{
	int width, height;
	int constraints [] = new int[4];			//left, up, right and down
	int pattern [][] = new int [width][height];
	
	TwoDTile(int width, int height, int pattern[][], int constraints[])
	{
		this.width = width;
		this.height = height;
		this.pattern = pattern;
		this.constraints = constraints;
	}
}
