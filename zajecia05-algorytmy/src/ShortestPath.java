import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ShortestPath {

	public static void main(String[] args) {
		int[][] stage = {
				{0,1,0,0,1,0,0,0,1,0,0,0,1},//
				{0,1,0,0,1,0,0,0,0,0,0,0,0},//
				{0,1,0,0,1,0,0,0,0,0,0,0,0},//
				{0,0,0,0,0,0,0,1,0,1,0,1,0},//
				{0,1,0,0,0,0,0,1,0,0,1,0,0},//
				{0,1,1,1,1,1,0,1,0,0,0,0,0},//
				{0,0,0,0,0,0,0,1,0,0,1,0,0},//
		};
		
		int[][] stage2 = {
				{0,1,0,1,0},
				{0,1,0,1,1},
				{0,0,0,0,0},
				{0,1,0,1,0},
				{0,1,0,1,0},
				
		};
		
		List<Point> path  = findPath(stage2);
		System.out.println("koniec");
		//System.out.println(neighbours(6, 0, stage2));

	}

	private static List<Point> findPath(int[][] stage) {
		int startX = 0;
		int startY=0;
		
		int endX = stage.length-1;
		int endY = stage[stage.length-1].length-1;
		
		List<Point> neighbours = neighbours(startX, startY, stage);
		int index = 100;
		while(!neighbours.isEmpty()){
			//wszystkim z listy nadaje nr: index
			//szukam sasiadow, sasiadow
			List<Point> all = new ArrayList<>();
			for(Point p: neighbours){
				stage[p.x][p.y] = index;
				all.addAll(neighbours(p.x,p.y,stage));
				System.out.print(p + " ");
			}
			index++;
			System.out.println();
			neighbours = all;
			//if ()
			//jezeli sasiade zawieraja punkt ndx endy to koniec szukania.
		}
		
		return null;
	}
	
	static List<Point> neighbours(int x, int y, int[][] stage) {
		List<Point> findedNiehgbours = new ArrayList<Point>();
		Point start = new Point(x, y);
		
		if (x-1 >= 0 && stage[x-1][y]==0) {
			findedNiehgbours.add(new Point(start.x-1,start.y));
		}
		if (x+1 <= stage.length-1 && stage[start.x+1][start.y] == 0 ) {
			findedNiehgbours.add(new Point(start.x+1,start.y));
		}
		if (y-1 >= 0 && stage[start.x][start.y-1] == 0 ) {
			findedNiehgbours.add(new Point(start.x,start.y-1));
		}
		if (y+1 <= stage[stage.length-1].length-1 && stage[start.x][start.y+1] == 0 ) {
			findedNiehgbours.add(new Point(start.x,start.y+1));
		}
		
		return findedNiehgbours;
	}
	

}
