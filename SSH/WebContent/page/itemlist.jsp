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
    <!-- 栏目管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>栏目管理 
                    <div class="amcl fr">
                        <form action="Newsfuzzyqueryitem" method="post">
                        <input type="text" placeholder="栏目名" class="fl" name="character">
                        <div id="lanmujiansuo" class="search fl"><img src="images/search.png"></div>
                        <input style="display: none" type="submit" id="c" >
                   	</form>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <div herf="" class="add_btn df_btn fl" id="add_column_btn">添加</div>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name=""><span>序号</span></label></li>
                        <li class="b20"><label>栏目名称</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                        <!-- <ul class="list_null">
                            <li class="text_center">未添加栏目！</li>
                        </ul> -->
						<c:forEach items="${itemlist}" var="item">
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox" name=""><span>${item.itemId}</span></label></li>
                             <li class="b20"><label><span>${item.name}</span></label></li>
                            <li class="b60">
                            	<a href="Newsquerybyitemid?itemId=${item.itemId}"><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        		<a href="Newsdeleteitem?itemId=${item.itemId}"><div class="delete_btn df_btn fl text_center">删除</div></a>
                            </li>
                        </ul> 
                        </c:forEach>
                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up">上一页</div>
                            <ul>
								<c:forEach var="i" begin="1" end="${i}" step="1"> 
                                <a  href="Newsqueryallitem?pageNo=${i}"><li  class="on" id="tiaoye" >${i}</li></a>
                                </c:forEach> 
                                <li class="pull_page_df_btn">…</li>
                                <li>${i}</li>
                            </ul>
                        <div class="fl pull_page_down">下一页</div>
                    </div>

                    
                </div>
            </div>


            <!-- 添加栏目 -->
    <div class="add_Account dn" id="add_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加栏目
                    <form action="Newsadditem" method="post">
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="item.name">     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="item.itemId">     
            </div>
             <!-- <div class="add_Account_ok_btn text_center" id="add_column_ok_btn">确<i>皮</i>定</div> --> 
              <div style="margin-left: 40px"><input class="add_Account_ok_btn text_center" id="add_column_ok_btn" type="submit" value="确     定"></div>
            </form>
        </div>
    </div>

    <!-- 编辑栏目 -->
    <div class="add_Account dn" id="edit_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    编辑栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="">     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="">     
            </div>
            <div class="add_Account_ok_btn text_center" id="edit_column_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>

    <!-- 删除栏目 -->
    <div class="add_Account dn" id="delete_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span>jiaopwuchu</span> ”栏目吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_column_ok_btn">确<i>皮</i>定</div>
        </div>
    </div>
			<script type="text/javascript">
   					 var img=document.getElementById("lanmujiansuo"); 
   					 var a=document.getElementById("c");
   						 img.onclick=function(){
   							 a.click();	 
   						 }			
			</script>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>