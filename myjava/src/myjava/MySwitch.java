package myjava;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class MySwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=50;
		switch(count) {
		case 50:
			System.out.println("50");
			break;
		case 500:
			System.out.println("500");
			break;
		default:
			System.out.println("default");
		}
		/*1부터 100사이 임의의 숫자를 만들어서 그 숫자의 학점을 출력함*/
		int score=(int) ((Math.random()*100)+1);
		System.out.println(score);
		if(score>=90) {
			System.out.println('A');
		}else if(score>=80) {
			System.out.println('B');
		}else if(score>=70) {
			System.out.println('C');
		}else if(score>=60){
			System.out.println('D');
		}else {
			System.out.println('F');
		}
		
		switch(score/10) {
		case(10):case(9):
			System.out.println('A');
			break;
		case(8):
			System.out.println('B');
			break;
		case(7):
			System.out.println('C');
			break;
		case(6):
			System.out.println('D');
			break;
		default:
			System.out.println('F');
		}
		
	}

}
