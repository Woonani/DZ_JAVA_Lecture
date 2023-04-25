package kr.or.kosa;

public class Flower {
	private String flowerName;
	private int flowerPrice;
	private String flowerMeaning;
	
	public Flower(String flowerName,int flowerPrice,String flowerMeaning) {
		this.flowerName =flowerName;
		this.flowerPrice = flowerPrice;
		this.flowerMeaning = flowerMeaning;
	}
	public String getFlowerName() {
		return flowerName;
	}

	public int getFlowerPrice() {
		return flowerPrice;
	}

	public String getFlowerMeaning() {
		return flowerMeaning;
	}
	
}
