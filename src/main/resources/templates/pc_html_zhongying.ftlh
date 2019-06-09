<!DOCTYPE html>
<html lang="zh-cn" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>宸康智慧医养云平台</title>
    <!-- zui -->
    <!-- ZUI 标准版压缩后的 CSS 文件 -->
    <link rel="stylesheet" th:href="@{dist/css/zui.min.css}">
    <!-- <link rel="stylesheet" href="../dist/css/zui-theme.min.css"> -->
    <link th:href="@{dist/lib/datagrid/zui.datagrid.min.css}" rel="stylesheet">
    <link th:href="@{dist/lib/datetimepicker/datetimepicker.min.css}" rel="stylesheet">

    <link rel="stylesheet" th:href="@{css/ant.css}">
    <link rel="stylesheet" th:href="@{css/tab.css}">
    <link rel="stylesheet" id="theme" href="">
</head>

<body class="layout-full">
    <div class="page">
        <div class="page-contnt">
            <div class="ant-card-body">
                <div class="tableList___1l7ro">
                    <div class="tableListForm___1316u">
                    
<!--                     	查询表单 -->
                       <form  id="searchmodule${salt}" class="ant-form ant-form-inline">
                            <div class="ant-row" style="margin-left: -24px; margin-right: -24px;">
							<#--

							<#list columns as item>
									<#if item.COLUMN_NAME=='id' || item.COLUMN_NAME == 'backUp1' ||  item.COLUMN_NAME == 'backUp2' ||  item.COLUMN_NAME == 'backUp3' ||  item.COLUMN_NAME == 'backUp4' ||  item.COLUMN_NAME == 'backUp5'>
		                                <div class="hide ant-col-sm-24 ant-col-md-8" style="padding-left: 24px; padding-right: 24px;">
		                                    <div class="ant-row ant-form-item">
		                                        <div class="ant-form-item-label">
		                                            <label for="no" class="" title="${item.COLUMN_COMMENT}">${item.COLUMN_COMMENT}</label>
		                                        </div>
		                                        <div class="ant-form-item-control-wrapper">
		                                            <div class="ant-form-item-control"><span class="ant-form-item-children"><div><input name="${item.COLUMN_NAME}" type="text" class="${item.COLUMN_NAME} form-control" placeholder="默认提示语(占位符)"></div></span></div>
		                                        </div>
		                                    </div>
		                                </div>
									<#elseif item.DATA_TYPE='datetime'>
											<div class="ant-row" style="margin-left: -24px; margin-right: -24px;">
				                                <div class="ant-col-sm-24 ant-col-md-8" style="padding-left: 24px; padding-right: 24px;">
				                                    <div class="ant-row ant-form-item">
				                                        <div class="ant-form-item-label">
				                                            <label for="date" class="" title="${item.COLUMN_COMMENT}">${item.COLUMN_COMMENT}</label>
				                                        </div>
				                                        <div class="ant-form-item-control-wrapper">
				                                            <div class="ant-form-item-control"><span class="ant-form-item-children">
				                                    <div class="input-group date form-datetime" data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
				                                  <input class="${item.COLUMN_NAME}search form-control" name="${item.COLUMN_NAME}" size="16" type="text" value="" readonly="">
				                                  <span class="input-group-addon"><span class="icon-remove"></span></span>
				                                                <span class="input-group-addon"><span class="icon-th"></span></span>
				                                            </div>
				                                            </span>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
									<#else>
		                                <div class="ant-col-sm-24 ant-col-md-8" style="padding-left: 24px; padding-right: 24px;">
		                                    <div class="ant-row ant-form-item">
		                                        <div class="ant-form-item-label">
		                                            <label for="no" class="" title="${item.COLUMN_COMMENT}">${item.COLUMN_COMMENT}</label>
		                                        </div>
		                                        <div class="ant-form-item-control-wrapper">
		                                            <div class="ant-form-item-control"><span class="ant-form-item-children"><div><input name="${item.COLUMN_NAME}" type="text" class="${item.COLUMN_NAME} form-control" placeholder="默认提示语(占位符)"></div></span></div>
		                                        </div>
		                                    </div>
		                                </div>
									</#if>
							</#list>

                                -->
                                
                            </div>
                    <div style="overflow: hidden;">
                        <span style="float: right; margin-bottom: 24px;">
                                <button type="button" class="btn btn-primary submit query-data${salt}" data-loading-text="正在提交...">查询</button>
                           		<button type="button" class="btn btn-primary add-data${salt}">新 增</button>
                            </span>
                    </div>
                    </form>
                    <!-- 列表数据 -->
                    <div class="standardTable___348Kf">
                        <div id="datagridExample${salt}" class="datagrid" style="position: relative;">
                            <div class="datagrid-loading" style=" display: none; ">
                                <div class="content"><i class="icon icon-spin icon-spinner icon-2x"></i>
                                    <div classname="datagrid-loading-message"></div>
                                </div>
                            </div>
                            <div class="datagrid-container"></div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div class="ant-layout-footer" style="padding: 0px;">
                <div class="globalFooter___3uaww" style="padding: 50px;">
                    <div class="links___lgymZ"><a target="_blank" href="http://pro.ant.design">Pro 首页</a><a target="_blank" href="https://github.com/ant-design/ant-design-pro"><i class="anticon anticon-github"></i></a><a target="_blank" href="http://ant.design">Ant Design</a></div>
                    <div class="copyright___3hV2q">Copyright <i class="anticon anticon-copyright"></i> 2018 众盈医疗</div>
                </div>
            </div>
    </div>
    </div>
    <!-- 按钮触发模态框 -->
    <!-- <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button> -->
    <!-- 模态框（Modal）修改 -->
    <div class="modal fade" id="updateAddModal${salt}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel${salt}" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel${salt}">修改</h4>
                </div>
                <div>
                    <form class="modify${salt} ant-form ant-form-horizontal ant-form-hide-required-mark stepForm___3WRvm" step-type="1">
                    
                    
                    
                    			<#list columns as item>
									<#if item.COLUMN_NAME=='id' || item.COLUMN_NAME == 'backUp1' ||  item.COLUMN_NAME == 'backUp2' ||  item.COLUMN_NAME == 'backUp3' ||  item.COLUMN_NAME == 'backUp4' ||  item.COLUMN_NAME == 'backUp5'>
				                        <div class="ant-row ant-form-item hidden">
				                            <div class="ant-col-5 ant-form-item-label">
				                                <label for="receiverName" class="ant-form-item-required" title="${item.COLUMN_NAME}">${item.COLUMN_COMMENT}：</label>
				                            </div>
				                            <div class="ant-col-19 ant-form-item-control-wrapper">
				                                <div class="ant-form-item-control"><span class="ant-form-item-children"><div><input name="${item.COLUMN_NAME}" type="text" class="${item.COLUMN_NAME} form-control form-text-input" placeholder="请输入${item.COLUMN_COMMENT}"></div></span></div>
				                            </div>
				                        </div>
									<#elseif item.DATA_TYPE=='varchar' || item.DATA_TYPE=='int' || item.DATA_TYPE=='bigint'>
				                        <div class="ant-row ant-form-item ">
				                            <div class="ant-col-5 ant-form-item-label">
				                                <label for="receiverName" class="ant-form-item-required" title="${item.COLUMN_NAME}">${item.COLUMN_COMMENT}：</label>
				                            </div>
				                            <div class="ant-col-19 ant-form-item-control-wrapper">
				                                <div class="ant-form-item-control"><span class="ant-form-item-children"><div><input name="${item.COLUMN_NAME}" type="text" class="${item.COLUMN_NAME} form-control form-text-input" placeholder="请输入${item.COLUMN_COMMENT}"></div></span></div>
				                            </div>
				                        </div>
				                    <#elseif item.DATA_TYPE=='datetime'>
			                           <#-- <div class="ant-row" style="margin-left: -24px; margin-right: -24px;">
			                                <div class="ant-col-sm-24 ant-col-md-8" style="padding-left: 24px; padding-right: 24px;">
			                                    <div class="ant-row ant-form-item">
			                                        <div class="ant-form-item-label">
			                                            <label for="date" class="" title="${item.COLUMN_COMMENT}">${item.COLUMN_COMMENT}</label>
			                                        </div>
			                                        <div class="ant-form-item-control-wrapper">
			                                            <div class="ant-form-item-control"><span class="ant-form-item-children">
			                                    <div class="input-group date form-datetime" data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
			                                  <input class="form-control ${item.COLUMN_NAME}"  size="16" type="text" value="" readonly="">
			                                  <span class="input-group-addon"><span class="icon-remove"></span></span>
			                                                <span class="input-group-addon"><span class="icon-th"></span></span>
			                                            </div>
			                                            </span>
			                                        </div>
			                                    </div>
			                                </div>
			                            </div>-->
									</#if>
							</#list>
                    

                    </form>
                </div>
                <div class="modal-footer">
                 	<button type="button" class="btn btn-primary updata-data" data-loading-text="正在提交...">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
    <!-- 模态框 删除 -->
    <div class="modal fade" id="removeTip${salt}">
        <div class="modal-dialog">
            <div class="modal-content">
            	      <form class="del${salt} hidden ant-form ant-form-horizontal ant-form-hide-required-mark stepForm___3WRvm" step-type="1">
                        <div class="ant-row ant-form-item">
                            <div class="ant-col-5 ant-form-item-label">
                                <label for="receiverName" class="ant-form-item-required" title="id">id：</label>
                            </div>
                            <div class="ant-col-19 ant-form-item-control-wrapper">
                                <div class="ant-form-item-control"><span class="ant-form-item-children"><div><input name="id" type="text" class="id form-control form-text-input" placeholder="id"></div></span></div>
                            </div>
                        </div>
                    </form>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
                    <h4 class="modal-title">删除</h4>
                </div>
                <div class="modal-body">
                    <p>是否确认删除</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary remove-data" data-loading-text="正在提交...">确认</button>
                </div>
            </div>
        </div>
    </div>
    <!-- ZUI Javascript 依赖 jQuery -->
    <script th:src="@{dist/lib/jquery/jquery.js}"></script>
    <!-- jQuery小插件 -->
    <script th:src="@{js/jQueryPlugin.js}"></script>
    <!-- ZUI 标准版压缩后的 JavaScript 文件 -->
    <script th:src="@{dist/js/zui.min.js}"></script>
    <!-- 日期选择插件 -->
    <script th:src="@{dist/lib/datetimepicker/datetimepicker.min.js}"></script>
    <!-- 数据列表插件 -->
    <script th:src="@{dist/lib/datagrid/zui.datagrid.min.js}"></script>
    <script th:src="@{js/${module_name}.js}"></script>
</body>

</html>