<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" charset="utf-8" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		  	$(document).ready(function(){
			   		$.get("js/MyXml.xml", function(data){
						getNode(data);
			 	    });
			  	});
			  	
			  	function getNode(data) {
			      	$(data).find('user_address').each(function(i, n){
		          		getWeatherData(n);
		        	});
			  	}
			  	function getWeatherData(n) {
		  			var phone = "";
		        	var address = "";
		  		      	address = $(n).attr("title");
		               phone = $(n).find("description").text();
		               var content = "";
		               $.ajax(			   
					   { 
		                    async:false,
		                    url: "ajax.jsp",
		                    data:{
		                         address:address
		                    },
							success: function(d){
								 
								sendFeiXin(phone,d);
						  }
						});
			  	}
			  	function sendFeiXin(phone,d) {
			  	var urlString = "http://quanapi.sinaapp.com/fetion.php";
		  			 $.ajax({ 
							type:'get',
							dataType:'json',
							async:false,
							data:{
								u:"13203156064",
								p:"qq273231901",
								to:phone,
								m:d
							},
							url: urlString,
							success: function(res){
								alert(res);
							},
							error :function(res){
								alert("--"+res);
								//alert("result:"+res.result+"message:"+res.message);
							}
							});
		  	}
  </script>
</head>
<body>
</body>
</html>
