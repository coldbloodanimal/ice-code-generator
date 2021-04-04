package ice.tool;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class JsonToJava {
    public static void main(String[] args) throws IOException {
        JCodeModel codeModel = new JCodeModel();


        String ss="{ \"returnCode\":\"状态码,详见第七章节\", \"returnMsg\":\"状态码说明\", \"totalPageCount\":\"总页数\", \"totalRecordCount\":\"总记录数量\", \"currentPageNumber\":\"当前页码\", \"successList\":[ { \"hospitalId\":\"医疗机构账号\", \"departmentID\":\"部门编号\", \"goodsID\":\"产品 Id\",\n" +
                " \"sortName\":\"分类\", \"productNameFirst\":\"一级目录\", \"productNameSecond\":\"二级目录\", \"goodsName\":\"产品名\", \"outlookc\":\"规格\", \"goodsType\":\"型号\", \"unit\":\"单位\", \"provinceId\":\"市标产品码（cn 码）\", \"regcodeName\":\"注册证\", \"brand\":\"品牌\", \"source\":\"来源\", \"purchasePrice\":\"医疗机构设置采购价格\", \"companyIdTb\":\"投标企业编号\", \"companyNameTb\":\"投标企业\", \"companyIdPs\":\"医疗机构设置的配送商编号\", \"companyNamePs\":\"医疗机构设置的配送商\", \"purchaseType\":\"采购类别\", \"addTime\":\"添加时间\", \"lastUpDateTime\":\"最后更新时间\" } ],\"todayRemainVisitCount\":\"当日接口剩余访问次数\" }";
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        String className="ClassName";
        mapper.generate(codeModel, className, "com.example", ss);
        File projectFile=new File("");
        String folderName=projectFile.getAbsolutePath()+"\\src\\main\\resources\\results";
        File folder=new File(folderName);
        System.out.println(folderName);
        //codeModel.build(Files.createTempDirectory("required").toFile());
        codeModel.build(folder);
        //codeModel.build(folder);
    }



}
