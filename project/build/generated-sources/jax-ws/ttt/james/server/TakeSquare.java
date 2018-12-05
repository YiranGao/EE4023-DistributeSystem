
package ttt.james.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>takeSquare complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="takeSquare">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "takeSquare", propOrder = {
    "x",
    "y",
    "gid",
    "pid"
})
public class TakeSquare {

    protected int x;
    protected int y;
    protected int gid;
    protected int pid;

    /**
     * 获取x属性的值。
     * 
     */
    public int getX() {
        return x;
    }

    /**
     * 设置x属性的值。
     * 
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * 获取y属性的值。
     * 
     */
    public int getY() {
        return y;
    }

    /**
     * 设置y属性的值。
     * 
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * 获取gid属性的值。
     * 
     */
    public int getGid() {
        return gid;
    }

    /**
     * 设置gid属性的值。
     * 
     */
    public void setGid(int value) {
        this.gid = value;
    }

    /**
     * 获取pid属性的值。
     * 
     */
    public int getPid() {
        return pid;
    }

    /**
     * 设置pid属性的值。
     * 
     */
    public void setPid(int value) {
        this.pid = value;
    }

}
