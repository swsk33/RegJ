package swsk33.Reg;
public class RegExport {
	public void exportHKCR(String name,String filepath) throws Exception {		//����HKEY_CLASSES_ROOT�����ĳһ��
		String cmd="cmd /c reg export HKCR\\"+name+" "+filepath+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
}
