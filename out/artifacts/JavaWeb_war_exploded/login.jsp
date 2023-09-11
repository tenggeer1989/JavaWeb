<%--
  Created by IntelliJ IDEA.
  User: tengg
  Date: 2023/9/6
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
    <form action="/sessionLogin" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/checkCodeServlet1"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>

    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%></div>

    <script>
        const img = document.querySelector('#img')


            img.addEventListener('click',() => {
                let date = new Date().getTime()
                img.src = `/checkCodeServlet1?time=` + date
            })

    </script>
</body>
</html>
