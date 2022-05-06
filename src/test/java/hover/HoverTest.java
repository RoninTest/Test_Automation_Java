package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTests {
    @Test
    public void testHoverUser1(){
        homePage.clickHover();
            var hoversPage=homePage.clickHover();
            var caption=hoversPage.hoverOverFigure(1);
            assertTrue(caption.isCapitonDisplayed(),"Caption not displayed");
            assertEquals(caption.getTitles(),"name: user1","Caption title incorrect");
            assertEquals(caption.getLinkText(),"View profile","Caption link text");
            assertTrue(caption.getLink().endsWith("/users/1"),"Link incorrect");

        }
    }

