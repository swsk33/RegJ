import swsk33.reg.*;
import swsk33.reg.exception.*;

public class MainTest {

	public static void main(String[] args) throws Exception {
		System.out.println(new RegQuery().queryHKLM("SYSTEM\\CurrentControlSet\\Control\\Session Manager\\Environment", "Path"));
	}

}
