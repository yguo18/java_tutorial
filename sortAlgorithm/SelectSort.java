package cn.sortAlgorithm;

import java.util.Scanner;

public class SelectSort {

	public static void main(String[] args) {
		System.out.print("���������֣��Կո������\n");
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int[] arr = new int[s.length];
		for (int i=0; i<s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
//		int[] arr = {1,2,4,3,0};
		System.out.println("����ǰ��");
		display(arr);
		sort(arr);
	}
	public static void sort(int[] arr){
		int index=0,tmp;
		int min;
		for(int i=0; i<arr.length-1; i++){
			min = arr[i]; // �ӵ�ǰλ�ÿ�ʼ���������Ƚϣ���¼��С����
			index = i;  // ��¼��ǰ������
			for(int j=i+1; j<arr.length; j++){
				if(min>arr[j]){
					min = arr[j];  // ��¼��С����������¼����
					index = j;
				}
			}
			if(index != i){     // ����С�����뵱ǰ��ʼ�Ƚϵ�λ��������
				tmp = arr[i];
				arr[i] = arr[index];
				arr[index] = tmp;
			}
		}
		System.out.println("�����");
		display(arr);
	}
	public static void display(int[] arr){  // ��ʾ����
		for(int b:arr){
			System.out.print(b+" ");
		}
		System.out.println();
	}

}
