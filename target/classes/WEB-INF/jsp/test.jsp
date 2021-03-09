<%--
  Created by IntelliJ IDEA.
  User: paragon
  Date: 2021/3/8
  Time: 下午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>购买产品测试</title>
    <script type="text/javascript"
            src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<script type="text/javascript">
        // var params = {
        //     userId : 1,
        //     productId : 1,
        //     quantity : 1
        // };
        // // 通过POST请求后端
        // $.post("./purchase", params, function(result) {
        //     alert(result.message);
        // });
        //模拟高并发情况下超卖情况
    for (var i=1; i<=300; i++) {
        var params = {
            userId : 1,
            productId : 1,
            quantity : 1
        };
        // 通过POST请求后端,这里的JavaScript会采用异步请求
        $.post("./purchase", params, function(result) {
        });
    }
</script>
<body>
<h1>秒杀系统测试</h1>
</body>
</html>
