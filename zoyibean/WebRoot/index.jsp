<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
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
<link rel="stylesheet" type="text/css" href="css/photos.css" />
</head>

<body>
<f:view>
	<div id="logo"><img src="images/logo.gif" /><img
		src="images/banner.png" /></div>
	<ul id="menu">
		<li><a class="current" href="#">首页</a></li>
		<c:choose>
			<c:when test="${not empty sessionScope.zoyiGroup}">
				<li><h:outputLink
					value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="group_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:when test="${not empty sessionScope.zoyiUser}">
				<li><h:outputLink
					value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_self_index.php">我的公益</h:outputLink></li>
			</c:when>
			<c:otherwise>
				<li><h:outputLink
					value="http://localhost/cq/home/space.php?uid=#{sessionScope.zoyiId}">我的主页</h:outputLink></li>
				<li><h:outputLink value="user_login.php">我的公益</h:outputLink></li>
			</c:otherwise>
		</c:choose>
		<li><h:outputLink value="user_group_activity_list.php">公益活动库</h:outputLink></li>
		<li><h:outputLink value="news_list.php">公益新闻库</h:outputLink></li>
		<li style="width: 200px">&nbsp;</li>
		<li class="assistnav"><h:outputLink
			value="http://localhost/cq/home/index.php">社区</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">帮助</h:outputLink></li>
		<li class="assistnav"><h:outputLink value="#">高级搜索</h:outputLink></li>
	</ul>
	<div class="location">您的位置：首页</div>
	<table width="980" border="0" cellspacing="0" cellpadding="0">
		<tr>

			<td width="770">
			<div id="photos">
			<div id="ifocus2">
			<div id="ifocus2_btn"><h:form id="AllBenifitActivity">
				<ul>
					<li class="current"><h:commandLink
						action="#{benifitActivityBean.queryById}" target="_blank">
						<f:param name="baid" value="#{indexBean.allBenifitActivity[0].id}" />
						<h:graphicImage value="#{indexBean.allBenifitActivity[0].poster}"
							alt="点击查看详细" />
					</h:commandLink></li>
					<li class="normal"><h:commandLink
						action="#{benifitActivityBean.queryById}" target="_blank">
						<f:param name="baid" value="#{indexBean.allBenifitActivity[1].id}" />
						<h:graphicImage value="#{indexBean.allBenifitActivity[1].poster}"
							alt="点击查看详细" />
					</h:commandLink></li>
					<li class="normal"><h:commandLink
						action="#{benifitActivityBean.queryById}" target="_blank">
						<f:param name="baid" value="#{indexBean.allBenifitActivity[2].id}" />
						<h:graphicImage value="#{indexBean.allBenifitActivity[2].poster}"
							alt="点击查看详细" />
					</h:commandLink></li>
					<li class="normal"><h:commandLink
						action="#{benifitActivityBean.queryById}" target="_blank">
						<f:param name="baid" value="#{indexBean.allBenifitActivity[3].id}" />
						<h:graphicImage value="#{indexBean.allBenifitActivity[3].poster}"
							alt="点击查看详细" />
					</h:commandLink></li>
				</ul>
			</h:form></div>
			<div id="ifocus2_pic">
			<div id="ifocus2_piclist" style="left: 0; top: 0;">
			<ul>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
			</div>
			<div id="ifocus2_opdiv"></div>
			<div id="ifocus2_tx">
			<ul>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
			</div>
			</div>
			</div>
			<div id="ifocus">
			<div id="ifocus_pic">
			<div id="ifocus_piclist" style="left: 0; top: 0;">
			<ul>
				<h:form id="allNewsP">
					<li><h:commandLink action="#{newsBean.queryById}"
						target="_blank">
						<f:param name="nid" value="#{indexBean.focusNews[0].innerId}" />
						<h:graphicImage value="#{indexBean.focusNews[0].picture}"
							alt="点击查看详细" />
					</h:commandLink></li>
				</h:form>
				<h:form>
					<li><h:commandLink action="#{newsBean.queryById}"
						target="_blank">
						<f:param name="nid" value="#{indexBean.focusNews[1].innerId}" />
						<h:graphicImage value="#{indexBean.focusNews[1].picture}"
							alt="点击查看详细" />
					</h:commandLink></li>
				</h:form>
				<h:form>
					<li><h:commandLink action="#{newsBean.queryById}"
						target="_blank">
						<f:param name="nid" value="#{indexBean.focusNews[2].innerId}" />
						<h:graphicImage value="#{indexBean.focusNews[2].picture}"
							alt="点击查看详细" />
					</h:commandLink></li>
				</h:form>
				<h:form>
					<li><h:commandLink action="#{newsBean.queryById}"
						target="_blank">
						<f:param name="nid" value="#{indexBean.focusNews[3].innerId}" />
						<h:graphicImage value="#{indexBean.focusNews[3].picture}"
							alt="点击查看详细" />
					</h:commandLink></li>
				</h:form>
			</ul>
			</div>
			<div id="ifocus_opdiv"></div>
			<div id="ifocus_tx">
			<ul>
				<li class="current"><h:outputText
					value="#{indexBean.focusNews[0].title}" /></li>
				<li class="normal"><h:outputText
					value="#{indexBean.focusNews[1].title}" /></li>
				<li class="normal"><h:outputText
					value="#{indexBean.focusNews[2].title}" /></li>
				<li class="normal"><h:outputText
					value="#{indexBean.focusNews[3].title}" /></li>
			</ul>
			</div>
			</div>
			<div id="ifocus_btn">
			<ul>
				<li class="current"><h:graphicImage
					value="#{indexBean.focusNews[0].picture}"
					alt="#{indexBean.focusNews[0].title}" /></li>
				<li class="normal"><h:graphicImage
					value="#{indexBean.focusNews[1].picture}"
					alt="#{indexBean.focusNews[1].title}" /></li>
				<li class="normal"><h:graphicImage
					value="#{indexBean.focusNews[2].picture}"
					alt="#{indexBean.focusNews[2].title}" /></li>
				<li class="normal"><h:graphicImage
					value="#{indexBean.focusNews[3].picture}"
					alt="#{indexBean.focusNews[3].title}" /></li>
			</ul>
			</div>
			</div>
			</div>
			</td>
			<td width="230"><c:choose>
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
					<p>欢迎您 &nbsp;<c:out value="${sessionScope.zoyiGroup.groupName }" />
					<c:out value="${sessionScope.zoyiUser.name }" /> ！&nbsp;</p>
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
			</c:choose></td>
		</tr>
		<tr>
			<td width="770">
			<div id="guide"></div>
			</td>
			<td width="230">
			<div id="annoucement">
			<div id="annouce_bg"><h:outputLink
				value="announcement_list.php" target="_blank">更多&gt;&gt;</h:outputLink></div>
			<table width="230" border="0" cellspacing="5" cellpadding="0">
				<tr>
					<td>
					<div class="annouce_con">
					<ul>
						<c:forEach items="#{indexBean.newAnnouncement}" var="announcement">
							<li><h:outputLink target="_blank"
								value="announcement_content.php">
								<f:param name="aid" value="#{announcement.id}" />
								<h:outputText value="#{announcement.title }" />
							</h:outputLink></li>
						</c:forEach>
					</ul>
					</div>
					</td>
				</tr>
			</table>
			</div>
			</td>
		</tr>
		<tr>
			<td width="770">
			<div id="activity" style="text-align: left;">
			<div id="active_bg"></div>
			<div
				style="width: 500px; margin: 10px; line-height: 1.5em; text-align: left;"><h:form>
				<c:forEach items="#{indexBean.allBenifitActivity}"
					var="benifitActivity" varStatus="sta">
					<h:outputLink target="_blank" value="http://localhost/cq/home/space.php?do=event&id=#{benifitActivityBean.benifitActivity.id}">
						[<h:outputText
							value="#{benifitActivity.benifitActivityCategory.benifitActivityCategoryName }" />]
						<h:outputText value="#{benifitActivity.activityName }" />&nbsp;——&nbsp;<h:outputText
							value="#{benifitActivity.province }" />
						<h:outputText value="#{benifitActivity.city }" />
						<h:outputText value="#{benifitActivity.location }" />
					</h:outputLink>
					<br />
				</c:forEach>
			</h:form></div>
			</div>
			<div id="news">
			<div id="news_bg"></div>
			<div
				style="text-align: left; width: 700px; margin: 10px; line-height: 1.5em"><h:form>
				<c:forEach items="#{indexBean.newNews}" var="news">
					<h:commandLink target="_blank" action="#{newsBean.queryById}">
						<f:param name="nid" value="#{news.innerId}" />
				[<h:outputText value="#{news.newsCategory.newsCategoryName }" />]<h:outputText
							value="#{news.title}" />
					</h:commandLink>
					<br />
				</c:forEach>
			</h:form></div>
			</div>
			</td>
			<td width="230">
			<div id="earth">
			<p>已有<h:outputText value="#{indexBean.groupCount}" />公益组织入驻</p>
			<p>已有<h:outputText value="#{indexBean.userCount}" />益友入驻</p>
			</div>
			</td>
		</tr>
	</table>
	<table width="956" border="0" cellspacing="0" cellpadding="0">
		<h:form>
			<tr>
				<td>
				<div id="user_bg"><h:commandLink
					action="#{groupBean.queryById}" target="_blank">
					<f:param name="gid" value="#{indexBean.groupStar.id }" />
					<h:graphicImage style="margin:50px 15px" height="135" width="180"
						value="#{indexBean.groupStar.logoPicture }" />
				</h:commandLink> <h:commandLink target="_blank" action="#{groupBean.queryById}">
					<f:param name="gid" value="#{indexBean.newGroup.id }" />
					<h:graphicImage style="margin:50px 15px" height="135" width="180"
						value="#{indexBean.newGroup.logoPicture }" />
				</h:commandLink></div>
				</td>
				<td>
				<div id="organ_bg"><h:commandLink
					action="#{usermodelbean.queryById}" target="_blank">
					<f:param name="uid" value="#{indexBean.userStar.userId }" />
					<h:graphicImage style="margin:50px 15px" height="135" width="190"
						value="#{indexBean.userStar.picture }" />
				</h:commandLink> <h:commandLink target="_blank" action="#{usermodelbean.queryById}">
					<f:param name="uid" value="#{indexBean.newUser.userId }" />
					<h:graphicImage style="margin:50px 15px" height="135" width="190"
						value="#{indexBean.newUser.picture }" />
				</h:commandLink></div>
				</td>
			</tr>
		</h:form>
	</table>
	<div id="league">公益联盟</div>
	<div id="community">战略合作</div>
	<table width="960" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td><img src="images/link8.jpg" /></td>
			<td><img src="images/link9.jpg" /></td>
			<td><img src="images/link10.jpg" /></td>
			<td><img src="images/link11.jpg" /></td>
			<td><img src="images/link12.jpg" /></td>
			<td><img src="images/link13.jpg" /></td>
			<td><img src="images/link14.jpg" /></td>
		</tr>
	</table>
	<div id="league_con"><h:outputLink value="#">中华人民共和国民政部</h:outputLink>|
	<h:outputLink value="#">中华人民共和国环保部</h:outputLink>| <h:outputLink
		value="#">中华人民共和国水利部</h:outputLink>| <h:outputLink value="#">国家林业局</h:outputLink>|
	<h:outputLink value="#">国家文物局</h:outputLink>| <h:outputLink value="#">中国消防在线</h:outputLink>|
	<h:outputLink value="#">国家禁毒委员会办公室</h:outputLink>| <h:outputLink
		value="#">中国社会工作协会</h:outputLink></div>
	<div id="community">媒体合作</div>
	<table width="960" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td><img src="images/link1.jpg" /></td>
			<td><img src="images/link2.jpg" /></td>
			<td><img src="images/link3.jpg" /></td>
			<td><img src="images/link4.jpg" /></td>
			<td><img src="images/link5.jpg" /></td>
			<td><img src="images/link6.jpg" /></td>
			<td><img src="images/link7.jpg" /></td>
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
<script type="text/javascript">
<!--
function $(id) { return document.getElementById(id); }

