<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!-- richfaces -->
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!-- FCKeditor -->
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改新闻</title>
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
	<h:form id="modifyNews">
		<h:inputHidden value="#{newsBean.news.innerId}" required="true" />
		<h:inputHidden value="#{newsBean.news.clickCount}" />

		<table align="center">
			<tr>
				<th><h:inputHidden id="publisherId" required="true"
					value="#{newsBean.news.publisherId}" />修改新闻</th>
			</tr>
			<tr>
				<td><h:outputLabel for="title" value="新闻标题：" /> <h:inputText
					id="title" value="#{newsBean.news.title}" maxlength="100"
					requiredMessage="请输入新闻标题！" /></td>
			</tr>
			<tr>
				<td><a4j:outputPanel id="newsCategoryAll">
					<h:outputLabel for="newsCategory" value="新闻分类：" />
					<h:selectOneMenu id="newsCategory"
						value="#{newsBean.news.newsCategory.id }" required="true"
						requiredMessage="必须设置新闻分类！">
						<f:selectItem itemValue="0" itemLabel="新闻分类" escape="false"/>
						<f:selectItems value="#{newsBean.allNewsCategory}" />
					</h:selectOneMenu>
				</a4j:outputPanel>&nbsp; <h:outputLink value="admin_manage_newsCategory.php">&nbsp;新增新闻分类</h:outputLink></td>
			</tr>
			<tr valign="top">
				<td align="center" width="500" height="600"><h:outputLabel
					value="新闻内容:" /> <FCK:editor instanceName="content" height="600"
					inputName="content">
					<jsp:attribute name="value">
						<c:out value="${newsBean.news.content}" escapeXml="false"></c:out>
						</jsp:attribute>
					<jsp:body>
					<FCK:config />
				</jsp:body>
				</FCK:editor></td>
			</tr>
			<rich:panel id="keyword">
				<tr>
					<td><h:outputLabel for="keyword" value="keyword:" /></td>
				</tr>
				<tr>
					<td><h:inputText value="#{newsBean.news.keyword1}"
						id="keyword1" required="true" size="10"
						requiredMessage="至少要填写第一个关键字" maxlength="10" /><h:inputText
						value="#{newsBean.news.keyword2}" id="keyword2" size="10"
						maxlength="10" /><br />
					<h:inputText value="#{newsBean.news.keyword3}" id="keyword3"
						size="10" maxlength="10" /><h:inputText
						value="#{newsBean.news.keyword4}" id="keyword4" size="10"
						maxlength="10" /><br />
					<h:inputText value="#{newsBean.news.keyword5}" id="keyword5"
						size="10" maxlength="10" /> <h:inputText
						value="#{newsBean.news.keyword6}" id="keyword6" size="10"
						maxlength="10" /><br />
					</td>
				</tr>
			</rich:panel>
			<tr>
				<td><h:outputLabel value="图片链接" /> <h:inputText
					value="#{newsBean.news.picture }" id="picture" /><br />
				<h:outputLabel value="如果需要焦点图片，请先上传" /> <a4j:region>
					<rich:fileUpload fileUploadListener="#{newsBean.uploadListener}"
						maxFilesQuantity="5" autoclear="false" addControlLabel="添加图片"
						uploadControlLabel="上传" clearAllControlLabel="清除所有"
						clearControlLabel="清除" cancelEntryControlLabel="取消"
						stopControlLabel="停止" stopEntryControlLabel="停止"
						noDuplicate="true" id="upload" listHeight="100" ajaxSingle="true"
						acceptedTypes="jpg, gif, png, bmp"
						transferErrorLabel="传输出错--文件过大或名称错误！">
						<a4j:support event="onuploadcomplete"
							reRender="newsPicture,picture,errorinfo" />
					</rich:fileUpload>
				</a4j:region> <h:graphicImage width="350" height="260"
					value="#{newsBean.news.picture }" id="newsPicture"
					style=" height : 298px;" /></td>
			</tr>
			<tr>
				<td><h:outputLabel value="备注：" for="remark" /> <h:inputText
					id="remark" value="#{newsBean.news.remark}" maxlength="255"/></td>
			</tr>
			<tr>
				<td><h:commandButton id="submit_modify_news"
					action="#{newsBean.modify}" type="submit" value="提交" /><h:commandButton
					id="reset_modify_news" type="reset" value="重置" /></td>
			</tr>
			<tr>
				<td><h:outputText value="#{newsBean.errormsg}" id="errorinfo"></h:outputText>
				<h:messages /></td>
			</tr>
		</table>
	</h:form>
	<rich:spacer height="20" />
	<h:outputLink value="admin_manage.php">新闻管理</h:outputLink>
	<br />
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>