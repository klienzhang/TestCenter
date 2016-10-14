package UUMDeliveryTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUumUserVo {
    private String mobile;
    private int bizType;
    private int position_id;
    private String position_name;
    private int parent_id;
}
