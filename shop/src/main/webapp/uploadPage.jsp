<%--
  Created by IntelliJ IDEA.
  User: mayn
  Date: 2020/4/25
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图片上传</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    选择图片:<input type="file" type="file" accept="image/*" /> <br>
    <input type="submit" value="立刻上传">
</form>
</body>
</html>
