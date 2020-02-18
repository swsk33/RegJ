import swsk33.Reg.*;
public class Test {
	public static void main(String[] args) throws Exception {
		RegAdd ra=new RegAdd();
		RegDelete rd=new RegDelete();
		RegExport rep=new RegExport();
		RegImport ri=new RegImport();
		RegQuery rq=new RegQuery();
		ri.importReg("C:\\Users\\swsk33\\Downloads\\s s\\s.reg");
	}

}
