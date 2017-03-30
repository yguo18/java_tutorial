package cn.sortAlgorithm;

import java.util.Vector;

public class test {

	public static void main(String[] args) {
		boolean[] gene = new boolean[10];
		for(int i=0; i<gene.length; i++){
			boolean m = Math.random()>=0.5;
//			System.out.println(m);
			gene[i] = m;
		}
		for(boolean b : gene) {
			System.out.print(b+" ");
		}
		System.out.println();
//		if(gene == null){
//			return;
//		}
		int m1 = getNum(gene);
		System.out.println(m1);
		// mutation
		int number = 3; //变异基因的个数
		for(int i=0; i<number; i++){
			int at = (int) (Math.random()*gene.length) % gene.length;
			boolean bool = !gene[at];
			gene[at] = bool;
		}
		for(boolean b : gene) {
			System.out.print(b+" ");
		}
		System.out.println();
		int m2 = getNum(gene);
		System.out.println(m2);
		
		Vector<Integer> a = new Vector<>();
		a.add(1);
		a.add(3);
		System.out.println(a.elementAt(1));
		
	}
	public static int getNum(boolean[] gene){
		int num = 0;
		for (boolean b : gene) {
			num <<= 1 ;
			//System.out.println(num);
			if(b){
				num += 1;
			}
		}
		return num;
	}
}
