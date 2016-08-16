import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class mapGenerator 
{
	public final int WALL = 1;
	public final int OPEN = 0;

	public final int LEFT = 0;
	public final int UP = 1;
	public final int RIGHT = 2;
	public final int DOWN = 3;

	public List<TwoDTile> createTiles()
	{
		List<TwoDTile> tiles = new ArrayList<TwoDTile>();

		TwoDTile t1 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{1,0,0},
				{1,1,1}}, 
				new int[]{WALL, WALL, OPEN, WALL});

		TwoDTile t2 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{0,0,1},
				{1,1,1}}, 
				new int[]{OPEN, WALL, WALL, WALL});

		TwoDTile t3 = new TwoDTile(3, 3, new int[][]{{1,0,1},
				{1,0,1},
				{1,1,1}}, 
				new int[]{WALL, OPEN, WALL, WALL});

		TwoDTile t4 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{1,0,1},
				{1,0,1}}, 
				new int[]{WALL, WALL, WALL, OPEN});

		TwoDTile t5 = new TwoDTile(3, 3, new int[][]{{0,0,0},
				{0,0,0},
				{0,0,0}}, 
				new int[]{OPEN, OPEN, OPEN, OPEN});

		TwoDTile t6 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{1,1,1},
				{1,1,1}}, 
				new int[]{WALL, WALL, WALL, WALL});

		TwoDTile t7 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{1,0,0},
				{1,0,0}},
				new int[]{WALL, WALL, OPEN, OPEN});

		TwoDTile t8 = new TwoDTile(3, 3, new int[][]{{1,0,0},
				{1,0,0},
				{1,1,1}},
				new int[]{WALL, OPEN, OPEN, WALL});

		TwoDTile t9 = new TwoDTile(3, 3, new int[][]{{1,0,1},
				{1,0,1},
				{1,0,1}},
				new int[]{WALL, OPEN, WALL, OPEN});

		TwoDTile t10 = new TwoDTile(3, 3, new int[][]{{0,0,1},
				{0,0,1},
				{1,1,1}},
				new int[]{OPEN, OPEN, WALL, WALL});

		TwoDTile t11 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{0,0,0},
				{1,1,1}},
				new int[]{OPEN, WALL, OPEN, WALL});

		TwoDTile t12 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{0,0,1},
				{0,0,1}},
				new int[]{OPEN, WALL, WALL, OPEN});

		TwoDTile t13 = new TwoDTile(3, 3, new int[][]{{1,0,0},
				{1,0,0},
				{1,0,0}},
				new int[]{WALL, OPEN, OPEN, OPEN});

		TwoDTile t14 = new TwoDTile(3, 3, new int[][]{{1,1,1},
				{0,0,0},
				{0,0,0}},
				new int[]{OPEN, WALL, OPEN, OPEN});

		TwoDTile t15 = new TwoDTile(3, 3, new int[][]{{0,0,1},
				{0,0,1},
				{0,0,1}},
				new int[]{OPEN, OPEN, WALL, OPEN});

		TwoDTile t16 = new TwoDTile(3, 3, new int[][]{{0,0,0},
				{0,0,0},
				{1,1,1}},
				new int[]{OPEN, OPEN, OPEN, WALL});

		tiles.add(t1);
		tiles.add(t2);
		tiles.add(t3);
		tiles.add(t4);
		tiles.add(t5);
		tiles.add(t6);
		tiles.add(t7);
		tiles.add(t8);
		tiles.add(t9);
		tiles.add(t10);
		tiles.add(t11);
		tiles.add(t12);
		tiles.add(t13);
		tiles.add(t14);
		tiles.add(t15);
		tiles.add(t16);

		return tiles;
	}

	public List<TwoDTile> candidateTiles(TwoDTile map[][], int x, int y, List<TwoDTile> tiles, int width, int height)
	{
		List<TwoDTile> candidates = new ArrayList<TwoDTile>();

		if(x == 0 && y == 0)					//Origin
		{
			for(int i=0; i<tiles.size(); i++)
			{
				if(tiles.get(i).constraints[LEFT] == WALL && tiles.get(i).constraints[UP] == WALL)
					candidates.add(tiles.get(i));
			}
		}

		else if(y == 0 && x > 0)				//Top row
		{
			for(int i=0; i<tiles.size(); i++)
			{
				if(map[x-1][y].constraints[RIGHT] == WALL && tiles.get(i).constraints[LEFT] == WALL && 
						tiles.get(i).constraints[UP] == WALL)
					candidates.add(tiles.get(i));

				else if(map[x-1][y].constraints[RIGHT] == OPEN && tiles.get(i).constraints[LEFT] == OPEN &&
						tiles.get(i).constraints[UP] == WALL)
					candidates.add(tiles.get(i));
			}
		}

		else if(x == 0 && y > 0)				//Left column
		{
			for(int i=0; i<tiles.size(); i++)
			{
				if(map[x][y-1].constraints[DOWN] == WALL && tiles.get(i).constraints[UP] == WALL &&
						tiles.get(i).constraints[LEFT] == WALL)
					candidates.add(tiles.get(i));

				else if(map[x][y-1].constraints[DOWN] == OPEN && tiles.get(i).constraints[UP] == OPEN &&
						tiles.get(i).constraints[LEFT] == WALL)
					candidates.add(tiles.get(i));
			}
		}

		else if(x == width-1 && y > 0)			//Right column
		{
			for(int i=0; i<tiles.size(); i++)
			{
				if(map[x][y-1].constraints[DOWN] == WALL && tiles.get(i).constraints[UP] == WALL &&
						tiles.get(i).constraints[RIGHT] == WALL)
					candidates.add(tiles.get(i));

				else if(map[x][y-1].constraints[DOWN] == OPEN && tiles.get(i).constraints[UP] == OPEN &&
						tiles.get(i).constraints[RIGHT] == WALL)
					candidates.add(tiles.get(i));
			}
		}

		else if(y == height - 1 && x > 0)     //Bottom row
		{
			for(int i=0; i<tiles.size(); i++)
			{
				if(map[x-1][y].constraints[RIGHT] == WALL && tiles.get(i).constraints[LEFT] == WALL &&
						tiles.get(i).constraints[DOWN] == WALL)
					candidates.add(tiles.get(i));

				else if(map[x-1][y].constraints[RIGHT] == OPEN && tiles.get(i).constraints[LEFT] == OPEN &&
						tiles.get(i).constraints[DOWN] == WALL)
					candidates.add(tiles.get(i));
			}
		}

		else											//Other cases
		{
			for(int i=0; i<tiles.size(); i++)
			{
				if(map[x-1][y].constraints[RIGHT] == WALL  && tiles.get(i).constraints[LEFT] == WALL
						&& map[x][y-1].constraints[DOWN] == WALL && tiles.get(i).constraints[UP] == WALL)
					candidates.add(tiles.get(i));

				else if(map[x-1][y].constraints[RIGHT] == OPEN  && tiles.get(i).constraints[LEFT] == OPEN
						&& map[x][y-1].constraints[DOWN] == OPEN && tiles.get(i).constraints[UP] == OPEN)
					candidates.add(tiles.get(i));

				else if(map[x-1][y].constraints[RIGHT] == WALL  && tiles.get(i).constraints[LEFT] == WALL
						&& map[x][y-1].constraints[DOWN] == OPEN && tiles.get(i).constraints[UP] == OPEN)
					candidates.add(tiles.get(i));

				else if(map[x-1][y].constraints[RIGHT] == OPEN  && tiles.get(i).constraints[LEFT] == OPEN
						&& map[x][y-1].constraints[DOWN] == WALL && tiles.get(i).constraints[UP] == WALL)
					candidates.add(tiles.get(i));
			}
		}

		return candidates;

	}

	public TwoDTile[][] generateMap(int width, int height, List<TwoDTile> tiles)
	{
		TwoDTile map [][] = new TwoDTile[width][height];

		for (int y=0; y<height; y++)
		{
			for(int x=0; x<width; x++)
			{
				List<TwoDTile> candidates = candidateTiles(map, x, y, tiles, width, height);
				map[x][y] = candidates.get(new Random().nextInt(candidates.size()));
			}
		}

		return map;
	}


	public void output(TwoDTile map[][], int width, int height) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter("mymap.tmx", "UTF-8");

		writer.println("<?xml" + " " + "version=" + "\"1.0\"" + " " + "encoding=" + "\"UTF-8\"" + "?>");

		writer.println("<map version=" + "\"1.0\"" + " " + "orientation=" +
				"\"orthogonal\"" + " " +  "width=" + "\"" + width + "\"" + " " + "height=" + "\"" + height+ "\"" + " " + "tilewidth=" + "\"64\"" 
				+ " " + "tileheight=" + "\"64\"" + " " + "renderorder=" + "\"left-up\"" + ">");

		writer.println(" <properties>");

		writer.println("  <property name=" + "\"name\"" + " " + "value=" + "\"Blackrock\"" + "/>" );

		writer.println(" </properties>");

		writer.println(" <tileset firstgid=" + "\"1\"" + " " + "name=" + "\"graphics\"" +" "
				+ "tilewidth=" + "\"64\"" + " " + "tileheight=" + "\"64\"" + ">");

		writer.println(" <image source=" + "\"graphics2x-basic.png\"" + " " +
				"width=" + "\"640\"" + " " + "height=" + "\"1344\"" + "/>");

		writer.println(" </tileset>");

		writer.println(" <tileset firstgid=" + "\"211\"" + " " + "name=" + "\"walls\"" +" "
				+ "tilewidth=" + "\"64\"" + " " + "tileheight=" + "\"64\"" + ">");

		writer.println(" <image source=" + "\"graphics2x-walls.png\"" + " " +
				"width=" + "\"128\"" + " " + "height=" + "\"1024\"" + "/>");

		writer.println(" </tileset>");

		writer.println(" <layer name=" + "\"Tile Layer\"" + " " + 
				"width=" + "\"" + width + "\"" + " " + "height=" + "\"" + height+ "\"" + ">");

		writer.println("  <data>");
	
		
		int lowlevel[][] = new int[width*3][height*3];
		
		
		for(int y = 0; y < height; y++)
		{
			for(int x=0; x < width; x++)
			{
				for(int i=0; i<3; i++)
				{
					for(int j=0; j<3; j++)
					{						
						if(map[x][y].pattern[i][j] == 1)
							lowlevel[x*3+j][y*3+i] = 213;
						else
							lowlevel[x*3+j][y*3+i] = 1;
					}

				}
			}
		}
		for(int i=0; i<height*3; i++)
		{
			for(int j=0; j<width*3; j++)
			{						
				writer.println("   <tile gid=" + "\""+lowlevel[j][i]+"\"" + "/>");
			}

		}

		writer.println("  </data>");
		writer.println(" </layer>");
		writer.println("</map>");

		writer.close();
	}

	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException
	{
		mapGenerator mg = new mapGenerator();
		List<TwoDTile> tiles = mg.createTiles();
		TwoDTile map [][] = mg.generateMap(10, 5, tiles);
		mg.output(map, 10, 5);
	}
}
