$(function(){
var option = {
// datepicker 애니메이션 타입
// option 종류 : "show" , "slideDown", "fadeIn", "blind", "bounce", "clip", "drop", "fold", "slide"
showAnim : "slideDown",
// 해당 월의 다른 월의 날짜가 보이는 여부, 예를 들면 10월이면 전후에 9월 마지막과 11월의 시작 일이 보이는 여부입니다. 즉, 달력이 꽉 차 보이게 하는 것
showOtherMonths: true,
// 선택 여부 (showOtherMonths 옵션과 같이 일치시키지 않으면 에러가 발생합니다.)
selectOtherMonths: true,
// 달력 밑에 오늘과 닫기 버튼이 보인다.
showButtonPanel: true,
// 년 월이 셀렉트 박스로 표현 되어서 선택할 수 있다.
changeMonth: true,
changeYear: true,
// 한번에 보이는 개월 수
numberOfMonths: 1,
// 데이터 포멧
dateFormat: "yy-mm-dd",
// 텍스트 박스 옆의 달력 포시
showOn: "button",
//이미지 타입인지 버튼 타입인지 설정
buttonImageOnly: true,
// 이미지 경로
buttonImage: "https://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
// 버튼 타입이면 버튼 값
buttonText: "Select date",
// alt 데이터 포멧
altFormat: "DD, d MM, yy",
// 선택 가능한 날짜(수 형식) - 현재 기준 -20일
minDate: -20,
// 선택 가능한 최대 날짜(문자 형식) - 현재 기준 +1월 +20일
maxDate: "+1M +20D",
// 주 표시
showWeek: true
};
var optionFrom = option;
optionFrom.altField = "#alternateFrom";
var dateFormat = "mm/dd/yy";
// 시작일이 선택이 되면 종료일은 시작일 보다 앞을 선택할 수 없다.
var from = $( "#from" )
.datepicker(optionFrom)
.on( "change", function() {
to.datepicker( "option", "minDate", getDate( this ) );
});
var optionTo = option;
optionTo.altField = "#alternateTo";
// 종료일이 선택이 되면 시작일은 시작일 보다 앞을 선택할 수 없다.
var to = $( "#to" )
.datepicker(optionTo)
.on( "change", function() {
from.datepicker( "option", "maxDate", getDate( this ) );
});
function getDate( element ) {
return moment(element.value).toDate();
}
});


