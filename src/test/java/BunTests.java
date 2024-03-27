import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {
    Bun bun = new Bun("Флюоресцентная булка", 20.5F);
    @Test
    public void getNameBun() {
        String expectedNameBun = "Флюоресцентная булка";
        String actualNameBun = bun.getName();
        Assert.assertEquals("Имена не совпадают", expectedNameBun, actualNameBun);
    }

    @Test
    public void getPriceBun() {
        float expectedNameBun = 20.5F;
        float actualNameBun = bun.getPrice();
        Assert.assertEquals("Цены не совпадают", expectedNameBun, actualNameBun, 0);
    }

}
