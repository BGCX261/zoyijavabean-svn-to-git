<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<h1 align="center">接受活动</h1>
	<h:form>
		<rich:dataTable id="allAppliedActivity" width="520" border="0"
			align="center" cellspacing="0" cellpadding="4"
			value="#{benifitActivityBean.appliedBenifitActivityData}"
			var="benifitActivity" rows="#{benifitActivityBean.pageSize }">
			<rich:column style="text-align:left;">
				<f:facet name="header">
					<h:outputText value="活动号" />
				</f:facet>
				<h:commandLink target="_blank"
					action="#{benifitActivityBean.queryById}">
					<f:param name="baid" value="#{benifitActivity.id}" />
					<h:outputText value="#{benifitActivity.title}" />
				</h:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:spacer />
		<rich:datascroller page="#{benifitActivityBean.scrollerPage}"
			for="allBenifitActivity" align="center" />
		<rich:spacer />
		<rich:spacer height="20" />

	</h:form>
	<rich:modalPanel height="150" id="refuseBenifitActivityShow"
		resizeable="false" width="200" zindex="1000">
		<h:form id="refuseBenifitActivityForm">
			<a4j:region>
				<h:outputText value="确定删除相关数据吗？此操作不能恢复。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('refuseBenifitActivityShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="gid">
					<h:outputText value="#{param.baid}" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('refuseBenifitActivityShow')"
						actionListener="#{newsBean.ajaxDelete}" ajaxSingle="true"
						reRender="allAppliedActivity">
						<f:param name="baid" value="#{param.baid}" />确定拒绝
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('refuseBenifitActivityShow')"
						value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>
</f:view>
</body>
</html>