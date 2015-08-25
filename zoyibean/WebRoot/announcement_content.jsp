<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>众益网</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/second.css" />
<link rel="stylesheet" type="text/css" href="css/edit.css" />
</head>
<style type="text/css">
<!--
#login {
	margin-top: 10px
}
//-->
</style>
<body>
<f:view>
	<div id="logo"><img src="images/logo.gif" /><img
		src="images/banner.png" /></div>
	<ul id="menu">
		<li><h:outputLink value="index.php">首页</h:outputLink></li>
		<c:choose>
			<c:when test="${not empty sessionScope.zoyiGroup}">
				<li><h:outputLink value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="group_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:otherwise>
				<li><h:outputLink value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_self_index.php">我的公益</h:outputLink></li>
			</c:otherwise>
		</c:choose>
		<li><h:outputLink value="#">公益活动库</h:outputLink></li>
		<li><a class="current" href="#">公益新闻库</a></li>
		<li style="width: 200px">&nbsp;</li>
		<li class="assistnav"><h:outputLink value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：首页 -&gt;公告</div>
	<table width="960" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="2" valign="top"><img src="images/gongyiads.png"
				width="960" height="91" /></td>
		</tr>
		<tr>
			<td width="730" valign="top">
			<div id="newscon_bg">
			<div id="newstitle"><h:outputText
				value="#{announcementBean.announcement.title}" /></div>
			<div id="newstime"><span> <h:outputLabel value="发布时间："
				for="createDate" /> <h:outputText
				value="#{announcementBean.announcement.createDate}" id="createDate">
				<f:convertDateTime pattern="yyyy年MM月dd HH:mm:ss" />
			</h:outputText> </span><span><h:outputLabel value="发布者：" for="announcer" /><h:outputText
				value="#{announcementBean.announcement.announcer}" id="announcer" /></span></div>
			<div id="newscon"><h:outputText escape="false"
				value="#{announcementBean.announcement.content}" /></div>
			</div>
			</td>
			<td width="230" valign="top"><c:choose>
				<c:when test="${empty sessionScope.zoyiIdentity}">
					<h:form id="userLoginForm">
						<div id="login">
						<div id="logintd"><a href="http://localhost/cq/home/"><img
							src="images/yonghudenglu.gif" /></a> <a
							href="http://localhost/cq/home/do.php?ac=39ea7e5632f8aac51e5c8a99eb13899e"><img
							src="images/yonghuzhuce.gif" /></a><br />
						<a href="http://localhost/cq/home/"><img
							src="images/zuzhidenglu.gif" /></a> <a href="group_apply.php"><img
							src="images/zuzhizhuce.gif" /></a><br />
						</div>
						<div><img src="images/hr.jpg" /></div>
						<div id="login_con">
						<p>登陆后，您可以：</p>
						<p>· 查看您的公益成长动态</p>
						<p>· 查看您的月捐记录</p>
						<p>· 查看您的志愿者活动记录</p>
						</div>
						</div>
					</h:form>
				</c:when>
				<c:otherwise>
					<div id="login">
					<div id="welcome">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>欢迎来到大众公益网！</p>
					<p>让我们携手</p>
					<p>为公益事业贡献力量！</p>
					</div>
					<div id="user_info">
					<p>欢迎您，<c:out value="${sessionScope.zoyiUser.name }" /> ！</p>
					</div>
					<div id="exit"><h:outputLink value="logout.php">退出</h:outputLink></div>
					<div><img src="images/hr.jpg" /></div>
					<div id="login_con">
					<p>现在，您可以：</p>
					<p>· 查看您的公益成长动态</p>
					<p>· 查看您的月捐记录</p>
					<p>· 查看您的志愿者活动记录</p>
					</div>
					</div>
				</c:otherwise>
			</c:choose>
			<div id="annoucement">
			<div id="annouce_bg"><h:outputLink value="announcement_list.php" target="_blank"> 更多&gt;&gt;</h:outputLink></div>
			<table width="230" border="0" cellspacing="5" cellpadding="0">
				<tr>
					<td>
					<div class="annouce_con">
					<ul>
						<h:form>
							<c:forEach items="#{indexBean.newAnnouncement}"
								var="newAnnouncement">
								<li><h:outputLink target="_blank"
						value="announcement_content.php">
									<f:param name="aid" value="#{newAnnouncement.id}" />
									<h:outputText value="#{newAnnouncement.title }" />
								</h:outputLink></li>
							</c:forEach>
						</h:form>
					</ul>
					</div>
					</td>
				</tr>
			</table>
			</div>
			<div><img src="images/gongyitieshi.gif" /></div>
			</td>
		</tr>
		<tr>
			<td colspan="2"><img src="images/ad3.png" /></td>
		</tr>
	</table>
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