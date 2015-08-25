<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理首页</title>
</head>
<style type="text/css">
body {
	background-color: #eee
}

#login {
	width: 720px;
	height: 450px;
	background: url(images/guanli.jpg) left top no-repeat;
	position: absolute;
	margin-left: -360px;
	left: 50%;
	top: 50%;
	margin-top: -225px;
}

#panel {
	width: 560px;
	height: 230px;
	margin: 110px auto 0;
	text-align:center
}

dl {
	margin: 20px auto 0;
	width: 400px;
	background: none;
	text-align: center;
}

dl dt {
	background: none;
	font-size: 13px;
	font-weight: bold;
	line-height: 30px;
	margin:10px 20px;
}

dl dt a {
	display: block;
	width: 200px;
	color: #000;
	text-decoration: none;
	background: url(images/thispre.gif) no-repeat 36px 9px;
}

dl dt a:hover {
	background: url(images/this.gif) no-repeat 36px 9px;
	font-size: 14px;
}
</style>
<body>
<f:view>
	<div id="login">
	<div id="panel">
	<dl>
		<table>
			<tr>
				<td>
				<dt><h:outputLink value="admin_manage_activity.php">活动管理</h:outputLink></dt>
				<dt><h:outputLink value="admin_manage_activity.php">活动积分管理</h:outputLink></dt>
				<dt><h:outputLink value="admin_manage_announcement.php">通知管理</h:outputLink></dt>
				<dt><h:outputLink value="http://localhost/cq/home/admincp.php?ac=space">用户管理</h:outputLink></dt>
				</td>
				<td>
				<dt><h:outputLink value="http://localhost/cq/ucenter/">Admin管理</h:outputLink></dt>
				<dt><h:outputLink value="admin_manage_newsCategory.php">新闻分类管理</h:outputLink></dt>
				<dt><h:outputLink value="admin_manage_news.php">新闻管理</h:outputLink></dt>
				<dt><h:outputLink value="admin_manage_appliedGroup.php">组织申请管理</h:outputLink></dt>
				</td>
			</tr>
		</table>
	</dl>
	</div>
	<div style="width:560px; margin:30px 80px; line-height:1.5em">
	<h:outputLink value="index.php">首页</h:outputLink>
	<br />
	<h:outputLink value="logout.php">注销</h:outputLink>
    </div>
	</div>
	
</f:view>
</body>
</html>