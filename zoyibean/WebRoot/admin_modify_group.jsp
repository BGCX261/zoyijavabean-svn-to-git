<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改组织</title>
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
	<h1 align="center">修改组织</h1>
	<h:form id="modifygroupForm">
		<table align="center">
			<tr>
				<td><h:outputLabel value="组织名：" /><h:inputText
					value="#{groupBean.group.groupName}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="组织性质：" /><h:inputText
					value="#{groupBean.group.nature}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="电话：" /><h:inputText
					value="#{groupBean.group.phone}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="省份：" /><h:inputText
					value="#{groupBean.group.groupName}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="城市：" /><h:inputText
					value="#{groupBean.group.birthCity}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="规模：" /><h:inputText
					value="#{groupBean.group.birthProvince }" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="地址：" /><h:inputText
					value="#{groupBean.group.address }" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="Email：" /><h:inputText
					value="#{groupBean.group.email}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="组织网站：" /><h:inputText
					value="#{groupBean.group.index}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="logo：" /><h:inputText
					value="#{groupBean.group.logoPicture}" id="logoPicture" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="首页图片：" /><h:inputText
					value="#{groupBean.group.adPicture}" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="未来展望：" /> <FCK:editor
					instanceName="future" width="500" height="500">
					<jsp:attribute name="value">
			<c:out value="${groupBean.group.future}" escapeXml="false"/>
		</jsp:attribute>
					<jsp:body>
			<FCK:config />
		</jsp:body>
				</FCK:editor></td>
			</tr>
			<tr>
				<td><h:commandButton action="#{groupBean.modify }" value="修改"
					type="submit" /><h:commandButton type="reset" value="重置" /></td>
			</tr>
			<tr>
				<td><h:outputText value="#{groupBean.errormsg}" id="errorinfo"/> &nbsp; <h:messages/></td>
			</tr>
		</table>
		<h:inputHidden value="#{groupBean.group.id}"></h:inputHidden>
	</h:form>
	<h:form id="uploadPicture">
		<table>
			<tr>
				<td><a4j:region>
					<rich:fileUpload fileUploadListener="#{groupBean.uploadListener}"
						maxFilesQuantity="5" autoclear="false" addControlLabel="添加图片"
						uploadControlLabel="上传" clearAllControlLabel="清除所有"
						clearControlLabel="清除" cancelEntryControlLabel="取消"
						stopControlLabel="停止" stopEntryControlLabel="停止"
						noDuplicate="true" id="upload" listHeight="100" ajaxSingle="true"
						acceptedTypes="jpg, gif, png, bmp,jpeg "
						transferErrorLabel="传输出错--文件过大或名称错误！">
						<a4j:support event="onuploadcomplete" reRender="picture,errorinfo" />
					</rich:fileUpload>
				</a4j:region></td>
			</tr>
			<a4j:outputPanel id="picture">
				<tr>
					<td><h:outputLabel for="groupPicture" value="请复制链接"
						rendered="#{not empty groupBean.picture}" /> <h:outputText
						id="groupPicture" value="#{groupBean.picture }" /></td>
				</tr>
				<tr>
					<td><h:graphicImage value="#{groupBean.picture }" /></td>
				</tr>
			</a4j:outputPanel>
		</table>
	</h:form>
</f:view>
</body>
</html>