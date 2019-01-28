package distributed.mall.common.utils.pojo;

import java.util.List;

/**
 * <b><code>Node</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/23 10:53.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
public class Node {
    Object data;
    List<Node> children;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
