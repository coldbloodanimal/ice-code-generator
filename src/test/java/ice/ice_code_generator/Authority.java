package ice.ice_code_generator;
/** 
* @author 作者:zhaowei 
* 创建时间：2017年12月7日 下午12:22:03 
* 
*/
public enum Authority {
	/**
	 * 只能查看自己
	 * */
	SELF,
	/**
	 * 查看自己和下属
	 * */
	SUBORIDINATE,
	/**
	 * 查看所有人
	 * */
	ALL
}
