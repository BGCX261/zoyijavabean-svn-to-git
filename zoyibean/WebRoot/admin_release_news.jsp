<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!-- richfaces -->
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!-- FCKeditor -->
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin新增新闻</title>
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
	<h:form id="releaseNews">
	
		<table align="center">
			<tr>
				<th><h:outputLabel value="发布新闻" /></th>
			</tr>
			
			<tr>
				<td><h:outputLabel for="title" value="新闻标题：" /> <h:inputText
					id="title" value="#{newsBean.news.title}" required="true"
					maxlength="100" requiredMessage="请输入新闻标题！" /></td>
			</tr>
			<tr>
				<td><a4j:outputPanel id="newsCategoryAll">
					<h:outputLabel for="newsCategory" value="新闻分类：" />
					<h:selectOneMenu id="newsCategory" required="true" 
						requiredMessage="必须设置新闻分类！"
						value="#{newsBean.news.newsCategory.id }">
						<f:selectItem itemValue="0" itemLabel="新闻分类" itemDisabled="true"/>
						<f:selectItems value="#{newsBean.allNewsCategory}" />
					</h:selectOneMenu>
				</a4j:outputPanel>&nbsp; <h:outputLink value="admin_manage_newsCategory.php">&nbsp;新增新闻分类</h:outputLink>
				</td>
			</tr>
			<tr valign="top">
				<td align="center" width="500" height="600"><h:outputLabel
					value="新闻内容" /> <FCK:editor instanceName="content" height="600"
					inputName="content">
					<jsp:attribute name="value">
						${param.content }
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
						id="keyword1" required="true" requiredMessage="必须输入一个关键字"
						size="10" maxlength="10" />&nbsp;<h:inputText
						value="#{newsBean.news.keyword2}" id="keyword2" size="10"
						maxlength="10" /><br />
					<h:inputText value="#{newsBean.news.keyword3}" id="keyword3"
						size="10" maxlength="10" />&nbsp;<h:inputText
						value="#{newsBean.news.keyword4}" id="keyword4" size="10"
						maxlength="10" /><br />
					<h:inputText value="#{newsBean.news.keyword5}" id="keyword5"
						size="10" maxlength="10" />&nbsp;<h:inputText
						value="#{newsBean.news.keyword6}" id="keyword6" size="10"
						maxlength="10" /><br />
					</td>
				</tr>
			</rich:panel>

			<tr>
				<td><h:outputLabel value="如果需要焦点图片，请先上传" /> <a4j:region>
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
				</a4j:region> <h:outputLabel value="图片链接:" for="picture" /> <h:inputText
					value="#{newsBean.news.picture }" id="picture" size="50" /> <br />
				<h:graphicImage width="350" height="260" value="#{newsBean.news.picture }" id="newsPicture" />
				</td>
			</tr>
			<tr>
				<td><h:commandButton id="submit_release_news"
					action="#{newsBean.add}" type="submit" value="提交" />&nbsp;&nbsp;&nbsp;<h:commandButton
					id="reset_release_news" type="reset" value="重置" /></td>
			</tr>
			<tr>
				<td><h:outputText value="#{newsBean.errormsg}" id="errorinfo" />
				<h:messages /></td>
			</tr>
		</table>
	</h:form><br/>
	<h:outputLink value="admin_manage_news.php">新闻管理页面</h:outputLink><br/>
	<h:outputLink value="admin_manage_newsCategory.php">新闻分类管理页面</h:outputLink><br/>
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink>
</f:view>
</body>
</html>