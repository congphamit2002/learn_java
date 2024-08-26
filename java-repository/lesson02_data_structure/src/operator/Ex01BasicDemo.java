package operator;

public class Ex01BasicDemo {
	public static void main(String[] args) {
		int a = 10; 
		int b = 22;
		
		// + += -= *= /=
		a = a + b;
		b = b * 4;
		b += 12;
		System.out.println("a: " + a); //32
		System.out.println("b: " + b); //100
		
		// ++ (+=1) --(-=1) --> prefix(tiền tố), suffix(hậu tố)
		// int x = 5;
		// int z = 5;
		// Tiền tố: int y = 7 + ++x --> 13
		// Hậu tố: int y = 7 + z++ --> 12
		// 		   int y = 7 + z++ + ++z --> 19
		System.out.println("a++ suffix: " + a++); //32
		System.out.println("++b prefix: " + ++b); //101
		System.out.println("--a prefix: " + --a); //32
		System.out.println("b-- suffix: " + b--); //101
		System.out.println("b: " + b); //100
		
		int x = 7;
		int z = 2;
		int k = 3; 
//		int v = x++ + --z + k++ + ++z - x-- - --k;
//      z  z-- + z++ - --z + k++ + ++k; 
		z += z-- + z++ - --z + k++ + ++k; 
		System.out.println("x: " + x); //7
		System.out.println("z: " + z); //12
		System.out.println("k: " + k); //3
//		System.out.println("v: " + v); //2
		
		a = 30;
		b = 100;
		// == != >=
		// 1. Kiểm tra 1 số có phải là bội của 5 không
		boolean isPowerOf5 = (a % 5 == 0);
		System.out.println(a + " isPowerOf5: " + isPowerOf5);
		
		isPowerOf5 = (b % 5 == 0);
		System.out.println(b + " isPowerOf 5: " + isPowerOf5);
		
		// 2. Kiểm tra 1 số có phải là số chẵn không
		boolean isPowerOf2 = (a % 2 == 0);
		System.out.println("isPowerOf2: " + isPowerOf2);
		
		
		// 3. Kiểm tra 1 số có phải là bội của 10 và bé hơn 100 không.
		boolean isValid = isPowerOf10AndLessThan100(a);
		System.out.println("isValid: " + isValid);
		
		b = 90;
		isValid = isPowerOf10AndLessThan100(b);
		System.out.println("isValid: " + isValid);
		
		// Nếu mà số X mà chia hết cho 10 và bé hơn 100 thì sẽ in ra dòng chữ hợp lệ
		// Biểu thức điều kiện
		/*
		 if(Biểu thức đúng sai){
		 	Thực hiện nếu biểu thức đúng --> BT trả về true
		 }
		 else{
		 	Thực hiện nếu biểu thức sai --> BT trả về false
		 }
		*/
		
//		if(isValid == true) {
//			System.out.println("Hop le!");
//		}
//		else {
//			System.out.println("Khong hop le!");
//		}
		// if(booleanExpression) --> if(booleanExpression == true)
		// if(!booleanExpression) --> if(booleanExpression == false)
		if(isValid) {
			System.out.println("Hop le!");
		}
		else {
			System.out.println("Khong hop le!");
		}
	}
	
	// Hàm
	// --> phạm vi truy cập: public, private
	// --> static
	// Kiểu trả về: boolean
	// Tham số truyền vào: số đầu vào
	private static boolean isPowerOf10AndLessThan100(int number) {
		return number % 10 == 0 && number < 100;
	}
}
