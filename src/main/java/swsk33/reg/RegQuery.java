package swsk33.reg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegQuery {
	// 查询HKEY_CLASSES_ROOT
	public String queryHKCR(String name) throws Exception { // 查询HKEY_CLASSES_ROOT下的某项及其所有子项的名称、类型和值
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

	public String queryHKCR(String name, String objname) throws Exception { // 查询HKEY_CLASSES_ROOT下的某项的子项的信息
		String result = "";
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"" + " /v " + "\"" + objname + "\"";
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

	public String queryHKCRve(String name) throws Exception { // 查询HKEY_CLASSES_ROOT下的某项的默认子项信息
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

	public boolean isHKCRexists(String name) throws Exception { // 判断HKEY_CLASSES_ROOT下的某一项是否存在
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

	public boolean isHKCRexists(String name, String objname) throws Exception { // 判断HKEY_CLASSES_ROOT下的某一项的子项是否存在
		boolean result = false;
		String cmd = "cmd /c reg query \"HKCR\\" + name + "\"" + " /v " + "\"" + objname + "\"";
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

	public boolean isHKCRexistsve(String name) throws Exception { // 判断HKEY_CLASSES_ROOT下的某一项的默认值是有内容（不为空）
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
	public String queryHKCU(String name) throws Exception { // 查询HKEY_CURRENT_USER下的某项及其所有子项的名称、类型和值
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

	public String queryHKCU(String name, String objname) throws Exception { // 查询HKEY_CURRENT_USER下的某项的子项的信息
		String result = "";
		String cmd = "cmd /c reg query \"HKCU\\" + name + "\"" + " /v " + "\"" + objname + "\"";
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

	public String queryHKCUve(String name) throws Exception { // 查询HKEY_CURRENT_USER下的某项的默认子项信息
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

	public boolean isHKCUexists(String name) throws Exception { // 判断HKEY_CURRENT_USER下的某一项是否存在
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

	public boolean isHKCUexists(String name, String objname) throws Exception { // 判断HKEY_CURRENT_USER下的某一项的子项是否存在
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

	public boolean isHKCUexistsve(String name) throws Exception { // 判断HKEY_CURRENT_USER下的某一项的默认值是有内容（不为空）
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
	public String queryHKLM(String name) throws Exception { // 查询HKEY_LOCAL_MACHINE下的某项及其所有子项的名称、类型和值
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

	public String queryHKLM(String name, String objname) throws Exception { // 查询HKEY_LOCAL_MACHINE下的某项的子项的信息
		String result = "";
		String cmd = "cmd /c reg query \"HKLM\\" + name + "\"" + " /v " + "\"" + objname + "\"";
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

	public String queryHKLMve(String name) throws Exception { // 查询HKEY_LOCAL_MACHINE下的某项的默认子项信息
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

	public boolean isHKLMexists(String name) throws Exception { // 判断HKEY_LOCAL_MACHINE下的某一项是否存在
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

	public boolean isHKLMexists(String name, String objname) throws Exception { // 判断HKEY_LOCAL_MACHINE下的某一项的子项是否存在
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

	public boolean isHKLMexistsve(String name) throws Exception { // 判断HKEY_LOCAL_MACHINE下的某一项的默认值是有内容（不为空）
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
	public String queryHKU(String name) throws Exception { // 查询HKEY_USERS下的某项及其所有子项的名称、类型和值
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

	public String queryHKU(String name, String objname) throws Exception { // 查询HKEY_USERS下的某项的子项的信息
		String result = "";
		String cmd = "cmd /c reg query \"HKU\\" + name + "\"" + " /v " + "\"" + objname + "\"";
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

	public String queryHKUve(String name) throws Exception { // 查询HKEY_USERS下的某项的默认子项信息
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

	public boolean isHKUexists(String name) throws Exception { // 判断HKEY_USERS下的某一项是否存在
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

	public boolean isHKUexists(String name, String objname) throws Exception { // 判断HKEY_USERS下的某一项的子项是否存在
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

	public boolean isHKUexistsve(String name) throws Exception { // 判断HKEY_USERS下的某一项的默认值是有内容（不为空）
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
	public String queryHKCC(String name) throws Exception { // 查询HKEY_CURRENT_CONFIG下的某项及其所有子项的名称、类型和值
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

	public String queryHKCC(String name, String objname) throws Exception { // 查询HKEY_CURRENT_CONFIG下的某项的子项的信息
		String result = "";
		String cmd = "cmd /c reg query \"HKCC\\" + name + "\"" + " /v " + "\"" + objname + "\"";
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

	public String queryHKCCve(String name) throws Exception { // 查询HKEY_CURRENT_CONFIG下的某项的默认子项信息
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

	public boolean isHKCCexists(String name) throws Exception { // 判断HKEY_CURRENT_CONFIG下的某一项是否存在
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

	public boolean isHKCCexists(String name, String objname) throws Exception { // 判断HKEY_CURRENT_CONFIG下的某一项的子项是否存在
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

	public boolean isHKCCexistsve(String name) throws Exception { // 判断HKEY_CURRENT_CONFIG下的某一项的默认值是有内容（不为空）
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
