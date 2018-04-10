package myjava;

import java.sql.Date;
import java.util.Calendar;

public class MyIf {
	final static int SUNDAY=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=500;
		/*if(count) { //js에서는 오류가 없다. 조건은 참과 거짓으로 판정이 되어야 한다.
		 오늘이 주중인지 주말인지를 체크하여 주중이면 
		 열심히 공부합시다라는 문자열을 출력하고
		 주말이면 쫌 쉽시다라는 문자열을 출력	
		}*/
		int today;
		today=Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		/*int today2=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int month=Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
		System.out.println(month);*/
		if(today==SUNDAY/*상수를 정해서하는것이 더 좋다.*/ || today==7) {//1은 일요일 7은 토요일 today==Calendar.SATURDAY
			System.out.println("주말이면 쫌 쉽시다.");
		}else {
			System.out.println("열심히 공부합시다.");
		}
	}

}
