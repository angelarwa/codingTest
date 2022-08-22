public class doubleSubmitFlag {
    //예시
    function doubleSubmitcheck(){
        if(doubleSubmitFlag){ //true가 되었기 때문에 더이상 submit을 탈 수 없다.
            alert('제출중');
            return false;
        }else{
            doubleSubmitFlag = true; //더블써밋방지 플래그 값이 true가 됨
            form.action = "/test";
            form.submit();
            return false;
        }
        }
    if(doubleSubmitcheck()) return;


    // 전문발송 중복방지
    var doubleSubmitFlag = false;

    function fn_cardApply(){
        $('#applyClose').click();
        var checkFlag = fnValidate();
        if(checkFlag == false){
            var doubleSubmitFlag = false;
            return ;
        }

        if(doubleSubmitFlag == true){
            alert('제출중입니다.');
            //return false;
        }else{
            doubleSubmitFlag = true;
            //return true;
        }

        //중도이탈값 기본세팅
        $('#HalfWayLeave').val("N");
        var target = $('#step04');
        fn_applicationSend(target);
    }

}
