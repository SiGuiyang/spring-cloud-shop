import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

public class ManageNoSpringTests {

    @Test
    public void testConvert() {

//        List<Long> collect = Stream.of().collect(Collectors.toList());
        List<Long> collect = Stream.of((Long[]) ConvertUtils.convert("32323,8888,999".split(","), Long.class)).collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void testLong() {

        int[] arr = {2, 1, 5, 9, 4, 0, 6, 3, 8, 7};
        insertSort(arr);

        bubbleSort(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("快速排序结果：" + Arrays.toString(arr));

        System.out.println(System.getProperty("user.name"));

    }

    @Test
    public void testrepeat() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 3, 1, 2, 4};
        System.out.println(toArray(arr));
    }

    private List<Integer> toArray(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                list.add(num);
            }
            map.put(num, 0);
        }
        return list;
    }

    @Test
    public void testStack() {
        System.out.println(queue());
    }


    private int queue() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        stack1.push(stack.pop());
        stack1.push(stack.pop());
        stack1.push(stack.pop());
        stack1.push(stack.pop());

        return stack1.pop();

    }


    @Test
    public void testQueue() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

    private int mid(int[] arr, int start, int end) {
        int temp = arr[start];

        while (start < end) {
            while (start < end && arr[start] < temp)
                start++;
            arr[start] = arr[end];

            while (start < end && arr[end] > temp)
                end--;
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }


    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = mid(arr, start, end);
            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);

        }
    }


    private void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while (j > 0 && temp > arr[j - 1]) {
                arr[j] = arr[j - 1];
                j -= 1;
            }
            arr[j] = temp;
            System.out.println(Arrays.toString(arr));
        }

    }


    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("冒泡排序：" + Arrays.toString(arr));
    }
}
