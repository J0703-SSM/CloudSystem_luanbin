<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/resources/styles/global_color.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script language="javascript" type="text/javascript">
        //排序按钮的点击事件
        function sort(btnObj) {
            if (btnObj.className == "sort_desc")
                btnObj.className = "sort_asc";
            else
                btnObj.className = "sort_desc";
        }

        //启用
        function startFee(result) {
            var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
            $.post("/fee/startStatus", {
                "id": result
            });
            document.getElementById("operate_result_info").style.display = "block";
        }
        //删除
        function deleteFee(result) {
            var r = window.confirm("确定要删除此资费吗？");
            $.post("/fee/deleteCost", {
                "id": result
            });
            document.getElementById("operate_result_info1").style.display = "block";
        }

        function startS() {
            location.href = "/fee/fee_list_findAll/1";
            this.parentNode.style.display = 'none';
        }
        function deleteS() {
            location.href = "/fee/fee_list_findAll/1";
            this.parentNode.style.display = 'none';
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
    <form action="" method="post">
        <!--排序-->
        <div class="search_add">
            <div>
                <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                <input type="button" value="基费" class="sort_asc" onclick="sort(this);"/>
                <input type="button" value="时长" class="sort_asc" onclick="sort(this);"/>
            </div>


            <input type="button" value="增加" class="btn_add" onclick="location.href='/fee/fee_add';"/>
        </div>
        <!--启用操作的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="/resources/images/close.png" onclick="startS()"/>
            启用成功！
        </div>
        <div id="operate_result_info1" class="operate_success">
            删除成功！
            <img src="/resources/images/close.png" onclick="deleteS()"/>
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <c:if test="${!empty pb}">
                    <tr>
                        <th>资费ID</th>
                        <th class="width100">资费名称</th>
                        <th>基本时长</th>
                        <th>基本费用</th>
                        <th>单位费用</th>
                        <th>创建时间</th>
                        <th>开通时间</th>
                        <th class="width50">状态</th>
                        <th class="width200"></th>
                    </tr>

                    <c:forEach items="${pb.beanList}" var="costs">
                        <tr>
                            <td>${costs.id}</td>
                            <td><a href="/fee/fee_detail/${costs.id}">${costs.name}</a></td>
                            <td>${costs.base_duration}</td>
                            <td>${costs.base_cost}</td>
                            <td>${costs.unit_cost}</td>
                            <td><fmt:formatDate value="${costs.creatime}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${costs.startime}" pattern="yyyy-MM-dd"/></td>
                            <td>
                                <c:choose>
                                    <c:when test="${costs.status == 0}">
                                        开通
                                    </c:when>
                                    <c:otherwise>
                                        暂停
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${costs.status == 0}">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="button" value="启用" class="btn_start"
                                               onclick="startFee(${costs.id});"/>
                                        <input type="button" value="修改" class="btn_modify"
                                               onclick="location.href='/fee/fee_modi/${costs.id}';"/>
                                        <input type="button" value="删除" class="btn_delete"
                                               onclick="deleteFee(${costs.id});"/>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
            <p>业务说明：<br/>
                1、创建资费时，状态为暂停，记载创建时间；<br/>
                2、暂停状态下，可修改，可删除；<br/>
                3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br/>
                4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
            </p>
        </div>
        <!--分页-->
        <div id="pages">
            第${pb.pageCode}页/共${pb.totalPage}页
            <a href="<c:url value="${pb.url}/1"/>">首页</a>
            <c:if test="${pb.pageCode > 1}">
                <a href="<c:url value="${pb.url}/${pb.pageCode-1}"/>">上一页</a>
            </c:if>

            <%-- 计算 begin , end
                >如果总页数 tp<=10 : begin=1,end = tp
                >如果总页数大于10
                    >使用计算公式计算: begin=pc-5 end=pc+4
                        * 头溢出 begin < 1 begin = 1
                        * 尾溢出 end > tp end = tp

            --%>

            <c:choose>
                <%-- 总页数<= 10 时--%>
                <c:when test="${pb.totalPage<=10}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pb.totalPage}"/>
                </c:when>
                <%-- 总页数>10 使用计算公式--%>
                <c:otherwise>
                    <c:set var="begin" value="${pb.pageCode-5}"/>
                    <c:set var="end" value="${pb.pageCode+4}"/>
                    <%-- 头溢出 --%>
                    <c:if test="${begin<1}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="10"/>
                    </c:if>
                    <%-- 尾溢出 --%>
                    <c:if test="${end>pb.totalPage}">
                        <c:set var="begin" value="${pb.totalPage-9}"/>
                        <c:set var="end" value="${pb.totalPage}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>


            <%-- for循环遍历 begin --- end --%>


            <c:forEach var="a" begin="${begin}" end="${end}">
                <c:choose>
                    <c:when test="${pb.pageCode eq a}">
                        ${a}
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value="${pb.url}/${a}"/>">[${a}]</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>


            <c:if test="${pb.pageCode < pb.totalPage}">
                <a href="<c:url value="${pb.url}/${pb.pageCode+1}"/>">下一页</a>
            </c:if>
            <a href="<c:url value="${pb.url}/${pb.totalPage}"/>">尾页</a>
        </div>
        <%--<div id="pages">--%>
        <%--<a href="#">上一页</a>--%>
        <%--<a href="#" class="current_page">1</a>--%>
        <%--<a href="#">2</a>--%>
        <%--<a href="#">3</a>--%>
        <%--<a href="#">4</a>--%>
        <%--<a href="#">5</a>--%>
        <%--<a href="#">下一页</a>--%>
        <%--</div>--%>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司</p>
</div>
</body>
</html>