function addLoadEvent(func){
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function(){
			oldonload();
			func();
		}
	}
}

function moveElement(elementID,final_x,final_y,interval) {
  if (!document.getElementById) return false;
  if (!document.getElementById(elementID)) return false;
  var elem = document.getElementById(elementID);
  if (elem.movement) {
    clearTimeout(elem.movement);
  }
  if (!elem.style.left) {
    elem.style.left = "0px";
  }
  if (!elem.style.top) {
    elem.style.top = "0px";
  }
  var xpos = parseInt(elem.style.left);
  var ypos = parseInt(elem.style.top);
  if (xpos == final_x && ypos == final_y) {
		return true;
  }
  if (xpos < final_x) {
    var dist = Math.ceil((final_x - xpos)/10);
    xpos = xpos + dist;
  }
  if (xpos > final_x) {
    var dist = Math.ceil((xpos - final_x)/10);
    xpos = xpos - dist;
  }
  if (ypos < final_y) {
    var dist = Math.ceil((final_y - ypos)/10);
    ypos = ypos + dist;
  }
  if (ypos > final_y) {
    var dist = Math.ceil((ypos - final_y)/10);
    ypos = ypos - dist;
  }
  elem.style.left = xpos + "px";
  elem.style.top = ypos + "px";
  var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  elem.movement = setTimeout(repeat,interval);
}

