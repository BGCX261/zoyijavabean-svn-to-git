<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>组织管理</title>
</head>
<body>
<f:view>
	<h1 align="center">组织管理</h1>
	<h:form>
		<rich:dataTable id="allGroup" border="0" 
			align="center" cellpadding="0" value="#{groupBean.dataModel}"
			var="group" rows="#{groupBean.pageSize }">
			<rich:column>
				<f:facet name="header">
					<h:outputText value="序号"></h:outputText>
				</f:facet>
				<h:outputText value="#{groupBean.dataModel.rowIndex}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="名称"></h:outputText>
				</f:facet>
				<h:commandLink target="_blank" action="#{groupBean.queryById}">
					<f:param name="gid" value="#{group.id}" />
					<h:outputText value="#{group.groupName}" />
				</h:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="规模"></h:outputText>
				</f:facet>
				<h:outputText value="#{group.scale}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="地区"></h:outputText>
				</f:facet>
				<h:outputText value="#{group.birthProvince}" />
				<h:outputText value="#{group.birthCity}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="地址"></h:outputText>
				</f:facet>
				<h:outputText value="#{group.address}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="删除" />
				</f:facet>
				<a4j:commandLink ajaxSingle="true"
					onclick="javascript:Richfaces.showModalPanel('deleteGroupShow',{width:200,top:200});"
					id="deleteGroupCategory" reRender="gid">
					<f:param name="gid" value="#{group.id }" />
					<h:outputText value="删除" />
				</a4j:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="编辑"></h:outputText>
				</f:facet>
				<h:commandLink action="#{groupBean.adminPreModify}">
					<f:param name="gid" value="#{group.id}" />
					<h:outputText value="编辑" />
				</h:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:spacer />
		<rich:datascroller page="#{groupBean.scrollerPage}" for="allGroup"
			align="center">
			<f:param name="cond" value="#{groupBean.cond }"></f:param>
		</rich:datascroller>
		<rich:spacer />
	</h:form>
	<rich:modalPanel height="150" id="deleteGroupShow" resizeable="false"
		width="200" zindex="1000">
		<h:form id="deleteGroupForm">
			<a4j:region>
				<h:outputText value="确定删除相关数据吗？此操作不能恢复。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('deleteGroupShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="gid">
					<h:outputText value="#{param.gid}" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deleteGroupShow')"
						actionListener="#{groupBean.ajaxDelete}" ajaxSingle="true"
						reRender="allGroup">
						<f:param name="gid" value="#{param.gid}" />确定删除
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deleteGroupShow')" value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel><br/>
	<h:outputText id="errorinfo" value="#{groupBean.errormsg }"></h:outputText><br/>
	<h:messages ></h:messages>
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>