package myjava;

public class MyOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=500+500;
		System.out.println(500*5);
		System.out.println(5/2); //int�� int�� �����̶� ��� ���� int�̴�.
		System.out.println(1==1.0); //�ڵ� ����ȯ(������ ����ȯ) int->double
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
		//str!=null �� false�̱� ������ && ���� ������ �̷������ �ʰ� if���� ����� �ȴ�.
		print(str);
		//throw NullPointerException
		
	}
	private static void print(String str) {
		if(str!=null && str.length()>0) {
			
		}
	}

}
