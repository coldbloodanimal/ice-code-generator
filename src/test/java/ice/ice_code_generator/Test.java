package ice.ice_code_generator;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String di="string:40283e815ed2c40a015ed2d726f50044";
		di=di.substring(di.lastIndexOf(":")+1);
		System.out.println(di);
		// TODO Auto-generated method stub
		List<String> ids=new ArrayList<String>();
		String[] hehe={"a","b","c","d"};
		for(String id:hehe){
			if(id.equals("c")||id.equals("d")){
				ids.add(id);
			}
		}
		String[] ss=new String[ids.size()];
		for(int i=0;i<ss.length;i++){
			ss[i]=ids.get(i);
		}
		System.out.println(ss);
	}

}
