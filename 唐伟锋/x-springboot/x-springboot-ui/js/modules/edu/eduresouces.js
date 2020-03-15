$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'edu/eduresouces/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '类型id', name: 'edutypeid', index: 'eduTypeId', width: 80 }, 			
			{ label: '标题', name: 'eduname', index: 'eduName', width: 80 }, 			
			{ label: '小标题', name: 'edusecname', index: 'eduSecName', width: 80 }, 			
			{ label: '内容', name: 'educontent', index: 'eduContent', width: 80 }, 			
			{ label: '时长', name: 'edutime', index: 'eduTime', width: 80 }, 			
			{ label: '作者', name: 'eduuser', index: 'eduUser', width: 80 }, 			
			{ label: '责任主编', name: 'eduleaderuser', index: 'eduLeaderUser', width: 80 }, 			
			{ label: '来源', name: 'eduorigin', index: 'eduOrigin', width: 80 }, 			
			{ label: '单位', name: 'eduunint', index: 'eduUnint', width: 80 }, 			
			{ label: '图片地址', name: 'eduimage', index: 'eduImage', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '创建时间', name: 'educreatetime', index: 'eduCreateTime', width: 80 }, 			
			{ label: '修改人', name: 'educreateuser', index: 'eduCreateUser', width: 80 }, 			
			{ label: '更新时间', name: 'eduupdatetime', index: 'eduUpdateTime', width: 80 }, 			
			{ label: '链接地址', name: 'url', index: 'url', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		eduResouces: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.eduResouces = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.eduResouces.id == null ? "edu/eduresouces/save" : "edu/eduresouces/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.eduResouces),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "edu/eduresouces/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "edu/eduresouces/info/"+id, function(r){
                vm.eduResouces = r.eduResouces;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});