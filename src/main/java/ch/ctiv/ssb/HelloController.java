package ch.ctiv.ssb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/welcome")
	public Wink index() {
		String index = System.getenv("INSTANCE_INDEX");
		return new Wink((index == null) ? "N/A" : index, "Herzlich willkommen!");
	}

	public static class Wink {

		private String index;
		private String message;

		private Wink(String index, String message) {
			this.index = index;
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public String getIndex() {
			return index;
		}

	}

}
