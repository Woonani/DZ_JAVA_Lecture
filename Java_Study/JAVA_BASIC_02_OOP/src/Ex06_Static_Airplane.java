import kr.or.kosa.Airplane;

public class Ex06_Static_Airplane {

	public static void main(String[] args) {
		/*
		 * 
		Airplane air1 = new Airplane();
		air1.makeAirplane(707, "대한항공");
		Airplane air2 = new Airplane();
		air2.makeAirplane(708, "아시아나");
		air1.airTotal();
		
		//Airplane.airtotalcount   static private 접근불가 (간접)
				//air1.airtotalcount   막았어요 
		
//		air1.setAirNo(123);
//		air1.airInfo();
//		air1.totalAirInfo();
		 */
		
		Airplane air1 = new Airplane(101, "대한항공");
		air1.airDisplay();
		air1.airPlaneTotalCount();
		
		Airplane air2 = new Airplane(707, "아시아나");
		air2.airDisplay();
		air2.airPlaneTotalCount();
		
	}

}
