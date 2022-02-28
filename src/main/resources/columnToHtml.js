var columns=[{
	display: '配送单号',
	name: 'ps_no',
	width: 110,
	align: 'left'
}, {
	display: '类型',
	name: 'bill_type',
	align: 'center',
	width: '80',
}];

var s='';
for(var p in columns){

	var s=s+'<div class="layui-inline " style="width: 20%">'
		+'<label class="layui-form-label">'+columns[p]["display"]+'：</label>'
		+'<div class="layui-inline-text">'
		+'<span class="layui-span" id="'+columns[p]["name"]+'"></span>'
		+'</div>'
		+'</div>';
}
console.log(s);