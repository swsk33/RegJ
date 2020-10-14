package swsk33.reg;

public class RegDelete {
	// 操作HKEY_CLASSES_ROOT
	public void delHKCR(String name) throws Exception { // 删除HKEY_CLASSES_ROOT里面的某项及其所有子项
		String cmd = "cmd /c reg delete \"HKCR\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKCR(String name, String objname) throws Exception { // 删除HKEY_CLASSES_ROOT里面的某项的某个子项
		String cmd = "cmd /c reg delete \"HKCR\\" + name + "\"" + " /v " + "\"" + objname + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKCRve(String name) throws Exception { // 删除HKEY_CLASSES_ROOT里面的某项的默认值
		String cmd = "cmd /c reg delete \"HKCR\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_CURRENT_USER
	public void delHKCU(String name) throws Exception { // 删除HKEY_CURRENT_USER里面的某项及其所有子项
		String cmd = "cmd /c reg delete \"HKCU\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKCU(String name, String objname) throws Exception { // 删除HKEY_CURRENT_USER里面的某项的某个子项
		String cmd = "cmd /c reg delete \"HKCU\\" + name + "\"" + " /v " + "\"" + objname + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKCUve(String name) throws Exception { // 删除HKEY_CURRENT_USER里面的某项的默认值
		String cmd = "cmd /c reg delete \"HKCU\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_LOCAL_MACHINE
	public void delHKLM(String name) throws Exception { // 删除HKEY_LOCAL_MACHINE里面的某项及其所有子项
		String cmd = "cmd /c reg delete \"HKLM\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKLM(String name, String objname) throws Exception { // 删除HKEY_LOCAL_MACHINE里面的某项的某个子项
		String cmd = "cmd /c reg delete \"HKLM\\" + name + "\"" + " /v " + "\"" + objname + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKLMve(String name) throws Exception { // 删除HKEY_LOCAL_MACHINE里面的某项的默认值
		String cmd = "cmd /c reg delete \"HKLM\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_USERS
	public void delHKU(String name) throws Exception { // 删除HKEY_USERS里面的某项及其所有子项
		String cmd = "cmd /c reg delete \"HKU\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKU(String name, String objname) throws Exception { // 删除HKEY_USERS里面的某项的某个子项
		String cmd = "cmd /c reg delete \"HKU\\" + name + "\"" + " /v " + "\"" + objname + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKUve(String name) throws Exception { // 删除HKEY_USERS里面的某项的默认值
		String cmd = "cmd /c reg delete \"HKU\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	// 操作HKEY_CURRENT_CONFIG
	public void delHKCC(String name) throws Exception { // 删除HKEY_CURRENT_CONFIG里面的某项及其所有子项
		String cmd = "cmd /c reg delete \"HKCC\\" + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKCC(String name, String objname) throws Exception { // 删除HKEY_CURRENT_CONFIG里面的某项的某个子项
		String cmd = "cmd /c reg delete \"HKCC\\" + name + "\"" + " /v " + "\"" + objname + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}

	public void delHKCCve(String name) throws Exception { // 删除HKEY_CURRENT_CONFIG里面的某项的默认值
		String cmd = "cmd /c reg delete \"HKCC\\" + name + "\"" + " /ve " + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
	}
}
