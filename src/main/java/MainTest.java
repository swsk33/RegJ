import swsk33.reg.*;
import swsk33.reg.utils.*;

public class MainTest {

	public static void main(String[] args) throws Exception {

		RegAdd ra = new RegAdd();
		RegDelete rd = new RegDelete();
		RegExport re = new RegExport();
		RegImport ri = new RegImport();
		RegQuery rq = new RegQuery();
		boolean a = rd.del(RegPrimaryKey.HKCR, "swsk33Test");
		System.out.println(a);
		//String s = rq.queryDefaultValue(RegPrimaryKey.HKCR, "swsk33Test");
		//System.out.println(s);
	}

}
