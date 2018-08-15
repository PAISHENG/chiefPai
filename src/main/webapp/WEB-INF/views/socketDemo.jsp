<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<title>Chat WebSocket</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--     <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<!--     <link href="/main.css" rel="stylesheet"> -->
<%-- <script src="<c:url value='/resources/js/jquery-3.3.1.min.js' />"></script> --%>
<!-- <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script> -->
<!-- <script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script> -->
<script src="https://cdn.bootcss.com/sockjs-client/0.3.4/sockjs.min.js"></script>
<script src="https://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
<%--     <script src="<c:url value='/theme1/resources/js/app.js' />"></script> --%>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    connect();
    //checkoutUserlist();
});
var stompClient = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}
//this line.
function connect() {
    var userid = document.getElementById('name').value;
    var socket = new SockJS('/chiefPai/hello');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('http://localhost:8080/chiefPai/topic/greetings', function(greeting){
            showGreeting(JSON.parse(greeting.body).content);
        });

//         stompClient.subscribe('/user/' + userid + '/message',function(greeting){
//             alert(JSON.parse(greeting.body).content);
//             showGreeting(JSON.parse(greeting.body).content);
//         });
    });
}
function sendName() {
    var name = document.getElementById('name').value;
    stompClient.send("http://localhost:8080/chiefPai/app/hello", {atytopic:"greetings"}, JSON.stringify({ 'name': name }));
}

function connectAny() {
    var socket = new SockJS("http://localhost:8080/chiefPai/hello");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/feed', function(greeting){
            alert(JSON.parse(greeting.body).content);
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function showGreeting(message) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message));
    response.appendChild(p);
}

</script>
</head>
<body >
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="connectAny" onclick="connectAny();">ConnectAny</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>What is your name?</label><input type="text" id="name" />
        <button id="sendName" onclick="sendName();">Send</button>
        <p id="response"></p>
    </div>
</div>

</body>
</html>