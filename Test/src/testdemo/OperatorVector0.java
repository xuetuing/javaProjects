package testdemo;

import java.util.*;

public class OperatorVector0 {
	public Vector buildVector(){
		   Vector vTemps = new Vector();
		   for(int i=0;i<4;i++){
			  Vector vTemp = new Vector();
			  for (int j=0;j<4;j++){
		        vTemp.addElement("Vector("+i+")("+j+")");
			  }
			  vTemps.addElement(vTemp);
		   }
		   return vTemps;
		}
	public Vector insert(Vector vTemp,int iTemp,Object oTemp){
	    if(iTemp>vTemp.size()){
			print("���ݳ���!");
			return null;
		}else{
			 vTemp.insertElementAt(oTemp,iTemp);
		}
		return vTemp;
	}
	public Vector delete(Vector vTemp,int iTemp){
	    if(iTemp>vTemp.size()){
			print("���ݳ���!");
			return null;
		}else{
			 vTemp.removeElementAt(iTemp);
		}
		return vTemp;
	}
	public Vector updata(Vector vTemp,int iTemp,Object oTemp){
	    if(iTemp>vTemp.size()){
			print("���ݳ���!");
			return null;
		}else{
			 vTemp.setElementAt(oTemp,iTemp);
		}
		return vTemp;
	}
	public void print(String sTemp,Vector oTemp){
	    System.out.println(sTemp+"���ݣ�");
	    this.print(oTemp);
	}
	public void print(Object oPara){
	    System.out.println(oPara);
	}
	public void print(Vector vPara){
		   for(int i=0;i<vPara.size();i++){
		    System.out.println(vPara.elementAt(i));
		   }
		}
	
	public static void main(String[] args) 
	{
		OperatorVector0 ov = new OperatorVector0();
		Vector vTemp = ov.buildVector();
		ov.print("vTemp0",vTemp);
		Vector vResult = ov.insert(vTemp,2,"��ӵ�����");
		ov.print("vResult",vResult);
        Vector vResultup = ov.updata(vResult,2,"�޸ĵ�����");
		ov.print("vResultmp",vResultup);
        Vector vResultnow = ov.delete(vResultup,2);
		ov.print("vResultnow",vResultnow);
	}
	
	
}
