use test;
-- 교수번호가 2010160001인 교수님의 지도학생수를 출력하는 쿼리문
select count(*) as '지도학생수' from guide where gu_pr_num = 2010160001;

-- 강의가 2020년 1학기
-- at_mid, at_final, at_attend, at_homework 성적을 이용하여 
-- A,B,C,D,F를 at_score에 수정하는 쿼리문
select * from attend;

update attend 
join course on at_co_num = co_num
set at_score = case 
	when at_mid + at_final + at_attend + at_homework between 90 and 100 then 'A'
	when at_mid + at_final + at_attend + at_homework between 80 and 89.9 then 'B'
	when at_mid + at_final + at_attend + at_homework between 70 and 79.9 then 'C'
	when at_mid + at_final + at_attend + at_homework between 60 and 69.9 then'D'
	else 'F' end 
where co_year = '2020' and co_term = 1;

-- at_co_num가 1인 강의의 학생들 이름과 성적을 출력하는 쿼리문
select st_name as '이름', at_score as '성적' from attend
	join student on at_st_num = st_num
	where at_co_num = 1;
    
-- 과목명이 대학수학이고 2020년 1학기 강의를 수강한 학생들 이름과 성적을 출력하는 쿼리문
-- 과목명이 있는 subject테이블과 attend 테이블 student 테이블이 연결할 수 없기 때문에 course테이블을 중간으로 연결한다.
select st_name as '이름', at_score as '성적' from attend
	join student on at_st_num = st_num
	join course on at_co_num = co_num
    join subject on co_su_num = su_num
    where su_title = '대학수학' and co_year = '2020' and co_term = 1;

-- 홍길동 교수님이 2020년 2학기에 수업하는 강의 리스트를 출력하는 쿼리문
select pr_name, su_title from course
	join professor on co_pr_num = pr_num
    join subject on co_su_num = su_num
    where pr_name = '홍길동' and co_year = '2020' and co_term = 2;
    
-- 과목명이 대학수학이고 2020년 1학기 강의를 수강한 학생 성적별 학생수를 출력하는 출력하는 쿼리문 
select at_score as '학점', count(at_st_num) as '학생수' from attend
	join course on at_co_num = co_num
    join subject on co_su_num = su_num
    where su_title = '대학수학' and co_year = '2020' and co_term = 1
    group by at_score;
    
-- 김영철 학생이 수강했거나 하고있는 모든 강의 리스트를 출려하는 쿼리문
select su_title as '강의', co_term as '학기' from attend
	join student on at_st_num = st_num
    join course on at_co_num = co_num
    join subject on co_su_num = su_num
    where st_name = '김영철'
    order by co_term;
    
select su_title from subject
	join course on co_su_num = su_num
    join attend on at_co_num = co_num
    join (select* from student where st_name = '김영철') as std on st_num = at_st_num;
-- 위 예제에서 학생 테이블에 학생 정보가 많으면 검색을 먼저한 후 검색결과를 join 하는 것이 속도 향상에 도움이 된다.
-- 서브쿼리는 뒤에 반드시 as를 붙여줘햐 한다.

-- 트리거 : 테이블에 대한 이벤트(update, insert, delete)에 반응해 자동으로 실행되는 작업
-- 실행되는 작업
-- 이벤트가 발생했을 때 데이터의 무결성(일관성)을 지킬때 사용
-- 트리거를 생성하면 해당 이벤트가 발생될 때 자동으로 실행
-- 기본문법
/*
drop trigger 트리거명 if exists 트리거명;
delimiter //
create trigger 트리거명 AFTER|BEFORE 이벤트 on 테이블명
for each row
begin
	구현;
end //
delimiter;
*/

-- example DB에 있는 buy 테이블에 행이 추가되면 추가된 행과 일치하는 제품의 제고량과 판매량이 변경되는 트리거
use example;
drop trigger if exists insert_buy;
delimiter //
create trigger insert_buy after insert on buy
for each row
begin
	-- 변수 선언 방법
    -- declare 변수명 자료형 기본값;
    -- 변수에 값 설정 방법
    -- set 변수명 = 값;
    -- new : 이벤트가 발생한 행의 최신 데이터
    -- old : 이번트가 발생한 행의 이전 데이터(insert인 경우는 없음)
    
    declare _amount int default 0;
    set _amount = new.amount;
    update product 
		set 
			amount = amount - _amount,
            sale_amount = sale_amount + _amount
		where
			name = new.product_name;
end //
delimiter ;

-- example DB에 있는 buy 테이블에 행이 변경되면 행과 일치하는 제품의 제고량과 판매량이 변경되는 트리거
-- 변경되기 전의 값은 old.속성명으로, 변경된 후의 값은 new.속성명으로 호출
-- 단 제품명은 변경되지 않는다.

drop trigger if exists update_buy;
delimiter //
create trigger update_buy after update on buy
for each row
begin
	declare new_amount int default 0;
    declare old_amount int default 0;
    declare dif_amount int default 0;
    set new_amount = new.amount;  -- 변경된 내용의 수량
    set old_amount = old.amount;  -- 변경전 내용의 수량
    set dif_amount = new_amount - old_amount;  -- 변경전과 변경후 수량의 차이
    update product
		set 
		amount = amount - dif_amount,
		sale_amount = sale_amount + dif_amount
	where
		name = new.product_name;

end //
delimiter ;

-- 현재 DB에 있는 트리거리스트를 보여줌
show triggers;

use test;
-- tset DB에 있는 attend 테이블에 수강생이 추가되면 course 테이블에 수강인원이 증가하는 트리거를 생성하세요.

drop trigger if exists insert_attend;
delimiter //
create trigger insert_attend after insert on attend
for each row
begin
	declare _count int default 0;
    set _count = (select count(*) from attend where at_co_num = old.at_co_num);
    update course
		set
			co_attendee = _count
	where
		co_num = old.at_co_num;
    
end //
delimiter ;


