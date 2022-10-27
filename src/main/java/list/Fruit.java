package list;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author:ljh
 * @date:2022/10/25 14:44
 */


@Data
public class Fruit {

    private String sid;
    private String name;
    private String type;
    private Long total;
    private BigDecimal price;

}