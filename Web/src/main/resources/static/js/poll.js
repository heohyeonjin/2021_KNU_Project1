//방에 들어갈 때 Id, roomId값 받아오기

      // function poll() {
      //     $.ajax({
      //         // url: "counselor/poll" + roomid + "/" + id,
      //         url: "counseling/poll",
      //         type: 'get',
      //         timeout: 60000,
      //         success: function (response) {
      //             console.log(response);
      //             //만약 status가 true면(새로운 채팅이 들어와있으면) setTimeout함수 실행
      //             messages.push({"msgContent":"안녕"})
      //             setTimeout(poll(), 10);
      //         },
      //         error: function (status) {
      //             console.error(status);
      //         }
      //
      //     })
      // }

        function addMessage() {
            $.ajax({
                url: "/counseling/addMessage",
                type: 'get',
                timeout:60000,
            }).done(function(fragment) {
                $("#messageDiv").append(fragment);
                setTimeout(addMessage(),10);
            });

        }



