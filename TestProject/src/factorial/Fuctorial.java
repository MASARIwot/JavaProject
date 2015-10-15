package factorial;

public class Fuctorial {
	
	
	public static double fuct(double n){
		if(n == 0) return 1;
		return n*fuct(n-1);
	}
	
	
	public static double fuctTail(double n){
		return fuct(n, 1);
	}
	
	private static double fuct(double n, double x) {
		if(n == 0) return x;
		return fuct(n-1, x*n);
		
	}

	public static void main(String[] args) {
		System.out.println(fuct(5));
		System.out.println(fuctTail(5));

	}

}
