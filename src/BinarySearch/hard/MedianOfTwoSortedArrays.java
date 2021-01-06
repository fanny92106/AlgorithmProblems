/**
  * @TC: O(logn), n is length of the shorter array
  * @SC: O(1)
*/

public class MedianOfTwoSortedArrays {
  public double median(int[] a, int[] b) {

    if(b.length < a.length){
        return median(b, a); // ensure run binary search to a array with shorter length
    }

    if(a.length == 0){
      if(b.length % 2 == 1){
        return (double)b[b.length/2];
      } 
      double leftEle = (double)b[(b.length - 1) / 2]; // b has even number of elements
      double rightEle = (double)b[(b.length - 1) / 2 + 1];
      return (leftEle + rightEle) / 2;
    }

    // binary search
    int len = a.length + b.length;
    int leftOfA = 0;
    int rightOfA = a.length - 1;

    while(leftOfA <= rightOfA) {
      int midOfA = leftOfA + (rightOfA - leftOfA) / 2;
      int cutOfA = midOfA + 1;
      int cutOfB = len/2 - cutOfA;
      int midOfB = cutOfB - 1;

      int leftValOfA = (midOfA == -1) ? Integer.MIN_VALUE : a[midOfA];
      int rightValOfA = (midOfA == a.length - 1) ? Integer.MAX_VALUE : a[midOfA + 1];
      int leftValOfB = (midOfB == -1) ? Integer.MIN_VALUE: b[midOfB];
      int rightValOfB = (midOfB == b.length - 1) ? Integer.MAX_VALUE : b[midOfB + 1];

      if(leftValOfA > rightValOfB) {
          // move to left
          rightOfA = midOfA - 1;

      }
      else if (leftValOfB > rightValOfA) {
          // move to right
          leftOfA = midOfA + 1;
      }
      else {
        if(len % 2 == 0) {
            return (double)(Math.max(leftValOfA, leftValOfB) + Math.min(rightValOfA, rightValOfB)) /2;
        }
        return (double)(Math.min(rightValOfA, rightValOfB));
      }
    }
    // post-processing
    return (double)(Math.min(a[0], b[len/2]));
  }
}
