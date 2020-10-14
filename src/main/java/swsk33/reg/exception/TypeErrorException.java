package swsk33.reg.exception;

public class TypeErrorException extends Exception {
	public TypeErrorException() {
		super("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
	}
}
