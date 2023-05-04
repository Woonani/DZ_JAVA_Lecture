package BeackJoon;
// 위에꺼 빼고

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
/*
 
  import java.util.*;
class Main{
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a+b);
    }
}	
  
 */
class Main{
/* 메모리 초과
 public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String obj = br.readLine();
    	String bomb = br.readLine();
    	while(obj.contains(bomb)) {
    		obj = obj.replace(bomb, "");
    	}
    	String answer = (obj.length() == 0)? "FRULA":obj ;
    	bw.write(answer);
        bw.flush();
        bw.close();
    }
 */
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String[] obj = br.readLine().split("");
    	String[] bomb = br.readLine().split("");
    	
    	
    	
    	String answer="";
    	bw.write(answer);
        bw.flush();
        bw.close();
    }
    
    
    
//}   // 끝라인
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void catIsCute() throws IOException {
//    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str," ");
//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());
//		
//		System.out.println(a-b);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());
		/*
		\    /\ 
		 )  ( ')
		(  /  )
		 \(__)|
    	StringBuilder sb = new StringBuilder();
    	sb.append("|\\_/|").append("/n");
    	System.out.println(sb.toString());
		 */
		StringBuilder sb = new StringBuilder();
		
		System.out.println();
		sb.append(" \\    /\\ ").append("\n");
		sb.append("  )  ( ')").append("\n");
		sb.append(" (  /  )").append("\n");
		sb.append("  \\(__)|").append("\n");
		System.out.println(sb.toString());
		
//		sb.append("|\\_/|").append("\n");
//		sb.append("|q p|   /}").append("\n");
//		sb.append("( 0 )\"\"\"\\").append("\n");
//		sb.append("|\"^\"`    |").append("\n");
//		sb.append("||_/=\\\\__|");
//		System.out.println(sb.toString());
		
		
    }
}	
