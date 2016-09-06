package other;

/**
 * Created by klien on 2016/9/6.
 */
public enum EnumClass {
    FIRST(1, "klien"),
    SECOND(2, "kureha");
    private int id;
    private String name;

    private EnumClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
