package com.saurabh.dada.iq.impl.iq.quikr;

public class RobotCircularPath {

	//http://www.geeksforgeeks.org/check-if-a-given-sequence-of-moves-for-a-robot-is-circular-or-not/
	public static void main(String[] args) {
		String s = "GRGL";
		System.out.println(circle(s));
	}
	
	public static String circle(String commands){
		StringBuilder sb = new StringBuilder(commands);
		String str = "NO";
		int x=0;
		int y=0;
		int dir=0;
		
/*		if(!commands.contains("G"))
			return str;*/
		/*if(commands.length()<8){
			do
				sb.append(commands);
			while(sb.length()<8);
		}
		System.out.println(sb);*/
		char[] path = sb.toString().toCharArray();
		for (int i = 0; i < path.length; i++) {
			char move = path[i];
			if (move == 'R')
				dir = (dir + 1) % 4;
			else if (move == 'L')
				dir = (4 + dir - 1) % 4;
			else {
				if (dir == 0)
					y++;
				else if (dir == 1)
					x++;
				else if (dir == 2)
					y--;
				else
					//dir == 3
					x--;
			}
			System.out.println("x:"+x+" y:"+y+" c:" + move);
			if(x==0&&y==0)
				return "YES";
		}
		return str;
	}

}
