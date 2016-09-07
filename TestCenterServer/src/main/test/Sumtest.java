import org.testng.annotations.Test;

/**
 * Created by klien on 2016/9/7.
 */
public class Sumtest {
    @Test
    public void testSum(){
        String str = "123456789";

        int[] array = new int[str.length()];
        for(int i = 0; i<str.length(); i++){
            array[i] = Integer.valueOf(str.substring(i,i+1));
        }
        int sum = 0;
        for (int j=0; j<array.length; j++){
            System.out.println(array[j]);
            sum += array[j];
        }

        System.out.println(sum);
    }
}
