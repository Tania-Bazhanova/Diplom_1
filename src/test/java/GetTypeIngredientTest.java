import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class GetTypeIngredientTest {

    private final IngredientType selectedIngredientType;
    private final IngredientType expectedIngredientType;

    public GetTypeIngredientTest(IngredientType selectedTypeIngredient, IngredientType expectedTypeIngredient) {
        this.selectedIngredientType = selectedTypeIngredient;
        this.expectedIngredientType = expectedTypeIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeData() {
        return new Object[][]{
                {IngredientType.FILLING, IngredientType.FILLING},
                {IngredientType.SAUCE, IngredientType.SAUCE}
        };
    }
    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(selectedIngredientType, "test test", 37.9F);
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals("Тип ингредиента не совпадает", expectedIngredientType, actualIngredientType);
    }
}