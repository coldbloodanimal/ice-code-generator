package ice.ice_code_generator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;

public class GsonJavaBeanMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


			// Serialization
			BagOfPrimitives obj = new BagOfPrimitives();
			Gson gson = new Gson();
			String json = gson.toJson(obj);

			HashMap map=(HashMap) gson.fromJson(json, HashMap.class);
			System.out.println(map);
	}
}
