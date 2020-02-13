package swsk33.Reg;
public class RegAdd {
	public void addHKCR(String name) throws Exception {		//��HKEY_CLASSES_ROOT������ӿ���
		String cmd="cmd /c reg add HKCR\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCR(String name,String data) throws Exception {		//��HKEY_CLASSES_ROOT��������ָ����Ĭ�����ֵ���ַ���ֵ����
		String cmd="cmd /c reg add HKCR\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCR(String name,String type,String data) throws Exception {		//��HKEY_CLASSES_ROOT��������ָ�����������ͺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCR\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
	public void addHKCR(String name,String type,String objname,String data) throws Exception {		//��HKEY_CLASSES_ROOT��������ָ�����������͡����ƺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCR\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
	public void addHKCU(String name) throws Exception {		//��HKEY_CURRENT_USER������ӿ���
		String cmd="cmd /c reg add HKCU\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCU(String name,String data) throws Exception {		//��HKEY_CURRENT_USER��������ָ����Ĭ�����ֵ���ַ���ֵ����
		String cmd="cmd /c reg add HKCU\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCU(String name,String type,String data) throws Exception {		//��HKEY_CURRENT_USER��������ָ�����������ͺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCU\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
	public void addHKCU(String name,String type,String objname,String data) throws Exception {		//��HKEY_CURRENT_USER��������ָ�����������͡����ƺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCU\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
	public void addHKLM(String name) throws Exception {		//��HKEY_LOCAL_MACHINE������ӿ���
		String cmd="cmd /c reg add HKLM\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKLM(String name,String data) throws Exception {		//��HKEY_LOCAL_MACHINE��������ָ����Ĭ�����ֵ���ַ���ֵ����
		String cmd="cmd /c reg add HKLM\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKLM(String name,String type,String data) throws Exception {		//��HKEY_LOCAL_MACHINE��������ָ�����������ͺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKLM\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
	public void addHKLM(String name,String type,String objname,String data) throws Exception {		//��HKEY_LOCAL_MACHINE��������ָ�����������͡����ƺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKLM\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
	public void addHKU(String name) throws Exception {		//��HKEY_USERS������ӿ���
		String cmd="cmd /c reg add HKU\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKU(String name,String data) throws Exception {		//��HKEY_USERS��������ָ����Ĭ�����ֵ���ַ���ֵ����
		String cmd="cmd /c reg add HKU\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKU(String name,String type,String data) throws Exception {		//��HKEY_USERS��������ָ�����������ͺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKU\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
	public void addHKU(String name,String type,String objname,String data) throws Exception {		//��HKEY_USERS��������ָ�����������͡����ƺ�ֵ
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKU\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("�������ʹ��󣡱�����REG_SZ���ַ���ֵ��,REG_MULTI_SZ�����ַ���ֵ��,REG_EXPAND_SZ������չ�ַ���ֵ��,REG_DWORD��DWORDֵ��,REG_QWORD��QWORDֵ��,REG_BINARY��������ֵ������REG_NONE���ޣ�(�ɲ��ִ�Сд)");
		}
	}
}
