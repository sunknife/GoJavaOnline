package file_processing;

import files.File;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class FileProcessingTest {
    private static FileProcessing textHandler;
    private static String fileName;
    private static String text;

    @BeforeClass
    public static void setUp() throws Exception {
        textHandler = new FileProcessing();
        textHandler.setKey(2);
        fileName = "testFile.txt";
        text = "It is bad that time flows, but good - that you're a pilot";

    }

    @Test
    public void testISUploadedTextEqualsSavedText() throws Exception {
        textHandler.saveText(text, fileName);
        Assert.assertEquals(text, textHandler.uploadText(fileName));
    }
}