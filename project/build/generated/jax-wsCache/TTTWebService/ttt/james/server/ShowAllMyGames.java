
package ttt.james.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>showAllMyGames complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="showAllMyGames">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "showAllMyGames", propOrder = {
    "uid"
})
public class ShowAllMyGames {

    protected int uid;

    /**
     * 获取uid属性的值。
     * 
     */
    public int getUid() {
        return uid;
    }

    /**
     * 设置uid属性的值。
     * 
     */
    public void setUid(int value) {
        this.uid = value;
    }

}
