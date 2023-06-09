package DI3;

import java.util.Scanner;

// ������ ����ϴ� Ŭ����
public class NewRecordView implements RecordView {
	// NewRecordView�� ������ �ޱ� ���ؼ� NewRecord�� �ʿ��մϴ�. 
	// ��� : ���� ** 
	
	private NewRecord record; // member field�� NewRecord ��ü�� �ּҸ� �����ڴ�.
	// NewRecord ��ü�� �ּҸ� �ʿ信 ���� ���� �ް� �־��
	// NewRecordView ��������ٰ� �ؼ� ������ record�� NewRecord ���� �ʿ�� �����.
	
	// ============���� ����================
	// ���� �Լ� 
//	public void setRecord(NewRecord record) {
	public void setRecord(Record record) { // interface ����ؼ� ������(�θ�Ÿ��)
		this.record = (NewRecord) record; // �ڽ�Ÿ������ �ٿ�ĳ���� �ؾ���
	}
	/*
	 	���� �ϰ� �ʿ���
	 	���� ���� ��ü [�ּ�]�� �ʿ���
	 	
	 	1. �����ڸ� ���ؼ� �ʿ��� ��ü�� ���� �Ǵ� ���� > DI > ����, ���� (���ԵǸ� ���տ���)
	 	2. �Լ�(setter)�� ���ؼ� �ʿ��� ��ü�� ���� > DI > ���� > �ʿ信 ���� 
	 	
	 */
	
	@Override
	public void print() {
		System.out.println(record.total() + " / " +record.avg());
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("kor");
		record.setKor(Integer.parseInt(sc.nextLine()));
		System.out.println("eng");
		record.setEng(Integer.parseInt(sc.nextLine()));
		System.out.println("math");
		record.setMath(Integer.parseInt(sc.nextLine()));
		
	}

}