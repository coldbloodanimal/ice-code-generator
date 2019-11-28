/**
* ${module_description}
    */
    @Data
    public class ${module_name}Model {
<#list columns as item>
    <#if item?is_first>

        @ApiModelProperty("${item.COLUMN_COMMENT}")
        private ${item.COLUMN_JAVA_DATATYPE} ${item.COLUMN_NAME};
    <#else>

        @ApiModelProperty("${item.COLUMN_COMMENT}")
        private ${item.COLUMN_JAVA_DATATYPE} ${item.COLUMN_NAME};
    </#if>
</#list>
}