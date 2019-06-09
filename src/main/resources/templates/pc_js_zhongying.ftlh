(function($) {
	

	var randomString = function(len) {　　
		len = len || 32;　　
		var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678'; /****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/ 　　
		var maxPos = $chars.length;　　
		var pwd = '';　　
		for (i = 0; i < len; i++) {　　　　
			pwd += $chars.charAt(Math.floor(Math.random() * maxPos));　　
		}　　
		return pwd;
	};
	var pageObj = {
		init: function() {
			var that = this;
			var userSet = sessionStorage.getItem('userSet');
			if (userSet && JSON.parse(userSet)) {
				$('#theme').attr('href', '../dist/css/' + JSON.parse(userSet).theme);
			}
			//初始化提示插件
			$('[data-toggle="tooltip"]').tooltip();
			//初始化数据表格
			$('#datagridExample${salt}').datagrid({
				dataSource: {},
				height: 'page',
				sortable: true,
				// checkable: true,
				// selectable: false,
				states: {
					pager: {
						page: 1,
						recPerPage: 12
					}
				}
				// ... 其他初始化选项
			});
			
			//查询按钮
			$('.query-data${salt}').click(function() {
				that.queryParam= $("form#searchmodule${salt}").serializeFormJSON();
				that.getServerData(that.queryParam);
			});
			
			$('#searchmodule${salt} input[name=type]').change(function() {
				that.queryParam= $("form#searchmodule${salt}").serializeFormJSON();
				that.getServerData(that.queryParam);
			});
			
			that.nextBtn();
			that.initTime();
			that.getServerData();
			that.operationItem();
		},
		queryParam:{},
		nextBtn: function() {

		},
		initTime: function() {
		
		<#list columns as item>
				<#if item.DATA_TYPE='datetime'> 
					<#--
					$(".${item.COLUMN_NAME}").datetimepicker({
						language: "zh-CN",
						weekStart: 1,
						todayBtn: 1,
						autoclose: 1,
						todayHighlight: 1,
						startView: 2,
						minView: 2,
						forceParse: 0,
						format: "yyyy-mm-dd"
					});
					$(".${item.COLUMN_NAME}search").datetimepicker({
						language: "zh-CN",
						weekStart: 1,
						todayBtn: 1,
						autoclose: 1,
						todayHighlight: 1,
						startView: 2,
						minView: 2,
						forceParse: 0,
						format: "yyyy-mm-dd"
					});
					-->
				</#if>
		</#list>


		},
		getServerData: function(data) {
			data=data||{};
			$('#datagridExample${salt} .datagrid-loading').fadeIn();
			//setTimeout(function() {}, 1000);

			var list = [];
			var param=data||{};
			$.ajax({
				  type: "POST",
				  url: "${module_name}/select",
				  data: param,
//				  dataType: 'json',
//				  contentType: "text/plain",
				  //contentType:'application/x-www-form-urlencoded; charset=UTF-8',
				  success: function(data){

						list=data;
						for(p in list){
							var obj=list[p];
							obj.operation='<div ' 
							<#list columns as item>
									<#if item?is_first> 
									+'data-${item.COLUMN_NAME}="' + obj.${item.COLUMN_NAME}
									<#else>
									+ '" data-${item.COLUMN_NAME}="' + obj.${item.COLUMN_NAME}
									</#if>
							</#list>
					  + '" style="text-align:center;"><button class="btn btn-xs btn-info updata-data">\u4FEE\u6539</button><button class="btn btn-xs btn-danger remove-data" style="margin-left:8px;margin-right:8px;">\u5220\u9664</button><button class="btn btn-xs btn-primary see-data">\u67E5\u770B</button></div>';						
						}
						var myDataGrid = $('#datagridExample${salt}').data('zui.datagrid');
						myDataGrid.setDataSource({
							cols: [
							
							<#list columns as item>
									<#if item?is_first> 
									{
										name: '${item.COLUMN_NAME}',
										label: '${item.COLUMN_COMMENT}',
										width: 100
									}
									<#elseif item.COLUMN_NAME == 'backUp1' ||  item.COLUMN_NAME == 'backUp2' ||  item.COLUMN_NAME == 'backUp3' ||  item.COLUMN_NAME == 'backUp4' ||  item.COLUMN_NAME == 'backUp5'>
									//,{
									//	name: '${item.COLUMN_NAME}',
									//	label: '${item.COLUMN_COMMENT}',
									//	width: 100
									//}	
									<#else>
									,{
										name: '${item.COLUMN_NAME}',
										label: '${item.COLUMN_COMMENT}',
										width: 100
									}									

									</#if>
							</#list>,{
								name: 'operation',
								label: '操作',
								html:true,
								width:150
							}],
							array: list
						});
						myDataGrid.render();
					
				  }
				  
				});
			

			$('#datagridExample${salt} .datagrid-loading').fadeOut();
		
		},
		
		
		operationItem: function() {
			var that = this;
			$('#datagridExample${salt}').on('click', '.updata-data', function() {
				var itemData = $(this).parent()[0];
				var modelDom = $('#updateAddModal${salt}');
				var $itemData=$(itemData);
				modelDom.find('#myModalLabel${salt}').text('修改');
				modelDom.find('.updata-data').text('修改').attr('op-type', 'updata');
				<#list columns as item>
					modelDom.find('.${item.COLUMN_NAME}').val($itemData.attr("data-${item.COLUMN_NAME}"));		
				</#list>
				modelDom.find("button.updata-data").show();
				modelDom.modal('show');
			});
			$('#datagridExample${salt}').on('click', '.remove-data', function() {
				var itemData = $(this).parent()[0];
				var modelDom = $('#removeTip${salt}');
				modelDom.find('.id').val(itemData.dataset.id);
				$('#removeTip${salt}').modal('show');
			});
			$('#datagridExample${salt}').on('click', '.see-data', function() {
				var itemData = $(this).parent()[0];
				var modelDom = $('#updateAddModal${salt}');
				var $itemData=$(itemData);
				modelDom.find('#myModalLabel${salt}').text('查看');
				<#list columns as item>
					modelDom.find('.${item.COLUMN_NAME}').val($itemData.attr("data-${item.COLUMN_NAME}"));		
				</#list>
				modelDom.find("button.updata-data").hide();
				//打算隐藏一整个，但是失败了
				//modelDom.prop( "disabled", true );
				modelDom.modal('show');
			});
			$('#updateAddModal${salt}').on('click', '.updata-data', function() {
				var subBtn = $(this);
				var data = $("form.modify${salt}").serializeFormJSON();
				subBtn.button('loading');
			 	if (subBtn.attr('op-type') == 'updata') {
					$.ajax({
						  type: "POST",
						  url: "${module_name}/update",
						  data: data,
						  success: function(data){
							  
						 		new $.zui.Messager('修改成功', {
						 			type: 'success' // 定义颜色主题
						 		}).show();
						 		
							 	subBtn.button('reset');
							 	$('#updateAddModal${salt}').modal('hide');
							 	that.getServerData(that.queryParam);
						  
						  }
						  
						});

			 	} else {
					$.ajax({
						  type: "POST",
						  url: "${module_name}/add",
						  data: data,
						  success: function(data){
							  
						 		new $.zui.Messager('新增成功', {
						 			type: 'success' // 定义颜色主题
						 		}).show();
							  
							 	subBtn.button('reset');
							 	$('#updateAddModal${salt}').modal('hide');
							 	that.getServerData(that.queryParam);
						  }
						  
						});

			 	}
			});
			
			$('#removeTip${salt}').on('click', '.remove-data', function() {
				
				
				var subBtn = $(this);
				var data = $("form.del${salt}").serializeFormJSON();
				
				var subBtn = $(this);
				subBtn.button('loading');
				
				$.ajax({
					  type: "POST",
					  url: "${module_name}/delete",
					  data: data,
					  success: function(data){

							subBtn.button('reset');
							$('#removeTip${salt}').modal('hide');
							that.getServerData(that.queryParam);
					  }
					  
					});

			});
			$('.add-data${salt}').click(function() {
				var modelDom = $('#updateAddModal${salt}');
				modelDom.find('#myModalLabel${salt}').text('新增');
				modelDom.find('.updata-data').text('新增').attr('op-type', 'add');
				modelDom.find("button.updata-data").show();
				modelDom.find('form')[0].reset();
				modelDom.modal('show');
			});
		},
	};
	pageObj.init();
})(jQuery);