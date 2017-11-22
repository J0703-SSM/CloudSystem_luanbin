<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
</head>
<body class="index">
<div class="login_box">
    <form action="/login" method="post">
        <table>
            <tr>
                <td class="login_info">账号：</td>
                <td colspan="2"><input id="admin_code" name="admin_code" type="text" class="width150"/></td>
                <td class="login_error_info"><span class="required">
                <c:if test="${admin_codeError != null and admin_codeError != ''}">
                    ${admin_codeError.defaultMessage}
                </c:if></span></td>
            </tr>
            <tr>
                <td class="login_info">密码：</td>
                <td colspan="2"><input id="password" name="password" type="password" class="width150"/></td>
                <td><span class="required">
                <c:if test="${passwordError != null and passwordError != ''}">
                    ${passwordError.defaultMessage}
                </c:if>
            </span></td>
            </tr>
            <tr>
                <td class="login_info">验证码：</td>
                <td class="width70"><input name="code" type="text" class="width70"/></td>
                <td><img src="/getVerifyCode" alt="验证码" title="点击更换" id="verifyCodeImage" onclick="changeImage()"/></td>
                <td><span class="required">
                    <c:if test="${codeError != null and codeError !=''}">
                        ${codeError}
                    </c:if></span></td>
            </tr>
            <tr>
                <td></td>
                <td class="login_button" colspan="2">
                    <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img
                            src="/resources/images/login_btn.png"/></a>
                </td>
                <td><span class="required">
                        <c:if test="${loginError != null and loginError !=''}">
                            ${loginError}
                        </c:if></span></td>
            </tr>
        </table>
    </form>
</div>
<script>
    function changeImage() {
        $("#verifyCodeImage").attr("src", "/getVerifyCode?i=" + Math.random());
    }

</script>
</body>
</html>
