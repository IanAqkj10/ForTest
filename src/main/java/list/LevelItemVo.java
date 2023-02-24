package list;

import lombok.Data;

@Data
public class LevelItemVo {

    private Integer level;

    private Double max;

    private Double min;

    private Double time;

    public LevelItemVo(Integer level, Double max) {
        this.level = level;
        this.max = max;
    }
}
