package cn.distance;


class Adjacency1{
	 final int INTINITE = 99999;
	 public int[][] Graph_Matrix;
	 // construct function
	 public Adjacency1(int[][] Weight_Path, int number){
		 int Start_Point, End_Point;
		 Graph_Matrix = new int[number][number];
		 for(int i = 1; i <Graph_Matrix.length; i++)
			 for(int j = 1; j < Graph_Matrix.length; j++)
				 if (i == j)
					 Graph_Matrix[i][j] = 0;
				 else
					 Graph_Matrix[i][j] = INTINITE;
		 for(int i = 0; i < Weight_Path.length; i++){
			 Start_Point = Weight_Path[i][0];
			 End_Point = Weight_Path[i][1];
			 Graph_Matrix[Start_Point][End_Point] = Weight_Path[i][2];
			 Graph_Matrix[End_Point][Start_Point] = Weight_Path[i][2];
		 }
	 }
	 public void printGraph_Matrix(){
		 for (int i = 1; i < Graph_Matrix.length; i++){
			 for (int j = 1; j < Graph_Matrix.length; j++){
				 if (Graph_Matrix[i][j] == INTINITE)
					 System.out.print(" X ");
				 else {
					System.out.print(" "+Graph_Matrix[i][j]+" ");
				}
			 }
			 System.out.println();
		 }
	 }
}

class Floyd extends Adjacency1{
	private int[][] cost;
	private int capcity;
	public Floyd(int[][] Weight_Path, int number){
		super(Weight_Path, number);
		cost = new int[number][];
		capcity = Graph_Matrix.length;
		for (int i = 0; i < capcity; i++){
			cost[i] = new int[number];
		}
	}
	public void shortPath(){
		for(int i = 1; i < Graph_Matrix.length; i++)
			for(int j = 1; j < Graph_Matrix.length; j++)
				cost[i][j] = cost[j][i] = Graph_Matrix[i][j];
		for(int k = 1; k < Graph_Matrix.length; k++)
			for(int i = 1; i < Graph_Matrix.length; i++)
				for(int j = 1; j < Graph_Matrix.length; j++)
					if(cost[i][k] + cost[k][j] < cost[i][j])
						cost[i][j] = cost[i][k] + cost[k][j];
		System.out.print("point ");
		for(int i = 1; i < Graph_Matrix.length; i++)
			System.out.print(" vex"+i);
		System.out.println();
		for (int i = 1; i < Graph_Matrix.length; i++){
			System.out.print("vex"+i+" ");
			for(int j = 1; j < Graph_Matrix.length; j++){
				System.out.print(" "+cost[i][j]+" ");
			}
			System.out.println();
		}
			
	}
}

public class Test02Floyd {

	public static void main(String[] args) {
		int[][] Weight_Path = {{1,2,10},{2,1,10},{2,3,29},{2,4,23},{4,2,6},{3,5,10},{4,5,21},{4,6,78},{5,6,34}};
		Floyd floyd = new Floyd(Weight_Path, 7);
		floyd.shortPath();
	}

}
