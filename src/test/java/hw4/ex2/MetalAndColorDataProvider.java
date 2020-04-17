package hw4.ex2;

import hw4.builder.MetalAndColorsBuilder;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class MetalAndColorDataProvider  {
    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {MetalAndColorsBuilder.builder().setElements(Arrays.asList("Earth"))
                        .setColors(Arrays.asList("Yellow")).setMetals(Arrays.asList("Gold")).build()},

                {MetalAndColorsBuilder.builder().setSummary(Arrays.asList("3", "8"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato")).build()},

                {MetalAndColorsBuilder.builder().setSummary(Arrays.asList("3", "2"))
                        .setElements(Arrays.asList("Water", "Wind", "Fire"))
                        .setMetals(Arrays.asList("Bronze")).setVegetables(Arrays.asList("Onion")).build()},

                {MetalAndColorsBuilder.builder().setSummary(Arrays.asList("6", "5"))
                        .setElements(Arrays.asList("Water"))
                        .setColors(Arrays.asList("Green")).setMetals(Arrays.asList("Selen"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).build()},

                {MetalAndColorsBuilder.builder().setElements(Arrays.asList("Fire"))
                        .setColors(Arrays.asList("Blue"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).build()}
        };
    }

}
