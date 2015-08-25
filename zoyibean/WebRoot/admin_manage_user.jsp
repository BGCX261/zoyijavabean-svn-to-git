<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich"  uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<!--
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
	margin: 110px auto
}

dl {
	margin: 20px auto 0;
	width: 200px;
	background: none;
	text-align: center;
}

dl dt {
	background: none;
	font-size: 13px;
	font-weight: bold;
	line-height: 30px;
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
//
-->
</style>
</head>
<body>
<f:view><h1 align="center">管理会员</h1>
	<h:form>
		
		<rich:dataTable id="allAnnouncement" align="center"
			value="#{announcementBean.dataModel}" var="ann"
			rows="#{announcementBean.pageSize }">
			<rich:column>
			<f:facet name="header">
					<h:outputText value="活动号" />
				</f:facet>
				<h:outputText value="#{ann.id}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="活动标题" />
				</f:facet>
				<h:commandLink action="#{announcementBean.queryById}">
					<f:param name="id" value="#{ann.id}" />
					<h:outputText value="#{ann.title}" />
				</h:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:datascroller
			align="center" for="allAnnouncement" />
		<rich:spacer />
	</h:form>
	<rich:spacer height="10"></rich:spacer>
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>