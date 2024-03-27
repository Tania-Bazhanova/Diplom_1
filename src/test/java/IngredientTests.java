import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTests {
    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Краторная булка", 97.3F);
        float expectedPrice = 97.3F;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Цена не совпадает", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Краторная булка", 101.6F);
        String expectedName = "Краторная булка";
        String actualName = ingredient.getName();
        Assert.assertEquals("Имя не совпадает", expectedName, actualName);
    }
}
