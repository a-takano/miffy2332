//Ajaxで使うXMLHttpRequestオブジェクトを作って返す。
function createHttpRequest(){
    var httplist = [
        function(){ return new XMLHttpRequest(); },
        function(){ return new ActiveXObject("Msxml2.XMLHTTP"); },
        function(){ return new ActiveXObject("Microsoft.XMLHTTP"); }
    ];
    for(var i = 0;i < httplist.length;i++){
        try {
            var http = httplist[i]();
            if (http != null){ return http; }
        } catch(e){ continue; }
    }
    return null;
}

//Ajaxを使ってサーブレットにアクセスする。
function getData(id){
    var request = createHttpRequest();
    if (request == null){
        alert("HttpRequestが取得できませんでした。");
        return;
    }
    var uri = "/miffy2332";
    if (id != null) uri = "/miffy2332?id=" + id;
    request.open("GET",uri,true);
    request.setRequestHeader("User-Agent","XMLHttpRequest");
    request.onreadystatechange = function(){
        if (request.readyState == 4 && request.status == 200){
            callback(request);
        }
    }
    request.send();
}

//クエリー配列を解析して連想配列にして返す。
function getQuery(){
    var datas = new Array();
    var query = location.search.substring(1);
    var arr = query.split('&');
    for(var i = 0;i < arr.length;i++){
        var item = arr[i].split('=');
        datas[item[0]] = item[1];
    }
    return datas;
}