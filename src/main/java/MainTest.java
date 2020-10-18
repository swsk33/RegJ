import swsk33.reg.*;
import swsk33.reg.utils.*;

public class MainTest {

	public static void main(String[] args) throws Exception {

		RegAdd ra = new RegAdd();
		RegDelete rd = new RegDelete();
		RegExport re = new RegExport();
		RegImport ri = new RegImport();
		RegQuery rq = new RegQuery();
		// ra.add(RegPrimaryKey.HKCR, "swsk33Test", RegDataType.REG_MULTI_SZ, "val",
		// "默认值mul");
		// rd.del(RegPrimaryKey.HKCR, "swsk33Test");
		// re.export(RegPrimaryKey.HKCR, "*", "E:\\a.reg");
		// ri.importReg("E:\\hbx.reg");
		String s = rq.query(RegPrimaryKey.HKCR, "*\\shell\\HBuilderX", "icon");
		System.out.println(s);
		
	}

}
