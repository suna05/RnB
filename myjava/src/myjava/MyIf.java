package myjava;

import java.sql.Date;
import java.util.Calendar;

public class MyIf {
	final static int SUNDAY=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=500;
		/*if(count) { //js������ ������ ����. ������ ���� �������� ������ �Ǿ�� �Ѵ�.
		 ������ �������� �ָ������� üũ�Ͽ� �����̸� 
		 ������ �����սôٶ�� ���ڿ��� ����ϰ�
		 �ָ��̸� �� ���ôٶ�� ���ڿ��� ���	
		}*/
		int today;
		today=Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		/*int today2=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int month=Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
		System.out.println(month);*/
		if(today==SUNDAY/*����� ���ؼ��ϴ°��� �� ����.*/ || today==7) {//1�� �Ͽ��� 7�� ����� today==Calendar.SATURDAY
			System.out.println("�ָ��̸� �� ���ô�.");
		}else {
			System.out.println("������ �����սô�.");
		}
	}

}
