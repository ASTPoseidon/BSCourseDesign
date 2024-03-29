<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>登录</title>

    <style>
        html,
        body {
            height: 100%;
        }

        body {
            display: -ms-flexbox;
            display: flex;
            -ms-flex-align: center;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: white;
        }

        .form-login {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }

        .form-login .checkbox {
            font-weight: 400;
        }

        .form-login .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }

        .form-login .form-control:focus {
            z-index: 2;
        }

        .form-login input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-login input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .text-muted {
            margin-top: 50px;
        }


    </style>

</head>
<body class="text-center">
<form class="form-login" action="LoginServlet" method="post">
    <img class="mb-4" src="images/login.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">欢迎使用选课系统</h1>
    <label for="UserName" class="sr-only">UserName</label>
    <input type="UserName" id="UserName" name="account" class="form-control" placeholder="用户名" required
           autofocus>
    <label for="PassWord" class="sr-only">PassWord</label>
    <input type="PassWord" id="Password" name="password" class="form-control" placeholder="密码" required>
    <div class="form-group">
        <select name="type" class="form-control">
            <option value="student">学生</option>
            <option value="teacher">教师</option>
            <option value="root">管理员</option>
        </select>
    </div>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" name="checkbox" value="remember-me"> 记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted">&copy; 选课系统</p>
</form>

<%
    //Todo:此处引入cookie，暂未使用

%>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
</body>
</html>
