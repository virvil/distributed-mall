package distributed.mall.pojo.pojo;

import java.io.Serializable;

public class SpuSpecName implements Serializable {
    private Integer id;

    private Integer spuId;

    private Integer specNameId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getSpecNameId() {
        return specNameId;
    }

    public void setSpecNameId(Integer specNameId) {
        this.specNameId = specNameId;
    }
}