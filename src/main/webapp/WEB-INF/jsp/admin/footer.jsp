<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglib.jsp" %>
<footer class="main-footer">
    <div class="pull-right hidden-xs">
        Made with Love
    </div>
    <strong>Copyright &copy; 2017 <a href="#">${fnc:getConfig('appName')}</a> </strong>
    All rights reserved. Powered by <b>ss-panel</b> ${fnc:getConfig('version')} | <a href="/tos">服务条款 </a> | Running
    time ${runningTime} Milliseconds
</footer>
</div><!-- ./wrapper -->


<!-- Bootstrap 3.3.2 JS -->
<script src="${ctxStatic}/assets/public/js/bootstrap.min.js" type="text/javascript"></script>
<!-- SlimScroll -->
<script src="${ctxStatic}/assets/public/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- FastClick -->
<script src='${ctxStatic}/assets/public/plugins/fastclick/fastclick.min.js'></script>
<!-- AdminLTE App -->
<script src="${ctxStatic}/assets/public/js/app.min.js" type="text/javascript"></script>
<div style="display:none;">
    ${analyticsCode}
</div>
</body>
</html>
