package swsk33.reg;

public class RegExport {

	/**
	 * 导出HKEY_CLASSES_ROOT里面的某一项
	 * 
	 * @param name     待导出项名称
	 * @param filePath 导出路径
	 * @throws Exception 权限不足抛出异常
	 */
	public void exportHKCR(String name, String filePath) throws Exception {
		String cmd = "cmd /c reg export \"HKCR\\" + name + "\"" + " " + "\"" + filePath + "\"" + " /y";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 导出HKEY_CURRENT_USER里面的某一项
	 * 
	 * @param name     待导出项名称
	 * @param filePath 导出路径
	 * @throws Exception 权限不足抛出异常
	 */
	public void exportHKCU(String name, String filePath) throws Exception {
		String cmd = "cmd /c reg export \"HKCU\\" + name + "\"" + " " + "\"" + filePath + "\"" + " /y";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 导出HKEY_LOCAL_MACHINE里面的某一项
	 * 
	 * @param name     待导出项名称
	 * @param filePath 导出路径
	 * @throws Exception 权限不足抛出异常
	 */
	public void exportHKLM(String name, String filePath) throws Exception {
		String cmd = "cmd /c reg export \"HKLM\\" + name + "\"" + " " + "\"" + filePath + "\"" + " /y";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 导出HKEY_USERS里面的某一项
	 * 
	 * @param name     待导出项名称
	 * @param filePath 导出路径
	 * @throws Exception 权限不足抛出异常
	 */
	public void exportHKU(String name, String filePath) throws Exception {
		String cmd = "cmd /c reg export \"HKU\\" + name + "\"" + " " + "\"" + filePath + "\"" + " /y";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 导出HKEY_CURRENT_CONFIG里面的某一项
	 * 
	 * @param name     待导出项名称
	 * @param filePath 导出路径
	 * @throws Exception 权限不足抛出异常
	 */
	public void exportHKCC(String name, String filePath) throws Exception {
		String cmd = "cmd /c reg export \"HKCC\\" + name + "\"" + " " + "\"" + filePath + "\"" + " /y";
		Process run = Runtime.getRuntime().exec(cmd);
	}

}
