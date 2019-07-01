/**
* ${module_description}
    */
    @Data
    @TableName("${table_name}")
    public class ${module_name}Entity {
<#list columns as item>
    <#if item?is_first>

        /**
        * ${item.COLUMN_COMMENT}
        */
        @ApiModelProperty("${item.COLUMN_COMMENT}")
        private ${item.COLUMN_JAVA_DATATYPE} ${item.COLUMN_NAME};
    <#else>

        /**
        * ${item.COLUMN_COMMENT}
        */
        @ApiModelProperty("${item.COLUMN_COMMENT}")
        private ${item.COLUMN_JAVA_DATATYPE} ${item.COLUMN_NAME};
    </#if>
</#list>