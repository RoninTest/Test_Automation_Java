package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage=homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Eren\\Desktop\\Wallpapers\\Matador");
        assertEquals(uploadPage.getUploadedFiles(),"Matador.PNG","File name incorrect");
    }

}
