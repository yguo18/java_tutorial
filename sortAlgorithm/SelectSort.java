package cn.sortAlgorithm;

import java.util.Scanner;

public class SelectSort {

	public static void main(String[] args) {
		System.out.print("请输入数字，以空格隔开：\n");
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int[] arr = new int[s.length];
		for (int i=0; i<s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
//		int[] arr = {1,2,4,3,0};
		System.out.println("排序前：");
		display(arr);
		sort(arr);
	}
	public static void sort(int[] arr){
		int index=0,tmp;
		int min;
		for(int i=0; i<arr.length-1; i++){
			min = arr[i]; // 从当前位置开始与后面的数比较，记录最小的数
			index = i;  // 记录当前的索引
			for(int j=i+1; j<arr.length; j++){
				if(min>arr[j]){
					min = arr[j];  // 记录最小的数，并记录索引
					index = j;
				}
			}
			if(index != i){     // 把最小的数与当前开始比较的位置做交换
				tmp = arr[i];
				arr[i] = arr[index];
				arr[index] = tmp;
			}
		}
		System.out.println("排序后：");
		display(arr);
	}
	public static void display(int[] arr){  // 显示数组
		for(int b:arr){
			System.out.print(b+" ");
		}
		System.out.println();
	}

}
