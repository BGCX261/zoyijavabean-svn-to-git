<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增组织</title>
</head>
<body>
<f:view>
	<h1 align="center">新增组织</h1>
	<h:form id="addGroupForm">
		<table align="center">
			<tr>
				<td><h:outputLabel for="groupName" value="组织名：" /><h:inputText
					id="groupName" value="#{group.groupName}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="pwd" value="登录密码：" /><h:inputSecret
					id="pwd" value="#{group.pwd}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="nature" value="组织性质：" /><h:inputText
					id="nature" value="#{group.nature}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="phone" value="电话：" /><h:inputText
					id="phone" value="#{group.phone}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="birthProvince" value="省份：" /><h:inputText
					id="birthProvince" value="#{group.birthProvince}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="birthCity" value="城市：" /><h:inputText
					id="birthCity" value="#{group.birthCity}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="scale" value="规模：" /><h:inputText
					id="scale" value="#{group.scale }" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="address" value="地址：" /><h:inputText
					id="address" value="#{group.address }" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="email" value="Email：" /><h:inputText
					id="email" value="#{group.email}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="logoPicture" value="Logo：" /><h:inputText
					id="logoPicture" value="#{group.logoPicture}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel for="adPicture" value="首页图片：" /><h:inputText
					id="adPicture" value="#{group.adPicture}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="未来展望：" /> <FCK:editor
					instanceName="future" toolbarSet="Basic">
					<jsp:attribute name="value">
			<h:outputText value="#{param.future}" />
		</jsp:attribute>
					<jsp:body>
			<FCK:config />
		</jsp:body>
				</FCK:editor></td>
			</tr>
			<tr>
				<td><h:outputLabel value="备注：" for="remark" /> <h:inputTextarea
					id="remark" value="#{group.remark}"></h:inputTextarea></td>
			</tr>
			<tr>
				<td><h:commandButton action="#{groupBean.add }" value="新增"
					type="submit" /><h:commandButton type="reset" value="重置" /></td>
			</tr>
			<tr>
				<td><h:outputText value="#{groupBean.errormsg}" id="errorinfo"/> &nbsp; <h:messages/></td>
			</tr>
		</table>
	</h:form>
	<rich:spacer height="20" />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>