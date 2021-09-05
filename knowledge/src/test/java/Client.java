import com.mobius.design.behavioralpatterns.chainofresponsibilty.Bug;
import com.mobius.design.behavioralpatterns.chainofresponsibilty.GoodProgrammer;
import com.mobius.design.behavioralpatterns.chainofresponsibilty.NewbieProgrammer;
import com.mobius.design.behavioralpatterns.chainofresponsibilty.NormalProgrammer;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    public void test() {
        NewbieProgrammer newbie = new NewbieProgrammer();
        NormalProgrammer normal = new NormalProgrammer();
        GoodProgrammer good = new GoodProgrammer();

        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);

        // 组成责任链
        newbie.setNext(normal);
        normal.setNext(good);

        // 从菜鸟程序员开始，沿着责任链传递
        newbie.handle(easy);
        newbie.handle(middle);
        newbie.handle(hard);
    }
}
