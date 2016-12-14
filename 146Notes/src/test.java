
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		
		recur(a);
	}
	
	public static void recur(int[] a){
		int size = a.length;
		int mid = size/2;
		System.out.println(mid);
		System.out.println(a[mid]);
		if (size>1){
			int[] b = new int[mid];
			for(int i=0;i<mid;i++){
				b[i] = a[mid+i]*10;
			}
			recur(b);
		}
	}

}
