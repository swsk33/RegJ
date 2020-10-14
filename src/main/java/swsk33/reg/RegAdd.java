package swsk33.reg;

import swsk33.reg.exception.TypeErrorException;

/**
 * 添加注册表项
 * 
 * @author swsk33
 *
 */
public class RegAdd {

	/**
	 * 注册表数据类型：REG_SZ
	 */
	public static final String REG_SZ = "REG_SZ";
	/**
	 * 注册表数据类型：REG_MULTI_SZ
	 */
	public static final String REG_MULTI_SZ = "REG_MULTI_SZ";
	/**
	 * 注册表数据类型：REG_EXPAND_SZ
	 */
	public static final String REG_EXPAND_SZ = "REG_EXPAND_SZ";
	/**
	 * 注册表数据类型：REG_DWORD
	 */
	public static final String REG_DWORD = "REG_DWORD";
	/**
	 * 注册表数据类型：REG_QWORD
	 */
	public static final String REG_QWORD = "REG_QWORD";
	/**
	 * 注册表数据类型：REG_BINARY
	 */
	public static final String REG_BINARY = "REG_BINARY";
	/**
	 * 注册表数据类型：REG_NONE
	 */
	public static final String REG_NONE = "REG_NONE";

	// HKEY_CLASSES_ROOT操作
	/**
	 * 在HKEY_CLASSES_ROOT里面添加空项
	 * 
	 * @param name 项名称
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public void addHKCR(String name) throws Exception {
		String cmd = "cmd /c reg add \"HKCR\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 在HKEY_CLASSES_ROOT里面添加项并指定其默认项的值，字符串值类型
	 * 
	 * @param name 项名称
	 * @param data 指定默认项的值
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public void addHKCR(String name, String data) throws Exception {
		String cmd = "cmd /c reg add \"HKCR\\" + name + "\"" + " /d " + "\"" + data + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	/**
	 * 在HKEY_CLASSES_ROOT里面添加项并指定其默认值的类型和值
	 * 
	 * @param name 项名称
	 * @param type 默认值的类型
	 * @param data 默认值的值
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public void addHKCR(String name, String type, String data) throws Exception {
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKCR\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /d " + "\"" + data
					+ "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	/**
	 * 在HKEY_CLASSES_ROOT里面添加项并指定项中值的类型、名称和值（若该项已存在，则会在该项中添加值）
	 * 
	 * @param name    项名称
	 * @param type    值的类型
	 * @param objname 值的名称
	 * @param data    值的值
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public void addHKCR(String name, String type, String objname, String data) throws Exception {
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKCR\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /v " + "\"" + objname
					+ "\"" + " /d " + "\"" + data + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	// HKEY_CURRENT_USER操作
	public void addHKCU(String name) throws Exception { // 在HKEY_CURRENT_USER里面添加空项
		String cmd = "cmd /c reg add \"HKCU\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKCU(String name, String data) throws Exception { // 在HKEY_CURRENT_USER里面添加项并指定其默认项的值，字符串值类型
		String cmd = "cmd /c reg add \"HKCU\\" + name + "\"" + " /d " + "\"" + data + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKCU(String name, String type, String data) throws Exception { // 在HKEY_CURRENT_USER里面添加项并指定其子项类型和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKCU\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /d " + "\"" + data
					+ "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	public void addHKCU(String name, String type, String objname, String data) throws Exception { // 在HKEY_CURRENT_USER里面添加项并指定其子项类型、名称和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKCU\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /v " + "\"" + objname
					+ "\"" + " /d " + "\"" + data + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	// HKEY_LOCAL_MACHINE操作
	public void addHKLM(String name) throws Exception { // 在HKEY_LOCAL_MACHINE里面添加空项
		String cmd = "cmd /c reg add \"HKLM\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKLM(String name, String data) throws Exception { // 在HKEY_LOCAL_MACHINE里面添加项并指定其默认项的值，字符串值类型
		String cmd = "cmd /c reg add \"HKLM\\" + name + "\"" + " /d " + "\"" + data + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKLM(String name, String type, String data) throws Exception { // 在HKEY_LOCAL_MACHINE里面添加项并指定其子项类型和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKLM\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /d " + "\"" + data
					+ "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	public void addHKLM(String name, String type, String objname, String data) throws Exception { // 在HKEY_LOCAL_MACHINE里面添加项并指定其子项类型、名称和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKLM\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /v " + "\"" + objname
					+ "\"" + " /d " + "\"" + data + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	// HKEY_USERS操作
	public void addHKU(String name) throws Exception { // 在HKEY_USERS里面添加空项
		String cmd = "cmd /c reg add \"HKU\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKU(String name, String data) throws Exception { // 在HKEY_USERS里面添加项并指定其默认项的值，字符串值类型
		String cmd = "cmd /c reg add \"HKU\\" + name + "\"" + " /d " + "\"" + data + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKU(String name, String type, String data) throws Exception { // 在HKEY_USERS里面添加项并指定其子项类型和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKU\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /d " + "\"" + data
					+ "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	public void addHKU(String name, String type, String objname, String data) throws Exception { // 在HKEY_USERS里面添加项并指定其子项类型、名称和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKU\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /v " + "\"" + objname
					+ "\"" + " /d " + "\"" + data + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	// HKEY_CURRENT_CONFIG操作
	public void addHKCC(String name) throws Exception { // 在HKEY_CURRENT_CONFIG里面添加空项
		String cmd = "cmd /c reg add \"HKCC\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKCC(String name, String data) throws Exception { // 在HKEY_CURRENT_CONFIG里面添加项并指定其默认项的值，字符串值类型
		String cmd = "cmd /c reg add \"HKCC\\" + name + "\"" + " /d " + "\"" + data + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void addHKCC(String name, String type, String data) throws Exception { // 在HKEY_CURRENT_CONFIG里面添加项并指定其子项类型和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKCC\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /d " + "\"" + data
					+ "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}

	public void addHKCC(String name, String type, String objname, String data) throws Exception { // 在HKEY_CURRENT_CONFIG里面添加项并指定其子项类型、名称和值
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"HKCC\\" + name + "\"" + " /t " + "\"" + type + "\"" + " /v " + "\"" + objname
					+ "\"" + " /d " + "\"" + data + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
		} else {
			throw new TypeErrorException();
		}
	}
}