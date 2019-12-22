import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

public class ManageApplicationNoSpringTests {

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
