package ice.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheStringUtil {
	public static void main(String[] args) throws Exception {
		String s="平台运营系统-数据字典值";
		String result=getCoreName(s);
		System.out.println(result);
	}
	/**
	 * 根据注解获得核心字段
	 * */
	public static String getCoreName(String s){
		Pattern pattern=Pattern.compile("\\S*-(\\S*)表?");
		Matcher m=pattern.matcher(s);
		m.find();
		String result=m.group(1);
		return result;
	}
	/**
	 * 首字母大写
	 * */
	public static String firstWordCaseUpper(String s){
		
		return s.substring(0, 1).toUpperCase()+s.substring(1);
	}
}
