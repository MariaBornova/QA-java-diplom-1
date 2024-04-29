package praktikum;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("bunName");
        burger.setBuns(bun);

        MatcherAssert.assertThat(
                "В бургер не добавлены передаваемые булочки",
                bun.getName(),
                equalTo(burger.bun.getName())
        );
    }
    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertTrue(
                "Ингредиент не добавлен",
                burger.ingredients.contains(ingredient)
        );
    }
    @Test
    public void moveIngredientTest() {
        Mockito.when(ingredient.getName()).thenReturn("ingredientName");

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        int currentIndex = burger.ingredients.indexOf(ingredient);
        int newIndex = burger.ingredients.indexOf(ingredient2);

        burger.moveIngredient(currentIndex, newIndex);

        MatcherAssert.assertThat(
                "Ингредиент не перемещается",
                ingredient.getName(),
                equalTo(burger.ingredients.get(newIndex).getName())
        );
    }
    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);

        assertFalse(
                "Ингредиент не удаляется",
                burger.ingredients.contains(ingredient)
        );
    }
    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(250f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(
                "Цена рассчитана некорректно",
                450f,
                equalTo(burger.getPrice())
        );

    }
    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(bun.getPrice()).thenReturn(80f);
        Mockito.when(ingredient.getName()).thenReturn("ingredientName");
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        String expectedReceipt =
                "(==== bunName ====)\n" +
                        "= filling ingredientName =\n" +
                        "(==== bunName ====)\n" +
                        "\nPrice: 260,000000\n";

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        MatcherAssert.assertThat(
                "Некорректная строка с рецептом",
                burger.getReceipt(),
                equalTo(expectedReceipt)
        );
    }
}