$(function(){

  //初期化処理
  function initialFunc(){
    $.ajax({
      url:'SampleServlet',
      type:'POST',
      data:{"select":"init",
        "insert":"",
        "delete":"",
        "update":""
      }
    })
    .done(function(data){
      $("#sampleTable tbody").append(data);
    })
    .fail(function(){
      alert("fail");
    });
  }

  //読み込んだらまず初期化する
  initialFunc();

  //INSERTボタン押下処理
  $("#insertButton").on("click", function(){

    var $input = $('input[name=my-text]');
    var td = "";

    for(var i = 0; i < $input.length; i++){
      td += $input[i].value + "__";
    }

    $.ajax({
      url:'SampleServlet',
      type:'POST',
      data:{"select":"",
            "insert":td,
            "delete":"",
            "update":""
        }
    })
    .done(function(data){
      initialFunc();
      alert("行が追加されました");
    })
    .fail(function(){
      alert("行の追加に失敗しました");
    });

  });

  //DELETEボタン押下処理
  $("#deleteButton").on("click", function(){

    var trId = $("#sampleTable").find(".selectTr");

    $.ajax({
      url:'SampleServlet',
      type:'POST',
      data:{"select":"",
            "insert":"",
            "delete":trId[0].children["0"].innerHTML,
            "update":""
        }
    })
    .done(function(data){
      initialFunc();
      alert("行が削除されました");
    })
    .fail(function(){
      alert("行の削除に失敗しました");
    });

  });

  //UPDATEボタン押下処理
  $("#updateButton").on("click", function(){

    //
    //delete insert を順に実行する。順序を守る
    //delete実行して帰ってきたら insert を実行する
    //

    alert("未実装だよ");

  });

  //Table TR 押下処理
  $(document).on("click", "#sampleTable tr", function(){
    $("#sampleTable tr").removeClass("selectTr");
    $(this).addClass("selectTr");
  });

});