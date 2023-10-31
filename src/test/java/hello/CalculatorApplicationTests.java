package hello;

import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class CalculatorApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	public void addTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/calculator/add?op1=1&op2=2", String.class);
			assertThat(body).isEqualTo("1.0 + 2.0 = 3.0");
	}

	@Test
	@Order(2)
	public void minusTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/calculator/minus?op1=1&op2=2", String.class);
		assertThat(body).isEqualTo("1.0 - 2.0 = -1.0");
	}

	@Test
	@Order(3)
	public void divisionTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/calculator/divide?op1=1&op2=2", String.class);
		assertThat(body).isEqualTo("1.0 / 2.0 = 0.5");
	}

	@Test
	@Order(4)
	public void divisionZeroTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/calculator/divide?op1=1&op2=0", String.class);
		assertThat(body).isEqualTo("1.0 / 0.0 = Infinity");
	}

	@Test
	@Order(5)
	public void productTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/calculator/product?op1=1&op2=2", String.class);
		assertThat(body).isEqualTo("1.0 x 2.0 = 2.0");
	}

	@Test
	@Order(6)
	public void historyTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/calculator/history", String.class);
		assertThat(body).isEqualTo("1.0 + 2.0 = 3.0 <br> 1.0 - 2.0 = -1.0 <br> 1.0 / 2.0 = 0.5 <br> Infinity <br> 1.0 x 2.0 = 2.0");
	}

	@Test
	@Order(7)
	public void clearHistoryTest() {
		String body = this.restTemplate.getForObject("http://localhost:8080/calculator/clear", String.class);
		assertThat(body).isEqualTo("history cleared");
	}
}
