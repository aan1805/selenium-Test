import org.junit.*;

public class MainClassTest {
    @BeforeClass
    @Ignore
    public static void beforeClassMethod(){

    }

    @Before
    @Ignore
    public void setUp(){

    }

    @Test
    public void method1(){
       //...
       Assert.assertTrue(1 + 1 == 2);
       Assert.assertFalse(1 + 1 == 3);
    }

    @Test
    public void method2(){
        Assert.assertNull(null);
        Assert.assertNotNull(1);
    }

    @Test
    public void method3(){
        Assert.assertEquals(10, 5 + 5);
        Assert.assertNotEquals(10, 5 + 4);
    }

    @After
    @Ignore
    public void tearDown(){

    }

    @AfterClass
    @Ignore
    public static void afterClassMethod(){

    }
}
