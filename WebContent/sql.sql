--alter table member drop primary key cascade;   
--drop table member purge; 

create table member (
	num		number(20), 		-- 회원번호	
	name 		varchar2(20),		-- 이름
	id		varchar2(20)   primary key,	-- 아이디
	pw		varchar2(20),		-- 비밀번호
	email		varchar2(40),		-- 이메일
	phone 		varchar2(20),		-- 핸드폰번호
	zipcode		varchar2(20),		-- 우편번호
	address		varchar2(60),		-- 주소	
	gender		varchar2(2),		-- 성별
	birth		number(20),		-- 생년월일
	indate		date		default sysdate,		-- 가입일
	admin		number(7)	default '0'    -- 관리자(1), 회원(0)	
);

insert into member(num, name, id, pw, email, phone,zipcode,address, gender, birth, indate) values
(member_seq.nextval, '백승규', 'yrs01131', '1478', 'yrs01131@gmail.com', '010-5555-6666', '03012' ,'서울시 종로구 구기동 54-6', 'm', 19940704 , sysdate);

insert into member(num, name, id, pw, email, phone,zipcode,address, gender, birth, indate) values
(member_seq.nextval, '권애지', 'ae1234', '1234', 'ae1234@gmail.com', '010-5555-6666', '01234' ,'서울시 용산구 원효로 216', 'f', 19890131 , sysdate);

insert into member(num, name, id, pw, email, zipcode, address, phone, admin, gender, birth)
values(member_seq.nextval, '김영민', 'ymin00', '1234', 'youngmin@naver.com', '12345', '서울시 구로구 고척동 123번지', '010-1234-1234', 0, 'm', 20000515);   -- 회원
insert into member(num, name, id, pw, email, zipcode, address, phone, admin, gender, birth)
values(member_seq.nextval, '권애지', 'aed00', '1234', 'tmreg00@naver.com', '56789', '서울특별시 용산구 청파동1가 청파로 327', '010-7542-1234', 0, 'f', 19970718);-- 회원
insert into member(num, name, id, pw, email, zipcode, address, phone, admin, gender, birth)
values(member_seq.nextval, '백승규', 'efdg52', '1234', 'yuij00@naver.com', '08524', '서울특별시 마포구 공덕동 마포대로 110 1층', '010-5555-1234', 0, 'm', 19981116);-- 회원
insert into member(num, name, id, pw, email, zipcode, address, phone, admin, gender, birth)
values(member_seq.nextval, '김운지', 'amdet', '1234', 'qwed00@naver.com', '03751', '서울특별시 영등포구 영등포본동 592-48', '010-7777-1234', 0, 'm', 19970802);

insert into member(num, name, id, pw, email, zipcode, address, phone, admin, gender, birth)
values(member_seq.nextval, '김영민', 'scott', 'tiger', 'kimyoungmin@naver.com', '56789', '서울시 구로구 고척동 456번지', '010-9999-1234', 1, 'm', 20000515); 
select * from member;

--drop sequence member_seq;
create sequence member_seq start with 1;

-------------------------------------------------------------------------------------------------------------------------
alter table product drop primary key cascade;   
drop table product purge; 

create table product (
	num		number(20) 	primary key, 	-- 등록번호
	id		varchar2(20)	 references  member(id),	-- 등록회원
	title		varchar2(40),	-- 등록제목
	name		varchar2(40),	-- 물품명
	count		number(5),	-- 물품 개수
	price		number(15),	
	category		number(3),	-- 물품카테고리(숫자로 분류)  
	-- 컴퓨터 - 1 , 카메라/영상기기 - 2, 음악악기 - 3, 스포츠/레저 - 4, 도서 - 5, 출산/육아 - 6, 의류잡화 - 7, 게임용품 - 8	
	img		varchar2(30),	-- 등록 이미지	
	locationname	varchar2(40)	 references  location(name) on delete cascade,	-- 거래지점이름
	content		varchar2(3000),	-- 등록 내용
	indate		date		default sysdate,	-- 등록일
	viewcount		number(10)	default 0, 	-- 조회수	
	rentcount 	number(10),	-- 대여 또는 판매 횟수
	classify		char(1) 	default 1	  	-- 대여(1)/판매(2)		
);


insert into product(num, id, title, name, price, category, img, locationname,content,indate, rentcount,classify) values(
product_seq.nextval, 'yrs01131', '프린터 대여합니다. ', '삼성프린터 ', 10000, 1, '삼성프린터.jpg', '종로평창동' ,'레이저젯 프린터로 토너 많이 남았어요', sysdate, 0, '1');

update product set rentcount =0 where num = 44; 
delete

