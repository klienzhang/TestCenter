package vo.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class IdentificationCardModel {
    private int id;
    private String bankName;

    public IdentificationCardModel(int id, String bankName) {
        this.id = id;
        this.bankName = bankName;
    }
}
