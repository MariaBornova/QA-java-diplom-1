package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType expectedIngredientType = IngredientType.SAUCE;
    private final String expectedName = "sauceName";
    private final float expectedPrice = 50f;
    @Before
    public void prepareData() {
        this.ingredient = new Ingredient(
                expectedIngredientType,
                expectedName,
                expectedPrice
        );
    }
    @Test
    public void getPriceTest() {
        MatcherAssert.assertThat(
                "Некорретная стоимость ингредиента",
                ingredient.getPrice(),
                equalTo(expectedPrice)

        );

    }
    @Test
    public void getNameTest() {
        MatcherAssert.assertThat(
                "Некорректное наименование ингредиента",
                ingredient.getName(),
                equalTo(expectedName)
        );
    }
    @Test
    public void getTypeTest() {
        MatcherAssert.assertThat(
                "Некорректный тип ингредиента",
                ingredient.getType(),
                equalTo(expectedIngredientType)
        );
    }
}
