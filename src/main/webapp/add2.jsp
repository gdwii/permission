<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function(){
        $("#button_submit").click(function(){
            var user = {
        		"username":"gaodwei"	
            };
            
           $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/user.do",
                data:user,
                success:function(data){
                    alert("成功");
                },
                error:function(e) {
                    alert("出错："+e);
                }
            });
        });
    });
</script>
</head>
<body>
<form enctype="application/x-www-form-urlencoded">
	<!-- <input id="name" type="text" />
	<input id="birthday" type="text"> -->
	<input id="button_submit" type="button" value="提交">
</form>
</body>
</html>
