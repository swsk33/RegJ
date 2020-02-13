package swsk33.Reg;
import java.io.*;
public class RegQuery {
	public String queryHKCR(String name) throws Exception {		//查询HKEY_CLASSES_ROOT下的某项及其所有子项的名称、类型和值
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
	public String queryHKCR(String name,String objname) throws Exception {		//查询HKEY_CLASSES_ROOT下的某项的子项的信息
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
	public String queryHKCRve(String name) throws Exception {		//查询HKEY_CLASSES_ROOT下的某项的默认子项信息
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
	public boolean isHKCRexists(String name) throws Exception {		//判断HKEY_CLASSES_ROOT下的某一项是否存在
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
	public boolean isHKCRexists(String name,String objname) throws Exception {		//判断HKEY_CLASSES_ROOT下的某一项的子项是否存在
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
	public boolean isHKCRexistsve(String name) throws Exception {		//判断HKEY_CLASSES_ROOT下的某一项的默认值是否存在
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