insert into product(num, id, title, name, count, img, locationname, content, category, rentcount, classify)
values(product_seq.nextval, 'ymin00', '노트북 빌려드립니다', '노트북', '1', 'A1.jpg', '도산가로수길', 'NT930XCJ-K716A제품입니다', '1', '3', '1');
insert into product(num, id, title, name, count, img, locationname, content, category, rentcount, classify)
values(product_seq.nextval, 'aed00', '노트북 빌려드립니다', '컴퓨터', '1', 'A2.jpg', '논현힐탑', '애플 아이맥 27형 2019년형 (MRR12KH/A) 제품입니다', '1', '2', '1');

insert into product(num, id, title, name, count, img, locationname, content, category, rentcount, classify)
values(product_seq.nextval, 'efdg52', '카메라 빌려드립니다', '카메라', '1', 'B1.jpg', '삼성역', '후지필름 X-A7제품입니다', '2', '3', '1');
--insert into product(num, id, title, name, count, img, locationname, content, category, rentcount, classify)
--values(product_seq.nextval, 'amdet', '카메라 빌려드립니다', '카메라', '1', 'B2.jpg', '선릉로', '소니 알파 A6000제품입니다', '2', '3', '2');
--
--insert into product(num, id, title, name, count, img, locationname, content, category, rentcount, classify)
--values(product_seq.nextval, 'ymin00', '기타 빌려드립니다', '기타', '1', 'C1.jpg', '포스코', '콜트 CR100 레스폴 입문용 일렉기타 제품입니다', '3', '3', '4');
--insert into product(num, id, title, name, count, img, locationname, content, category, rentcount, classify)
--values(product_seq.nextval, 'aed00', '바이올린 빌려드립니다', '바이올린', '1', 'C2.jpg', '길동사거리', '영창 수제바이올린 153 시리즈 연습용 입문용 제품입니다', '3', '3', '4');
--
--
--
--insert into product(num, id, title, name, count, img, locationname, content, category, rentcount, classify)
--values(product_seq.nextval, 'amdet', '농구공 빌려드립니다', '농구공', '2', 'D2.jpg', '천호역', '나이키 농구공 입니다', '4', '3', '7');


select * from product where content like '%프린터%' ;
--drop sequence product_seq;
create sequence product_seq start with 1;
select * from product ;
-------------------------------------------------------------------------------------------------------------------------
--alter table location drop primary key cascade;   
--drop table location purge; 

create table location (
	num		number(5),	--지점번호
	name		varchar2(40)	 primary key, 	-- 지점 이름
	city		varchar2(20),	-- 서울시
	gu		varchar2(20),	-- 구
	dong		varchar2(30),	-- 동
	bunji		varchar2(40),	-- 번지		
	zipcode		varchar2(20),	-- 우편번호
	phone		varchar2(40)	-- 지점 연락처	
);





select * from location;


insert into location(num, name, city, gu, dong, bunji, zipcode, phone) values(
location_seq.nextval, '종로평창동', '서울시', '종로구', '평창동', '182-11 나라빌딩' , '03009', '02-396-3631');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '도산가로수길', '서울특별시' ,'강남구', '논현동','5번지 2층',  '02-758-8429');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '논현힐탑', '서울특별시' ,'강남구', '논현동','216-5번지',  '02-758-8426');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '삼성역', '서울특별시' ,'강남구', '삼성동','168-26번지',  '02-758-8585');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '선릉로', '서울특별시' ,'강남구', '역삼동','697-45 대흥빌딩 1층', '02-758-8429');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '포스코', '서울특별시' ,'강남구', '대치동','942-5번지 1층',  '02-758-8331');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '길동사거리', '서울특별시' ,'강동구', '길동',' 459-4번지 1층',  '02-758-8342');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '명일이마트', '서울특별시' ,'강동구', '명일동','47-7 명일이마트별관주차장',  '02-758-8752');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '천호역', '서울특별시' ,'강동구', '성내동','62-4 태승빌딩',  '02-758-8296');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '올림픽공원북문', '서울특별시' ,'강동구', '성내동','468',  '02-758-8761');
insert into location(num, name, city, gu, dong, bunji,  phone) values(
location_seq.nextval, '도산가로수길 ', '서울특별시' ,'강남구', '상일동','373-1',  '02-758-8670');


