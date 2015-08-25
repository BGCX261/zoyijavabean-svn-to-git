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
<title>用户信用管理</title>
</head>
<body>

<f:view>
	<h1 align="center">用户信用管理</h1>
	<h:form id="applyBenifitActivityForm">
		<rich:dataTable id="allUserinfo" align="center"
			value="#{benifitActivityBean.relatedUserData }" var="userinfo"
			rows="#{benifitActivityBean.pageSize }">
			<rich:column>
				<f:facet name="header">
					<h:outputText value="用户名" />
				</f:facet>
				<h:outputLink target="_blank" value="user_index.php">&nbsp;&nbsp;
					<f:param value="#{userinfo.userId}" name="uid" />
					<h:outputText value="#{userinfo.name}" />&nbsp;&nbsp;
				</h:outputLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Email" />
				</f:facet>
				<h:outputText value="#{userinfo.email}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="活动" />
				</f:facet>
				<h:outputLink target="_blank" value="http://localhost/cq/home/space.php">&nbsp;&nbsp;
					<f:param value="#{benifitActivityBean.benifitActivity.id}"
						name="id" />
					<f:param value="event" name="do" />
					<h:outputText
						value="#{benifitActivityBean.benifitActivity.activityName}" />
				</h:outputLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="活动时间" />
				</f:facet>
				<h:outputText
					value="#{benifitActivityBean.benifitActivity.starttime}" ><f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText>~<br />
				<h:outputText value="#{benifitActivityBean.benifitActivity.endtime}" ><f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="爱心" />
				</f:facet>
				<h:outputText value="#{userinfo.credit }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="黑心" />
				</f:facet>
				<h:outputText value="#{userinfo.darkmind }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="无信用" />
				</f:facet>
				<h:commandLink actionListener="#{benifitActivityBean.noCredit}">
					<f:param value="uid" name="#{userinfo.userId}"></f:param>
					<h:outputText value="无信用" />
				</h:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="信用+1" />
				</f:facet>
				<h:commandLink actionListener="#{benifitActivityBean.addCredit}">
					<f:param name="baid" value="#{param.baid}" />
					<f:param name="uid" value="#{userinfo.userId}" />
					<h:outputText value="信用+1" />
				</h:commandLink>
			</rich:column>
		</rich:dataTable>
		<rich:datascroller for="allUserinfo" align="center">
			<f:param value="#{param.cond}" name="cond"></f:param>
		</rich:datascroller>
		<rich:spacer />
		<a4j:commandLink ajaxSingle="true"
			onclick="javascript:Richfaces.showModalPanel('addCreditShow',{width:200,top:200});"
			id="addCredit" reRender="baid">
			<f:param name="baid" value="#{param.baid }" />给参与<h:outputText
				value="#{benifitActivityBean.benifitActivity.activityName}" />活动的同学信用都+1
		</a4j:commandLink>
	</h:form>

	<rich:modalPanel height="150" id="addCreditShow" resizeable="false"
		width="200" zindex="1000">
		<h:form id="addCreditForm">
			<a4j:region>
				<h:outputText value="确定执行相关操作吗？此操作不能回退。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('addCreditShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="baid">
					<h:outputText value="#{param.baid}" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('addCreditShow')"
						action="#{benifitActivityBean.addAllCredit}" ajaxSingle="true"
						reRender="allUserinfo">
						<f:param name="baid" value="#{param.baid}" />确定给他们信用+1
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('addCreditShow')" value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>
	<h:outputText id="errorinfo" value="#{benifitActivityBean.errormsg}" />
	<br />
	<h:messages></h:messages>
	<br />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>

</f:view>
</body>
</html>