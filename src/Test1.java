import java.util.Scanner;

/**
 * 1. 简单Java语句练习：输入八个整数，排序后存于数组中，然后再输入一个查找key键，判断key键是否在数组中。
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[8];
        for (int i = 0; i < nums.length; i++) {
            System.out.println("请输入第" + (i + 1) + " 个数字:  ");
            nums[i] = scanner.nextInt();
        }
        System.out.println("请输入查询Key：");
        int key = scanner.nextInt();

        Test1 t1 = new Test1();
        t1.selectSort(nums);

        int index = t1.search(nums, key);
        if (index != -1) {
            System.out.println("当前key存在，排序后下标为:   " + index);
        } else {
            System.out.println("当前key不存在");
        }
    }

    //    排序
    int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 最小数字下标
            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                // 比较下标对应值，如果找到更小的，修改minIndex
                if (nums[minIndex] >= nums[j]) {
                    minIndex = j;
                }
            }

            // 数字位置交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }

    //    查找
    int search(int[] nums, int key) {
        // 最下界
        int low = 0;
        //  最大界
        int high = nums.length - 1;
        // 中间
        int mid;


        while (low <= high) {
            mid = (low + high) / 2;
            // 小于中间数字，最大界递减
            if (key < nums[mid]) {
                high = mid - 1;
            }
            // 小于中间数字，最小界递增
            if (key > nums[mid]) {
                low = mid + 1;
            }
            // 相等直接返回
            if (key == nums[mid]) {
                return mid;
            }
        }
        return -1;
    }
}
