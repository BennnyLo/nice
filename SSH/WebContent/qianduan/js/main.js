$(function(){
    
    //设置nav_scrollbar ul 宽度
    var liLength = $(".nav_scrollbar ul li").length;
    var liw = $(".nav_scrollbar ul li").eq(0).width();
    var all_liw = 0;
    for( var j = 0; j < liLength ; j++ ){
        all_liw += $(".nav_scrollbar ul li").eq(j).width();
    }
    all_liw += parseInt(liLength * 20 + 30);
    // alert(all_liw);
    $(".nav_scrollbar ul").css( "width" , all_liw + "px" )

    // nav_scrollbar 
    $(".nav_scrollbar ul li").each(function(){
        var index = $(this).index();
        $(".nav_scrollbar ul li").eq(index).click(function(){
            $(this).addClass("nav_scrollbar_on").siblings().removeClass("nav_scrollbar_on");
        })
    })

    // $(".nav_more").click(function(){
    //     $(".popup_nav").fadeIn(0);
    //     if ( $(".popup_nav").show() ) {
    //         holdmove();
    //     }
    //     $(".popup_nav ul").animate({left:"40%"},200)
    // })

    // $(".popup_nav").click(function(){
    //     $(".popup_nav ul").animate({left:"100%"},100);
    //     $(".popup_nav").fadeOut(100);

    // })


    //蒙版滑动事件禁止穿透
    // function holdmove(){
    //     $('body').bind('touchmove',function(){
    //         return false;
    //     })
    // }

    

    
})
