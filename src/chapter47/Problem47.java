package chapter47;
/*���üӼ��˳����ӷ�
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+�� -�� *�� /����
�������
˼·���������������㿼����λ������
1.�����ǽ�λ��,0+0,1+0,0+1����������ֱ�ӳ��ֳ���
2.���н�λ�ģ����ֻ���ʧ��1+1����������¼�������ƶ�һλ
3.ֱ����������λΪֹ*/
public class Problem47 {
	public int add(int num1,int num2){
		int sum=0;
		int carry=0;
		while(num2!=0)
		{
			sum=num1^num2;
			carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
		}
		return num1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem47 test=new Problem47();
		int res=test.add(16, 7);
		System.out.println(res);
	}

}
