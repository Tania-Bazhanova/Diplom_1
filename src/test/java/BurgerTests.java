import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Test
    public void setBurgerBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Bun actualBurgerBun = burger.bun;
        Assert.assertEquals("Булочки не совпадают", bun, actualBurgerBun);
    }

    @Test
    public void addBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Ingredient actualBurgerIngredient = burger.ingredients.get(0);
        Assert.assertEquals("Игредиенты не совпадают", ingredient1, actualBurgerIngredient);
    }

    @Test
    public void removeBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        int actualSizeListBurgerIngredients = burger.ingredients.size();
        Assert.assertEquals("Размер списка не совпадает", 0, actualSizeListBurgerIngredients);
    }

    @Test
    public void moveBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1); // 0
        burger.addIngredient(ingredient2); // 1
        Assert.assertEquals("Ингридиенты не совпадают", ingredient2, burger.ingredients.get(1));
        burger.moveIngredient(1,0);
        Assert.assertEquals("Ингридиенты не совпадают", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getBurgerPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(35.5F);
        Mockito.when(ingredient1.getPrice()).thenReturn(86.9F);
        float actualBurgerPrice = burger.getPrice();
        Assert.assertEquals("Цены у бургеров не совпадают", 157.9F, actualBurgerPrice, 0);
    }

    @Test
    public void getReceiptBurger() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getName()).thenReturn("булочка без кунжута");
        Mockito.when(ingredient1.getName()).thenReturn("свиная котлета");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("сырный соус");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(41F);
        Mockito.when(ingredient1.getPrice()).thenReturn(66F);
        Mockito.when(ingredient2.getPrice()).thenReturn(84.3F);

        float expectedBurgerPrice = 41F*2 + 66F + 84.3F;

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== булочка без кунжута ====)" + System.lineSeparator() +
                "= filling свиная котлета =" + System.lineSeparator() +
                "= sauce сырный соус =" + System.lineSeparator() +
                "(==== булочка без кунжута ====)" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "Price: " + String.format("%f", expectedBurgerPrice) + System.lineSeparator();

        Assert.assertEquals("Рецепты не совпадают", expectedReceipt, actualReceipt);
    }
}
