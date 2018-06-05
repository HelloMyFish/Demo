<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("tbody tr td").click(function () {
                $("#answer").html($("#answer").html() + $(this).html());
            })
            //清空
            $("#del").click(function(){
                $("#answer").html("");
            })

            $("#submit").click(function () {
                var html = $("#answer").html();
                if (html == "") {
                    return;
                }
                var url = "/demoTest";

                $.ajax({
                    type: "POST",
                    url: url,
                    dataType: 'json',
                    data: {dataMsg: html},
                    success: function (jsonObject) {
                        alert(jsonObject)
                        if (jsonObject.status) {
                            var answer = jsonObject.answer;
                            $("#answer").html(answer);
                        } else {
                            alert("输出错误")
                            $("#answer").html("");
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<h2><span style="margin: 0 auto;">计算器</span></h2>
<table style="border: solid 1px black;height: 400px;width: 400px;">
    <thead>
    <tr>
        <td colspan="4">这是一个计算器</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="4" id="answer"></td>
    </tr>
    <tr>
        <td>(</td>
        <td>)</td>
        <td>%</td>
        <td id="del">C</td>
    </tr>
    <tr>
        <td>7</td>
        <td>8</td>
        <td>9</td>
        <td>/</td>
    </tr>
    <tr>
        <td>4</td>
        <td>5</td>
        <td>6</td>
        <td>*</td>
    </tr>
    <tr>
        <td>1</td>
        <td>2</td>
        <td>3</td>
        <td>-</td>
    </tr>
    <tr>
        <td>0</td>
        <td>.</td>
        <td id="submit">=</td>
        <td>+</td>
    </tr>
    </tbody>
</table>
</body>
</html>
