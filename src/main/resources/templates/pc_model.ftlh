<#list columns as item>
    <#if item?is_first>

        /**
        * ${item.COLUMN_COMMENT}
        */
        @TableId("${item.COLUMN_NAME_PURE}")
        private ${item.COLUMN_JAVA_DATATYPE} ${item.COLUMN_NAME};
    <#else>

        /**
        * ${item.COLUMN_COMMENT}
        */
        @TableField("${item.COLUMN_NAME_PURE}")
        private ${item.COLUMN_JAVA_DATATYPE} ${item.COLUMN_NAME};
    </#if>
</#list>