package ice.tool;

/**
 * @author: Monster
 * @date: 2019-06-05 11:25
 **/
public class DataTypeConverter {
    public static void main(String[] args) {

    }

    public static String sqlDatatypeConvertToJavaDatatype(String input){
        System.out.print(input);
        if(input.contains("bigint")){
            return "Long";
        }else if(input.contains("int")){
            return "Integer";
        }else if(input.contains("tinyint")){
            return "Integer";
        }else if(input.contains("decimal")){
            return "BigDecimal";
        }else if(input.contains("datetime")){
            return "Date";
        }else if(input.contains("varchar")){
            return "String";
        }

        return "";
    }
}
