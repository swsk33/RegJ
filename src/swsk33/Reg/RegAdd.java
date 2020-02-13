package swsk33.Reg;
public class RegAdd {
	public void addHKCR(String name) throws Exception {		//在HKEY_CLASSES_ROOT里面添加空项
		String cmd="cmd /c reg add HKCR\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCR(String name,String data) throws Exception {		//在HKEY_CLASSES_ROOT里面添加项并指定其默认项的值，字符串值类型
		String cmd="cmd /c reg add HKCR\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCR(String name,String type,String data) throws Exception {		//在HKEY_CLASSES_ROOT里面添加项并指定其子项类型和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCR\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
	public void addHKCR(String name,String type,String objname,String data) throws Exception {		//在HKEY_CLASSES_ROOT里面添加项并指定其子项类型、名称和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCR\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
	public void addHKCU(String name) throws Exception {		//在HKEY_CURRENT_USER里面添加空项
		String cmd="cmd /c reg add HKCU\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCU(String name,String data) throws Exception {		//在HKEY_CURRENT_USER里面添加项并指定其默认项的值，字符串值类型
		String cmd="cmd /c reg add HKCU\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKCU(String name,String type,String data) throws Exception {		//在HKEY_CURRENT_USER里面添加项并指定其子项类型和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCU\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
	public void addHKCU(String name,String type,String objname,String data) throws Exception {		//在HKEY_CURRENT_USER里面添加项并指定其子项类型、名称和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKCU\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
	public void addHKLM(String name) throws Exception {		//在HKEY_LOCAL_MACHINE里面添加空项
		String cmd="cmd /c reg add HKLM\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKLM(String name,String data) throws Exception {		//在HKEY_LOCAL_MACHINE里面添加项并指定其默认项的值，字符串值类型
		String cmd="cmd /c reg add HKLM\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKLM(String name,String type,String data) throws Exception {		//在HKEY_LOCAL_MACHINE里面添加项并指定其子项类型和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKLM\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
	public void addHKLM(String name,String type,String objname,String data) throws Exception {		//在HKEY_LOCAL_MACHINE里面添加项并指定其子项类型、名称和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKLM\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
	public void addHKU(String name) throws Exception {		//在HKEY_USERS里面添加空项
		String cmd="cmd /c reg add HKU\\"+name+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKU(String name,String data) throws Exception {		//在HKEY_USERS里面添加项并指定其默认项的值，字符串值类型
		String cmd="cmd /c reg add HKU\\"+name+" /d "+data+" /f";
		Process run=Runtime.getRuntime().exec(cmd);
	}
	public void addHKU(String name,String type,String data) throws Exception {		//在HKEY_USERS里面添加项并指定其子项类型和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKU\\"+name+" /t "+type+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
	public void addHKU(String name,String type,String objname,String data) throws Exception {		//在HKEY_USERS里面添加项并指定其子项类型、名称和值
		if(type.equals("REG_SZ")||type.equals("REG_MULTI_SZ")||type.equals("REG_EXPAND_SZ")||type.equals("REG_DWORD")||type.equals("REG_QWORD")||type.equals("REG_BINARY")||type.equals("REG_NONE")||type.equals("reg_sz")||type.equals("reg_multi_sz")||type.equals("reg_expand_sz")||type.equals("reg_dword")||type.equals("reg_qword")||type.equals("reg_binary")||type.equals("reg_none")) {
			String cmd="cmd /c reg add HKU\\"+name+" /t "+type+" /v "+objname+" /d "+data+" /f";
			Process run=Runtime.getRuntime().exec(cmd);
		} else {
			Process tip=Runtime.getRuntime().exec("cmd /c echo msgbox \"数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)\",64,\"ERROR\">alert.vbs && start alert.vbs && ping -n 2 127.1>nul && del alert.vbs");
			System.out.println("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
		}
	}
}
