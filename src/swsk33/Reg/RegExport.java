package swsk33.Reg;
public class RegExport {
	public void exportHKCR(String name,String filepath) throws Exception {		//导出HKEY_CLASSES_ROOT里面的某一项
		String cmd="cmd /c reg export \"HKCR\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKCU(String name,String filepath) throws Exception {		//导出HKEY_CURRENT_USER里面的某一项
		String cmd="cmd /c reg export \"HKCU\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKLM(String name,String filepath) throws Exception {		//导出HKEY_LOCAL_MACHINE里面的某一项
		String cmd="cmd /c reg export \"HKLM\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKU(String name,String filepath) throws Exception {		//导出HKEY_USERS里面的某一项
		String cmd="cmd /c reg export \"HKU\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void exportHKCC(String name,String filepath) throws Exception {		//导出HKEY_CURRENT_CONFIG里面的某一项
		String cmd="cmd /c reg export \"HKCC\\"+name+"\""+" "+"\""+filepath+"\""+" /y";
		Process run=Runtime.getRuntime().exec(cmd);
	}
}
