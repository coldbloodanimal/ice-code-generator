package ice.ice_code_generator;

public class EnumTest {

	public static void main(String[] args) {
		System.out.println("hehe");
		
		Authority authority=Enum.valueOf(Authority.class, "ALL");
		System.out.println(Authority.ALL==authority);
		System.out.println(Authority.ALL.equals(authority));
		System.out.println(authority);
	}

}
