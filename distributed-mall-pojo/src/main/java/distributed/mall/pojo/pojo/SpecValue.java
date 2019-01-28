package distributed.mall.pojo.pojo;

import java.io.Serializable;

public class SpecValue implements Serializable {
    private Integer id;

    private Integer specNameId;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecNameId() {
        return specNameId;
    }

    public void setSpecNameId(Integer specNameId) {
        this.specNameId = specNameId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}