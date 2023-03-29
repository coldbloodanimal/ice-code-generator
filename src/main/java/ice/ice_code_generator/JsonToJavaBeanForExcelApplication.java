package ice.ice_code_generator;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import ice.tool.CamelNamed;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :zw
 * 时间：2023/3/28
 */
@SpringBootApplication
public class JsonToJavaBeanForExcelApplication {


    public static void main(String[] args) throws Exception {

        //推荐的json格式化工具
        //https://jsonformatter.curiousconcept.com/#

        String fields = "[\n" +
                "      {\n" +
                "      \"display\":\"平台订单号\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"name\":\"order_ano\",\n" +
                "      \"width\":30\n" +
                "   },{\n" +
                "      \"display\":\"行号\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"name\":\"row_no\",\n" +
                "      \"width\":30\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"催单\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"name\":\"remind\",\n" +
                "      \"width\":60\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"品规标识\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"name\":\"inv_code\",\n" +
                "      \"width\":120\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"产品名称\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"name\":\"prod_name\",\n" +
                "      \"width\":150\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"规格\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"width\":150,\n" +
                "      \"name\":\"spec_name\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"型号\",\n" +
                "      \"name\":\"model\",\n" +
                "      \"width\":150,\n" +
                "      \"align\":\"alignType.CENTER\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"计量单位\",\n" +
                "      \"name\":\"unit_name\",\n" +
                "      \"width\":80,\n" +
                "      \"align\":\"alignType.CENTER\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"单价\",\n" +
                "      \"name\":\"price\",\n" +
                "      \"width\":80,\n" +
                "      \"align\":\"right\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"数量\",\n" +
                "      \"name\":\"amount\",\n" +
                "      \"width\":80,\n" +
                "      \"align\":\"right\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"金额\",\n" +
                "      \"name\":\"amount_money\",\n" +
                "      \"width\":80,\n" +
                "      \"align\":\"right\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"包装\",\n" +
                "      \"name\":\"package\",\n" +
                "      \"width\":100,\n" +
                "      \"align\":\"alignType.CENTER\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"产品分类\",\n" +
                "      \"name\":\"prod_type_name1\",\n" +
                "      \"width\":100,\n" +
                "      \"align\":\"alignType.CENTER\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"生产企业\",\n" +
                "      \"name\":\"fac_name\",\n" +
                "      \"width\":170,\n" +
                "      \"align\":\"alignType.CENTER\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"医保分类编码\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"name\":\"yb_serialno\",\n" +
                "      \"width\":150\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"备注\",\n" +
                "      \"align\":\"alignType.CENTER\",\n" +
                "      \"name\":\"note\",\n" +
                "      \"width\":180\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"已配货数量\",\n" +
                "      \"align\":\"right\",\n" +
                "      \"width\":100,\n" +
                "\t  \"name\":\"dispatch_amount\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"display\":\"已退货数量\",\n" +
                "      \"align\":\"right\",\n" +
                "      \"width\":100,\n" +
                "      \"name\":\"ret_amount\"\n" +
                "   }\n" +
                "]";

        Map<String,Object> data=new HashMap<>();
        data.put("class_name","ExcelDto");
        data.put("fields",JSONArray.parseArray(fields,JSONObject.class));
        fieldNameCamel(data);



        ApplicationContext application = SpringApplication.run(JsonToJavaBeanForExcelApplication.class, args);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        File templates=new File(ClassLoader.getSystemClassLoader().getResource("templates").getPath());
        cfg.setDirectoryForTemplateLoading(templates);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);


        File projectFile = new File("");
        String folderName = projectFile.getAbsolutePath() + "\\src\\main\\resources\\results" + "\\" + "excelDto";
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdir();
        }

        //template
        Template template;
        String fileName;
        File file;
        FileWriterWithEncoding fileWriterWithEncoding;

        //生成entity
        template = cfg.getTemplate("java_bean_excel.ftlh");
        fileName = folderName + "\\" + data.get("class_name") + "Model.java";
        System.out.println(fileName);
        file = new File(fileName);
        file.createNewFile();
        // FileOutputStream fos=new FileOutputStream(PCMainFile);
        fileWriterWithEncoding = new FileWriterWithEncoding(file, "UTF-8");
        template.process(data, fileWriterWithEncoding);
    }


    /**
     * 将列的名称改为骆驼命名
     */
    private static void fieldNameCamel(Map<String, Object> data) {
        List<Map<String, Object>> columns = (List<Map<String, Object>>) data.get("fields");
        for (Map<String, Object> c : columns) {
            System.out.println(c.get("name"));
            c.put("name", CamelNamed.camel((String) c.get("name")));
        }
    }




}
