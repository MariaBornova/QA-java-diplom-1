package praktikum;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class BunTest {

    @Test
    public void getNameTest() {
        String bunName = "bunName";
        Bun bun = new Bun(bunName, 100);

        MatcherAssert.assertThat(
                "Некорректное название булочки",
                bun.getName(),
                equalTo(bunName)
        );
    }

    @Test
    public void getPriceTest() {
        float bunPrice = 100;
        Bun bun = new Bun("bunName", bunPrice);

        MatcherAssert.assertThat(
                "Некорректная цена булочки",
                bun.getPrice(),
                equalTo(bunPrice)
        );
    }
}
