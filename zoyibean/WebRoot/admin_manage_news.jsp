<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻管理</title>
</head>
<body>
<f:view>
	<h1 align="center">新闻管理</h1>
	<div align="center"><h:form style="align-text:center;">
		<h:inputText value="#{newsBean.cond}" />&nbsp;&nbsp;&nbsp;
		<h:commandButton value="搜索" action="admin_manage_news.php"></h:commandButton>
	</h:form></div>
	<h:form>
		<rich:dataTable id="allNews" align="center"
			value="#{newsBean.dataModel}" var="news" rows="#{newsBean.pageSize }">
			<rich:column>
				<f:facet name="header">
					<h:outputText value="新闻号" />
				</f:facet>
				<h:outputText value="#{news.innerId }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="新闻标题" />
				</f:facet>
				<h:commandLink action="#{newsBean.queryById}" target="_blank">
					<f:param name="nid" value="#{news.innerId}" />
					<h:outputText value="#{news.title}" />
				</h:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="发布时间" />
				</f:facet>
				<h:outputText value="#{news.releasetime }" ><f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="分类" />
				</f:facet>
				<h:selectOneMenu readonly="true" disabled="true"
					value="#{news.newsCategory.id }">
					<f:selectItem itemValue="0" itemLabel="默认分类" />
					<f:selectItems value="#{newsBean.allNewsCategory}" />
				</h:selectOneMenu>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="发布者" />
				</f:facet>
				<h:outputText value="#{news.publisherId }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="删除" />
				</f:facet>
				<a4j:commandLink ajaxSingle="true"
					onclick="javascript:Richfaces.showModalPanel('deleteNewsShow',{width:200,top:200});"
					id="deleteNews" reRender="nid">
					<f:param name="nid" value="#{news.innerId }" />删除</a4j:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="编辑" />
				</f:facet>
				<a4j:commandLink ajaxSingle="true" action="#{newsBean.preModify}">
					<f:param name="nid" value="#{news.innerId}" />编辑</a4j:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:datascroller for="allNews" align="center">
			<f:param value="#{param.newsCategoryId}" name="newsCategoryId" />
			<f:param value="#{param.cond}" name="cond" />
		</rich:datascroller>
		<rich:spacer />
	</h:form>

	<rich:modalPanel height="150" id="deleteNewsShow" resizeable="false"
		width="200" zindex="1000">
		<h:form id="deleteNewsForm">
			<a4j:region>
				<h:outputText value="确定删除相关数据吗？此操作不能恢复。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('deleteNewsShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="nid">
					<h:outputText value="#{param.nid}" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deleteNewsShow')"
						actionListener="#{newsBean.ajaxDelete}" ajaxSingle="true"
						reRender="allNews">
						<f:param name="nid" value="#{param.nid}" />确定删除
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deleteNewsShow')" value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>
	<h:messages></h:messages>
	<br />
	<h:outputText value="#{newsBean.errormsg}" id="errorinfo"></h:outputText>
	<br />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
	<br />
	<h:outputLink value="admin_release_news.php">新增新闻</h:outputLink>
</f:view>
</body>
</html>