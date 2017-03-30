package cn.sortAlgorithm;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 2, 0};
		System.out.println("≈≈–Ú«∞");
		display(arr);
		System.out.println("≈≈–Ú∫Û");
		sort(arr);
	}
	public static void sort(int[] arr){
		int tmp;
		for(int i=1; i<arr.length; i++){
			tmp = arr[i];
			for(int j=0; j<i; j++){
				if(tmp<arr[j]){
					for(int k=i; k>j; k--)
						arr[k] = arr[k-1];
					arr[j] = tmp;
					break;
				}
			}
		}
		display(arr);
	}
	public static void display(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
