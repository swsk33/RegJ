package com.gitee.swsk33.reg;

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
	 * @param primaryKey 要操作的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       要删除的项的名称
	 * @return 布尔值 删除成功返回true
	 * @throws Exception 权限不足时抛出异常
	 */
	public static boolean del(String primaryKey, String name) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg delete \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (!RegQuery.isRegExists(primaryKey, name)) {
			success = true;
		}
		return success;
	}

	/**
	 * 删除注册表里面的某项的某个值
	 * 
	 * @param primaryKey 要操作的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       项的名称
	 * @param objectName 要删除的值的名称
	 * @return 布尔值 删除成功返回true
	 * @throws Exception 权限不足时抛出异常
	 */
	public static boolean del(String primaryKey, String name, String objectName) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg delete \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /v " + "\"" + InternalUtils.stringProcessing(objectName) + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (!RegQuery.isRegExists(primaryKey, name, objectName)) {
			success = true;
		}
		return success;
	}

	/**
	 * 删除（清空）注册表里面的某项的默认值
	 * 
	 * @param primaryKey 要操作的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       项的名称
	 * @return 布尔值 删除成功返回true
	 * @throws Exception 权限不足时抛出异常
	 */
	public static boolean delDefaultValue(String primaryKey, String name) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg delete \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (!RegQuery.isRegDefaultExists(primaryKey, name)) {
			success = true;
		}
		return success;
	}

}