
public class MAS {

	public static void main(String[] args) {
		MAS s = new MAS();
		String a ="rr";
		int r = 8;
		s.change(a);
		s.change(r);
		System.out.println(a + "  " + r);

	}

	
	void change(int a) {
		
		a=9;
	}
	
void change(String a) {
		
		a="9";
	}
}
