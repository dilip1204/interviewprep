package com.learn.thread;

import java.util.HashMap;
import java.util.Map;

public class Socksstest {
	
	public static void main(String[] args) {

		Integer in[]= {10, 20, 20 ,10, 10, 30, 50, 10, 20};
		Map<Integer, Integer> hm = new HashMap<>();
		int count=0;
		for(Integer in1:in) {
			if(hm.containsKey(in1)) {
				hm.put(in1, in1+1);
			}else {
				hm.put(in1, 1);
			}
			
		}
		
		for(Integer in1:hm.values()) {
			
			//System.out.println(in1+"  div============"+in1/2);
			System.out.println(in1+"  modulo============"+in1%2);
			/*if(in1%2==1) {
				System.out.println(in1+"  dilipki============"+count);
			}else {
				int c=count in1/2;
				System.out.println(in1+"  dilipki============"+ c+count+1);
			}*/
		}
		
		hm.forEach((k,v)-> System.out.println(k+"  "+ v));
	}
	
	
}
