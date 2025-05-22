package com.juaracoding.test.inventories;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.juaracoding.test.DriverSingleton;

public class InventoryListTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
    driver = DriverSingleton.createOrGetDriver();
    }

    @Test(priority = 1)
    public void getAllElementTitleTest(){
        List<WebElement> collections = driver.findElements(By.className("inventory_item_name"));
       for (WebElement element: collections){
            System.out.println("Judul: " + element.getText());
        }
        Assert.assertTrue(collections.size() > 0, "Judul tidak tersedia!!");
    }

    @Test(priority = 2)
    public void getAllElementPriceTest(){
        List<WebElement> collections = driver.findElements(By.className("inventory_item_price"));
        for (WebElement element: collections){
            System.out.println("Harga: " + element.getText());
        }
        Assert.assertTrue(collections.size() > 0, "Harga tidak tersedia!!");
    }
}
