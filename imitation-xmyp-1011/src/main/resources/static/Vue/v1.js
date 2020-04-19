new Vue({
    //绑定 DOM 元素
    el: '#category',
    data: {
        category: [],
        product: []
    },
    created: function () {
        var self = this;
        $.ajax({
            type: "get",
            url: "./cd",
            dataType: "json",
        }).then(function (res) {
            self.category = res;
        }).fail(function () {
            alert("失败");
        });
        $.ajax({
            type: "get",
            url: "./cd2",
            dataType: "json",
        }).then(function (res) {
            self.product = res;
        }).fail(function () {
            alert("失败");
        });
    }, methods: {
        mouseOver: function () {
            $("#Tz_banner .firstLi .info").each(function () {
                var $li = $(this).find("li");//获取到所有info下面的li
                var length = $li.length;//得到info下面所有li的数量
                var width = $li.width();//获取li的宽度
                var height = $li.height();//获取li的高度
                var col = Math.ceil(length / 6);//向上取整
                $(this).width(col * width);
                $li.each(function (i) {
                    var x = Math.floor(i / 6);//向下取整
                    var y = i % 6;//取余数
                    $(this).css({
                        left: x * width + "px",
                        top: y * height + "px"
                    });
                });
            });
            $("#Tz_banner .firstLi").mouseover(function () {
                $(this).find(".info").show();
            });
            /*
            $('#Tz_banner .firstLi').find(".info").show();*/
        },
        mouseout: function () {
            $("#Tz_banner .firstLi .info").each(function () {
                var $li = $(this).find("li");//获取到所有info下面的li
                var length = $li.length;//得到info下面所有li的数量
                var width = $li.width();//获取li的宽度
                var height = $li.height();//获取li的高度
                var col = Math.ceil(length / 6);//向上取整
                $(this).width(col * width);
                $li.each(function (i) {
                    var x = Math.floor(i / 6);//向下取整
                    var y = i % 6;//取余数
                    $(this).css({
                        left: x * width + "px",
                        top: y * height + "px"
                    });
                });
            });
            $("#Tz_banner .firstLi").mouseout(function () {
                $('#Tz_banner .firstLi').find(".info").hide();
            });
        }
    }
});
/*function init() {
    /!*左侧菜单栏*!/
    $("#Tz_banner .firstLi .info").each(function () {
        var $li = $(this).find("li");//获取到所有info下面的li
        var length = $li.length;//得到info下面所有li的数量
        var width = $li.width();//获取li的宽度
        var height = $li.height();//获取li的高度
        var col = Math.ceil(length / 6);//向上取整
        $(this).width(col * width);
        $li.each(function (i) {
            var x = Math.floor(i / 6);//向下取整
            var y = i % 6;//取余数
            $(this).css({
                left: x * width + "px",
                top: y * height + "px"
            });
        });

    });
    $("#Tz_banner .firstLi").hover(function () {
        $(this).find(".info").show();
    }, function () {
        $(this).find(".info").hide();
    });
}*/
