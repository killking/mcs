

	function openTab(text,url){
		/* 如果选项卡已经存在了， 选中即可， 如果不存在，新增 */
		if($('#tabs').tabs('exists',text)){
			$('#tabs').tabs('select',text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
			$('#tabs').tabs('add',{   
			    title:text,   
			    content:content,   
			    closable:true,   
			});  
		}

	}