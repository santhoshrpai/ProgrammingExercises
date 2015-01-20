package misc;
import java.util.Scanner;


public class LCM {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
	    int n1=0,n2=0;
	    String s = input.nextLine();
	    
	    if(s!=null && !s.equals("")) {
	    	n1 = Integer.parseInt(s);
	    }
	    
	    s = input.nextLine();
	    
	    if(s!=null && !s.equals("")) {
	    	n2 = Integer.parseInt(s);
	    }
	    
	    int lcm = findlcm(n1, n2);
	    System.out.println(lcm);
	}
	public static int findlcm(int n1,int n2) {
		int lcm = 0;
	      if(n1<=0 || n2<=0) {
	         //
	      }
	      int max,min;
	      if (n1>n2) {
	          max = n1;
	          min = n2;
	      } else {
	          max = n2;
	          min = n1;
	      }
	      for(int i=1; i<=min; i++) {
	          if( (max*i)%min == 0 ) {
	              lcm = i*max;
	              break;
	          }
	      }
	      return lcm;
	  }

}
