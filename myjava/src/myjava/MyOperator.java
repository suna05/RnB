package myjava;

public class MyOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=500+500;
		System.out.println(500*5);
		System.out.println(5/2); //int와 int의 연산이라 결과 또한 int이다.
		System.out.println(1==1.0); //자동 형변환(묵시적 형변환) int->double
		// || &&
		// 
		int amount=500;
		if(amount>500 && amount++==501) {
		}
		System.out.println(amount);
		//amount?
		
		String str=null;
		/*if(str!=null && str.length()>0) {
		}*/
		//str!=null 이 false이기 때문에 && 뒤의 연산은 이루어지지 않고 if문을 벗어나게 된다.
		print(str);
		//throw NullPointerException
		
	}
	private static void print(String str) {
		if(str!=null && str.length()>0) {
			
		}
	}

}
