<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>管理员登录</title>


    <!-- Bootstrap core CSS -->
<link href="/resource/bootstrap4/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="icon" href="/resource/images/shop.png" sizes="16x16" type="image/png">

<meta name="msapplication-config" content="/docs/assets/img/favicons/browserconfig.xml">
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
    <link href="resource/css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" method="post" action="login">
  <img class="mb-4" src="/resource/images/manager.png" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
  <label for="inputEmail" class="sr-only">用户名</label>
  <input type="text" id="inputEmail" class="form-control" placeholder="用户名" name="name" required="" autofocus="">
  <label for="inputPassword" class="sr-only">密码</label>
  <input type="password" id="inputPassword" class="form-control" placeholder="密码" name="password" required="">
  <div class="checkbox mb-3">
    <!-- <label>
      <input type="checkbox" value="remember-me"> 记住密码
    </label> -->
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
  <p class="mt-5 mb-3 text-muted">© 2019-2020</p>
</form>


</body></html>