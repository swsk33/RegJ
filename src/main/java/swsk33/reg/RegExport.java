package swsk33.reg;

/**
 * 导出注册表
 * 
 * @author swsk33
 *
 */
public class RegExport {

	/**
	 * 导出注册表里面的某一项
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       待导出项名称
	 * @param filePath   导出路径
	 * @throws Exception 权限不足抛出异常
	 */
	public void export(String primaryKey, String name, String filePath) throws Exception {
		String cmd = "cmd /c reg export \"" + primaryKey + name + "\"" + " " + "\"" + filePath + "\"" + " /y";
		Process run = Runtime.getRuntime().exec(cmd);
	}

}
