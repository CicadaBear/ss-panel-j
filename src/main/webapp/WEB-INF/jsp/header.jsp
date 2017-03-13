<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>${fnc:getConfig("appName")}</title>
    <!-- CSS fonts.googleapis.com -->
    <link href="//fonts.lug.ustc.edu.cn/icon?family=Material+Icons" rel="stylesheet">
    <link href="${ctxStatic}/assets/materialize/css/materialize.min.css" type="text/css" rel="stylesheet"
          media="screen,projection"/>
    <link href="${ctxStatic}/assets/materialize/css/style.css" type="text/css" rel="stylesheet"
          media="screen,projection"/>
</head>
<body>
<nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="/"
                                          class="brand-logo">${fnc:getConfig("appName")}</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="/">首页</a></li>
            <li><a href="https://shadowsocks.org/en/download/clients.html">客户端下载</a></li>
            <li><a href="code">邀请码</a></li>
            <%--{if $user->isLogin}--%>
            <c:if test="${fnc:isLogin()}">
                <li><a href="/user">用户中心</a></li>
                <li><a href="/user/logout">退出</a></li>
            </c:if>
            <%--{else}--%>
            <c:if test="${not fnc:isLogin()}">
                <li><a href="/auth/login">登录</a></li>
                <li><a href="/auth/register">注册</a></li>
                <%--{/if}--%>
            </c:if>

        </ul>

        <ul id="nav-mobile" class="side-nav">
            <li><a href="/">首页</a></li>
            <li><a href="https://shadowsocks.org/en/download/clients.html">客户端下载</a></li>
            <li><a href="/errorCode">邀请码</a></li>
            <%--{if $user->isLogin}--%>
            <c:if test="${fnc:isLogin()}">
                <li><a href="/user">用户中心</a></li>
                <li><a href="/user/logout">退出</a></li>
            </c:if>
            <%--{else}--%>
            <c:if test="${not fnc:isLogin()}">
                <li><a href="/auth/login">登录</a></li>
                <li><a href="/auth/register">注册</a></li>
                <%--{/if}--%>
            </c:if>
        </ul>
        <!-- To be compatible with some old browsers(especially mobile browsers), use &#xE5D2 instead of menu. For more information visit the link below.
         http://google.github.io/material-design-icons/#using-the-icons-in-html
         -->
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">&#xE5D2</i></a>
    </div>
</nav>
