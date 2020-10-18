package swsk33.reg;

/**
 * 删除注册表
 * 
 * @author swsk33
 *
 */
public class RegDelete {

	/**
	 * 删除注册表里面的某项及其所有子项
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       要删除的项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void del(String primaryKey, String name) throws Exception {
		String cmd = "cmd /c reg delete \"" + primaryKey + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除注册表里面的某项的某个值
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void del(String primaryKey, String name, String objectName) throws Exception {
		String cmd = "cmd /c reg delete \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除（清空）注册表里面的某项的默认值
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delDefaultValue(String primaryKey, String name) throws Exception {
		String cmd = "cmd /c reg delete \"" + primaryKey + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

}