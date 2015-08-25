<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请组织管理</title>
</head>
<body>
<f:view>
	<h1 align="center">申请组织</h1>
	<h:form>
		<rich:dataTable id="allAppliedGroup" align="center"
			value="#{appliedGroupBean.dataModel}" var="ag"
			rows="#{appliedGroupBean.pageSize }">
			<rich:column>
				<f:facet name="header">
					<h:outputText value="id"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.id}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="组织名字"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.groupName}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="地址"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.address }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="所在省市"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.birthProvince }" />
				<h:outputText value="#{ag.birthCity}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="email"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.email}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="联系人"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.linkman }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="分类" />
				</f:facet>
				<h:outputText value="#{ag.groupCategory.id }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="电话"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.phone }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="状态"></h:outputText>
				</f:facet>
				<h:outputText value="#{ag.applyStatus }" />
			</rich:column>
			<!-- 
			<rich:column>
				<f:facet name="header">
					<h:outputText value="编辑" />
				</f:facet>
				<h:commandLink action="#{appliedGroupBean.preModify}">
					<f:param name="agid" value="#{ag.id}" />
					<h:outputText value="编辑" />
				</h:commandLink>
			</rich:column> -->
			<rich:column>
				<f:facet name="header">
					<h:outputText value="同意" />
				</f:facet>
				<a4j:commandLink actionListener="#{appliedGroupBean.ajaxAccept}"
					reRender="allAppliedGroup,errorinfo">
					<f:param name="agid" value="#{ag.id}" />
					<f:param name="status" value="#{ag.applyStatus}" />
					<h:outputText value="同意" />
					<c:out value="${ag.applyStatus}"></c:out>
				</a4j:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="拒绝" />
				</f:facet>
				<a4j:commandLink ajaxSingle="true"
					onclick="javascript:Richfaces.showModalPanel('refuseAGShow',{width:200,top:200});"
					id="refuseAppliedGroup" reRender="agid">
					<f:param name="agid" value="#{ag.id}" />
					<f:param name="status" value="#{ag.applyStatus}" />
					<h:outputText value="拒绝" />
				</a4j:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="删除" />
				</f:facet>
				<a4j:commandLink actionListener="#{appliedGroupBean.ajaxDelete}"
					reRender="allAppliedGroup">
					<f:param name="agid" value="#{ag.id}" />
					<f:param name="status" value="#{ag.applyStatus}" />
					<h:outputText value="删除" />
				</a4j:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:spacer />
		<rich:datascroller page="#{appliedGroupBean.scrollerPage}"
			for="allAppliedGroup" align="center">
			<f:param name="cond" value="#{appliedGroupBean.cond}"></f:param>
			<f:param name="status" value="#{param.status}"></f:param>
		</rich:datascroller>
		<rich:spacer />
	</h:form>

	<rich:modalPanel height="150" id="refuseAGShow" resizeable="false"
		width="200" zindex="1000">
		<h:form id="deleteAGForm">
			<a4j:region>
				<h:outputText id="emsg" />
				<h:outputText value="确定拒绝相关组织吗？此操作不能恢复。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('refuseAGShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="agid">
					<h:outputText value="#{param.agid}" />
					<br />
					<a4j:commandLink onclick="Richfaces.hideModalPanel('refuseAGShow')"
						actionListener="#{appliedGroupBean.ajaxRefuse}" ajaxSingle="true"
						reRender="allAppliedGroup,errorinfo">
						<f:param name="agid" value="#{param.agid}" />
						<f:param name="status" value="#{param.status}" />确定拒绝
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('refuseAGShow')">取消</a4j:commandLink>
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>
	<rich:spacer />
	<h:outputText value="#{appliedGroupBean.errormsg}" id="errorinfo"></h:outputText>
	<h:messages id="emsg" />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>