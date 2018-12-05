
package ttt.james.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setGameState complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="setGameState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gstate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setGameState", propOrder = {
    "gid",
    "gstate"
})
public class SetGameState {

    protected int gid;
    protected int gstate;

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
     * 获取gstate属性的值。
     * 
     */
    public int getGstate() {
        return gstate;
    }

    /**
     * 设置gstate属性的值。
     * 
     */
    public void setGstate(int value) {
        this.gstate = value;
    }

}
