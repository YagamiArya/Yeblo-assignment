package com.yebelo.service;

public class Service {
	
	
	public int findSum(int n) {
		//returns sum      
		//if number is not equal to 0 then execute code after colon (:), else print 0    
		//the method findSum() is recursively called  
		return n == 0 ? 0 : n % 10 +findSum(n/10) ;  
		
	}

//	public static void main(String[] args) {
//		
//		int num = nextNum(28);
//		System.out.println(num);
//		
//	}

	public int nextNum(int n) {
		int num=n;
		for(int i=num+1;i<100000;i++) {
			int sum = findSum(i);
			if(sum==1||sum==10||sum==100||sum==1000) {
				num = i;
				return num;
			}
		}
		return 0;
		
	}

}
