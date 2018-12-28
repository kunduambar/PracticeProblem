import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        //System.out.println(out_);

        pr.close();
        br.close();

	}
	
	static long Solve(int k, int[] arr){
        // Write code here
		int maxPosition = returnMaxPosition(arr);
		System.out.println("Max value array found at: " +  maxPosition);
		//get the possible Array
		int[] computeArr = Arrays.copyOfRange(arr, (maxPosition - k) < 0 ? 0 : (maxPosition - k), (maxPosition + k) > arr.length ? arr.length : (maxPosition + k + 1));
		
		//int[] rightArr = Arrays.copyOfRange(arr, maxPosition + 1, (maxPosition + k) > arr.length ? arr.length : (maxPosition + k + 1));
		//int[] leftArr = Arrays.copyOfRange(arr, (maxPosition - k) < 0 ? 0 : (maxPosition - k), maxPosition);
		System.out.println("Compute Arrray:");
		IntStream.of(computeArr).forEach((i) -> System.out.println(i));
		if(arr[maxPosition] > 0 ) {
			int negativeSum = IntStream.of(computeArr).filter((i)-> i < 0).sum();
			int leftover = negativeSum + arr[maxPosition];
			if(leftover == arr[maxPosition]) { 
				// No negative numbers hence cost cannot be reduced
			}else if(leftover > 0){
				
			}else if(leftover < 0) {
				
			}
		}else {
			int positiveSum = IntStream.of(computeArr).filter((i)-> i > 0).sum();
		}
		
		
		return returnMaxPosition(arr);
    }
	
	static int returnMaxPosition(int[] arr) {
		return IntStream.range(0, arr.length).reduce((a,b) -> Math.abs(arr[a]) < Math.abs(arr[b]) ? b : a).getAsInt();
	}

}
