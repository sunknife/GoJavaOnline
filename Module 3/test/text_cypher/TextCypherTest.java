package text_cypher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class TextCypherTest {
    private static String text;
    private static TextCypher encriptor;

    @BeforeClass
    public static void setUp() throws Exception {
        text = "Mammal";
        encriptor = new TextCypher();
    }

    @Test
    public void testCaesarCypher() throws Exception {
        Assert.assertEquals("Nbnnbm", encriptor.caesarCypher(text, 1));
    }

    @Test
    public void testCaesarDecipher() throws Exception {
        Assert.assertEquals(text, encriptor.caesarDecipher("Nbnnbm", 1));

    }
}