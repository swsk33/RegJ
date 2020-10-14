package swsk33.reg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 查询注册表
 * 
 * @author swsk33
 *
 */
public class RegQuery {

	// 查询HKEY_CLASSES_ROOT
	/**
	 * 查询HKEY_CLASSES_ROOT下的某项及其所有值的名称、类型和值
	 * 
	 * @param name 查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCR(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_CLASSES_ROOT下的某项的值的信息
	 * 
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCR(String name, String objectName) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_CLASSES_ROOT下的某项的默认值信息
	 * 
	 * @param name 查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCRve(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 判断HKEY_CLASSES_ROOT下的某一项是否存在
	 * 
	 * @param name 判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCRexists(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_CLASSES_ROOT下的某一项的值是否存在
	 * 
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCRexists(String name, String objectName) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("" + "\r\n" + "" + "\r\n" + "") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_CLASSES_ROOT下的某一项的默认值是有内容（不为空）
	 * 
	 * @param name 判断项的名称
	 * @return 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCRexistsve(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.contains("数值未设置") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// 查询HKEY_CURRENT_USER
	/**
	 * 查询HKEY_CURRENT_USER下的某项及其所有值的名称、类型和值
	 * 
	 * @param name 查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCU(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCU\\" + name + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_CURRENT_USER下的某项的值的信息
	 * 
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCU(String name, String objectName) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCU\\" + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_CURRENT_USER下的某项的默认值信息
	 * 
	 * @param name 查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCUve(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCU\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 判断HKEY_CURRENT_USER下的某一项是否存在
	 * 
	 * @param name 判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCUexists(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCU\\" + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_CURRENT_USER下的某一项的值是否存在
	 * 
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCUexists(String name, String objname) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCU\\" + name + "\"" + " /v " + "\"" + objname + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("" + "\r\n" + "" + "\r\n" + "") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_CURRENT_USER下的某一项的默认值是有内容（不为空）
	 * 
	 * @param name 判断项的名称
	 * @return 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCUexistsve(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCU\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.contains("数值未设置") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// 查询HKEY_LOCAL_MACHINE
	/**
	 * 查询HKEY_LOCAL_MACHINE下的某项及其所有值的名称、类型和值
	 * 
	 * @param name 查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKLM(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKLM\\" + name + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_LOCAL_MACHINE下的某项的值的信息
	 * 
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKLM(String name, String objectName) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKLM\\" + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_LOCAL_MACHINE下的某项的默认值信息
	 * 
	 * @param name 查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKLMve(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKLM\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 判断HKEY_LOCAL_MACHINE下的某一项是否存在
	 * 
	 * @param name 判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKLMexists(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKLM\\" + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_LOCAL_MACHINE下的某一项的值是否存在
	 * 
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKLMexists(String name, String objname) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKLM\\" + name + "\"" + " /v " + "\"" + objname + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("" + "\r\n" + "" + "\r\n" + "") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_LOCAL_MACHINE下的某一项的默认值是有内容（不为空）
	 * 
	 * @param name 判断项的名称
	 * @return 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKLMexistsve(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKLM\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.contains("数值未设置") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// 查询HKEY_USERS
	/**
	 * 查询HKEY_USERS下的某项及其所有值的名称、类型和值
	 * 
	 * @param name 查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKU(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKU\\" + name + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_USERS下的某项的值的信息
	 * 
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKU(String name, String objectName) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKU\\" + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_USERS下的某项的默认值信息
	 * 
	 * @param name 查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKUve(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKU\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 判断HKEY_USERS下的某一项是否存在
	 * 
	 * @param name 判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKUexists(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKU\\" + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_USERS下的某一项的值是否存在
	 * 
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKUexists(String name, String objname) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKU\\" + name + "\"" + " /v " + "\"" + objname + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("" + "\r\n" + "" + "\r\n" + "") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_USERS下的某一项的默认值是有内容（不为空）
	 * 
	 * @param name 判断项的名称
	 * @return 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKUexistsve(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKU\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.contains("数值未设置") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// 查询HKEY_CURRENT_CONFIG
	/**
	 * 查询HKEY_CURRENT_CONFIG下的某项及其所有值的名称、类型和值
	 * 
	 * @param name 查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCC(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCC\\" + name + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_CURRENT_CONFIG下的某项的值的信息
	 * 
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCC(String name, String objectName) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCC\\" + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询HKEY_CURRENT_CONFIG下的某项的默认值信息
	 * 
	 * @param name 查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryHKCCve(String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"HKCC\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 判断HKEY_CURRENT_CONFIG下的某一项是否存在
	 * 
	 * @param name 判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCCexists(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCC\\" + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_CURRENT_CONFIG下的某一项的值是否存在
	 * 
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCCexists(String name, String objname) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCC\\" + name + "\"" + " /v " + "\"" + objname + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("" + "\r\n" + "" + "\r\n" + "") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断HKEY_CURRENT_CONFIG下的某一项的默认值是有内容（不为空）
	 * 
	 * @param name 判断项的名称
	 * @return 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isHKCCexistsve(String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCC\\" + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.contains("数值未设置") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
}
