<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function(){
        $("#button_submit").click(function(){
            var name = $("#name").val();
            var birthday = $("#birthday").val();
            var data = {};
            
            var user = {
        		"name":name, "birthday": birthday	
            };
            
           $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/api/user.do",
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
	<input id="name" type="text" />
	<input id="birthday" type="text">
	<input id="button_submit" type="button" value="提交">
</form>
<%-- <form action="${pageContext.request.contextPath}/api/user.do" method="POST">
	<input type="text" name="name"/>
	<input name="s" type="text" value="sss">
	<input name="birthday" type="text">
	<input type="submit" value="Submit">
</form>  --%>
</body>
</html>
