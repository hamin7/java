package 실습;

public class Appointment
{
	private int value;
	
	IntegerClass()    //기본생성자 ()안에 인자가 없는 생성
	{
		this.value=0;
	}
	IntegerClass(int value)
	{
		this.value=value;
	}
	
	IntegerClass(){
		setValue(0); //리펙토링 적용.
	}
	
	IntegerClass(int value){
		setValue(value);
	}
	
	public int getValue() { return value;}
	public void setValue(int value) { this.value=value;}
	public void add(int value) {this.value+=value;}
	public void subtract (int value) {this.value-=value; }
	public void multiply(int value) {this.value*=value;}
	public void printInformation() { 
		System.out.println("Value is " +value);  //파이썬과 다른점은 자바에서는 문자열+문자열은 문자
	}
	
	public static void main(String[] args) 
	{
		IntegerClass a = new IntegerClass();
		IntegerClass sample = new IntegerClass();
		System.out.println(sample.getValue());
		IntegerClass sample2 = new IntegerClass(5);
		System.out.println(sample2.getValue());
		
		//a.setValue(2);  //a=2 (cf. c++연산자 오버로딩/자바에서는 없)
		a.printInformation();
		a.add(3);  //a=a+3
		a.printInformation();
		a.subtract(1);  //a=a-1
		a.printInformation();
		a.multiply(2);  //a=a*2
		a.printInformation();
	}
}


// 생성자 오버로딩 - 리턴값으로 구별하지는 않음. 인자의 갯수, 형태로 구별.
// 리턴 값으로 구별하지 않는다는 얘기가 void add(int a) 랑 int void(int a)랑은 구별 안된다는 얘기.
