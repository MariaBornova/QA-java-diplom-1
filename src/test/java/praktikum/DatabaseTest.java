package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunsTest() {
        List<Bun> actualBunsList = database.availableBuns();
        Assert.assertFalse("Cписок булок пустой", actualBunsList.isEmpty());
        Assert.assertEquals("Ожидался список из трех элементов", 3, actualBunsList.size());
    }

    @Test
    public void availableIngredientsTest() {
        List<Ingredient> actualIngredientList = database.availableIngredients();
        Assert.assertFalse("Cписок булок пустой", actualIngredientList.isEmpty());
        Assert.assertEquals("Ожидался список из трех элементов", 6, actualIngredientList.size());
    }
}
