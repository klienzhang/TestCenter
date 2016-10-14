package UUMDeliveryTest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Old
 *   private String mobile;
     private int bizType;
    private int position_id;
    private String position_name;
    private int parent_id;
 */
public class ListComparisonUtil {

    @Test
    public void testListCompare(){
        OldTradeUserVo vo1 = new OldTradeUserVo("1",1,1,"test1",1);
        OldTradeUserVo vo2 = new OldTradeUserVo("2",2,2,"test1",2);
        OldTradeUserVo vo3 = new OldTradeUserVo("1",1,1,"test1",1);

        //NewUumUserVo vo11 = new NewUumUserVo("1",1,1,"test1",1);

        List<OldTradeUserVo> list1 = new ArrayList<OldTradeUserVo>();
        List<OldTradeUserVo> list2 = new ArrayList<OldTradeUserVo>();

        list1.add(vo1);
        list1.add(vo2);
        list2.add(vo3);

        System.out.println(list1.contains(vo3));
    }
}
