package swsk33.reg;

/**
 * 删除注册表
 * 
 * @author swsk33
 *
 */
public class RegDelete {

	private RegQuery query = new RegQuery();

	/**
	 * 删除注册表里面的某项及其所有子项
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       要删除的项的名称
	 * @return 布尔值 删除成功返回true
	 * @throws Exception 权限不足时抛出异常
	 */
	public boolean del(String primaryKey, String name) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg delete \"" + primaryKey + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (!query.isRegExists(primaryKey, name)) {
			success = true;
		}
		return success;
	}

	/**
	 * 删除注册表里面的某项的某个值
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @return 布尔值 删除成功返回true
	 * @throws Exception 权限不足时抛出异常
	 */
	public boolean del(String primaryKey, String name, String objectName) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg delete \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (!query.isRegExists(primaryKey, name, objectName)) {
			success = true;
		}
		return success;
	}

	/**
	 * 删除（清空）注册表里面的某项的默认值
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       项的名称
	 * @return 布尔值 删除成功返回true
	 * @throws Exception 权限不足时抛出异常
	 */
	public boolean delDefaultValue(String primaryKey, String name) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg delete \"" + primaryKey + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (!query.isRegDefaultExists(primaryKey, name)) {
			success = true;
		}
		return success;
	}

}