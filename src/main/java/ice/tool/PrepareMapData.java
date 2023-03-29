package ice.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

public class PrepareMapData {
	public static void main(String[] args) {
//		String s="csup_id,chos_id,ps_id,ps_detail_id,ps_ingr_id,amount,ingr_no,ingr_date,note,create_time,create_user,update_time,update_user";
//		prepareString("p",s,",","ingr","get");
		JSONObject jo=JSON.parseObject("{\n" +
				"\t\t\t\t\t\t\"id\": \"8d56b74b302c372944557623df165b53\",\n" +
				"\t\t\t\t\t\t\"current\": 0,\n" +
				"\t\t\t\t\t\t\"size\": 0,\n" +
				"\t\t\t\t\t\t\"parentId\": \"54040b51df9d0072cd7c2318a5ea72ef\",\n" +
				"\t\t\t\t\t\t\"ancestors\": \"[0],[54040b51df9d0072cd7c2318a5ea72ef]\",\n" +
				"\t\t\t\t\t\t\"code\": \"openapi-manager\",\n" +
				"\t\t\t\t\t\t\"name\": \"API管理\",\n" +
				"\t\t\t\t\t\t\"type\": \"M\",\n" +
				"\t\t\t\t\t\t\"router\": \"/openapi/api-manager\",\n" +
				"\t\t\t\t\t\t\"openType\": \"0\",\n" +
				"\t\t\t\t\t\t\"frame\": false,\n" +
				"\t\t\t\t\t\t\"cached\": true,\n" +
				"\t\t\t\t\t\t\"visible\": true,\n" +
				"\t\t\t\t\t\t\"icon\": \"hos-icon-menu\",\n" +
				"\t\t\t\t\t\t\"weight\": 0,\n" +
				"\t\t\t\t\t\t\"remark\": null,\n" +
				"\t\t\t\t\t\t\"categoryLocation\": \"left\",\n" +
				"\t\t\t\t\t\t\"pageProperties\": null,\n" +
				"\t\t\t\t\t\t\"advancedJs\": null,\n" +
				"\t\t\t\t\t\t\"category\": \"base\",\n" +
				"\t\t\t\t\t\t\"hasPagePreset\": true,\n" +
				"\t\t\t\t\t\t\"leaf\": true\n" +
				"\t\t\t\t\t}");

		String s=String.join(",",jo.keySet());


		//prepareStringMapFromMap("ps",s,",","d","get");

		//prepareStringMapFromMap("p",s,",","jq","get");
		prepareStringMapFromMap2("jq",jo);
	}

	/**
	 *
	 * @param sourceObject
	 * @param columns
	 * @param split
	 * @param targetObject
	 * @param getMethod
	 */
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

	/**
	 * 从一个map中获得另一个map的值
	 * @param sourceObject
	 * @param columns
	 * @param split
	 * @param targetObject
	 * @param getMethod
	 */
	public static void prepareStringMapFromMap(String sourceObject,String columns,String split,String targetObject,String getMethod){

		List<String> columnsList= Arrays.asList(columns.split(split));
//		for (String s : columnsList) {
//			System.out.println("String "+s+ " = "+sourceObject+"."+getMethod+"(\""+s+"\");");
//		}
//		System.out.println();
//		System.out.println();
//		System.out.println("");
		for (String s : columnsList) {
			String source=sourceObject+"."+getMethod+"(\""+s+"\")";
			System.out.println(targetObject+".put(\""+s+ "\","+source+");");
		}
	}


	public static void prepareStringMapFromMap2(String targetObject,JSONObject jsonObject){


		for (String s : jsonObject.keySet()) {
			System.out.println(targetObject+".put(\""+s+ "\",\""+jsonObject.getString(s)+"\");");
		}
	}

}
