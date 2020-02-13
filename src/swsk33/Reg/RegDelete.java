package swsk33.Reg;
public class RegDelete {
	public void delHKCR(String name) throws Exception {		//ɾ��HKEY_CLASSES_ROOT�����ĳ�����������
		String cmd="cmd /c reg delete HKCR\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCR(String name,String objname) throws Exception {		//ɾ��HKEY_CLASSES_ROOT�����ĳ���ĳ������
		String cmd="cmd /c reg delete HKCR\\"+name+" /v "+objname+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCRve(String name) throws Exception {		//ɾ��HKEY_CLASSES_ROOT�����ĳ���Ĭ��ֵ
		String cmd="cmd /c reg delete HKCR\\"+name+" /ve "+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCU(String name) throws Exception {		//ɾ��HKEY_CURRENT_USER�����ĳ�����������
		String cmd="cmd /c reg delete HKCU\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCU(String name,String objname) throws Exception {		//ɾ��HKEY_CURRENT_USER�����ĳ���ĳ������
		String cmd="cmd /c reg delete HKCU\\"+name+" /v "+objname+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCUve(String name) throws Exception {		//ɾ��HKEY_CURRENT_USER�����ĳ���Ĭ��ֵ
		String cmd="cmd /c reg delete HKCU\\"+name+" /ve "+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKLM(String name) throws Exception {		//ɾ��HKEY_LOCAL_MACHINE�����ĳ�����������
		String cmd="cmd /c reg delete HKLM\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKLM(String name,String objname) throws Exception {		//ɾ��HKEY_LOCAL_MACHINE�����ĳ���ĳ������
		String cmd="cmd /c reg delete HKLM\\"+name+" /v "+objname+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKLMve(String name) throws Exception {		//ɾ��HKEY_LOCAL_MACHINE�����ĳ���Ĭ��ֵ
		String cmd="cmd /c reg delete HKLM\\"+name+" /ve "+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKU(String name) throws Exception {		//ɾ��HKEY_USERS�����ĳ�����������
		String cmd="cmd /c reg delete HKU\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKU(String name,String objname) throws Exception {		//ɾ��HKEY_USERS�����ĳ���ĳ������
		String cmd="cmd /c reg delete HKU\\"+name+" /v "+objname+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKUve(String name) throws Exception {		//ɾ��HKEY_USERS�����ĳ���Ĭ��ֵ
		String cmd="cmd /c reg delete HKU\\"+name+" /ve "+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCC(String name) throws Exception {		//ɾ��HKEY_CURRENT_CONFIG�����ĳ�����������
		String cmd="cmd /c reg delete HKCC\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCC(String name,String objname) throws Exception {		//ɾ��HKEY_CURRENT_CONFIG�����ĳ���ĳ������
		String cmd="cmd /c reg delete HKCC\\"+name+" /v "+objname+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void delHKCCve(String name) throws Exception {		//ɾ��HKEY_CURRENT_CONFIG�����ĳ���Ĭ��ֵ
		String cmd="cmd /c reg delete HKCC\\"+name+" /ve "+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
}
