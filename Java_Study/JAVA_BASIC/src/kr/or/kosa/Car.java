package kr.or.kosa;

// class == 설계도 == 타입
public class Car { 
	//car에 접근하려면 kr.or.kosa 통해 들어와야함
	private int door;
	private String carColor;
	
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	public void run() {
		System.out.println("달린다");
	}
	public void stop() {
		System.out.println("멈춘다");
	}

}
