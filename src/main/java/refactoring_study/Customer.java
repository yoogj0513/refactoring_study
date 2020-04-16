
package refactoring_study;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public String getName() {
		return this.name;
	}
	
	public String statement() {
		StringBuilder result = new StringBuilder(getName() + " 고객님의 대여 기록\n");
		
		//비디오 종류별 대여료 계산
		for(Rental each : rentals) {
			//이번에 대여한 비디오 정보와 대여료를 출력
			result.append("\t" + each.getMovie().getTitle());
			result.append("\t" + String.valueOf(each.getCharge()) + "\n");
			
		}// end of for-loop
		
		//푸터행 추가
		result.append("누적 대여료 : " + String.valueOf(getTotalChange()) + "\n");
		result.append("적립 포인트 : " + String.valueOf(getTotalFrequentRenterPoints()));
		
		return result.toString();
	}// end of method statement
	
	public String htmlStatement() {
		StringBuilder result = new StringBuilder("<h1><em>"+ getName() +" 고객님의 대여 기록</em></h1><p>\n");
	
		for(Rental each : rentals) {
			result.append(each.getMovie().getTitle()+": ");
			result.append(String.valueOf(each.getCharge()) + "<br>\n");
		}//end of for-loop
		
		result.append("<p>누적 대여료 : <em>");
		result.append(String.valueOf(getTotalChange()) + "</em></p>\n");
		
		result.append("<p>적립 포인트 : <em>");
		result.append(String.valueOf(getTotalFrequentRenterPoints()) + "</em></p>");
		
		return result.toString();
	}

	// 적립포인트 (적립 포인트를 1포인트 증가 / 최신물을 이틀 이상 대여하면 보너스 포인트 지급)
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for(Rental rental : rentals) {
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}

	// 누적된 총 대여료
	private double getTotalChange() {
		double result = 0;
		for(Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}

}
