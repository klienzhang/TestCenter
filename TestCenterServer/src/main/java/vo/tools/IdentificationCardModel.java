package vo.tools;

import lombok.Data;

@Data
public class IdentificationCardModel {
    private int id;
    private String bankName;

    public IdentificationCardModel(int id, String bankName) {
        this.id = id;
        this.bankName = bankName;
    }
}
