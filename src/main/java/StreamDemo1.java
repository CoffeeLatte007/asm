import asm.filter.AddressDesFilter;
import asm.DesFiled;
import asm.Desensitized;
import asm.filter.DesFilterMap;
import asm.filter.MobileDesFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:lizhao07
 * @Description:
 * @Date: 2017/7/18  下午5:00
 */
@Desensitized
public class StreamDemo1 {


    @DesFiled(MobileDesFilter.class)
    private String name;
    private String idCard;
    @DesFiled(AddressDesFilter.class)
    private List<String> mm;


    @Override
    public String toString() {
        return "StreamDemo1{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", mm=" + mm +
                '}';
    }
    public static void main(String[] args) throws Exception {
        StreamDemo1 streamDemo1 = new StreamDemo1();
        streamDemo1.setName("18428368642");
        streamDemo1.setIdCard("22321321321");
        streamDemo1.setMm(Arrays.asList("北京是朝阳区打撒所大所大","北京是朝阳区打撒所大所大"));
        System.out.println(streamDemo1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public List<String> getMm() {
        return mm;
    }

    public void setMm(List<String> mm) {
        this.mm = mm;
    }

    public void checkAndSetF(int f) {
        if (f >= 0) {
            this.name = String.valueOf(f);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
