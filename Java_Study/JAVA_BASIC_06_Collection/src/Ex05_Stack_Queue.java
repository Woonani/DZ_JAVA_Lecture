import java.util.Stack;

import kr.or.kosa.MyStack;

public class Ex05_Stack_Queue {

	public static void main(String[] args) {
		// JAVA API 제공하는 클래스
		// Javascript의 배열도 stack을 씀 : push와 pop 기능 똑같음!!
		
		// LIFO 
		Stack stack = new Stack(); 
		stack.push("A");
		stack.push("B");
		stack.push("C"); 
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		// C, B, A
		System.out.println(stack.empty()); // stack이 비어있는지 물어봄 //true
		
		// 동전케이스 , 핸드폰 화면(전환) , 연탄갈기 등 ..
		
		MyStack mystack = new MyStack(2);
		System.out.println(mystack.isEmpty());
		mystack.push(1);
		mystack.push(3);
		System.out.println(mystack.isEmpty());
		System.out.println(mystack.pop());
		System.out.println(mystack.isfull());
	}

}
