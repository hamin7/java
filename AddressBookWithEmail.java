public class AddressBookWithEmail extends AddressBook{    //여기도 public 있어야? public이 없으면 만약 이 클래스에 main이 없고 다른 클래스에 있다면 실행이 안됌.
	private String email;
	public String getEmail() {
		return email;
	} 
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public void setName(String name) {
		super.name = name;               // 부모클래스의 필드를 호출. (변수를 이용하는 방법) // 부  모 클래스의 멤버 private를 protected로 바꿔주면 가능.
		System.out.println("******");  
		//super.setName("name");         // 이게 정석쿠임. 부모클래스의 메소드를 호출. (함수를 이용하는 방법)	
		System.out.println(name);
		System.out.println("******");
	}
	
	public void parentSetName (String name) {
		super.setName(name);
		System.out.println("++++++");
		System.out.println(name);
		System.out.println("++++++");
	}

	public static void main(String[] args) {
		AddressBookWithEmail sample = new AddressBookWithEmail(); 
		sample.setName("Hamin");
		sample.setAddress("seoul");
		sample.setTelephone("010-2786-8089");
		sample.setAge(25); 
		sample.setGender("male");
		sample.setEmail("ggamini7@gmail.com");
		
		sample.setName("World");             // name필드를 새로 세팅??
		sample.parentSetName("World!!!");    // 배송 대행지라고 생각 // 위에 줄이랑 같은 작동이지만 그냥 조금 다른것. 왜냐면 main내부에는 super못하기 때문에....
		
		sample.setName("Java");               //main은 순서대로 실행 sample.setName은 함수라고 생각해도 됨.
		sample.parentSetName("java!!!");
	}

}
// main은 순서대로 위에 public void setName이랑 public void parentSetName은 함수로 생각해도됨?

// new는 object 생성. // 생성자 오버로딩 얘나을때 마다 어느 산후조리원 갈꺼냐 그거임. 얘하나 나을때 마다 유모차 하나씩 필요 그게 생성자 오버로딩 살때마다 정하는거. 
// 선택을 하는 개념이 오버로딩. 생성될때 마다 생성자는 호출 되는것. 클래스 정의할때 자동으로 만들어짐??
