<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
$(function () {

    $('#scissors').click(function () {
        let S = Number($('#scissors').val());
        $('#Player').attr('src', '/Test/gawe.png');
        Com(S);
    })
    $('#rock').click(function () {
        let R = Number($('#rock').val());
        $('#Player').attr('src', '/Test/bawe.png');
        Com(R);
    })
    $('#paper').click(function () {
        let P = Number($('#paper').val());
        $('#Player').attr('src', '/Test/bo.png');
        Com(P);
    })

    function Com(Player) {

        let com = Math.floor(Math.random() * 3);
        let comRsp = "";
        switch (com) {
            case 0: {
                comRsp = "가위";
                $('#Com').attr('src', '/Test/gawe.png');
                break;
            }
            case 1: {
                comRsp = "바위";
                $('#Com').attr('src', '/Test/bawe.png');
                break;
            }
            case 2: {
                comRsp = "보";
                $('#Com').attr('src', '/Test/bo.png')
                break;
            }


        }
        let result = Player - com;
        if (result == 0) {
            $('#result').text("Draw")
            console.log('draw');
            $('#comResult').val(comRsp);

        }
        else if (result == 1 || result == -2) {
            $('#result').text('You Win')
            console.log('win');
            $('#comResult').val(comRsp);

        }
        else if (result == -1 || result == 2) {
            $('#result').text('You Lose')
            console.log('lose');
            $('#comResult').val(comRsp);

        }
    }
})

</script>


<body>
	 <div>
        <div id="p" class="float-left">
            <img id="Player" src="/Test/ezgif.com-gif-maker.gif">
            <p>You</p>
            <div class="d-flex">
            <button id='scissors' value='0'>가위</button>
            <button id="rock" value="1">바위</button>
            <button id="paper" value='2'>보</button>
            </div>
        </div>

        <div id="dealer" class="float-left">
            <img src="/Test/5e2e1093200894c127cb2ce80392b430.gif">
            <h1><p id="result">VS</p></h1>
        </div>

        <div id="c" class="float-left">
            <img id="Com" src="/Test/ezgif.com-gif-maker.gif">
            <p>Com</p>
            <input id="comResult" type="button" value="ComResult" disabled>
        </div>
    </div>	
</body>
</html>