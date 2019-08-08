package com.algo;

public class ReplaceZeroIndexes {

	static int count = 0;
	static int i = 0;
	static int j = 0;
	public static  void findindex(int[] ip ,int startindex){

		int size = 0;
		int de = startindex;
		int dV = 0;
		if(ip[de] == 0){
			i = de;
			dV = 1;
			while(startindex < ip.length){

				if(ip[startindex] == 0){
					if (dV == 1){
						size ++;
						j =startindex;
						startindex++;
					} else {
						if(size > count ){

						}
					}
				}  else {
					dV = 0;
				}


			}


		}




	}
}
