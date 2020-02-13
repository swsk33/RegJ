package swsk33.Reg;
public class RegExport {
	public void exportHKCR(String name,String filepath) throws Exception {		//导出HKEY_CLASSES_ROOT里面的某一项
		String cmd="cmd /c reg export HKCR\\"+name+" "+filepath+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
}
