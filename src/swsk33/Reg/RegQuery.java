package swsk33.Reg;
import java.io.*;
public class RegQuery {
	public String queryHKCR(String name) throws Exception {		//��ѯHKEY_CLASSES_ROOT�µ�ĳ���������������ơ����ͺ�ֵ
		String result="";
		String cmd="cmd /c reg query HKCR\\"+name+" /s";
		Process run=Runtime.getRuntime().exec(cmd);
		InputStreamReader isr=new InputStreamReader(run.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String cdr=br.readLine();
		while(cdr!=null) {
			result=result+cdr+"\r\n";
			cdr=br.readLine();
		}
		br.close();
		return result;
	}
	public String queryHKCR(String name,String objname) throws Exception {		//��ѯHKEY_CLASSES_ROOT�µ�ĳ����������Ϣ
		String result="";
		String cmd="cmd /c reg query HKCR\\"+name+" /v "+objname;
		Process run=Runtime.getRuntime().exec(cmd);
		InputStreamReader isr=new InputStreamReader(run.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String cdr=br.readLine();
		while(cdr!=null) {
			result=result+cdr+"\r\n";
			cdr=br.readLine();
		}
		br.close();
		return result;
	}
	public String queryHKCRve(String name) throws Exception {		//��ѯHKEY_CLASSES_ROOT�µ�ĳ���Ĭ��������Ϣ
		String result="";
		String cmd="cmd /c reg query HKCR\\"+name+" /ve";
		Process run=Runtime.getRuntime().exec(cmd);
		InputStreamReader isr=new InputStreamReader(run.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String cdr=br.readLine();
		while(cdr!=null) {
			result=result+cdr+"\r\n";
			cdr=br.readLine();
		}
		br.close();
		return result;
	}
	public boolean isHKCRexists(String name) throws Exception {		//�ж�HKEY_CLASSES_ROOT�µ�ĳһ���Ƿ����
		boolean result=false;
		String cmd="cmd /c reg query HKCR\\"+name;
		Process run=Runtime.getRuntime().exec(cmd);
		InputStreamReader isr=new InputStreamReader(run.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String cdr=br.readLine();
		String res="";
		while(cdr!=null) {
			res=res+cdr+"\r\n";
			cdr=br.readLine();
		}
		br.close();
		if(res.equals("")) {
			result=false;
		} else {
			result=true;
		}
		return result;
	}
	public boolean isHKCRexists(String name,String objname) throws Exception {		//�ж�HKEY_CLASSES_ROOT�µ�ĳһ��������Ƿ����
		boolean result=false;
		String cmd="cmd /c reg query HKCR\\"+name+" /v "+objname;
		Process run=Runtime.getRuntime().exec(cmd);
		InputStreamReader isr=new InputStreamReader(run.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String cdr=br.readLine();
		String res="";
		while(cdr!=null) {
			res=res+cdr+"\r\n";
			cdr=br.readLine();
		}
		br.close();
		if(res.equals(""+"\r\n"+""+"\r\n"+"")||res.equals("")) {
			result=false;
		} else {
			result=true;
		}
		return result;
	}
	public boolean isHKCRexistsve(String name) throws Exception {		//�ж�HKEY_CLASSES_ROOT�µ�ĳһ���Ĭ��ֵ�Ƿ����
		boolean result=false;
		String cmd="cmd /c reg query HKCR\\"+name+" /ve";
		Process run=Runtime.getRuntime().exec(cmd);
		InputStreamReader isr=new InputStreamReader(run.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String cdr=br.readLine();
		String res="";
		while(cdr!=null) {
			res=res+cdr+"\r\n";
			cdr=br.readLine();
		}
		br.close();
		if(res.equals("")) {
			result=false;
		} else {
			result=true;
		}
		return result;
	}
}
