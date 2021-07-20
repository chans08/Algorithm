package step._6.function;

public class _1_15596_sum_of_n_integers {
	public static void main(String[] args) {
		int[] a = new int[3000001];
		
		for (int i=1; i<=3000000; i++) {
			a[i] = i;
		}
		System.out.println(sum(a));
	}
	
	public static long sum(int[] a) {
		long rtnVal = 0;
		for (int i=0; i<a.length; i++) {
			rtnVal += a[i];
		}
		return rtnVal;
	}
}
