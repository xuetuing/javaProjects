package testdemo;

import java.util.*;

public class OperatorVector {
	public Vector buildVector(){
		Vector vTmps = new Vector();
		for(int i=0;i<4;i++){
			Vector vTmp = new Vector();
			for(int j=0;j<4;j++){
				vTmp.addElement("Vector("+i+")("+j+")");
			}
			vTmps.addElement(vTmp);
		}
		return vTmps;
	}
	public Vector insert(Vector vTemp,int iTemp,Object oTemp){
		if(iTemp>vTemp.size()){
			System.out.println("数据越界");
			return null;
		}else{
			vTemp.insertElementAt(oTemp,iTemp);
		}
		return vTemp;
	}
	public Vector remove(Vector vTemp,int iTemp){
		if(iTemp>vTemp.size()){
			System.out.println("数据越界！");
			return null;
		}else{
			vTemp.removeElementAt(iTemp);
		}
		return vTemp;
	}
	public Vector update(Vector vTemp,int iTemp,Object oTemp){
		if(iTemp>vTemp.size()){
			System.out.println("数据越界");
			return null;
		}else{
			vTemp.setElementAt(oTemp,iTemp);
		}
		return vTemp;
	}
	public void print(String sTemp,Vector vTemp){
		System.out.println(sTemp+"数据");
		this.print(vTemp);
	}
	public void print(Object oPara){
		System.out.println(oPara);
	}
	public void print(Vector vPara){
		for(int i=0;i<vPara.size();i++){
			System.out.println(vPara.elementAt(i));
		}
	}
	public static void main(String[] args){
		OperatorVector ov = new OperatorVector();
		Vector vTemp = ov.buildVector();
		ov.print("vTemp",vTemp);
		Vector vResult = ov.insert(vTemp,2,"添加数据");
		ov.print("vResult",vResult);
        Vector vResultup = ov.update(vResult,2,"修改数据");
		ov.print("vResultmp",vResultup);
        Vector vResultnow = ov.remove(vResultup,2);
		ov.print("vResultnow",vResultnow);
		
	}
	
	
}

	