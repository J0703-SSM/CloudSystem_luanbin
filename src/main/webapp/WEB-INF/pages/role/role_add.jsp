﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="/resources/images/logo.png" alt="logo" class="left"/>
    <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <ul id="menu">
        <li><a href="/index" class="index_on"></a></li>
        <li><a href="/role/role_list_findAll" class="role_off"></a></li>
        <li><a href="/admin/admin_list_findAll" class="admin_off"></a></li>
        <li><a href="/fee/fee_list_findAll/1" class="fee_off"></a></li>
        <li><a href="/account_list" class="account_off"></a></li>
        <li><a href="/service_list" class="service_off"></a></li>
        <li><a href="/bill_list" class="bill_off"></a></li>
        <li><a href="/report_list" class="report_off"></a></li>
        <li><a href="/user_info_select" class="information_off"></a></li>
        <li><a href="/user_modi_pwd" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <!--保存操作后的提示信息：成功或者失败-->
    <%--<div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，角色名称重复！-->--%>
    <form action="/role/addRole" method="post" class="main_form">
        <div class="text_info clearfix"><span>角色名称：</span></div>
        <div class="input_info">
            <input type="text" name="name" class="width200"/>
            <span class="required">*</span>
            <div class="validate_msg_medium">
                <c:if test="${nameError != null and nameError != ''}">
                    ${nameError.defaultMessage}
                </c:if>
                <c:if test="${reNameError != null and reNameError !=''}">
                    ${reNameError}
                </c:if>
            </div>
        </div>
        <div class="text_info clearfix"><span>设置权限：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul>
                    <c:forEach items="${moduleInfos}" var="moduleInfo">
                        <li><input name="module_names" type="checkbox" value="${moduleInfo.name}"/>${moduleInfo.name}
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <span class="required">*</span>
            <div class="validate_msg_tiny">
                <c:if test="${moduleError != null and moduleError !=''}">
                    ${moduleError}
                </c:if>
            </div>
        </div>
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" onclick="showResult();"/>
            <input type="button" value="取消" class="btn_save" onclick="location.href='/role/role_list_findAll';"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br/>
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>
