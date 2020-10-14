import swsk33.reg.*;
import swsk33.reg.exception.*;

public class MainTest {

	public static void main(String[] args) throws Exception {
		// new RegAdd().addHKCR("*\\shell\\")
		new RegAdd().addHKCR("*\\shell\\aas", RegAdd.REG_NONE, "aaasa");
		System.out.println("a");
	}

}
