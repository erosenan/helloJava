package bonnie;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;

public class Grid {
	private Node[] grid;
	private int width;
	private int height;
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		grid = new Node[width * height];
		//Random rand = new Random();
		//int a;
		while(height > 0){
			height --;
			width = this.width;
			while(width > 0){
				width --;
				grid[height * this.height + width] = new Node(width, height, this);
				/*a = rand.nextInt(2);
				if(a == 1)
					grid[height * this.height + width].infect(new Germ());*/
				//System.out.println(width + ", " + height + " added");
			}
		}
		//System.out.println("grid set");
	}
	
	public Node getValue(int x, int y){
		//System.out.println("giving: (" + x + ", " + y + ")");
		//if(x < 0 || x >= width || y < 0 || y >= height)
		//	return null;
		return this.grid[(x + this.width) % this.width + (y + this.height) % this.height * this.width];
	}
	
	/*public void prepareNextTurn(){
		for(int i = 0; i < this.height * this.width; i ++)
			this.grid[i].determineLife();
	}*/
	
	public void nextTurn(){
		for(int i = 0; i < this.height * this.width; i ++)
			this.grid[i].spread();
		for(int i = 0; i < this.height * this.width; i ++)
			this.grid[i].nextTurn();
	}
	
	public void print(){
		for(int i = 0; i < this.height; i ++){
			for(int j = 0; j < this.width; j ++)
				System.out.print(this.getValue(j, i).isAlive() ? "[O]" : "[ ]");
			System.out.println();
		}
		System.out.println();
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

}
