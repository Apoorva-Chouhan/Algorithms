package codedSolutions.compi;

public class PartitionDisjoint {

    public static int partitionDisjoint(int[] nums) {
        int[] maxar = new int[nums.length];
        int[] minar = new int[nums.length];
        int size = nums.length;
        int maxval = nums[0], minval = nums[size-1];
        maxar[0] = nums[0];
        minar[size-1] = nums[size-1];
        for(int i=1;i<size;i++) {
            if(nums[i]>maxval) maxval = nums[i];
            maxar[i] = maxval;
        }
        for(int j=size-1;j>0;j--) {
            if(nums[j]<minval) minval = nums[j];
            minar[j] = minval;
        }
        int j = 0;
        while( j<size-1 && maxar[j]>minar[j+1]) {
            j++;
        }
        return j+1;
    }

    public static void main(String args[]) {
        int[] vals = {
                32,57,24,19,0,24,49,67,87,87
//                1,6,0,2,8,9
//                1,2,3,4,5,6
//                5,0,3,8,6
        };
        System.out.println(partitionDisjoint(vals));
    }

}
