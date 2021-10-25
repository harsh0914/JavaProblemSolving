import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

class GCD {

  public static int generalizedGCD(int num, int[] arr) {
    //deriving the set from ConcurrentHashMap for Thread safety
    Set<Integer> divisors = ConcurrentHashMap.newKeySet();
    //Sort arr[] and Find all divisors of a[0] (smallest number)
    // Leverage parallelism for faster execution
    Arrays.sort(arr);
    IntStream.range(1, arr[0] + 1).parallel().forEach(x -> {
      if (arr[0] % x == 0) {
        divisors.add(x);
      }
    });
    //Eliminate divisors from the set that are not a divisor of other elements in arr
    for (Integer cur : arr) {
      divisors.parallelStream().forEach(x -> {
        if (cur % x != 0) {
          divisors.remove(x);
        }
      });
    }
    //Gave up on the TreeSet implementation for leveraging parallelism
    return Collections.max(divisors);
  }

  public static void main(String[] args) {
    System.out.println("GCD: " + generalizedGCD(5, new int[]{3, 9, 3, 6}));
  }
}
