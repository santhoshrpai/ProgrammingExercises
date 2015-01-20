package misc;

public class TimesRotatedSortedArray {
	
	public static void main(String[] args) {
		
		int[] a = {25,52,68,1,5,8};
		
		for(int i=1;i<a.length;i++) {
			if(a[i]<a[i-1]) {
				System.out.println(i);
			}
		}
	}

}
