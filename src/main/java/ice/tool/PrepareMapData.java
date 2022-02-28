package ice.tool;

import java.util.Arrays;
import java.util.List;

public class PrepareMapData {
	public static void main(String[] args) {
		String s="csup_id,chos_id,ps_id,ps_detail_id,ps_ingr_id,amount,ingr_no,ingr_date,note,create_time,create_user,update_time,update_user";


		prepareString("p",s,",","ingr","get");
	}


	public static void prepareString(String sourceObject,String columns,String split,String targetObject,String getMethod){

		List<String> columnsList= Arrays.asList(columns.split(split));
		for (String s : columnsList) {
			System.out.println("String "+s+ " = "+sourceObject+"."+getMethod+"(\""+s+"\");");
		}
		System.out.println();
		System.out.println();
		System.out.println("");
		for (String s : columnsList) {
			System.out.println(targetObject+".put(\""+s+ "\","+s+");");
		}
	}

}
