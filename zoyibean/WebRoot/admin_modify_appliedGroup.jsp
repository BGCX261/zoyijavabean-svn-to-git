<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改组织申请</title>
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
	<h1 align="center">修改组织申请</h1>
	<h:form id="modifyappliedGroupForm">
		<table align="center">
			<tr>
				<td><h:outputLabel value="组织名：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.groupName}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="密码：" /><h:inputSecret
					value="#{appliedGroupBean.appliedGroup.pwd}" redisplay="true" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="组织性质：" /> <h:selectOneMenu
					id="newsCategory"
					value="#{appliedGroupBean.appliedGroup.groupCategory.id }"
					required="true" requiredMessage="必须设置组织分类！">
					<f:selectItem itemValue="0" itemLabel="组织分类" itemDisabled="true" />
					<f:selectItems value="#{groupBean.allGroupCategory}" />
				</h:selectOneMenu></td>
			</tr>
			<tr>
				<td><h:outputLabel value="电话：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.phone}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="省份：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.birthProvince}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="城市：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.birthCity}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="用户名：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.linkman }" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="地址：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.address }" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="Email：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.email}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="状态：" /><h:inputText
					value="#{appliedGroupBean.appliedGroup.applyStatus}" /></td>
			</tr>
			<tr>
				<td><h:commandButton action="#{appliedGroupBean.modify }"
					value="修改" type="submit" /><h:commandButton type="reset"
					value="重置" /></td>
			</tr>
		</table>
		<h:inputHidden value="#{appliedGroupBean.appliedGroup.applyDate}"
			converter="javax.faces.DateTime" />
		<h:inputHidden value="#{appliedGroupBean.appliedGroup.id}" />
	</h:form>

	<rich:spacer />

	<h:outputText value="#{appliedGroupBean.errormsg}" id="errorinfo" />
	<br />&nbsp; <h:messages />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>