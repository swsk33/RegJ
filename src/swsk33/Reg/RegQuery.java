package swsk33.Reg;

import java.io.*;

public class RegQuery {
	// ��ѯHKEY_CLASSES_ROOT
	public String queryHKCR(String name) throws Exception { // ��ѯHKEY_CLASSES_ROOT�µ�ĳ���������������ơ����ͺ�ֵ
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

	public String queryHKCR(String name, String objname) throws Exception { // ��ѯHKEY_CLASSES_ROOT�µ�ĳ����������Ϣ
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

	public String queryHKCRve(String name) throws Exception { // ��ѯHKEY_CLASSES_ROOT�µ�ĳ���Ĭ��������Ϣ
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

	public boolean isHKCRexists(String name) throws Exception { // �ж�HKEY_CLASSES_ROOT�µ�ĳһ���Ƿ����
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

	public boolean isHKCRexists(String name, String objname) throws Exception { // �ж�HKEY_CLASSES_ROOT�µ�ĳһ��������Ƿ����
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

	public boolean isHKCRexistsve(String name) throws Exception { // �ж�HKEY_CLASSES_ROOT�µ�ĳһ���Ĭ��ֵ�������ݣ���Ϊ�գ�
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
		if (res.contains("��ֵδ����") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// ��ѯHKEY_CURRENT_USER
	public String queryHKCU(String name) throws Exception { // ��ѯHKEY_CURRENT_USER�µ�ĳ���������������ơ����ͺ�ֵ
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

	public String queryHKCU(String name, String objname) throws Exception { // ��ѯHKEY_CURRENT_USER�µ�ĳ����������Ϣ
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

	public String queryHKCUve(String name) throws Exception { // ��ѯHKEY_CURRENT_USER�µ�ĳ���Ĭ��������Ϣ
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

	public boolean isHKCUexists(String name) throws Exception { // �ж�HKEY_CURRENT_USER�µ�ĳһ���Ƿ����
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

	public boolean isHKCUexists(String name, String objname) throws Exception { // �ж�HKEY_CURRENT_USER�µ�ĳһ��������Ƿ����
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

	public boolean isHKCUexistsve(String name) throws Exception { // �ж�HKEY_CURRENT_USER�µ�ĳһ���Ĭ��ֵ�������ݣ���Ϊ�գ�
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
		if (res.contains("��ֵδ����") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// ��ѯHKEY_LOCAL_MACHINE
	public String queryHKLM(String name) throws Exception { // ��ѯHKEY_LOCAL_MACHINE�µ�ĳ���������������ơ����ͺ�ֵ
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

	public String queryHKLM(String name, String objname) throws Exception { // ��ѯHKEY_LOCAL_MACHINE�µ�ĳ����������Ϣ
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

	public String queryHKLMve(String name) throws Exception { // ��ѯHKEY_LOCAL_MACHINE�µ�ĳ���Ĭ��������Ϣ
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

	public boolean isHKLMexists(String name) throws Exception { // �ж�HKEY_LOCAL_MACHINE�µ�ĳһ���Ƿ����
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

	public boolean isHKLMexists(String name, String objname) throws Exception { // �ж�HKEY_LOCAL_MACHINE�µ�ĳһ��������Ƿ����
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

	public boolean isHKLMexistsve(String name) throws Exception { // �ж�HKEY_LOCAL_MACHINE�µ�ĳһ���Ĭ��ֵ�������ݣ���Ϊ�գ�
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
		if (res.contains("��ֵδ����") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// ��ѯHKEY_USERS
	public String queryHKU(String name) throws Exception { // ��ѯHKEY_USERS�µ�ĳ���������������ơ����ͺ�ֵ
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

	public String queryHKU(String name, String objname) throws Exception { // ��ѯHKEY_USERS�µ�ĳ����������Ϣ
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

	public String queryHKUve(String name) throws Exception { // ��ѯHKEY_USERS�µ�ĳ���Ĭ��������Ϣ
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

	public boolean isHKUexists(String name) throws Exception { // �ж�HKEY_USERS�µ�ĳһ���Ƿ����
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

	public boolean isHKUexists(String name, String objname) throws Exception { // �ж�HKEY_USERS�µ�ĳһ��������Ƿ����
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

	public boolean isHKUexistsve(String name) throws Exception { // �ж�HKEY_USERS�µ�ĳһ���Ĭ��ֵ�������ݣ���Ϊ�գ�
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
		if (res.contains("��ֵδ����") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	// ��ѯHKEY_CURRENT_CONFIG
	public String queryHKCC(String name) throws Exception { // ��ѯHKEY_CURRENT_CONFIG�µ�ĳ���������������ơ����ͺ�ֵ
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

	public String queryHKCC(String name, String objname) throws Exception { // ��ѯHKEY_CURRENT_CONFIG�µ�ĳ����������Ϣ
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

	public String queryHKCCve(String name) throws Exception { // ��ѯHKEY_CURRENT_CONFIG�µ�ĳ���Ĭ��������Ϣ
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

	public boolean isHKCCexists(String name) throws Exception { // �ж�HKEY_CURRENT_CONFIG�µ�ĳһ���Ƿ����
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

	public boolean isHKCCexists(String name, String objname) throws Exception { // �ж�HKEY_CURRENT_CONFIG�µ�ĳһ��������Ƿ����
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

	public boolean isHKCCexistsve(String name) throws Exception { // �ж�HKEY_CURRENT_CONFIG�µ�ĳһ���Ĭ��ֵ�������ݣ���Ϊ�գ�
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
		if (res.contains("��ֵδ����") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
}
