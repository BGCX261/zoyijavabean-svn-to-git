<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%><%@ taglib
	prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理活动</title>
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

	<h:form>
		<h1 align="center">管理活动</h1>
		<h:outputLink value="admin_manage_activity.php"><f:param name="status" value="1"/>查看今天前结束的活动</h:outputLink><br/>
		<h:outputLink value="admin_manage_activity.php"><f:param name="status" value="2"/>查看今天之后结束的活动</h:outputLink><br/>
		<h:outputLink value="admin_manage_activity.php">查看所有的活动</h:outputLink>
		<rich:dataTable id="allBenifitActivity" align="center"
			value="#{adminmodelbean.endDataModel}" var="activity"
			rows="#{adminmodelbean.pageSize }">
			<rich:column>
				<f:facet name="header">
					<h:outputText value="活动号" />
				</f:facet>
				<h:outputText value="#{activity.id}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="活动标题" />
				</f:facet>
				<h:outputLink target="_blank"
					value="http://localhost/cq/home/space.php">
					<f:param name="tagid" value="#{activity.id}" />
					<f:param name="do" value="mtag" />
					<h:outputText value="#{activity.activityName }" />
				</h:outputLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="活动地点" />
				</f:facet>
				<h:outputText value="#{activity.location }" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="接受申请时间" />
				</f:facet>
				<h:outputText value="#{activity.deadline}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="活动时间" />
				</f:facet>
				<h:outputText value="#{activity.starttime }" ><f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText> ~<br/>
				<h:outputText value="#{activity.endtime }" ><f:convertDateTime pattern="yyyy-MM-dd HH:mm" /></h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="组织" />
				</f:facet>
				<h:commandLink action="#{groupBean.queryById}" target="_blank">
					<f:param name="gid" value="#{activity.group.id}" />
					<h:outputText value="#{activity.group.groupName}" />
				</h:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="人员评分" />
				</f:facet>
				<h:outputLink value="admin_manage_activityusercredit.php">
					<f:param name="baid" value="#{activity.id}" />&nbsp;&nbsp;
					<h:outputText value="#{activity.membernum}" />/<h:outputText
						value="#{activity.limitnum  }" />&nbsp;&nbsp;
				</h:outputLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="操作" />
				</f:facet>
				<h:outputLink value="http://localhost/cq/home/admincp.php">
					<f:param name="baid" value="#{activity.id}" />
					<f:param name="ac" value="event" />
					<h:outputText value="操作" />
				</h:outputLink>
			</rich:column>

		</rich:dataTable>
		<rich:datascroller align="center" for="allBenifitActivity">
			<f:param name="status" value="#{param.status}" />
			<f:param name="cond" value="#{param.cond}" />
		</rich:datascroller>
		<rich:spacer />
	</h:form>

	<rich:spacer height="10"></rich:spacer>
	<br />
	<h:outputText value="#{newsBean.errormsg}" id="errorinfo"></h:outputText>
	<br />
	<h:messages></h:messages>
	<br />
	<h:outputLink value="http://localhost/cq/home/admincp.php?ac=event">活动管理</h:outputLink><br/>
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>