function classNormal(iFocusBtnID,iFocusTxID){
	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
	var iFocusTxs = $(iFocusTxID).getElementsByTagName('li');
	for(var i=0; i<iFocusBtns.length; i++) {
		iFocusBtns[i].className='normal';
		iFocusTxs[i].className='normal';
	}
}

function classCurrent(iFocusBtnID,iFocusTxID,n){
	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
	var iFocusTxs = $(iFocusTxID).getElementsByTagName('li');
	iFocusBtns[n].className='current';
	iFocusTxs[n].className='current';
}

function iFocusChange() {
	if(!$('ifocus')) return false;
	$('ifocus').onmouseover = function(){atuokey = true};
	$('ifocus').onmouseout = function(){atuokey = false};
	var iFocusBtns = $('ifocus_btn').getElementsByTagName('li');
	var listLength = iFocusBtns.length;
	iFocusBtns[0].onmouseover = function() {
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (listLength>=2) {
		iFocusBtns[1].onmouseover = function() {
			moveElement('ifocus_piclist',0,-225,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',1);
		}
	}
	if (listLength>=3) {
		iFocusBtns[2].onmouseover = function() {
			moveElement('ifocus_piclist',0,-450,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',2);
		}
	}
	if (listLength>=4) {
		iFocusBtns[3].onmouseover = function() {
			moveElement('ifocus_piclist',0,-675,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',3);
		}
	}
}

setInterval('autoiFocus()',5000);
var atuokey = false;
function autoiFocus() {
	if(!$('ifocus')) return false;
	if(atuokey) return false;
	var focusBtnList = $('ifocus_btn').getElementsByTagName('li');
	var listLength = focusBtnList.length;
	for(var i=0; i<listLength; i++) {
		if (focusBtnList[i].className == 'current') var currentNum = i;
	}
	if (currentNum==0&&listLength!=1 ){
		moveElement('ifocus_piclist',0,-225,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',1);
	}
	if (currentNum==1&&listLength!=2 ){
		moveElement('ifocus_piclist',0,-450,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',2);
	}
	if (currentNum==2&&listLength!=3 ){
		moveElement('ifocus_piclist',0,-675,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',3);
	}
	if (currentNum==3 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (currentNum==1&&listLength==2 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (currentNum==2&&listLength==3 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
}
addLoadEvent(iFocusChange);
//-->
</script>
<script type="text/javascript">
<!--
function $(id) { return document.getElementById(id); }

function addLoadEvent(func){
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function(){
			oldonload();
			func();
		}
	}
}

function moveElement(elementID,final_x,final_y,interval) {
  if (!document.getElementById) return false;
  if (!document.getElementById(elementID)) return false;
  var elem = document.getElementById(elementID);
  if (elem.movement) {
    clearTimeout(elem.movement);
  }
  if (!elem.style.left) {
    elem.style.left = "0px";
  }
  if (!elem.style.top) {
    elem.style.top = "0px";
  }
  var xpos = parseInt(elem.style.left);
  var ypos = parseInt(elem.style.top);
  if (xpos == final_x && ypos == final_y) {
		return true;
  }
  if (xpos < final_x) {
    var dist = Math.ceil((final_x - xpos)/10);
    xpos = xpos + dist;
  }
  if (xpos > final_x) {
    var dist = Math.ceil((xpos - final_x)/10);
    xpos = xpos - dist;
  }
  if (ypos < final_y) {
    var dist = Math.ceil((final_y - ypos)/10);
    ypos = ypos + dist;
  }
  if (ypos > final_y) {
    var dist = Math.ceil((ypos - final_y)/10);
    ypos = ypos - dist;
  }
  elem.style.left = xpos + "px";
  elem.style.top = ypos + "px";
  var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  elem.movement = setTimeout(repeat,interval);
}

function classNormal(ifocus2BtnID,ifocus2TxID){
	var ifocus2Btns= $(ifocus2BtnID).getElementsByTagName('li');
	var ifocus2Txs = $(ifocus2TxID).getElementsByTagName('li');
	for(var i=0; i<ifocus2Btns.length; i++) {
		ifocus2Btns[i].className='normal';
		ifocus2Txs[i].className='normal';
	}
}

function classCurrent(ifocus2BtnID,ifocus2TxID,n){
	var ifocus2Btns= $(ifocus2BtnID).getElementsByTagName('li');
	var ifocus2Txs = $(ifocus2TxID).getElementsByTagName('li');
	ifocus2Btns[n].className='current';
	ifocus2Txs[n].className='current';
}

function ifocus2Change() {
	if(!$('ifocus2')) return false;
	$('ifocus2').onmouseover = function(){atuokey = true};
	$('ifocus2').onmouseout = function(){atuokey = false};
	var ifocus2Btns = $('ifocus2_btn').getElementsByTagName('li');
	var listLength = ifocus2Btns.length;
	ifocus2Btns[0].onmouseover = function() {
		moveElement('ifocus2_piclist',0,0,5);
		classNormal('ifocus2_btn','ifocus2_tx');
		classCurrent('ifocus2_btn','ifocus2_tx',0);
	}
	if (listLength>=2) {
		ifocus2Btns[1].onmouseover = function() {
			moveElement('ifocus2_piclist',0,-225,5);
			classNormal('ifocus2_btn','ifocus2_tx');
			classCurrent('ifocus2_btn','ifocus2_tx',1);
		}
	}
	if (listLength>=3) {
		ifocus2Btns[2].onmouseover = function() {
			moveElement('ifocus2_piclist',0,-450,5);
			classNormal('ifocus2_btn','ifocus2_tx');
			classCurrent('ifocus2_btn','ifocus2_tx',2);
		}
	}
	if (listLength>=4) {
		ifocus2Btns[3].onmouseover = function() {
			moveElement('ifocus2_piclist',0,-675,5);
			classNormal('ifocus2_btn','ifocus2_tx');
			classCurrent('ifocus2_btn','ifocus2_tx',3);
		}
	}
}

setInterval('autoifocus2()',5000);
var atuokey = false;
function autoifocus2() {
	if(!$('ifocus2')) return false;
	if(atuokey) return false;
	var focusBtnList = $('ifocus2_btn').getElementsByTagName('li');
	var listLength = focusBtnList.length;
	for(var i=0; i<listLength; i++) {
		if (focusBtnList[i].className == 'current') var currentNum = i;
	}
	if (currentNum==0&&listLength!=1 ){
		moveElement('ifocus2_piclist',0,-225,5);
		classNormal('ifocus2_btn','ifocus2_tx');
		classCurrent('ifocus2_btn','ifocus2_tx',1);
	}
	if (currentNum==1&&listLength!=2 ){
		moveElement('ifocus2_piclist',0,-450,5);
		classNormal('ifocus2_btn','ifocus2_tx');
		classCurrent('ifocus2_btn','ifocus2_tx',2);
	}
	if (currentNum==2&&listLength!=3 ){
		moveElement('ifocus2_piclist',0,-675,5);
		classNormal('ifocus2_btn','ifocus2_tx');
		classCurrent('ifocus2_btn','ifocus2_tx',3);
	}
	if (currentNum==3 ){
		moveElement('ifocus2_piclist',0,0,5);
		classNormal('ifocus2_btn','ifocus2_tx');
		classCurrent('ifocus2_btn','ifocus2_tx',0);
	}
	if (currentNum==1&&listLength==2 ){
		moveElement('ifocus2_piclist',0,0,5);
		classNormal('ifocus2_btn','ifocus2_tx');
		classCurrent('ifocus2_btn','ifocus2_tx',0);
	}
	if (currentNum==2&&listLength==3 ){
		moveElement('ifocus2_piclist',0,0,5);
		classNormal('ifocus2_btn','ifocus2_tx');
		classCurrent('ifocus2_btn','ifocus2_tx',0);
	}
}
addLoadEvent(ifocus2Change);
//-->
</script>