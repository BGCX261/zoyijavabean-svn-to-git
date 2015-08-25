<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>众益网</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/edit.css" />
</head>

<body>
<f:view>
	<div id="logo"><img src="images/logo.gif" /><img
		src="images/banner.png" /></div>
	<ul id="menu">
		<li><a class="current" href="index.php">首页</a></li>
		<c:choose>
			<c:when test="${not empty sessionScope.zoyiGroup}">
				<li><h:outputLink
					value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="group_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:otherwise>
				<li><h:outputLink
					value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_self_index.php">我的公益</h:outputLink></li>
			</c:otherwise>
		</c:choose>
		<li><h:outputLink value="#">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php">公益新闻库</h:outputLink></li>
		<li style="width: 200px">&nbsp;</li>
		<li class="assistnav"><h:outputLink
			value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：登陆</div>
	<table width="900" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="400" align="center" valign="top" id="applytd">
			<div id="panel" style="width: 250px"><h:form
				id="applygroupForm">
				<span><h:outputLabel value="组织名：" /><h:inputText
					value="#{appliedGroup.groupName }" required="true" maxlength="64"
					requiredMessage=" 组织名不能为空 " /></span>
				<br />
				<span><h:outputLabel value="用户名：" /><h:inputText
					value="#{appliedGroup.linkman }" required="true" maxlength="15"
					requiredMessage=" 用户名不能为空 " /></span>
				<br />
				<span><h:outputLabel value="分类：" /><h:selectOneMenu
					id="newsCategory" value="#{appliedGroup.groupCategory.id }"
					required="true" requiredMessage="必须设置组织分类！">
					<f:selectItem itemValue="0" itemLabel="组织分类" itemDisabled="true"/>
					<f:selectItems value="#{groupBean.allGroupCategory}" />
				</h:selectOneMenu></span>
				<br />
				<span><h:outputLabel value="电话：" /><h:inputText
					value="#{appliedGroup.phone }" required="true" maxlength="15"
					requiredMessage=" 用户名不能为空 " /></span>
				<br />
				<span><h:outputLabel value="省份：" /><h:inputText
					value="#{appliedGroup.birthProvince }" /></span>
				<br />
				<span><h:outputLabel value="城市：" /><h:inputText
					value="#{appliedGroup.birthCity }" /></span>
				<br />
				<span><h:outputLabel value="地址：" /><h:inputText
					value="#{appliedGroup.address }" /></span>
				<br />
				<span><h:outputLabel value="Email：" /><h:inputText
					value="#{appliedGroup.email }" required="true" maxlength="100"
					requiredMessage=" 地址不能为空 " /></span>
				<br />
				<span><h:outputLabel value="密码：" /><h:inputSecret
					value="#{appliedGroup.pwd }" required="true" maxlength="41"
					requiredMessage=" 密码不能为空 " /></span>
				<br />
				<span><h:outputLabel value="验证码：" /><h:inputText
					value="#{appliedGroupBean.txtCode }" size="10" required="true"
					maxlength="4" requiredMessage=" 密码不能为空 " /> </span>
				<br />
				<span><a4j:outputPanel id="detail_media">
					<a4j:commandLink reRender="detail_media" ajaxSingle="true">点击图片刷新
						<a4j:mediaOutput element="img" cacheable="false" session="false"
							rendered="true" createContent="#{validateCodeImageData.paint}"
							value="#{validateCodeImageData}" mimeType="image/jpeg" />
					</a4j:commandLink>
				</a4j:outputPanel></span>
				<br />
				<span><h:commandButton action="#{appliedGroupBean.apply }"
					image="images/zuzhizhuce.gif" value="申请" type="submit" /><h:commandButton
					image="images/chongzhi.gif" type="reset" value="重置" /> </span>
				<br />
			</h:form>
			<table width="160" border="0" cellpadding="5" cellspacing="0"
				class="errorinfo">
				<tr>
					<td><h:outputText value="#{appliedGroupBean.errormsg}"
						id="errorinfo"></h:outputText> <h:messages /></td>
				</tr>
			</table>
			</div>
			</td>
			<td width="500" valign="top"><img src="images/loginrightpic.jpg" /></td>
		</tr>
	</table>
	<div id="hr">
	<hr />
	</div>
	<div id="footer">
	<div><h:outputLink value="#">联系我们</h:outputLink> | <h:outputLink
		value="#">关于我们</h:outputLink> | <h:outputLink value="#">网站地图</h:outputLink>
	| <h:outputLink value="#">友情连接</h:outputLink> | <h:outputLink value="#">网站律师</h:outputLink></div>
	<div>CopyRight 2003 © 东华大学旭日工商管理学院 版权所有</div>
	<div>地址：上海市延安西路1882号 邮编：200051</div>
	</div>
</f:view>
</body>
</html>