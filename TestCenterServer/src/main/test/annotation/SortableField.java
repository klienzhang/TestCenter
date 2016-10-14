package annotation;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * Created by klien on 2016/10/9.
 */
@Data
public class SortableField {
    private FieldMeta meta;
    private Field field;
    private String name;
    private Class<?> type;

    public SortableField(){}

    public SortableField(FieldMeta meta, Field field) {
        super();
        this.meta = meta;
        this.field = field;
        this.name=field.getName();
        this.type=field.getType();
    }


    public SortableField(FieldMeta meta, String name, Class<?> type) {
        super();
        this.meta = meta;
        this.name = name;
        this.type = type;
    }
}
