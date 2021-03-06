<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Floating labels example · Bootstrap</title>

    <!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >
	<script type="text/javascript" src="${pageContext.request.contextPath}/resource/jquery/jquery-3.4.1.js"></script>
<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resource/css/floating-labels.css" rel="stylesheet">
  </head>
  <body>
    <form class="form-signin"  method="POST">
  <div class="text-center mb-4">
    <img class="mb-4" src="/resource/img/hgshop.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">豪哥商城</h1>
    <p>  山寨  京东网 </p>
    <p> ${error}</p>
  </div>

  <div class="form-label-group">
    <input type="text" id="name" name="username" class="form-control" placeholder="用户名" required="" autofocus="">
    <label for="name">用户名</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="password" name="password" class="form-control" placeholder="密码" required="">
    <label for="password">密码</label>
  </div>
  <div class="form-label-group">
    <input type="text" id="code" name="code" class="form-control" placeholder="验证码" required="">
    <label for="password">验证码</label>
    <input class="btn btn-lg btn-primary btn-block" onclick="getCode()"  value="获取验证码"/>
  </div>

  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> 记住
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
  
  <p class="mt-5 mb-3 text-muted text-center">© 2017-2222</p>
</form>
<script type="text/javascript">
	function getCode(){
		$.post("/user/getValiCode",{},function(data){
			alert('获取验证码成功，请查收')
		})
	}

</script>

</body></html>