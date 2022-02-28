package ice.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.codemodel.JCodeModel;

import java.io.IOException;

public class JsonToJava3 {
    public static void main(String[] args) throws IOException {
        JCodeModel codeModel = new JCodeModel();


        String ss="[{\"field\":\"prod_name\",\"title\":\"产品名称\",\"width\":\"100px\",\"align\":\"left\",\"sort\":1},{\"field\":\"spec_name\",\"title\":\"规格型号\",\"width\":\"100px\",\"align\":\"left\",\"sort\":2},{\"field\":\"batch_no\",\"title\":\"生产批号\",\"width\":\"120px\",\"align\":\"left\",\"sort\":3},{\"field\":\"batch_date\",\"title\":\"生产日期\",\"width\":\"150px\",\"align\":\"left\",\"sort\":4},{\"field\":\"inva_date\",\"title\":\"有效期\",\"width\":\"120px\",\"align\":\"left\",\"sort\":5},{\"field\":\"unit_name\",\"title\":\"单位\",\"width\":\"60px\",\"align\":\"left\",\"sort\":6},{\"field\":\"price\",\"title\":\"单价\",\"width\":\"60px\",\"align\":\"right\",\"sort\":7},{\"field\":\"amount\",\"title\":\"配货数量\",\"width\":\"60px\",\"align\":\"right\",\"sum\":\"Y\",\"format\":\"#0\",\"sort\":8},{\"field\":\"amount_money\",\"title\":\"金额\",\"width\":\"80px\",\"align\":\"right\",\"sort\":9,\"sum\":\"Y\",\"format\":\"#,##0.00\"},{\"field\":\"disinfect_no\",\"title\":\"灭菌批号\",\"width\":\"150px\",\"align\":\"left\",\"sort\":10},{\"field\":\"disinfect_date\",\"title\":\"灭菌日期\",\"width\":\"150px\",\"align\":\"left\",\"sort\":10},{\"field\":\"fac_name\",\"title\":\"生产厂商\",\"width\":\"150px\",\"align\":\"left\",\"sort\":10},{\"field\":\"cert_code\",\"title\":\"材料证件信息\",\"width\":\"150px\",\"align\":\"left\",\"sort\":10}]";

        JSONArray ja= JSONArray.parseArray(ss);
        for (Object o : ja) {
            JSONObject j= (JSONObject) o;
            System.out.println("@PrintModelProperty(text=\""+j.getString("title").substring(0,j.getString("title").length())+"\"" +
                    ",width=\""+j.getString("width").substring(0,j.getString("width").length())+"\""+
                    ",align=\""+j.getString("align").substring(0,j.getString("align").length())+"\""+
                    ",sort=\""+j.getString("sort").substring(0,j.getString("sort").length())+"\""+
                    ")");
            System.out.println("private "+"String "+j.getString("field")+";");
        }

    }



}
