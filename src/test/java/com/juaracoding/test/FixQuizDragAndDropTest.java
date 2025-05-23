package com.juaracoding.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FixQuizDragAndDropTest extends BaseTest {
    private void dragAndDrop(String idDrag, String idDrop) {
        WebElement draggable = driver.findElement(By.id(idDrag));
        WebElement drop = driver.findElement(By.id(idDrop));
        Actions builder = new Actions(driver);

        Action dragger = builder.clickAndHold(draggable).pause(Duration.ofMillis(500))
                .moveToElement(drop, 0, 2).pause(Duration.ofMillis(500)).release()
                .pause(Duration.ofMillis(500)).build();
        dragger.perform();
    }

    private void dragAndDropReverse(String idDrag, String idDrop) {
        WebElement drop = driver.findElement(By.id(idDrop));
        WebElement draggable = driver.findElement(By.id(idDrag));
        Actions builder = new Actions(driver);

        Action dragger = builder.clickAndHold(draggable).pause(Duration.ofMillis(500))
                .moveToElement(drop, 0, 2).pause(Duration.ofMillis(500)).release()
                .pause(Duration.ofMillis(500)).build();
        dragger.perform();
    }

    @Test
    public void praktikumMinggu02Test01() throws InterruptedException {
        // box1 (oslo) - box101 (norwey)
        // box2 (stockholm) - box102 (sweden)

        /**
         * KETIKA DRAG AND DROP PERTAMA
         */
        String[][] keyElements = {{"box1", "box101"}, {"box2", "box102"}, {"box3", "box103"},
                {"box4", "box104"}, {"box5", "box105"}, {"box6", "box106"}, {"box7", "box107"},};

        /**
         * JIKA CODE DI UNCOMMENT DIKEMBALIKAN KE DROPCONTENT TAPI DENGAN URUTAN ID SECARA ASC
         */
        // String[][] returnToOrigin = {
        // {"box1", "dropContent"},
        // {"box2", "dropContent"},
        // {"box3", "dropContent"},
        // {"box4", "dropContent"},
        // {"box5", "dropContent"},
        // {"box6", "dropContent"},
        // {"box7", "dropContent"},
        // };

        /**
         * JIKA DIKEMBALIKAN SEPERTI SEMULA DAN URUTAN SESUAI SEMULA
         */
        String[][] returnToOrigin = {{"box4", "dropContent"}, {"box5", "dropContent"},
                {"box3", "dropContent"}, {"box1", "dropContent"}, {"box6", "dropContent"},
                {"box7", "dropContent"}, {"box2", "dropContent"},};

                
        for (int row = 0; row < keyElements.length; row++) {
            dragAndDrop(keyElements[row][0], keyElements[row][1]);
            Thread.sleep(500);
        }

        for (int row = 0; row < returnToOrigin.length; row++) {
            dragAndDropReverse(returnToOrigin[row][0], returnToOrigin[row][1]);
            Thread.sleep(500);
        }

    }


}
