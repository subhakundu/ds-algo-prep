/**
 * Problem: https://practice.geeksforgeeks.org/problems/minimum-swaps/1
 * Editorial article: https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 * Approach taken: Here I have sorted the array (of {value, index} pair) at first based on the value.
 * Then I have run a loop to modify array based on following criteria
 * 1. If after sorting index of the current element is same as the original
 *    porition in array, it is already in correct position.
 * 2. If not, swap it with the element on index in the current pair of inspection. This will
 *    contribute to number of swaps.
 * Time complxity: O(NLogN) where N is the length of array.
 */
class Solution {
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]) {
        // Code here
        List<Pair> arrayPosition = new ArrayList<>();
        for(int i=0; i< nums.length; i++) {
            arrayPosition.add(new Pair(nums[i],i));
        }
        arrayPosition.sort(new Comparator<Pair>() {
            @Override
            public int compare (Pair p1, Pair p2) {
                if(p1.value > p2.value) {
                    return 1;
                } else if (p1.value == p2.value) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(arrayPosition.get(i).index == i) {
                continue;
            } else {
                Collections.swap(arrayPosition, arrayPosition.get(i).index,
                        arrayPosition.get(arrayPosition.get(i).index).index);
                i--;
                count++;
            }
        }
        return count;
    }
    class Pair {
        int value;
        int index;
        public Pair(int v, int i) {
            value = v;
            index = i;
        }
    }
}