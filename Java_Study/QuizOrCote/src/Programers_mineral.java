
public class Programers_mineral {
	public static void main(String[] args) {
		int[] picks = new int[] {0,1,1};
//		int[] picks = new int[] {1, 3, 2};
		String[] minerals = new String[] {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
//		String[] minerals = new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		// TODO Auto-generated method stub

//		class Solution {
//		    public int solution(int[] picks, String[] minerals) {
		        int totalPickNo = 0;
		        for(int i : picks){
		            totalPickNo += i;
		        }
		        // 5개씩 끊어서 다이아 수가 많은거부터 다이아 곡괭이
		        
		        int l =(totalPickNo*5 > minerals.length) ? (int)((minerals.length+4)/5) : totalPickNo*5;
		        
		        int[][] mineral5each = new int[l][3]; // [앞에서부터 5개씩][다이아수, 철수, 돌수] 를 담을 것임
		        
		        for(int i=0; i<l;i++){
		            int dia=0; int iro = 0; int sto=0;
		            for(int j= i; j<i+5; j++){
		                try{
		                   if(minerals[j].equals("diamond")){
		                        dia += 1;
		                    }else if(minerals[j].equals("iron")){
		                        iro += 1;
		                    }else if(minerals[j].equals("ston")){
		                        sto += 1;
		                    }   
		                }catch(Exception e){
		                    continue;
		                }
		            }
		            if(i == 0) {			            	
			            mineral5each[i][0] = dia;  // 다이아
			            mineral5each[i][1] = iro;  // 철
			            mineral5each[i][2] = sto;  // 돌
		            }else {
		            	for(int k = 0; k<i; k++) {
		            		if(mineral5each[k][0] < mineral5each[i][0]) {
		            			int temp1 = mineral5each[k][0];
		            			mineral5each[k][0] = mineral5each[i][0];
		            			mineral5each[i][0] = temp1;
		            			int temp2 = mineral5each[k][1];
		            			mineral5each[k][1] = mineral5each[i][1];
		            			mineral5each[i][1] = temp2;
		            			int temp3 = mineral5each[k][2];
		            			mineral5each[k][2] = mineral5each[i][2];
		            			mineral5each[i][2] = temp3;
		            		}else if (mineral5each[k][0] == mineral5each[i][0]) {
		            			if(mineral5each[k][1] < mineral5each[i][1]) {
			            			int temp1 = mineral5each[k][0];
			            			mineral5each[k][0] = mineral5each[i][0];
			            			mineral5each[i][0] = temp1;
			            			int temp2 = mineral5each[k][1];
			            			mineral5each[k][1] = mineral5each[i][1];
			            			mineral5each[i][1] = temp2;
			            			int temp3 = mineral5each[k][2];
			            			mineral5each[k][2] = mineral5each[i][2];
			            			mineral5each[i][2] = temp3;
			            		}else if (mineral5each[k][1] == mineral5each[i][1]) {
			            			if(mineral5each[k][2] < mineral5each[i][2]) {
				            			int temp1 = mineral5each[k][0];
				            			mineral5each[k][0] = mineral5each[i][0];
				            			mineral5each[i][0] = temp1;
				            			int temp2 = mineral5each[k][1];
				            			mineral5each[k][1] = mineral5each[i][1];
				            			mineral5each[i][1] = temp2;
				            			int temp3 = mineral5each[k][2];
				            			mineral5each[k][2] = mineral5each[i][2];
				            			mineral5each[i][2] = temp3;
				            		}else if (mineral5each[k][0] == mineral5each[i][0]) {
				            			
				            		}
			            		}
		            		}
		            	}
		            }
		            
		            System.out.printf("%d, %d, %d \n",mineral5each[i][0],mineral5each[i][1],mineral5each[i][2]);
		        // 다이아 >> 철 >> 돌 순으로 정렬?
		            
		        }
		     // 다이아 수가 없으면 철 수로    /    다이아 곡괭이가 없으면 철곡괭이로 넘어가는 식
		        //다이아 곡괭이 쓸 경우 : 그냥 +( 5 )
		        //철 곡괭이 쓸 경우 : 다이아 수 * 25 + (남은 광물수)
		        //돌 곡괭이 쓸 경우 : 다이아 수 * 25 + 철 수*5 + (남은 광물 수)
		        

		        
		        int answer = 0;
//		        return answer;
		        System.out.println("answer : "+ answer);
//		    }
//		}
		
	}

}
