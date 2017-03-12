<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="main.jsp" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            节点列表
            <small>Node List</small>
        </h1>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- START PROGRESS BARS -->
        <div class="row">
            <div class="col-md-12">
                <div class="callout callout-warning">
                    <h4>注意!</h4>
                    <p>请勿在任何地方公开节点地址！</p>
                    <p>流量比例为0.5即使用1000MB按照500MB流量记录记录结算.</p>
                    ${msg}
                </div>
            </div>
        </div>

        <c:forEach items="${nodes}" var="node">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-widget">
                        <div class="box-body">
                            <ul class="products-list product-list-in-box">
                                <li class="item">
                                    <div class="product-img">
                                        <img src="../assets/public/img/iconfont-server.png" alt="Server Node">
                                    </div>
                                    <div class="product-info">
                                        <a href="./node/${node.id}" class="product-title">${node.name} <span
                                                class="label label-info pull-right">${node.status}</span></a>
                                        <p>
                                                ${node.info}
                                        </p>
                                    </div>
                                </li><!-- /.item -->
                            </ul>
                        </div>
                        <div class="box-footer no-padding">
                            <div class="row">
                                <div class="col-md-6">
                                    <ul class="nav nav-stacked">
                                        <li><a href="./node/${node.id}">节点地址 <span
                                                class="pull-right badge bg-blue">${node.server}</span></a></li>
                                        <li><a href="./node/${node.id}">连接端口 <span
                                                class="pull-right badge bg-aqua">${user.port}</span></a></li>
                                        <li><a href="./node/${node.id}">加密方式 <span
                                                class="pull-right badge bg-green"><c:if
                                                test="${node.customMethod}">${user.method}</c:if>  <c:if test="${not
                                                        node.customMethod}">${node.method}</c:if></span></a>
                                        </li>
                                        <li><a href="./node/${node.id}">负载: <span
                                                class="pull-right badge bg-green">${node.getNodeLoad()}</span></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-md-6">
                                    <ul class="nav nav-stacked">
                                        <li><a href="./node/${node.id}">流量比例 <span
                                                class="pull-right badge bg-blue">${node.trafficRate}</span></a>
                                        </li>
                                        <li><a href="./node/${node.id}">在线人数 <span
                                                class="pull-right badge bg-aqua">${node.getOnlineUserCount()}</span></a>
                                        </li>
                                        <li><a href="./node/${node.id}">产生流量 <span
                                                class="pull-right badge bg-green">${node.getTrafficFromLogs()}</span></a>
                                        </li>
                                        <li><a href="./node/${node.id}">Uptime: <span
                                                class="pull-right badge bg-green">${node.getNodeUptime()}</span></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div><!-- /.widget-user -->
                </div><!-- /.col -->
            </div>
            <!-- /.row -->


        </c:forEach>
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<%@ include file="footer.jsp" %>
