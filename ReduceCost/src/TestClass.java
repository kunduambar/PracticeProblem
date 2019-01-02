import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.IntStream;


public class TestClass {
	
	private static Logger logger = Logger.getLogger(TestClass.class.getName());

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		
        String[] arr_nk = br.readLine().split(" ");
        int n = Integer.parseInt(arr_nk[0]);
        int k = Integer.parseInt(arr_nk[1]);
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
        {
        	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }
        
        long out_ = Solve(k, arr);
        System.out.println("Final cost: " + out_);

        pr.close();
        br.close();

	}
	
	static long Solve(int k, int[] arr){
        // Write code here
		int maxPosition = returnMaxPosition(arr);
		//System.out.println("Max value array found at: " +  maxPosition);
		//get the possible Array
		int from =  (maxPosition - k) <= 0 ? 0 : (maxPosition - k);
		int to = (maxPosition + k) >= arr.length ? arr.length : (maxPosition + k + 1);
		int[] computeArr = Arrays.copyOfRange(arr, from, to);
		int[] restArrFront = Arrays.copyOfRange(arr, 0, from -1 <= 0 ? 0 : from-1);
		int[] restArrBack = Arrays.copyOfRange(arr, to , arr.length);
		//System.out.println("Compute Arrray:");
		//IntStream.of(computeArr).forEach((i) -> System.out.println(i));
		//Long cost = IntStream.of(computeArr).mapToLong(i -> i).sum();
		long cost = IntStream.of(computeArr).mapToLong(i -> i).sum();
		long cost1 = IntStream.of(restArrFront).map(number -> Math.abs(number)).mapToLong(i -> i).sum();
		long cost2 = IntStream.of(restArrBack).map(number -> Math.abs(number)).mapToLong(i -> i).sum();

		return cost + cost1 + cost2;
    }
	
	static int returnMaxPosition(int[] arr) {
		return IntStream.range(0, arr.length).reduce((a,b) -> Math.abs(arr[a]) < Math.abs(arr[b]) ? b : a).getAsInt();
	}

}
