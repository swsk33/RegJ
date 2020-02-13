package swsk33.Reg;
public class RegImport {		//从注册表文件(reg文件)导入注册表
	public void importReg(String filepath) throws Exception {
		String cmd="cmd /c regedit /s "+filepath;
		Process run=Runtime.getRuntime().exec(cmd);
	}
}
