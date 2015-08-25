<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
				<li><h:outputLink value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="group_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:when test="${not empty sessionScope.zoyiUser}">
				<li><h:outputLink value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:otherwise>
				<li><h:outputLink value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_login.php">我的公益</h:outputLink></li>
			</c:otherwise>
		</c:choose>
		<li><h:outputLink value="user_group_activity_list.php">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php" >公益新闻库</h:outputLink></li>
		<li style="width: 200px"></li>
		<li class="assistnav"><h:outputLink value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：用户注册</div>

	<h:form id="userRegisterForm">
		<table width="900" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="400" align="center" valign="top" id="registertd">
				<div id="panel"><span>邮<img src="images/1.gif"
					width="28" />箱：<a4j:region selfRendered="true">
					<h:inputText id="email" value="#{userinfo.email }"
						styleClass="login" required="true">
						<a4j:support event="onblur" reRender="errorinfo,emailAjax,email"
							action="#{emailValidator.processAjax}" />
						<f:validator validatorId="validator_email" />
					</h:inputText>
					<h:outputText id="emailAjax"
						value="#{emailValidator.errorMessage }" />
				</a4j:region></span><br />
				<span> 用户名：<img src="images/1.gif" width="14" /><h:inputText id="username"
					value="#{userinfo.username }" styleClass="login" required="true" />
				</span><br />
				<span> <a4j:region selfRendered="true">
				真实姓名：<h:inputText id="name" value="#{userinfo.name }"
						styleClass="login" required="true">
						<f:validateLength maximum="10" minimum="2" />
					</h:inputText>
				</a4j:region></span><br />
				<span>密<img src="images/1.gif" width="28" />码：<h:inputSecret
					id="pwd" value="#{userinfo.pwd}" styleClass="login" required="true" />
				</span><br />
				<span> 确认密码：<h:inputSecret id="pwd2"
					value="#{usermodelbean.pwd2 }" styleClass="login" required="true" />
				</span><br />
				<span> 验证码：<img src="images/1.gif" width="13" /><h:inputText
					styleClass="login" maxlength="4" size="4" id="txtCode"
					value="#{usermodelbean.txtCode}" required="true" /> </span><br />
				<div><a4j:outputPanel id="detail_media">
					<a4j:commandLink reRender="detail_media" ajaxSingle="true">点击图片刷新
						<a4j:mediaOutput element="img" cacheable="false" session="false"
							rendered="true" createContent="#{validateCodeImageData.paint}"
							value="#{validateCodeImageData}" mimeType="image/jpeg" />
					</a4j:commandLink>
				</a4j:outputPanel></div>
				<span><h:commandButton styleClass="btn"
					image="images/zhuce.gif" id="userRegisterCommand" type="submit"
					value="登录" action="#{usermodelbean.register }" /> <h:commandButton
					id="userResetCommand" image="images/chongzhi.gif" styleClass="btn"
					type="reset" value="重置" /></span></div>
				</td>
				<td width="450" valign="top"><img
					src="images/loginrightpic.jpg" /></td>
			</tr>
			<tr>
				<td><h:outputText value="#{usermodelbean.errormsg }" class="errorinfo" id="errorinfo"></h:outputText> <h:messages style="errorinfo" /></td>
			</tr>
		</table>
	</h:form>
	<div id="hr">
	<hr />
	</div>
	<div id="footer">
	<div><h:outputLink value="#">联系我们</h:outputLink> | <h:outputLink value="#">关于我们</h:outputLink> | <h:outputLink value="#">网站地图</h:outputLink>
	| <h:outputLink value="#">友情连接</h:outputLink> | <h:outputLink value="#">网站律师</h:outputLink></div>
	<div>CopyRight 2003 © 东华大学旭日工商管理学院 版权所有</div>
	<div>地址：上海市延安西路1882号 邮编：200051</div>
	</div>
</f:view>
</body>
</html>