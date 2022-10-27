package list;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IndustryStockRelation {
    private Long id;
    private String industryCode;
    private Integer num;
}