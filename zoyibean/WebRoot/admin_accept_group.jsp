<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<h:form>
		<rich:dataTable id="allAppliedGroup" width="520" border="0"
			cellspacing="0" cellpadding="4" value="#{GroupBean.appliedGroupData}"
			var="group" rows="#{GroupBean.pageSize }">
			<rich:column style="text-align:left;">
				<f:facet name="header">
					<h:outputText value="标题" />
				</f:facet>
				<h:commandLink target="_blank" action="#{GroupBean.queryById}">
					<f:param name="gid" value="#{group.id}" />
					<h:outputText value="#{group.title}" />
				</h:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="拒绝" />
				</f:facet>
				<a4j:commandLink ajaxSingle="true"
					onclick="javascript:Richfaces.showModalPanel('refuseGroupShow',{width:200,top:200});"
					id="refuseGroup" reRender="gid">
					<f:param name="gid" value="#{group.id}"/>
					<h:outputText value="拒绝" />
				</a4j:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="接受" />
				</f:facet>
				<a4j:commandLink actionListener="#{GroupBean.ajaxAccept}"
					id="acceptGroup" reRender="gid">
					<f:param name="gid" value="#{group.id}"/>
					<h:outputText value="接受" />
				</a4j:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:spacer />
		<rich:datascroller page="#{GroupBean.scrollerPage}" for="allGroup"
			align="left" />
		<rich:spacer />
	</h:form>

	<rich:modalPanel height="150" id="refuseGroupShow" resizeable="false"
		width="200" zindex="1000">
		<h:form id="refuseGroupForm">
			<a4j:region>
				<h:outputText value="确定删除相关数据吗？此操作不能恢复。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('refuseGroupShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="gid">
					<h:outputText value="#{param.gid}" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('refuseGroupShow')"
						actionListener="#{newsBean.ajaxDelete}" ajaxSingle="true"
						reRender="newsAll">
						<f:param name="gid" value="#{param.gid}" />确定拒绝
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('refuseGroupShow')" value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>

</f:view>
</body>
</html>