drop sequence location_seq;
create sequence location_seq start with 1;
-- 여기까지 일단 생성됫음 필요하면 다음 부터 생성 
-------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------
--alter table cart drop primary key cascade;   
--drop table cart purge; 
--
--create table cart (
--	num		number(4) primary key,	--번호
--	cnum		number(20)	references product(num) on delete cascade,	-- 상품번호
--	id		varchar2(20)	references  member(id) on delete cascade,
--	count		number(10),	-- 수량
--	price		number(15), 		--주문 금액
--	indate		date		default sysdate,	-- 등록날짜
--	result		char(1) 	default 0	-- 주문완료시/미완료(1/0)		
--);
--
--select * from cart;
--
--drop sequence cart_seq;
--create sequence cart_seq start with 1;
----price 부분 product에 맞게 수정 필요
--insert into cart (num, cnum, id, count,  result, price)
--values(cart_seq.nextval, 33, 'yrs01131', 1,0, 1000);
----
----insert into cart (num, cnum, id, count, indate, result, price)
----values(cart_seq.nextval, 2, 'two', 1,  '2020-01-24', 0, 4000);
----
----insert into cart (num, cnum, id, count, indate, result, price)
----values(cart_seq.nextval, 3, 'three', 1,  '2019-11-27', 0, 9000);
----
----insert into cart (num, cnum, id, count, indate, result, price)
----values(cart_seq.nextval, 4, 'one', 1,  '2020-02-28', 0, 2000);

-------------------------------------------------------------------------

create table rentcart (
	num		number(4),	--번호
	rnum		number(20)	references product(num) on delete cascade,	-- 상품번호
	id		varchar2(20)	references  member(id) on delete cascade,
	count		number(10),	-- 수량
	price		number(15) , 		--대여 금액
	borrow		date,		-- 대여날짜 -- 입력 형식을 잘 지정해주어야함..
	turn			date,		-- 반납날짜	
	indate		date		default sysdate,	-- 등록날짜
	result		char(1) 	default 0	-- 대여완료시/미완료(1/0)		
);
alter table rentcart drop primary key cascade;   
drop table rentcart purge; 
select * from rentcart;

drop sequence rentcart_seq;
create sequence rentcart_seq start with 1;

--price 부분 추가 필요
insert into rentcart(num, rnum, id, count, borrow, turn, result, price)
values (rentcart_seq.nextval, 1, 'yrs01131', 1, '2020-04-17', '2020-07-17', 0, 8000);
--
--insert into rentcart(num, rnum, id, count, borrow, turn, indate, result)
--values (rentcart_seq.nextval, 5678, 'two', 1, '2020-02-24', '2020-05-24', '2020-01-24', 0);
--
--insert into rentcart(num, rnum, id, count, borrow, turn, indate, result)
--values (rentcart_seq.nextval, 5555, 'three', 3, '2020-01-04', '2020-05-04', '2019-11-27', 0);
--
--insert into rentcart(num, rnum, id, count, borrow, turn, indate, result)
--values (rentcart_seq.nextval, 1111, 'one', 5, '2020-03-05', '2020-08-05', '2020-02-28', 0);

-------------------------------------------------------------------------
--alter table qnauser drop primary key cascade;   
--drop table qnauser purge; 
--
--create table qnauser (
--	num		number(10)	primary key, 		-- 번호	
--	qnum 		number(20) references product(num) on delete cascade,		--물품번호
--	title		varchar2(40),	-- 제목
--	id		varchar2(20) references  member(id) on delete cascade,		-- 작성자 아이디
--	content		varchar2(1000),		-- 질문내용
--	indate		date default sysdate,		-- 작성일
--	reply		varchar2(1000) default null,		-- 답변내용
--	--img    varchar2(30),
--	result		char(1)	default 0		--답변 유무	(1은 답변완료 / 0은 미답변)
--	
--);
--
--
--
--select * from qnauser;
--
--drop sequence qnauser_seq;
--create sequence qnauser_seq start with 1;
--
--insert into qnauser (num, qnum, title, id, content,  reply, result)
--values(qnauser_seq.nextval, 33, '물품 고장', 'yrs01131', '게임기를 대여해줬는데 고장이났습니다 수리비는 빌려준 분에게 청구하면되나요??', '빌려가신분 연락처 보내주시면 처리 도와드리겠습니다', '1');
--
--insert into qnauser (num, qnum, title, id, content, indate, result)
--values(qnauser_seq.nextval, 3, '이거 맞나요?', 'two', '신발을 대여해줬는데 반납기간 지났는데 반납하지 않습니다 어떻게해야 할까요?', '2020-02-26', '0');



-------------------------------------------------------------------------
alter table qna drop primary key cascade;   
drop table qna purge; 


create table qna(
	num		number(10)		primary key, 		-- 번호	
	title		varchar2(40),	-- 제목
	id		varchar2(20)	 references  member(id) on delete cascade,		-- 작성자 아이디
	content		varchar2(1000),		-- 질문내용
	indate		date 	default sysdate,		-- 작성일
	reply		varchar2(1000) default '',		-- 답변내용
	--img    varchar2(30),
	result		char(1)	default 0		--답변 유무(미응답0/답변완료1)		
);



