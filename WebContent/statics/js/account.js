
	// 删除账户
	function deleteAccount(){
		var obj = $("#dg").datagrid('getSelections');
		if(obj.length==0){
			alert("请至少选中一条记录");
			return;
		}
		
		var flag = confirm("确定要删除吗？想清楚！！");
		
		// 1,2
		var ids = "";
		for(var i=0; i<obj.length; i++){
			
			if(i==obj.length-1){
				ids += obj[i].id;
			}else{
				ids += obj[i].id + ",";
			}
		}
		
		
		if(flag){
			$.ajax({
				  type: "POST",
				  url: "accountController.do",
				  data:{
					 act:"deleteAccount",
					 ids: ids
				  },
				  success:function(data){
					if(data>0){
						alert('删除成功');
						// 更新页面数据
						searchAccount();
					}else{
						alert('删除失败');
					}
				  }
			});
		}
	}

	//  发送添加请求
	function updateAccount(){
		$.ajax({
			  type: "POST",
			  url: "accountController.do",
			  data:{
				  act:"updateAccount",
				  accountNameUpd:$("#accountNameUpd").val(),
				  moneyUpd:$("#moneyUpd").numberbox('getValue'),
				  remarkUpd:$('#remarkUpd').val() ,
				  accountTypeUpd:$('#accountTypeUpd').combobox('getValue'),
				  id:$("#id2").val()
			  },
			  success:function(data){
				if(data>0){
					alert('修改成功');
					// 更新页面数据
					searchAccount();
				}else{
					alert('修改失败');
				}
				
			  }
		});
		$('#ddUpdate').window('close');  
	}

	// 打开修改对话框， 并且回显数据
	function updateAccountDig(){
		var obj = $("#dg").datagrid('getSelected');
		console.log(obj);
		if(obj==null ){
			alert("请选择一条记录");
			return;
		}
		
		$("#ff").form('load',{
			accountNameUpd:obj.name,
			moneyUpd:obj.money,
			remarkUpd:obj.remark,
			accountTypeUpd:obj.type,
			id2:obj.id			
		});
	
		$("#ddUpdate").dialog('open');
	}


	// 按条件查询账户列表
	function searchAccount(){
		$('#dg').datagrid('load',{
			accountName:$("#accountName").val(),
			type:$("#type").combobox('getValue'),
			time:$("#time").datebox('getValue'),
			act:'queryByParam',
			url:'accountController.do'
		});
	}
	
	// 展示   添加输入框
	function addAccountDig(){
		// 显示模态框
		$('#ddAdd').window('open');  
	}
	
	/*
	发送添加请求
	*/
	function addAccount(){
		$.ajax({
			  type: "POST",
			  url: "accountController.do",
			  data:{
				  act:"addAccount",
				  accountNameAdd:$("#accountNameAdd").val(),
				  moneyAdd:$("#moneyAdd").numberbox('getValue'),
				  remark:$('#remarkAdd').val() ,
				  accountType:$('#accountTypeAdd').combobox('getValue')
			  },
			  success:function(data){
				if(data>0){
					alert('添加成功');
				}else{
					alert('添加失败');
				}
				// 更新页面数据
				searchAccount();
			  }
		});
		// 关闭对话框
		$('#ddAdd').window('close'); 
	}
	// 取消添加
	function addCancle(){
		$('#ddAdd').window('close');
	}