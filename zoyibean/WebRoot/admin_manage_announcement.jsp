<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理</title>
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

<f:view>
	<h1 align="center">公告管理</h1>
	<h:form id="manageAnnouncement">
		<rich:dataTable id="allAnnouncement" align="center"
			value="#{announcementBean.dataModel}" var="ann"
			rows="#{announcementBean.pageSize }">
			<rich:column>
				<f:facet name="header">
					<h:outputText value="公告标题" />
				</f:facet>
				<h:outputLink target="_blank"
					value="announcement_content.php">
					<f:param name="aid" value="#{ann.id}" />
					<h:outputText value="#{ann.title}" id="title" />
				</h:outputLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="发布者">
					</h:outputText>
				</f:facet>
				<h:outputText value="#{ann.announcer }" id="announcer">
				</h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="发布时间" />
				</f:facet>
				<h:outputText value="#{ann.createDate }">
					<f:convertDateTime pattern="yyyy-MM-dd HH:mm" />
				</h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="等级" />
				</f:facet>
				<h:outputText value="#{ann.level}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="删除" />
				</f:facet>
				<a4j:commandLink ajaxSingle="true"
					onclick="javascript:Richfaces.showModalPanel('deleteAnnouncementShow',{width:200,top:200});"
					id="deleteNewsCategory" reRender="anid">
					<f:param name="aid" value="#{ann.id}" />删除</a4j:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="编辑" />
				</f:facet>
				<h:commandLink action="#{announcementBean.preModify}">
					<f:param name="aid" value="#{ann.id}" />编辑</h:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:datascroller page="#{announcementBean.scrollerPage}"
			for="allAnnouncement" align="center" />
		<rich:spacer />
	</h:form>

	<rich:modalPanel height="150" id="deleteAnnouncementShow"
		resizeable="false" width="200" zindex="1000">
		<h:form id="deleteAnnouncementForm">
			<a4j:region>
				<h:outputText value="确定删除相关公告吗？此操作不能恢复。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('deleteAnnouncementShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="anid">
					<h:outputText value="#{param.aid}" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deleteAnnouncementShow')"
						actionListener="#{announcementBean.ajaxDelete}" ajaxSingle="true"
						reRender="allAnnouncement">
						<f:param name="aid" value="#{param.aid}" />确定删除
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deleteAnnouncementShow')"
						value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>
	<rich:spacer height="10" />
	<br />
	<h:outputText id="errorinfo" value="#{announcementBean.errormsg}"></h:outputText>
	<br />
	<h:messages />
	<br />
	<h:outputLink value="admin_release_announcement.php">新增公告</h:outputLink>
	<br />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
	<br />
</f:view>
</body>
</html>