package cn.sortAlgorithm;

public class BubbleSort extends Object{
	public static void main(String[] args){
		int[] data = {1,3,5,12,2,9,0};
		System.out.println("����ǰ��");
		display(data);
		sort(data);
	}
	public static void sort(int[] arr){
		int tmp;
		for(int i=arr.length-1; i>0; i--){  //��¼����
			int flag = 0;
			for(int j=0; j<i; j++){
				if(arr[j]>arr[j+1]){
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					flag++;
				}
			}
			if(flag == 0){
				break;
			}
		}
		//��ʾ����
		System.out.println();
		System.out.println("�����");
		display(arr);
	}
	public static void display(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
}
