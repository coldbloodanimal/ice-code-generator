package ice.tool;

import org.springframework.util.ObjectUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelNamed {

	public static void main(String[] args) throws Exception {
		System.out.println(null==null);
		String s="csup_id\tfac_id\tfac_name\tfac_type_code\tprovince\tcity\tcounty\taddress\tphone\tis_three_cert\tcheck_state\tcheck_date\tcheck_note\tspell_code\twbx_code\tis_stop\toper_name\toper_date\tload_date\tnote\tshort_name\twebsite\tcreate_time\tcreate_user\tupdate_time\tupdate_user\tlegal_rep\testablish_date\tcontact_person\tcategory_code\ttaxpayer";
		//pure(s,"\t");
		System.out.println();

		alias(s,"\t","f");
		System.out.println();
		sqlCamelGood(s,"\t","f");
		System.out.println();
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

	/**
	 * 打印纯粹的列
	 * */
	public static void pure(String s ,String split){
		String[] ss=s.split(split);
		for(String p:ss){
			p=p.trim();
			System.out.print(p+" ,");
		}
	}

	/**
	 * 加别名
	 * */
	public static void alias(String s ,String split,String alias){
		String[] ss=s.split(split);
		for(String p:ss){
			p=p.trim();
			if (ObjectUtils.isEmpty(alias)) {
				System.out.print(p+" ,");
			}else {
				System.out.print(alias+"."+p+" ,");
			}

		}
	}

}
