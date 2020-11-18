-- 프로시저 : 함수(메소드) - 쿼리의 집합
-- 			일련의 쿼리를 마치 하나의 함수처럼 실행하기 위한 커리의 집합
-- 장점 : 하나의 요청으로 SQL문을 실행
-- 		 처리 시간이 줄어든다.
-- 단점 : 재사용성이 나쁘다
-- 		 업무의 사양 변경 시 프로시저의 정의를 변경할 필요가 있다.
-- 프로시저 목록 화인 : show prodcedure status;
show procedure status;

/*
drop procedure if exists 프로시저명;
delimiter //
create procedure 프로시저명(
	in 매개변수명 자료형,   -- 매개변수
	out 리턴타입명 자료형,  -- 리턴타입
	리턴타입
)
begin
	쿼리문;
end //
delimiter ;
*/

-- 검색
use example;
drop procedure if exists select_buy;
delimiter //
create procedure select_buy(
	in in_name varchar(20),
    in in_mode int
)
begin
	if in_mode = 0 then
		select * from buy where product_name = in_name;
	end if;
	if in_mode <> 0 then
		select customer from buy where product_name = in_name;
    end if;
end //
delimiter ;

-- 호출방법 : call 프로시저명(매개변수, 리턴타입);
call select_buy('에이 나시', 1);

use test;
-- attend 학생 성적을 합한 결과에 따라 at_score를 결정하는 프로시저를 생성하고 테스트하세요
-- 매개변수로 at_num 가 주어짐  

drop procedure if exists update_attend;
delimiter //
create procedure update_attend(
	in in_at_num int  
)
begin
	-- 성적의 합을 저장할 변수 선언
    declare _sum int default 0;
    declare _score varchar(2) default 0;
    
    -- 성적의 합을 가져옴 : select를 통해
    set _sum = (select at_mid + at_final + at_attend + at_homework from attend where at_num = in_at_num);
    
    -- 성적에 따라
    if _sum >= 90 and _sum <= 100 then 
		set _score = 'A';
	end if;
	if _sum >= 80 and _sum < 90 then 
		set _score = 'B';
	end if;
    if _sum >= 70 and _sum < 80 then 
		set _score = 'C';
	end if;
    if _sum >= 60 and _sum < 70 then 
		set _score = 'D';
	end if;
    if _sum < 60 then 
		set _score = 'F';
	end if;
    
	update attend 
		set at_score = _score					 
		where at_num = in_at_num;
	select * from attend where at_num = in_at_num;
end //
delimiter ;

call update_attend(1);

-- 학생의 학번이 주어지면 주어진 학생의 이수학점을 계산하는 프로시저
-- at_st_num 주어지면 attend에 이수여부를 확인해서 subject su_point를 더해서 st_point 업데이트

drop procedure if exists update_student;
delimiter //
create procedure update_student(
	-- 매개변수 학번(at_st_num)
	in in_st_num int
)
begin
	-- 이수한 과목의 학점을 저장할 변수
    declare _sum int default 0;
    
    -- 이수한 과목의 학점을 가져와서 _sum에 저장 : select 이용
    set _sum = (select sum(su_point) from attend
					join course on at_co_num = co_num
					join subject on co_su_num = su_num
					where at_st_num = in_st_num and at_pass = 'Y');
    
    -- 이수한 학점 _sum 을 sutdent 테이블에 su_point 에 넣어줌 : update
    update student
		set st_point = _sum
        where st_num = in_st_num;
end //
delimiter ;

call update_student(2020456001);

-- 수강테이블의 이수 여부가 N -> Y로 수정되면 학생 이수학점을 계산하는 트리거

drop trigger if exists update_attend;
delimiter //
create trigger update_attend after update on attend
for each row
begin
	-- 정보가 변경된 학생의 학번 => new.at_st_num
	-- 이수 여부가 N -> Y로 수정되면
    if old.at_pass <> new.at_pass then
		call update_student(new.at_st_num);
    end if;
end //
delimiter ;

-- 대학수학을 들었던 모든 학생의 수
select count(*) from attend
	join course on at_co_num = co_num
    join subject on co_su_num = su_num
    where su_title = '대학수학';
    
select sum(co_attendee) from course
	join subject on su_num = co_su_num
    where su_title = '대학수학';
    
-- 김영철 학생이 들었던 강의 정보를 출력(년도, 학기, 과목명 순으로)
select at_num, co_year as '년도' , co_term as '학기' , su_title as '과목명' from attend
	join (select * from student where st_name = '김영철') as std on st_num = at_st_num
    join course on co_num = at_co_num
    join subject on su_num = co_su_num
    order by co_year desc, co_term desc, su_title asc;

-- 김영철 학생의 지도 교수님 이름을 출력
select st_name as '지도학생', pr_name as '지도교수' from guide
	join (select * from student where st_name = '김영철') as std on gu_st_num = st_num
    join professor on gu_pr_num = pr_num;
    
-- 강의 중 재수강 과목이면 at_repitition에 Y로 수정하세요
-- 수정 과정을 주석으로 설명하세요
select * from attend;
	
/*
select문을 이용해서 강의 테이블을 검색한다
 at_repitition에를 update를 이용해서 재수강여부를 판단하여 수정을한다
	- 재수강 판단 기준 : 같은 수업을 들었는지 확인 -> select문으로 attend를 검색을 하고
*/

-- 2020년도에 개강한 강의 리스트
select distinct su_title from course
	join subject on co_su_num = su_num
    where co_year = 2020;