select * from qna;

drop sequence qna_seq;
create sequence qna_seq start with 1;

insert into qna(num, title, id, content, reply, result)
values(qna_seq.nextval, '안녕하세요', 'yrs01131', '안녕하세요~', '안녕하세요~~~~', '1');

insert into qna(num, title, id, content, indate, result)
values(qna_seq.nextval, '안녕하세요', 'two', '안녕하세요~', '2020-03-15', '0');

-------------------------------------------------------------------------
--alter table review drop primary key cascade;   
--drop table review purge; 
--
--create table review (
--	num		number(10)	primary key, 		-- 번호	
--	rnum 		number(10) references product(num) on delete cascade,		--물품번호
--	title		varchar2(20),	-- 제목
--	id		varchar2(20) references  member(id) on delete cascade,		-- 작성자 아이디
--	content		varchar2(1000),		-- 후기내용
--	indate		date 	default sysdate,		-- 작성일
--	--point number(10),      --평점..	
--	img    varchar2(30) default 'default.jpg'
--);
--
--
--select * from review;
--
--drop sequence review_seq;
--create sequence review_seq start with 1;
--
--insert into review(num, rnum, title, id, content)
--values(review_seq.nextval, 33, '상품 후기','yrs01131', '유모차 대여 하였는데 아이가 너무 편안해 합니다 저도 너무 편합니다~^^');
--
--insert into review(num, rnum, title, id, content, indate)
--values(review_seq.nextval, 3, '게임용품 대여', 'one', '모드 게임 대여해갔는데 가족끼리 모여서 잘 쓰고 있습니다 가족끼리 너무 화목하게 보내는거 같습니다 ㅎㅎ', '2019-05-13');
--
----insert into review(num, rnum, title, id, content, indate, point number)
----values(review_seq.nextval, 2552, 카메라 대여 후기, efdg52, 원래 사려던 제품이였는데 안좋으면 어쩌나 걱정해서 안사고 있었는데 대여해서 써보니 너무 좋은거 같네용 바로 결제 하러 가려구영ㅎㅎ, '2019-04-29', ★★★★★);
--
----insert into review(num, rnum, title, id, content, indate, point number)
----values(review_seq.nextval, 4753, 상품 후기, amdet, 인형 대여하였는데 너무 더럽고 찢어진 곳도 몇군데 있네요.. 이런건 등록 안해주셨으면 합니다.. , 2019-10-06, ★☆☆☆☆);

-------------------------------------------------------------------------

create table rent (
	num		number(10)	primary key, 		-- 번호	
	name		varchar2(40),	-- 물품명
	rnum 		number(10) references product(num) on delete cascade,		--물품번호	
	id		varchar2(20) references  member(id) on delete cascade,		-- 예약자 아이디
	borrow		date,		-- 대여날짜 -- 입력 형식을 잘 지정해주어야함..
	turn			date,		-- 반납날짜	
	locationname    varchar2(30)	references  location(name),   --대여 지점
	price		number(15),		--대여 금액
	count		number(5)
	
);



select * from rent;

drop sequence rent_seq;
create sequence rent_seq start with 1;


insert into rent(num, name, rnum, id, borrow, turn, locationname, price, count)
values(rent_seq.nextval, '카메라', 33, 'yrs01131', '2020-04-17', '2020-04-19', '천호역', 50000,1);

-------------------------------------------------------------------------
--alter table buy drop primary key cascade;   
--drop table buy purge; 
--
--create table buy (
--	num		number(10)	primary key, 		-- 번호	
--	name		varchar2(40),	-- 물품명
--	onum 		number(10) references product(num),		--물품번호	
--	id		varchar2(20) references  member(id),		-- 주문 아이디
--	count		number(5),
--	price		number(15), 		--주문 금액
--	indate		date default sysdate			--주문날짜
--	
--);
--
--
--
--select * from buy;
--
--drop sequence buy_seq;
--create sequence buy_seq start with 1;
--
--insert into buy(num,name, onum, id, count, price, indate)
--values(buy_seq.nextval,'악기', 3, 'one', 1, 34000, '2020-03-10');

-------------------------------------------------------------------------
-- 베스트 상품 뷰 
create or replace view best_pro_view as
select num, name, price, img ,locationname , title
from( select rownum, num, name, price, img, locationname , title from product   order by rentcount desc)
where  rownum <=4;

select * from best_pro_view;

create or replace view new_pro_view as
select num, name, price, img ,locationname , title
from( select rownum, num, name, price, img, locationname , title from product   order by indate desc)
where  rownum <=8;


select * from new_pro_view;
