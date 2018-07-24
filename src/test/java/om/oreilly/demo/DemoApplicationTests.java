package om.oreilly.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.NumberFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ApplicationContext ctx;

    @Qualifier("frenchCurrencyFormatter")
    @Autowired
    private NumberFormat nf;

	@Test
	public void contextLoads() {
	}


    @Test
    public void testLocalCurrencyFormat(){
        double amount = 12345678.90123456;
        NumberFormat local = ctx.getBean("localCurrencyFormatter", NumberFormat.class);
        String formatted = local.format(amount);
        System.out.println(formatted);
    }

    @Test
    public void testWiredLocalCurrencyFormat(){
        double amount = 12345678.90123456;
        String formatted = nf.format(amount);
        System.out.println(formatted);
    }
}
