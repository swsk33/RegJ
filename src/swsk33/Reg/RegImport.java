package swsk33.Reg;
public class RegImport {		//��ע����ļ�(reg�ļ�)����ע���
	public void importReg(String filepath) throws Exception {
		String cmd="cmd /c regedit /s "+filepath;
		Process run=Runtime.getRuntime().exec(cmd);
	}
}
