package cn.distance;


class Adjacency{
	final int INFINITE = 99999;
	public int[][] Graph_Matrix;
	//constructed function
	public Adjacency(int[][] Weight_Path, int number){
		int Start_Point, End_Point;
		Graph_Matrix = new int[number][number];
		for(int i = 0; i < Graph_Matrix.length; i++)
			for(int j = 0; j < Graph_Matrix.length; j++){
				if(i != j)
					Graph_Matrix[i][j] = INFINITE;
				else {
					Graph_Matrix[i][j] = 0;
				}
			}
		for(int i = 0; i < Weight_Path.length; i++){
			Start_Point = Weight_Path[i][0];
			End_Point = Weight_Path[i][1];
			Graph_Matrix[Start_Point][End_Point] = Weight_Path[i][2];
		}
	}
	public void printGraph_Matrix(){
		for(int i = 1; i < Graph_Matrix.length; i++){
			for(int j = 1; j < Graph_Matrix.length; j++){
				if (Graph_Matrix[i][j] == INFINITE)
					System.out.print(" X ");
				else
					System.out.print(" "+Graph_Matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
class Dijkstra extends Adjacency{
	private int[] cost;
	private int[] visited;
	public Dijkstra(int[][] Weight_Path, int number){
		super(Weight_Path, number);
		cost = new int[number];
		visited = new int[number];
		for(int i = 1; i < number; i++){
			visited[i] = 0;
		}
	}
	public void shortPath(int source){
		int shortDistance; 
		int shortVertex = source;
		for(int i = 1; i < Graph_Matrix.length; i++)
			cost[i] = Graph_Matrix[source][i];
		visited[source] = 1;
		for(int i = 1; i < Graph_Matrix.length-1; i++){
			shortDistance = INFINITE;
			for(int j = 1; j < Graph_Matrix.length; j++){
				if(shortDistance > cost[j] && visited[j] == 0){
					shortDistance = cost[j];
					shortVertex = j;
				}
			}
			visited[shortVertex] = 1;
			for(int j = 1; j < Graph_Matrix.length; j++){
				if(visited[j] == 0 && cost[j] > cost[shortVertex] + Graph_Matrix[shortVertex][j])
					cost[j] = cost[shortVertex] + Graph_Matrix[shortVertex][j];
			}
		}
		System.out.println("====================");
		System.out.println("顶点"+source+"到各顶点的最短距离的最终结果");
		System.out.println("====================");
		for(int i = 1; i < Graph_Matrix.length; i++){
			System.out.println("顶点"+source+"到顶点"+i+"的最短距离 = " + cost[i]);
		}
	}
}
public class Test01Dijkstra {

	public static void main(String[] args) {
		int[][] Weight_Path = {{1,2,10},{2,1,10},{2,3,29},{2,4,23},{4,2,6},{3,5,10},{4,5,21},{4,6,78},{5,6,34}};
		Dijkstra dijkstra = new Dijkstra(Weight_Path, 7);
		dijkstra.shortPath(4);
	}

}
