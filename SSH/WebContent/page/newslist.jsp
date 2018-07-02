<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link href="css/main.css" rel="stylesheet">
</head>
<body>
			<div class="AccountManagement_c " id="AccountManagement_c">
                <h3>新闻管理 
                    <div class="amcl fr">
                    <form action="Newsfuzzyquerynews" method="post">
                        <input type="text" placeholder="新闻标题" class="fl" name="character">
                        <div id="jiansuo" class="search fl"><img  src="images/search.png"></div>
                        <input style="display: none" type="submit" id="a" >
                   		</form> 
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <a href="Newsqueryitem"><div class="add_btn df_btn fl" id="add_News_btn">添加</div></a>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name=""><span>标题</span></label></li>
                        <li class="b20"><label>所属栏目</label></li>
                         <li class="b20"><label>创建时间</label></li>
                        <li class="b40"><label>操作</label></li>
                    </ul>   
                    <div class="list_b_c">
                       <!--  <ul class="list_null">
                            <li class="text_center">未添加新闻！</li>
                        </ul> -->
						<c:forEach items="${newslist}" var="news">
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox" name=""><span>${news.title}</span></label></li>
                            <li class="b20"><label>${news.item.name}</label></li>
                            <li class="b20"><label>${news.createTime}</label></li>
                            <li class="b40"> 
                            	<a href="NewsquerybynewsId?newsId=${news.newsId}"><div class="edit_btn df_btn fl text_center" id="edit_News_btn">编辑</div></a>
                        		<a href="Newsdeletenews?newsId=${news.newsId}"><div class="delete_btn df_btn fl text_center" id="delete_News_btn">删除</div></a>
                            </li>
                        </ul>
                        </c:forEach>
                    </div>
                    <div class="pull_page">
                        <div class="fl pull_page_up">上一页</div>
                            <ul>
								<c:forEach var="i" begin="1" end="${i}" step="1"> 
                                <a  href="Newsquerynews?pageNo=${i}"><li  class="on" id="tiaoye" >${i}</li></a>
                                </c:forEach> 
                                <li class="pull_page_df_btn">…</li>
                                <li>${i}</li>
                            </ul>
                        <div class="fl pull_page_down">下一页</div>
                    </div>

                    
                </div>
            </div>


            <!-- 弹窗 -->
    <!-- 添加账户 -->
    <div class="add_Account dn" id="add_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_Account_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 账户编辑 -->
    <div class="add_Account dn" id="user_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    编辑账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="column_now ">正在编辑 “<span>jiaowuchu</span>”账户</div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="">     
            </div>
            <div class="add_Account_ok_btn text_center" id="user_column_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 删除账户 -->
    <div class="add_Account dn" id="delete_News">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span>jiaopwuchu</span> ”账户吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_Account_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 账户授权 -->
    <div class="add_Account dn" id="ac_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    账户栏目授权
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <ul>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
            </ul>
            <div class="add_Account_ok_btn text_center" id="ac_Account_ok_btn">保<i>呀</i>存</div>
        </div>
    </div>
    <script type="text/javascript">
   					 var img=document.getElementById("jiansuo"); 
   					 var a=document.getElementById("a");
   						 img.onclick=function(){
   							 a.click();	 
   						 }			
			</script>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>