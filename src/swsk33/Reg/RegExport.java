package swsk33.Reg;
public class RegExport {
	public void exportHKCR(String name,String filepath) throws Exception {		//����HKEY_CLASSES_ROOT�����ĳһ��
		String cmd="cmd /c reg export \"HKCR\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKCU(String name,String filepath) throws Exception {		//����HKEY_CURRENT_USER�����ĳһ��
		String cmd="cmd /c reg export \"HKCU\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKLM(String name,String filepath) throws Exception {		//����HKEY_LOCAL_MACHINE�����ĳһ��
		String cmd="cmd /c reg export \"HKLM\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKU(String name,String filepath) throws Exception {		//����HKEY_USERS�����ĳһ��
		String cmd="cmd /c reg export \"HKU\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKCC(String name,String filepath) throws Exception {		//����HKEY_CURRENT_CONFIG�����ĳһ��
		String cmd="cmd /c reg export \"HKCC\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
}
