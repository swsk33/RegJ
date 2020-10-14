package swsk33.reg;

/**
 * 从文件导入注册表
 * 
 * @author swsk33
 *
 */
public class RegImport {

	/**
	 * 从注册表文件(reg文件)导入注册表
	 * 
	 * @param filePath 导入的reg文件路径
	 * @throws Exception 权限不足抛出异常
	 */
	public void importReg(String filePath) throws Exception {
		String cmd = "cmd /c regedit /s " + "\"" + filePath + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
	}
	
}