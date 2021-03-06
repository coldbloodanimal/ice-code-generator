package ice.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelNamed {
	
	public static void main(String[] args) throws Exception {
		String s="ID\tENTERPRISE_ID\tMALL_ID\tMALL_NAME\tPROVINCE\tCITY\tREGION\tTOWN\tPROVINCE_CODE\tCITY_CODE\tREGION_CODE\tTOWN_CODE\tCREATE_TIME\tCREATE_USER";
		String result=allCamelsql(s,"\t","zzzzzzzzzzzzzz");
		sqlCamelGood(s,"\t","l");

		//pcamel(s);
	}
	
	/**
	 * @param s传入的字符串
	 * @param split分隔符
	 * @Param alias表别名
	 * */
	public static String sql(String s,String split,String alias){
		String[] elements=s.split("	");
		StringBuilder sb=new StringBuilder();
		for(String e:elements){
			sb.append(alias+"."+e+" as "+camel(e)+",");
		}
		return sb.toString();
	}
	
	/**
	 * @param s传入的字符串
	 * @param split分隔符
	 * @Param alias表别名
	 * */
	public static String allCamelsql(String s,String split,String alias){
		String[] elements=s.split("	");
		StringBuilder sb=new StringBuilder();
		for(String e:elements){
			sb.append(alias+"."+camel(e)+" as "+camel(e)+",");
		}
		return sb.toString();
	}
	
	/**
	 * 下划线命名改为骆驼命名
	 * */
	public static String camel(String s){
		s=s.toLowerCase();
		Pattern pattern=Pattern.compile("_([a-zA-Z])");
		Matcher m=pattern.matcher(s);
		StringBuffer sb=new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb, m.group(1).toUpperCase());
		}
		m.appendTail(sb);
		return sb.toString();
	}
	/**
	 * 字符串数组改为骆驼命名
	 * */
	public static void pcamel(String s){
		String[] ss=s.split("	");
		for(String p:ss){
			System.out.print(","+camel(p));
		}
		
	}

	/**
	 * 字符串数组改为骆驼命名,for mybatis
	 *
	 * ID,USER_ID,USER_NAME
	 * p.ID as id，p.USER_ID as userId ,p.USER_NAME as userName
	 * */
	public static void sqlCamelGood(String s,String split,String alias){
		String[] ss=s.split(split);
		for(String p:ss){
			p=p.trim();
			System.out.print(alias+"."+p+" as "+camel(p)+" ,");
		}

	}
	
}
