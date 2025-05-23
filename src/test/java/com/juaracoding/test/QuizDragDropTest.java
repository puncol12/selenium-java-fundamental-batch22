package com.juaracoding.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class QuizDragDropTest extends BaseTest {

    @Test(enabled = false)
    public void praktikumMinggu02Test() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy({top: 300, behavior: 'smooth'})");
        Thread.sleep(2000);

        WebElement draggable = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement drop = driver.findElement(By.id("box101"));
        Actions builder = new Actions(driver);

        Action dragger = builder.clickAndHold(draggable).pause(Duration.ofSeconds(2))
                .moveToElement(drop, 0, 2).pause(Duration.ofSeconds(2)).release()
                .pause(Duration.ofSeconds(3)).build();
        dragger.perform();

        Thread.sleep(1000);
        String bgColor = draggable.getCssValue("background-color");
        String expected = "rgba(0, 225, 0, 1)";
        // jse.executeScript("document.querySelector('#box1').style.backgroundColor = 'red'");
        Assert.assertEquals(bgColor, expected);

    }

    private void dragAndDrop(String idDrag, String idDrop) {
        WebElement draggable = driver.findElement(By.id(idDrag));
        WebElement drop = driver.findElement(By.id(idDrop));
        Actions builder = new Actions(driver);

        Action dragger = builder.clickAndHold(draggable).pause(Duration.ofSeconds(2))
                .moveToElement(drop, 0, 2).pause(Duration.ofSeconds(2)).release()
                .pause(Duration.ofSeconds(3)).build();
        dragger.perform();
    }

    @Test
    public void praktikumMinggu02Test01() throws InterruptedException {
        // box1 (oslo) - box101 (norwey)
        // box2 (stockholm) - box102 (sweden)

        String[][] keyElements = {{"box1", "box101"}, {"box2", "box102"}, {"box3", "box103"},
                {"box4", "box104"}, {"box5", "box105"}, {"box6", "box106"},
            {"box7", "box107"},};

        for (int row = 0; row < keyElements.length; row++) {
            dragAndDrop(keyElements[row][0], keyElements[row][1]);
            Thread.sleep(2000);
        }
    }

}
