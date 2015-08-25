<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
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
		<li><h:outputLink style="current" value="news_list.php">公益新闻库</h:outputLink></li>
		<li style="width: 200px"></li>
		<li class="assistnav"><h:outputLink value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：首页 -&gt; 新闻</div>
	<table width="960" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="2" valign="top"><img src="images/gongyiads.png"
				width="960" height="91" /></td>
		</tr>
		<tr>
			<td width="730" valign="top">
			<div id="newscon_bg">
			<div id="newstitle"><h:outputText
				value="#{newsBean.news.title}" /></div>
			<div id="newstime"><span><h:outputText
				value="#{newsBean.news.releasetime}" >
					<f:convertDateTime pattern="yyyy年MM月dd日  HH:mm:ss"/>
				</h:outputText> </span><span><h:outputText
				value="#{newsBean.news.publisherId}" /></span></div>
			<div id="newscon"><h:outputText
				value="#{newsBean.news.content}" escape="false"/></div>
			</div>
			</td>
			<td width="230" valign="top">
			<div id="guanzhu">
			<div class="newscon_title">新闻分类</div>
			<p style="text-align:left;"><h:form>
				<c:forEach items="#{newsCategoryBean.allNewsCategory }"
					var="newsCategory" varStatus="sta">
					<h:outputLink target="_self"
						value="news_list.php">
						<f:param name="ncid" value="#{newsCategory.id}" />
						<h:outputText value="#{newsCategory.newsCategoryName }" />
						<c:if test="${sta.count%2 == 0}"><br/></c:if>
					</h:outputLink>
				</c:forEach>
			</h:form></p>
			</div>
			<div id="newstop">
			<div class="newscon_title">新闻点击榜</div>
			<ul>
				<c:forEach items="#{indexBean.softNews}" var="softNews">
					<li> <h:commandLink
						target="_blank" action="#{newsBean.queryById}">
						<f:param name="nid" value="#{softNews.innerId}"></f:param><c:out value="${softNews.title}" /></h:commandLink></li>
				</c:forEach>
			</ul>
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