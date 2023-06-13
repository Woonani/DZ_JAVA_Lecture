package AOP_Basic_02_Java;

public interface Calc {
	//proxy객체가 인터페이스만 받는다고??
	int ADD(int x, int y);
	int MUL(int x, int y);
	int SUB(int x, int y);
}
