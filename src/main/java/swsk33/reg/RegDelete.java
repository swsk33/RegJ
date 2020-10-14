package swsk33.reg;

/**
 * 删除注册表
 * 
 * @author swsk33
 *
 */
public class RegDelete {

	// 操作HKEY_CLASSES_ROOT
	/**
	 * 删除HKEY_CLASSES_ROOT里面的某项及其所有子项
	 * 
	 * @param name 要删除的项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCR(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKCR\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_CLASSES_ROOT里面的某项的某个值
	 * 
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCR(String name, String objectName) throws Exception {
		String cmd = "cmd /c reg delete \"HKCR\\" + name + "\"" + " /v " + "\"" + objectName + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_CLASSES_ROOT里面的某项的默认值
	 * 
	 * @param name 项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCRve(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKCR\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_CURRENT_USER
	/**
	 * 删除HKEY_CURRENT_USER里面的某项及其所有子项
	 * 
	 * @param name 要删除的项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCU(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKCU\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_CURRENT_USER里面的某项的某个值
	 * 
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCU(String name, String objectName) throws Exception {
		String cmd = "cmd /c reg delete \"HKCU\\" + name + "\"" + " /v " + "\"" + objectName + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_CURRENT_USER里面的某项的默认值
	 * 
	 * @param name 项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCUve(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKCU\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_LOCAL_MACHINE
	/**
	 * 删除HKEY_LOCAL_MACHINE里面的某项及其所有子项
	 * 
	 * @param name 要删除的项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKLM(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKLM\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_LOCAL_MACHINE里面的某项的某个值
	 * 
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKLM(String name, String objectName) throws Exception {
		String cmd = "cmd /c reg delete \"HKLM\\" + name + "\"" + " /v " + "\"" + objectName + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_LOCAL_MACHINE里面的某项的默认值
	 * 
	 * @param name 项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKLMve(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKLM\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_USERS
	/**
	 * 删除HKEY_USERS里面的某项及其所有子项
	 * 
	 * @param name 要删除的项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKU(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKU\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_USERS里面的某项的某个值
	 * 
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKU(String name, String objectName) throws Exception {
		String cmd = "cmd /c reg delete \"HKU\\" + name + "\"" + " /v " + "\"" + objectName + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_USERS里面的某项的默认值
	 * 
	 * @param name 项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKUve(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKU\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_CURRENT_CONFIG
	/**
	 * 删除HKEY_CURRENT_CONFIG里面的某项及其所有子项
	 * 
	 * @param name 要删除的项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCC(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKCC\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_CURRENT_CONFIG里面的某项的某个值
	 * 
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCC(String name, String objectName) throws Exception {
		String cmd = "cmd /c reg delete \"HKCC\\" + name + "\"" + " /v " + "\"" + objectName + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 删除HKEY_CURRENT_CONFIG里面的某项的默认值
	 * 
	 * @param name 项的名称
	 * @throws Exception 权限不足时抛出异常
	 */
	public void delHKCCve(String name) throws Exception {
		String cmd = "cmd /c reg delete \"HKCC\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}
}