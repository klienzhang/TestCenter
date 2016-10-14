package annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by klien on 2016/10/9.
 */
@Data
@AllArgsConstructor
public class Anno {
    @FieldMeta(id = true,name = "序列号",order = 1)
    private int id;
    @FieldMeta(name = "姓名", order = 3)
    private String name;
    @FieldMeta(name = "年龄", order = 2)
    private int age;

    @FieldMeta(description="描述",order=4)
    public String desc(){
        return "java反射获取annotation的测试";
    }
}
