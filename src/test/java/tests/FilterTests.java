package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilterTests extends BaseTests {

    @Override
    @BeforeMethod
    public void before(){
        super.before();

        startFromProductsPage();
    }

    @Test
    public void sortByNameAToZ() {

        productsPage.selectSortOption("Name (A to Z)");

        List<String> actualNames = productsPage.getProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        Assert.assertEquals(actualNames, expectedNames, "Products are not sorted A to Z");
    }

    @Test
    public void sortProductsByNameZtoA() {

        productsPage.selectSortOption("Name (Z to A)");

        List<String> actualProductNames = productsPage.getProductNames();

        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        expectedProductNames.sort(Comparator.reverseOrder());

        Assert.assertEquals(actualProductNames, expectedProductNames, "Products are not sorted Z to A");
    }
    @Test
    public void filterByPriceLowToHigh() {

        productsPage.selectSortOption("Price (low to high)");

        List<Double> actualPrices = productsPage.getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals(actualPrices, expectedPrices, "Prices are not sorted from low to high");

    }
    @Test
    public void filterByPriceHighToLow() {

        productsPage.selectSortOption("Price (high to low)");

        List<Double> actualPrices = productsPage.getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder());

        Assert.assertEquals(actualPrices, expectedPrices, "Prices are not sorted from high to low");
    }

}
