package swsk33.reg;

import java.io.File;

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
	 * @return 布尔值 导出成功返回true
	 * @throws Exception 权限不足抛出异常
	 */
	public boolean export(String primaryKey, String name, String filePath) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg export \"" + primaryKey + name + "\"" + " " + "\"" + filePath + "\"" + " /y";
		Process run = Runtime.getRuntime().exec(cmd);
		if (new File(filePath).exists()) {
			success = true;
		}
		return success;
	}

}