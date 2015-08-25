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
<title>新闻分类管理</title>
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
<h1 align="center">新闻分类管理</h1>
	<h:form>
		<a4j:outputPanel id="newsCategoryAll">
			<rich:dataTable border="0" align="center"
				value="#{newsCategoryBean.allNewsCategory }" var="all">
				<rich:column>
					<f:facet name="header">
						<h:outputText value="分类号" />
					</f:facet>
					<h:outputText value="#{all.id }" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="分类名字" />
					</f:facet>
					<h:outputText value="#{all.newsCategoryName}" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="创建时间" />
					</f:facet>
					<h:outputText value="#{all.createDate}">
						<f:convertDateTime pattern="yyyy-MM-dd HH:mm" />
					</h:outputText>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="备注" />
					</f:facet>
					<h:outputText value="#{all.remark}" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="编辑" />
					</f:facet>
					<a4j:commandLink ajaxSingle="true"
						onclick="javascript:Richfaces.showModalPanel('modifyNewsCategoryShow',{width:200,top:200});"
						id="modifyNewsCategory" reRender="mncid">
						<f:param name="ncid" value="#{all.id}" />编辑</a4j:commandLink>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="删除" />
					</f:facet>
					<a4j:commandLink ajaxSingle="true"
						onclick="javascript:Richfaces.showModalPanel('deletenewsCategoryShow',{width:200,top:200});"
						id="deleteNewsCategory" reRender="ncid">
						<f:param name="ncid" value="#{all.id}" />删除</a4j:commandLink>
				</rich:column>
			</rich:dataTable>
		</a4j:outputPanel>
	</h:form>
	
	<rich:spacer height="20"/>
	
<div align="center" style="text-align:center;">
	<a4j:outputPanel>
		<h:form id="addNewsCategoryForm">
			<h:outputLabel for="newsCategoryName" value="新增新闻分类:" />
			<h:inputText id="newsCategoryName"
				value="#{newsCategory.newsCategoryName}" required="true"
				requiredMessage="需要输入分类名！" />
			<a4j:commandButton value="新增"
				actionListener="#{newsCategoryBean.ajaxAdd}" reRender="newsCategoryAll,errorinfo"/>
			<h:commandButton type="reset" value="重置" />
		</h:form>
	</a4j:outputPanel>
</div>

	<rich:modalPanel height="150" id="deletenewsCategoryShow"
		resizeable="false" width="200" zindex="1000">
		<h:form id="deletenewsCategoryForm">
			<a4j:region>
				<h:outputText value="确定删除相关分类吗？此操作不能恢复。" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('deletenewsCategoryShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="ncid">
					<h:outputText value="#{param.ncid}" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deletenewsCategoryShow')"
						actionListener="#{newsCategoryBean.ajaxDelete}" ajaxSingle="true"
						reRender="newsCategoryAll,errorinfo">
						<f:param name="ncid" value="#{param.ncid}" />确定删除
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('deletenewsCategoryShow')"
						value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>

	<rich:modalPanel height="150" id="modifyNewsCategoryShow"
		resizeable="false" width="200" zindex="1000">
		<h:form id="modifyNewsCategoryForm">
			<a4j:region>
				<h:outputText value="请输入新名字" />
				<f:facet name="controls">
					<h:outputLink
						value="javascript:Richfaces.hideModalPanel('modifyNewsCategoryShow')">close</h:outputLink>
				</f:facet>
				<rich:panel id="mncid">
					<h:outputText value="#{param.ncid}" />
					<br />
					<h:inputText value="#{newsCategory.newsCategoryName}"
						id="newsCategoryName" />
					<br />
					<a4j:commandLink
						onclick="Richfaces.hideModalPanel('modifyNewsCategoryShow')"
						actionListener="#{newsCategoryBean.ajaxModify }"
						reRender="newsCategoryAll,errorinfo">
						<f:param name="ncid" value="#{param.ncid}" />确定更改
					</a4j:commandLink>
						&nbsp;&nbsp;&nbsp;&nbsp;<a4j:commandLink
						onclick="Richfaces.hideModalPanel('modifyNewsCategoryShow')"
						value="取消" />
				</rich:panel>
			</a4j:region>
		</h:form>
	</rich:modalPanel>
	<h:messages /><br/>
	<h:outputText value="#{newsBean.errormsg}" id="errorinfo"></h:outputText><br/>
	<h:outputLink value="admin_manage.php">管理首页</h:outputLink><br/>
	<h:outputLink value="admin_release_news.php">继续新增新闻</h:outputLink>
</f:view>
</body>
</html>