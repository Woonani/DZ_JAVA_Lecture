
public class Ex07_Lotto_Quiz {

	public static void main(String[] args) {
//		for(int z=0; z<8; z++) {
			
		
		int[] numList = new int[6];
		
		for(int i =0; i<6; i++) {
			int num = (int) (Math.random()*45 +1);
			numList[i] = num;
			
			for(int j=0;j<i;j++) {
				if(numList[i] == numList[j]) {
				i--;
				break;
				}
			}
//			System.out.printf("random[%d] : %d \n",i, numList[i]);
					
				
				
				
		}
			
		for(int j=0; j<numList.length; j++) {
			for(int k=numList.length-1; k>j; k--) {
				if(numList[k]<numList[k-1]) {
					int t = numList[k];
					numList[k] = numList[k-1];
					numList[k-1]=t;
				}
				
			}
			System.out.printf("lotto[%d] : %d \n",j, numList[j]);
//			System.out.printf(" %d, ", numList[j]);
		}	
		
		System.out.println();
	}
//	}
	

}

