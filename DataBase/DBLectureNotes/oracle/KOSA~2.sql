-- Å×½ºÆ® 
select sysdate from dual;
-------------------------------------------------
--SQL JOIN¹®¹ý (´Ü¼ø)
select * 
from m, s, x
where m.m1 = s.s1 and s.s1 = x.x1;

-- ANSI ¹®¹ý (±ÇÀå)
select * 
from m join s on m.m1 = s.s1
       join x on s.s1 = x.x1;
--     join y on x.x1 = y.y1; °è¼Ó ºÙ¿©¾²¸é ¿©·¯ Å×ÀÌºí Á¶ÀÎ °¡´É!

-- HR°èÁ¤ ÀÌµ¿
show user;

-- USERÀÌ(°¡) "HR"ÀÔ´Ï´Ù.
select * from employees;
select * from departments;
select * from locations;

select count(*) from employees;
-- »ç¹ø, ÀÌ¸§(last_name), ºÎ¼­¹øÈ£, ºÎ¼­ÀÌ¸§À» Ãâ·ÂÇÏ¼¼¿ä
select e.employee_id, e.last_name, e.department_id, d.department_name
from employees e join departments d 
on e.department_id = d.department_id; 
-- »ç¿ø¼ö´Â 107¸í ÇÏÁö¸¸ joinÀ¸·Î ³ª¿Â µ¥ÀÌÅÍ´Â 106¸í >> ´©¶ôÀÚ°¡ ÀÖÀ½
select * from employees;
select * from employees where department_id is null; -- Á¶±ÝÀÖ´Ù°¡ >> outer join


-- »ç¹ø, ÀÌ¸§(last_name), ºÎ¼­¹øÈ£, ºÎ¼­ÀÌ¸§, Áö¿ªÄÚµå, µµ½Ã¸íÀ» Ãâ·ÂÇÏ¼¼¿ä
select * --e.employee_id, e.last_name, e.department_id, d.department_name
from employees e join departments d on e.department_id = d.department_id
                 join locations l on d.location_id = l.location_id;


-- KOSA °èÁ¤ ÀÌµ¿
show user;
-- USERÀÌ(°¡) "KOSA"ÀÔ´Ï´Ù.
select * from emp;
select * from salgrade;

--  »ç¿øÀÇ µî±Þ (ÇÏ³ªÀÇ ÄÃ·³À¸·Î ¸ÅÇÎ ¾ÈµÇ¿ä) >> ÄÃ·³ 2°³
-- ºñµî°¡ Á¶ÀÎ(non-equi) 1:1
-- ¹®¹ý µî°¡¿Í µ¿ÀÏ (ÀÇ¹Ì)

select * -- e.empno, e.ename, d.grade, e.sal
from emp e join salgrade d 
on e.sal between d.losal and d.hisal;



--outer join (equi  Á¶ÀÎ ¼±ÇàµÇ°í ³ª¼­ >> ³²¾ÆÀÖ´Â µ¥ÀÌÅÍ¸¦ °¡Á®¿À´Â ¹æ¹ý)
-- 1. ÁÖÁ¾ °ü°è (ÁÖÀÎÀÌ µÇ´Â ÂÊ¿¡ ³²¾ÆÀÖ´Â µ¥ÀÌÅÍ¸¦ °¡Á®¿À´Â ¹æ¹ý)
-- 2.  left outer join 
-- 2.1 right outer join
-- 2.2 full outer join ( left, right >> union)

select * 
from m left outer join s
on m.m1 = s.s1;

select * 
from m right outer join s
on m.m1 = s.s1;

select * 
from m full outer join s
on m.m1 = s.s1;

-- show user; -- HR °èÁ¤
-- ¾Æ±î ¹®Á¦ ¼öÁ¤
-- »ç¹ø, ÀÌ¸§(last_name), ºÎ¼­¹øÈ£, ºÎ¼­ÀÌ¸§À» Ãâ·ÂÇÏ¼¼¿ä
select e.employee_id, e.last_name, e.department_id, d.department_name
from employees e left join departments d 
on e.department_id = d.department_id; 
-- »ç¿ø¼ö´Â 107¸í >> ´©¶ôÀÚ ÇØ°á

-- self join (ÀÚ±âÂüÁ¶) -> ¹®¹ý µû·Î ¾øÀ½ -> ÀÇ¹Ì¸¸ Á¸Àç ->  µî°¡ join ¾²±â
-- ÇÏ³ªÀÇ Å×ÀÌºí¿¡ ÀÖ´Â ÄÃ·³ÀÌ ÀÚ½ÅÀÇ Å×ÀÌºí¿¡ ÀÖ´Â Æ¯Á¤ ÄÃ·³À» ÂüÁ¶ÇÏ´Â °æ¿ì
select * from emp;
-- smith  »ç¿øÀÇ »ç¼ö ÀÌ¸§
-- »ç¿ø Å×ÀÌºí, °ü¸®ÀÚ Å×ÀÌºí ¸¸µå´Â °ÍÀÌ..... >> Áßº¹µ¥ÀÌÅÍ..
-- Å×ÀÌºí °¡¸íÄª >> 2°³, 3°³ ÀÖ´Â °ÍÃ³·³
select e.empno, e.ename, m.empno, m.ename
from emp e join emp m
on e.mgr = m.empno;
-- 13¸í ...
-- 14¸í ... >> 
select e.empno, e.ename, m.empno, m.ename
from emp e left join emp m
on e.mgr = m.empno;
-----------------------------------------------------------------------------------------------------------
-- 1. »ç¿øµéÀÇ ÀÌ¸§, ºÎ¼­¹øÈ£, ºÎ¼­ÀÌ¸§À» Ãâ·ÂÇÏ¶ó.
select  ename, empno, dname 
from emp e left join dept d on e.deptno = d.deptno;
?

-- 2. DALLAS¿¡¼­ ±Ù¹«ÇÏ´Â »ç¿øÀÇ ÀÌ¸§, Á÷À§, ºÎ¼­¹øÈ£, ºÎ¼­ÀÌ¸§À»
-- Ãâ·ÂÇÏ¶ó.

select e.ename, e.job, e.deptno, m.dname
from emp e join dept m
on e.deptno = m.deptno
where loc = 'DALLAS';

-- 3. ÀÌ¸§¿¡ 'A'°¡ µé¾î°¡´Â »ç¿øµéÀÇ ÀÌ¸§°ú ºÎ¼­ÀÌ¸§À» Ãâ·ÂÇÏ¶ó.

select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where ename like '%A%';


-- 4. »ç¿øÀÌ¸§°ú ±× »ç¿øÀÌ ¼ÓÇÑ ºÎ¼­ÀÇ ºÎ¼­¸í, ±×¸®°í ¿ù±ÞÀ»
--Ãâ·ÂÇÏ´Âµ¥ ¿ù±ÞÀÌ 3000ÀÌ»óÀÎ »ç¿øÀ» Ãâ·ÂÇÏ¶ó.

select ename, dname, sal
from emp e left join dept d
on e.deptno = d.deptno
where sal >= 3000;


-- 5. Á÷À§(Á÷Á¾)°¡ 'SALESMAN'ÀÎ »ç¿øµéÀÇ Á÷À§¿Í ±× »ç¿øÀÌ¸§, ±×¸®°í
-- ±× »ç¿øÀÌ ¼ÓÇÑ ºÎ¼­ ÀÌ¸§À» Ãâ·ÂÇÏ¶ó.

select job, ename, dname
from emp e left join dept d
on e.deptno = d.deptno
where e.job = 'SALESMAN';

?
-- 6. Ä¿¹Ì¼ÇÀÌ Ã¥Á¤µÈ »ç¿øµéÀÇ »ç¿ø¹øÈ£, ÀÌ¸§, ¿¬ºÀ, ¿¬ºÀ+Ä¿¹Ì¼Ç,
-- ±Þ¿©µî±ÞÀ» Ãâ·ÂÇÏµÇ, °¢°¢ÀÇ ÄÃ·³¸íÀ» '»ç¿ø¹øÈ£', '»ç¿øÀÌ¸§',
-- '¿¬ºÀ','½Ç±Þ¿©', '±Þ¿©µî±Þ'À¸·Î ÇÏ¿© Ãâ·ÂÇÏ¶ó.
--(ºñµî°¡ ) 1 : 1 ¸ÅÇÎ ´ë´Â ÄÃ·³ÀÌ ¾ø´Ù

select empno as "»ç¿ø¹øÈ£", ename as "»ç¿øÀÌ¸§", sal as "¿¬ºÀ", (sal+comm) as "½Ç±Þ¿©", grade as "±Þ¿©µî±Þ"
from emp e join salgrade s on e.sal between s.losal and s.hisal 
where e.comm is not null;

/*
SELECT         E.EMPNO AS "»ç¿ø¹øÈ£",
               E.ENAME AS "»ç¿øÀÌ¸§",
               E.SAL*12 AS "¿¬ºÀ",
               --E.SAL*12+NVL(COMM,0) AS "½Ç±Þ¿©",
               E.SAL*12+COMM AS "½Ç±Þ¿©",
               S.GRADE AS "±Þ¿©µî±Þ"
FROM EMP E  join SALGRADE S on E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE E.Comm is not null;
*/


-- 7. ºÎ¼­¹øÈ£°¡ 10¹øÀÎ »ç¿øµéÀÇ ºÎ¼­¹øÈ£, ºÎ¼­ÀÌ¸§, »ç¿øÀÌ¸§,
-- ¿ù±Þ, ±Þ¿©µî±ÞÀ» Ãâ·ÂÇÏ¶ó.
-- inner ´Â »ý·« °¡´É

select d.deptno, d.dname, e.ename, e.sal, s.grade
from emp e left join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where d.deptno = 10;

-- 8. ºÎ¼­¹øÈ£°¡ 10¹ø, 20¹øÀÎ »ç¿øµéÀÇ ºÎ¼­¹øÈ£, ºÎ¼­ÀÌ¸§,
-- »ç¿øÀÌ¸§, ¿ù±Þ, ±Þ¿©µî±ÞÀ» Ãâ·ÂÇÏ¶ó. ±×¸®°í ±× Ãâ·ÂµÈ
-- °á°ú¹°À» ºÎ¼­¹øÈ£°¡ ³·Àº ¼øÀ¸·Î, ¿ù±ÞÀÌ ³ôÀº ¼øÀ¸·Î
-- Á¤·ÄÇÏ¶ó.
-- inner ´Â »ý·« °¡´É
select * from emp ;
select * from dept;
select * from salgrade;

select * 
from emp e left join dept d on e.deptno = d.deptno
                join salgrade s on e.sal between s.losal and s.hisal
where d.deptno in(10,20)
order by d.deptno asc, e.sal desc;

--
--select d.deptno, d.dname, e.ename, e.sal
--from emp e left join dept d
--on e.deptno = d.deptno
--where d.deptno = 10 or 20 -- in (10, 20)
--order by depno asc, sal desc;
/*
SELECT E.DEPTNO, D.DNAME, E.ENAME, E.SAL, S.GRADE
FROM EMP E  join DEPT D        on E.DEPTNO=D.DEPTNO
            join SALGRADE S    on E.SAL BETWEEN S.LOSAL AND S.HISAL
WHERE  E.DEPTNO<=20 --WHERE E.DEPTNO IN (10,20)  -- e.deptno = 10 or 
ORDER BY E.DEPTNO ASC,  E.SAL DESC;
*/

-- ?????????????????????????????????????????????????????????????????????????????????????????????????????????????¸Þ¸ðÀå¿¡¼­ ¹º°¡ Àß¸°µí

-- 9. »ç¿ø¹øÈ£¿Í »ç¿øÀÌ¸§, ±×¸®°í ±× »ç¿øÀ» °ü¸®ÇÏ´Â °ü¸®ÀÚÀÇ
-- »ç¿ø¹øÈ£¿Í »ç¿øÀÌ¸§À» Ãâ·ÂÇÏµÇ °¢°¢ÀÇ ÄÃ·³¸íÀ» '»ç¿ø¹øÈ£',
-- '»ç¿øÀÌ¸§', '°ü¸®ÀÚ¹øÈ£', '°ü¸®ÀÚÀÌ¸§'À¸·Î ÇÏ¿© Ãâ·ÂÇÏ¶ó.
--SELF JOIN (ÀÚ±â ÀÚ½ÅÅ×ÀÌºíÀÇ ÄÃ·³À» 
select * from emp;

select e1.empno as "»ç¿ø¹øÈ£", e1.ename as "»ç¿øÀÌ¸§", e2.empno as "°ü¸®ÀÚ¹øÈ£", e2.ename as "°ü¸®ÀÚÀÌ¸§"
from emp e1 join emp e2 on e1.mgr = e2.empno;

-----------------------------------------------------------
-- »ç¿ø Å×ÀÌºí¿¡¼­ »ç¿øµéÀÇ Æò±Õ ¿ù±Þº¸´Ù ´õ ¸¹Àº ¿ù±ÞÀ» ¹Þ´Â »ç¿øÀÇ »ç¹ø, ÀÌ¸§, ±Þ¿©¸¦ Ãâ·ÂÇÏ¼¼¿ä.
--1. Æò±Õ±Þ¿©
select avg(sal) from emp; --  Æò±Õ±Þ¿© 2073

select empno, ename, sal
from emp
where sal > 2073;

-- 2°³ÀÇ Äõ¸® ÅëÇÕ (ÇÏ³ªÀÇ Äõ¸®)
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);
-- ????????????????????????????????????????????????????????????????????????????????????????????????????????????

--------------------------------------------------------------------------------
--JOIN END----------------------------------------------------------------------

--subquery(¼­ºêÄõ¸®) 100page
--sql ²É .....¸¸´É ÇØ°á»ç 

--1. ÇÔ¼ö > ´ÜÀÏ Å×ÀÌºí > ´ÙÁß Å×ÀÌºí (join , union) > ÇØ°á ¾ÈµÇ¿ä >> subquery ÇØ°á

--»ç¿øÅ×ÀÌºí¿¡¼­ »ç¿øµéÀÇ Æò±Õ ¿ù±Þº¸´Ù ´õ ¸¹Àº ¿ù±ÞÀ» ¹Þ´Â »ç¿øÀÇ »ç¹ø, ÀÌ¸§, ±Þ¿©¸¦ Ãâ·ÂÇÏ¼¼¿ä

--1. Æò±Õ±Þ¿©
select avg(sal) from emp; --Æò±Õ±Þ¿© 2073

select empno , ename , sal 
from emp
where sal > 2073;

--2°³ÀÇ Äõ¸® ÅëÇÕ (ÇÏ³ªÀÇ Äõ¸®)

select empno , ename , sal 
from emp
where sal > (select avg(sal) from emp);


-- subquery
/*
1. single row subquery : ½ÇÇà°á°ú°¡ ´ÜÀÏ ÄÃ·³¿¡ ´ÜÀÏ·Î¿ì °ªÀÎ °æ¿ì (ÇÑ°³ÀÇ °ª)
ex) select sum(sal) from emp, select max (sal) from emp
¿¬»êÀÚ : = , != , < , >

2. multi row subquery : ½ÇÇà °á°ú°¡ ´ÜÀÏ ÄÃ·³¿¡ ¿©·¯°³ÀÇ ·Î¿ì°ªÀÎ °æ¿ì
ex) select deptno from emp, select sal from emp
¿¬»êÀÚ : IN, NOT IN, ANY, ALL
ALL : sal > 1000 and sal > 40000 and .....
ANY : sal > 1000 or sal > 40000 or .....

¹®¹ý) 
1. °ýÈ£¾È¿¡ ÀÖ¾î¾ß ÇÑ´Ù. (select max(sal) from emp)
2. ´ÜÀÏ ÄÃ·³À¸·Î ±¸¼ºµÇ¾î¾ß ÇÑ´Ù. (select max(sal), min(sal) from emp) ¼­ºêÄõ¸® ¾ÈµÇ¿ä. (x)
3. ¼­ºêÄõ¸®°¡ ´Üµ¶À¸·Î ½ÇÇà °¡´É 

¼­ºêÄõ¸®¿Í ¸ÞÀÎ Äõ¸®
1. ¼­ºêÄõ¸® ½ÇÇàµÇ°í ±× °á°ú¸¦ °¡Áö°í
2. ¸ÞÀÎ Äõ¸®°¡ ½ÇÇàµÈ´Ù.

TIP)
select (subquery) >> scala subquery
from (subquery) >> in line view (°¡»ó Å×ÀÌºí)
where (subquery) >> Á¶°Ç
https://gent.tistory.com/464 Âü°í -- 512 Âü°í ?

*/

-- »ç¿ø Å×ÀÌºí¿¡¼­ jonesÀÇ ±Þ¿©º¸´Ù ´õ ¸¹Àº ±Þ¿©¸¦ ¹Þ´Â»ç¿øÀÇ »ç¹ø, ÀÌ¸§, ±Þ¿©¸¦ Ãâ·ÂÇÏ¼¼¿ä
select empno, ename, sal
from emp
where sal > (select sal from emp where ename = 'JONES');

-- ºÎ¼­¹øÈ£°¡ 30¹øÀÎ »ç¿ø°ú °°Àº ±Þ¿©¸¦ ¹Þ´Â ¸ðµç »ç¿øÀ¸ Á¤º¸¸¦ Ãâ·ÂÇÏ¼¼¿ä
(select sal from emp where deptno = 30); -- multi row

select *
from emp
where sal in (select sal from emp where deptno = 30);
--where sal = (select sal from emp where deptno = 30); -- =  ¾²¸é  multi  query ¶ó ¾ÈµÊ
-- sal = 1600 or sal=1250 or ...

-- ºÎ¼­¹øÈ£°¡ 30¹øÀÎ »ç¿ø°ú ´Ù¸¥ ±Þ¿©¸¦ ¹Þ´Â ¸ðµç »ç¿øÀ¸ Á¤º¸¸¦ Ãâ·ÂÇÏ¼¼¿ä
select *
from emp
where sal not in (select sal from emp where deptno = 30);
-- sal != 1600 or sal != 1250 or ...

-- ºÎÇÏÁ÷¿øÀÌ ÀÖ´Â »ç¿øÀÇ »ç¹ø°ú ÀÌ¸§À» Ãâ·ÂÇÏ¼¼¿ä
-- ³» »ç¹øÀÌ mgr ÄÃ·³¿¡ ÀÖ´Ù¸é ³ª´Â ..^^
select empno, ename
from emp
where empno in (select mgr from emp); --  »ç¼öµé ¸ñ·Ï

-- ºÎÇÏÁ÷¿øÀÌ ¾ø´Â »ç¿øÀÇ »ç¹ø°ú ÀÌ¸§À» Ãâ·ÂÇÏ¼¼¿ä
select empno, ename
from emp
where empno not in (select nvl(mgr,0) from emp); --  ½ÅÀÔµé ¸ñ·Ï
-- null °ª ¶§¹®¿¡ ¾È³ª¿È : not inÀº and ¿¬»êÀÌ±â ¶§¹®¿¡ --
-- ¿Ü¿ì¶ó°í : not inÀº ºÎÁ¤ÀÇ and


-- king ¿¡°Ô º¸°íÇÏ´Â Áï Á÷¼Ó»ó°üÀÌ kingÀÎ »ç¿øÀÇ »ç¹ø, ÀÌ¸§, Á÷Á¾, °ü¸®ÀÚ »ç¹øÀ» Ãâ·ÂÇÏ¼¼¿ä
select empno, ename, job, mgr
from emp
where mgr in (select empno from emp where ename = 'KING');


-- 20¹ø ºÎ¼­ÀÇ »ç¿øÁß¿¡¼­ °¡Àå ¸¹Àº ±Þ¿©¸¦ ¹Þ´Â »ç¿øº¸´Ù ´õ ¸¹Àº ±Þ¿©¸¦ ¹Þ´Â »ç¿øÀÇ
-- »ç¹ø, ÀÌ¸§, ±Þ¿©, ºÎ¼­¹øÈ£¸¦ Ãâ·ÂÇÏ¼¼¿ä
select empno, ename, sal, deptno
from emp
where sal > ( select max(sal) from emp where deptno = 20);

-- ½ºÄ®¶ó ¼­ºêÄõ¸®
select e.empno, e.ename, e.deptno, (select d.dname from dept d where d.deptno = e.deptno)
from emp e
where e.sal >= 3000;

--#############################
--½Ç¹«¿¡¼­ ¸¹ÀÌ »ç¿ë (ÃÊÁß±Þ)
--hint) ¸¸¾à¿¡ ºÎ¼­¹øÈ£¿Í ºÎ¼­ÀÇ Æò±Õ ¿ù±ÞÀ» ´ã°íÀÖ´Â Å×ÀÌºíÀÌ Á¸ÀçÇÏ´Ù¸é (¸Þ¸ð¸®¿¡)
--in line view 
-- ÀÚ±â ºÎ¼­ÀÇ Æò±Õ ¿ù±Þº¸´Ù ´õ ¸¹Àº ¿ù±ÞÀ» ¹Þ´Â »ç¿øÀÇ »ç¹ø, ÀÌ¸§, ºÎ¼­¹øÈ£, ºÎ¼­º° Æò±Õ ¿ù±Þ Ãâ·ÂÇÏ¼¼¿ä

-- ±³¼ö´Ô Ç®ÀÌ
select a.empno, a.ename, a.deptno, a.sal, b.avgsal 
from emp a join (select deptno, trunc(avg(sal), 0) as avgsal from emp group by deptno) b 
on a.deptno = b.deptno
where a.sal > b.avgsal;

-- ³» Ç®ÀÌ
select a.empno, a.ename, a.deptno, a.sal, b.avgsal
from emp a
    ,(select  d.deptno, trunc(avg(sal)) as avgsal
    from emp e left join dept d on e.deptno = d.deptno
    group by d.deptno) b
where a.deptno = b.deptno and a.sal > b.avgsal;

------------------------------------------------------------------------------------------------------------
--subquery END----------------------------------------------------------------------------------------------
--¿¬½À¹®Á¦ (25ºÐ±îÁö)
/*
--1. 'SMITH'º¸´Ù ¿ù±ÞÀ» ¸¹ÀÌ ¹Þ´Â »ç¿øµéÀÇ ÀÌ¸§°ú ¿ù±ÞÀ» Ãâ·ÂÇÏ¶ó.

--2. 10¹ø ºÎ¼­ÀÇ »ç¿øµé°ú °°Àº ¿ù±ÞÀ» ¹Þ´Â »ç¿øµéÀÇ ÀÌ¸§, ¿ù±Þ,
-- ºÎ¼­¹øÈ£¸¦ Ãâ·ÂÇÏ¶ó.

--3. 'BLAKE'¿Í °°Àº ºÎ¼­¿¡ ÀÖ´Â »ç¿øµéÀÇ ÀÌ¸§°ú °í¿ëÀÏÀ» »Ì´Âµ¥
-- 'BLAKE'´Â »©°í Ãâ·ÂÇÏ¶ó.

--4. Æò±Õ±Þ¿©º¸´Ù ¸¹Àº ±Þ¿©¸¦ ¹Þ´Â »ç¿øµéÀÇ »ç¿ø¹øÈ£, ÀÌ¸§, ¿ù±ÞÀ»
-- Ãâ·ÂÇÏµÇ, ¿ù±ÞÀÌ ³ôÀº »ç¶÷ ¼øÀ¸·Î Ãâ·ÂÇÏ¶ó.

--5. ÀÌ¸§¿¡ 'T'¸¦ Æ÷ÇÔÇÏ°í ÀÖ´Â »ç¿øµé°ú °°Àº ºÎ¼­¿¡¼­ ±Ù¹«ÇÏ°í
-- ÀÖ´Â »ç¿øÀÇ »ç¿ø¹øÈ£¿Í ÀÌ¸§À» Ãâ·ÂÇÏ¶ó.

--6. 30¹ø ºÎ¼­¿¡ ÀÖ´Â »ç¿øµé Áß¿¡¼­ °¡Àå ¸¹Àº ¿ù±ÞÀ» ¹Þ´Â »ç¿øº¸´Ù
-- ¸¹Àº ¿ù±ÞÀ» ¹Þ´Â »ç¿øµéÀÇ ÀÌ¸§, ºÎ¼­¹øÈ£, ¿ù±ÞÀ» Ãâ·ÂÇÏ¶ó.
--(´Ü, ALL(and) ¶Ç´Â ANY(or) ¿¬»êÀÚ¸¦ »ç¿ëÇÒ °Í)

--7. 'DALLAS'¿¡¼­ ±Ù¹«ÇÏ°í ÀÖ´Â »ç¿ø°ú °°Àº ºÎ¼­¿¡¼­ ÀÏÇÏ´Â »ç¿øÀÇ
-- ÀÌ¸§, ºÎ¼­¹øÈ£, Á÷¾÷À» Ãâ·ÂÇÏ¶ó.

--8. SALES ºÎ¼­¿¡¼­ ÀÏÇÏ´Â »ç¿øµéÀÇ ºÎ¼­¹øÈ£, ÀÌ¸§, Á÷¾÷À» Ãâ·ÂÇÏ¶ó.

--9. 'KING'¿¡°Ô º¸°íÇÏ´Â ¸ðµç »ç¿øÀÇ ÀÌ¸§°ú ±Þ¿©¸¦ Ãâ·ÂÇÏ¶ó
--king ÀÌ »ç¼öÀÎ »ç¶÷ (mgr µ¥ÀÌÅÍ°¡ king »ç¹ø)

--10. ÀÚ½ÅÀÇ ±Þ¿©°¡ Æò±Õ ±Þ¿©º¸´Ù ¸¹°í, ÀÌ¸§¿¡ 'S'°¡ µé¾î°¡´Â
-- »ç¿ø°ú µ¿ÀÏÇÑ ºÎ¼­¿¡¼­ ±Ù¹«ÇÏ´Â ¸ðµç »ç¿øÀÇ »ç¿ø¹øÈ£, ÀÌ¸§,
-- ±Þ¿©¸¦ Ãâ·ÂÇÏ¶ó.

--11. Ä¿¹Ì¼ÇÀ» ¹Þ´Â »ç¿ø°ú ºÎ¼­¹øÈ£, ¿ù±ÞÀÌ °°Àº »ç¿øÀÇ
-- ÀÌ¸§, ¿ù±Þ, ºÎ¼­¹øÈ£¸¦ Ãâ·ÂÇÏ¶ó.

--12. 30¹ø ºÎ¼­ »ç¿øµé°ú ¿ù±Þ°ú Ä¿¹Ì¼ÇÀÌ °°Áö ¾ÊÀº
-- »ç¿øµéÀÇ ÀÌ¸§, ¿ù±Þ, Ä¿¹Ì¼ÇÀ» Ãâ·ÂÇÏ¶ó.
*/

-- 1¹ø
select ename, sal
from emp
where sal > (select sal from emp where ename ='SMITH'); 

-- 2¹ø
select ename, sal, deptno
from emp
where sal IN (select sal 
from emp 
where deptno = 10);

--select sal from emp where deptno = 10;

--3 ¹ø

select ename, hiredate
from emp
where deptno = (select deptno 
from emp
where ename = 'BLAKE') and ename != 'BLAKE';

-- 4¹ø
--select trunc(avg(sal), 0) 
--from emp;
select empno, ename, sal
from emp
where sal > (select trunc(avg(sal), 0) from emp)
order by sal desc;

-- 5¹ø
--select distinct deptno 
--from emp
--where ename like '%T%';

select empno, ename
from emp
where deptno IN (select distinct deptno 
from emp
where ename like '%T%');

/* ´Ù½Ã º¸±â ****
SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO
                FROM EMP
                WHERE ENAME LIKE '%T%');
*/

-- 6¹ø **
--select max(sal)
--from emp
--where deptno = 30;
select ename, deptno, sal
from emp
where sal > (select max(sal)
from emp
where deptno = 30);

/* Áß¿ä************************
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL > ALL(SELECT SAL
                FROM EMP
                WHERE DEPTNO=30)
 
--where sal > 1600 and sal > 1250 and sal > 2850 and sal > 1500 and sal > 950
 
*/


-- 7¹ø
select deptno, ename, job
from emp
where deptno = (select deptno  -- IN ¾²±â
from dept
where loc = 'DALLAS');

-- 8¹ø
select deptno, ename, job
from emp
where deptno = (select deptno 
from dept
where dname = 'SALES');

-- 9 ¹ø
select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING');

--10¹ø
select empno, ename, sal
from emp
where deptno = (
select distinct deptno 
from emp
where sal >(select trunc(avg(sal), 0) 
from emp) and ename like '%S%');

/*
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL)
             FROM EMP)
AND DEPTNO IN(SELECT DEPTNO
              FROM EMP
              WHERE ENAME LIKE '%S%');
              
  ¶Ç´Â            
--select * from emp
--where  deptno in  (
--                      select deptno from emp where sal > (select avg(sal) from emp)
--                      and ename like '%S%'
--                   )
*/

-- 11¹ø

select *
from emp
where deptno IN (select distinct deptno
from emp
where comm is not null) 
and sal IN (select distinct deptno
from emp
where comm is not null);

-- 12¹ø


/*
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO
                FROM EMP
                WHERE COMM IS NOT NULL)
AND SAL IN( SELECT SAL
            FROM EMP
            WHERE COMM IS NOT NULL);
            
            
SELECT ENAME, SAL, COMM
FROM EMP
WHERE SAL NOT IN(SELECT SAL
                 FROM EMP
                 WHERE DEPTNO=30)
AND COMM NOT IN(SELECT NVL(COMM, 0)
                FROM EMP
                WHERE DEPTNO=30 and comm is not null);       
            
*/

--------------------------------------------------------------------------------
--subquery END------------------------------------------------------------------
-- Á¦ 8Àå    SQL*Plus ¸í·Á¾î »ç¿ë¹ý »ý·«ÇÏ¼¼¿ä
-- Á¦ 9Àå Å×ÀÌºí »ý¼º
-- Á¦ 10Àå µ¥ÀÌÅÍ Á¶ÀÛ
-- ¼ö¾÷Àº 10Àå ¸ÕÀú ÇÏ°í ... 9Àå ÇÏµµ·Ï ÇÏ°Ú½À´Ï´Ù.
--------------------------------------------------------------------------------
--TIP)
select * from emp order by 1,2,3; --1,2,3¹øÂ° ÄÃ·³ ¼øÀ¸·Î ¿À¸§Â÷¼ø Á¤·Ä
                                  -- order by empno , ename , job µ¿ÀÏ
                                  
select deptno ,sal , empno from emp order by 1 desc,2; 
                                  -- order by deptno desc , sal asc µ¿ÀÏ
                                  
/*                                  
Áö±Ý±îÁö ÃÊ±Þ °³¹ßÀÚ ÇÊ¼ö »çÇ×
select
from 
where 
group by
having
order by
+
±âº» ÇÔ¼ö (¹®ÀÚ,¼ýÀÚ,³¯Â¥,º¯È¯,ÀÏ¹Ý,Áý°è)
+ 
´ÙÁßÅ×ÀÌºí (JOIN , UNION)
+
subquery ±îÁö 
+ 
±âº»ÀûÀÎ DML ±¸¹® (ÇÊ¼ö ¾Ï±â) ÀÔ´Ï´Ù
                                 
*/                        
--------------------------------------------------------------------------------
--µ¥ÀÌÅÍ Á¶ÀÛ(DML) ÀÔ´Ï´Ù
-- 168 page
-- insert, update, delete ( ¹Ýµå½Ã ¾Ï±â)

/*
DDL (µ¥ÀÌÅÍ Á¤ÀÇ¾î) :  create, alter, drop, truncate, rename, modify 
--      (truncate : )
DML (µ¥ÀÌÅÍ Á¶ÀÛ¾î) : Æ®·£Àè¼ÇÀ» ÀÏÀ¸Å°´Â ÀÛ¾÷ : insert, update, delete
ex) °³¹ßÀÚ ... È¸»ç °©ÀÚ±â ...DB select Àß µÇ´Âµ¥ insert, update, delete  ¾ÈµÇ¿ä
    >> °©ÀÚ±â log write ¸¦ ¼öÇàÇÏ´Â ÀÛ¾÷ (´©°¡ ¾ðÁ¦ ¾î¶² Å×ÀÌºí¿¡ ¹«½¼ÀÛ¾÷À» Çß´ÂÁö ±â·Ï)
    >> DISK ±â·Ï (log file full) >>  log write ¾ÈµÇ¸é >> DML ÀÛ¾÷ ¸øÇÔ
    >> log backup >> log  »èÁ¦ .....
    
    >> commit ÇÏÁö ¾ÊÀº °æ¿ì .....   ½Ç½À..... ÀÏ»ó ´Ù¹Ý»ç´Ï±î ÁÖÀÇÇÏ±â! 
DQL (µ¥ÀÌÅÍ ÁúÀÇ¾î) :  select    -- QUERY ÀÇ q
DCL (µ¥ÀÌÅÍ Á¦¾î¾î) :  °ü¸®ÀÚ : grant, revoke     -- control ÀÇ c
TCL (Æ®·£Àè¼Ç)     :  commit, rollback, savepoint

*/
-- ¿À¶óÅ¬  insert, update, delete  ÀÛ¾÷ ¹Ýµå½Ã commit , rollback  Ã³¸®
-- Tip) tab, col Å×ÀÌºí »ç¿ëÇÏ±â
select * from tab; -- »ç¿ëÀÚ(KOSA) °èÁ¤ÀÌ °¡Áö°í ÀÖ´Â Å×ÀÌºí ¸ñ·Ï

-- ³»°¡ Å×ÀÌºíÀ» »ý¼º .. ±× ÀÌ¸§ÀÌ ÀÖ´ÂÁö ¾ø´ÂÁö
select * from tab where tname = 'BOARD';
select * from tab where tname = 'EMP';
select * from col where tname = 'EMP';
---------------------------------------------------------------------------------
-- insert, update, delete ¹«Á¶°Ç ¾Ï±â

-- 1. INSERT
create table temp(
    id number primary key, -- not null, unique ¹Þ°Ú´Ù (È¸¿ø ID, ÁÖ¹Î¹øÈ£)
    name varchar2(20)
);
desc temp; -- temp Á¤º¸¸¦ º¼ ¼ö ÀÖÀ½.

--1. ÀÏ¹ÝÀûÀÎ  insert
insert into temp(id, name)
values(100, 'È«±æµ¿');
--commit, rolback ÇÏ±â Àü±îÁö ½Ç¹Ý¿µÇÏÁö ¾Ê¾Æ¿ä
select * from temp;
commit;

--2. ÄÃ·³ ¸ñ·ÏÀ» »ý·«( insert ) ¾²Áö ¸¶¼¼¿ä
insert into temp
 values(200, '±èÀ¯½Å');

 select * from temp;
 rollback; -- Ä¿¹Ô Àü ·Ñ¹éÇÏ¸é insert ¸¦ µÇµ¹¸± ¼ö ÀÖ´Ù.
 
 -- 3. ¹®Á¦  ... insert
 insert into temp(name)
 values('¾Æ¹«°³');
 -- ÀÚµ¿ id ÄÃ·³ >> null >> PK >> ORA-01400: cannot insert NULL into ("KOSA"."TEMP"."ID")
 -- null °ª ³ÖÀ» ¼ö ¾ø´À†« ³Ö¾î¼­ ¿¡·¯
 
 insert into temp(id, name)
 values(100, '°³¶ËÀÌ');
 -- PK >> id >> Áßº¹ µ¥ÀÌÅÍ(x) >> ORA-00001: unique constraint (KOSA.SYS_C007003) violated
 
 insert into temp (id, name)
 values(200, 'Á¤»óÀÌ');
 
 select * from temp;
 commit;
 
 ------------------------------------------------------------------------------------------
 --Tip
 --SQL Àº ÇÁ·Î±×·¥Àû ¿ä¼Ò (x) 
 --PL-SQL º¯¼ö, Á¦¾î¹®
 
 create table temp2(id varchar2(50));
 desc temp2;
 
 --PL-SQL
 -- for(int i =1; i <= 100; i++) { }
 /*
 BEGIN
    FOR i IN 1..100 LOOP
        insert into temp2(id) values('A' || to_char(i));
    END LOOP;
 END;
 -- ºí·Ï Àâ°í ½ÇÇà, ½ÇÇà ÈÄ ÁÖ¼® ÇÊ¼ö : PL/SQL ÇÁ·Î½ÃÀú°¡ ¼º°øÀûÀ¸·Î ¿Ï·áµÇ¾ú½À´Ï´Ù.
 */
 select * from temp2;
 
 create table temp3(
    memberid number(3) not null, -- 3ÀÚ¸® Á¤¼ö
    name varchar2(10), -- null  Çã¿ë
    regdate date default sysdate --Å×ÀÌºí ±âº»°ª ¼³Á¤ (insert ÇÏÁö ¾ÊÀ¸¸é ÀÚµ¿ (³¯Â¥) µé¾î°¡°Ô ÇÏ°Ú´Ù)
 );
 desc temp3;
 
 select sysdate from dual;
 
 --1. Á¤»ó
 insert into temp3 (memberid, name, regdate)
 values(100, 'È«±æµ¿', '2023-04-19');
 
 select * from temp3;
 commit;
 
 --2. ³¯Â¥
 insert into temp3 (memberid, name)
 values(200, '±èÀ¯½Å');
 
 select * from temp3;
 commit;
 
 --3. ÄÃ·³ ÇÏ³ª
 insert into temp3(memberid)
 values(300);
 
 select * from temp3;
 commit;
 
 -- 4. ¿À·ù
 insert into temp3 (name) -- id null °ª >> not null
 values('´Ï´©±¸');
 -- ORA-01400: cannot insert NULL into ("KOSA"."TEMP3"."MEMBERID")
 
 --------------------------------------------------------------------------------
--TIP)
create table temp4(id number);
create table temp5(num number);

desc temp4;
desc temp5;
 
insert into temp4(id) values(1);
insert into temp4(id) values(2);
insert into temp4(id) values(3);
insert into temp4(id) values(4);
insert into temp4(id) values(5);
insert into temp4(id) values(6);
insert into temp4(id) values(7);
insert into temp4(id) values(8);
insert into temp4(id) values(9);
insert into temp4(id) values(10);
commit;
         
select * from temp4;
--´ë·® µ¥ÀÌÅÍ »ðÀÔÇÏ±â
select * from temp5;
--temp4 Å×ÀÌºí¿¡ ¸ðµç µ¥ÀÌÅÍ¸¦ temp5  ³Ö°í ½Í¾î¿ä
--insert into Å×ÀÌºí¸í(ÄÃ·³¸®½ºÆ®) values ...
--insert into Å×ÀÌºí¸í(ÄÃ·³¸®½ºÆ®) select Àý *****************^^
-------------------------------------------------?????????????????????????????????????????????????????????????
insert into temp5(num)
select id from temp4; --´ë·® µ¥ÀÌÅÍ »ðÀÔ

select * from temp5;
commit;

-- 2. ´ë·® µ¥ÀÌÅÍ »ðÀÔÇÏ±â
-- µ¥Ÿæ¸¦ ´ãÀ» Å×ÀÌºíµµ ¾ø°í >> Å×ÀÌºí ±¸Á¶(º¹Á¦) : ½ºÅ°¸¶ + µ¥ÀÌÅÍ »ðÀÔ
-- ´Ü Á¦¾àÁ¤º¸´Â º¹Á¦ ¾ÈµÇ¿ä (PK, FK)
-- ¼ø¼öÇÑ µ¥ÀÌÅÍ ±¸Á¶ + µ¥ÀÌÅÍ

create table copyemp
as 
    select * from emp;
select * from copyemp;
create table copyemp2
as 
    select empno, ename, sal
    from emp
    where deptno = 30;
    
select * from copyemp2;

-- Åä¸· ÄûÁî
-- Æ²¸¸ (½ºÅ°¸¶) º¹Á¦ µ¥ÀÌÅÍ´Â º¹»çÇÏ°í ½ÍÁö ¾Ê¾Æ¿ä

create table copyemp3
as 
    select * from emp where 1=2; -- ÀÏºÎ·¯ °ÅÁþ Á¶°Ç ³Ö¾î¼­ Æ²¸¸ º¹»ç
select * from copyemp3;
/*
create table copyemp4
as 
    select * from emp where 1=1; -- ÀÌ·¸°Ô ÇÏ¸é ±×³É º¹»ç
*/

----------------------------------------------------------------------------------------
--INSERT END----------------------------------------------------------------------------

--UPDATE
/*
update  Å×ÀÌºí¸í
set ÄÃ·³¸í = °ª, ÄÃ·³¸í = °ª, ÄÃ·³¸í = °ª.......
where  Á¶°ÇÀý

update Å×ÀÌºí ¸í
set ÄÃ·³¸í = (subquery)
where ÄÃ·³¸í = (subquery)

*/

select * from copyemp;

update copyemp
set sal = 0;

select * from copyemp;

rollback;

update copyemp
set sal = 1111
where deptno = 20;

select * from copyemp;

rollback;

update copyemp
set sal = (select sum(sal) from emp);

select * from copyemp;
rollback;

update copyemp
set ename = 'AAA', job = 'BBB', hiredate = sysdate, sal = (select sum(sal) from emp)
where empno = 7788;

select * from copyemp
where empno = 7788;

commit;
-------------------------------------------------------------------------------------
--UPDATE END-------------------------------------------------------------------------

-- DELETE
delete from copyemp;
select * from copyemp;
rollback;

delete from copyemp
where deptno = 20;

select * from copyemp where deptno = 20;
commit;

-------------------------------------------------------------------------------------
--DELETE END-------------------------------------------------------------------------
drop table test;
select * from test;
create table test(num number, 
                  email varchar(100), 
                  name varchar(50),
                  jumin varchar(14),
                  phonenum varchar(13),
                  postnum varchar(5)
                  );
insert into test(num, email, name, jumin, phonenum, postnum)
values(1, 'dnskdms@naver.com', '¿ì³ªÀº', '123215-1236485' , '010-1235-1254', '16-14');
insert into test(num, email, name, jumin, phonenum, postnum)
values(2, 'chlgusehd123@naver.com', 'ÃÖÇöµ¿', '123215-1235364', '010-1234-4567', '01614');
insert into test(num, email, name, jumin, phonenum, postnum)
values(3, 'changhyun@gmail.com', '±èÃ¢Çö', '123215-1452364', '010-1236-4569', '456');
insert into test(num, email, name, jumin, phonenum, postnum)
values(4, 'a -sd f', 'Á¶º´±¹', '123215-2212364', '010-5486-8456', 'asd');
insert into test(num, email, name, jumin, phonenum, postnum)
values(5, 'asfda@asdf', 'Àå¼®Áø', '123215-12364as', '010-845*466-5', 'asdasd');
insert into test(num, email, name, jumin, phonenum, postnum)
values(6, 'dh3t2md1ghks@yahoo.co.kr', '¿À½ÂÈ¯', '123215-12364a', '010-  54-5555', '12345');
insert into test(num, email, name, jumin, phonenum, postnum)
values(6, 'dh3t2md1ghks@yahoo.co.kr', 'jackson', '123215-12364a', '010-1--4-----', '125 6');
insert into test(num, email, name, jumin, phonenum, postnum)
values(4, 'a -sd f', 'harry', '123215-2212364', '010-2154-585a', '00202');

-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÀü
select * from test;
-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÈÄ : ÀÌ¸ÞÀÏ
select * from test
where regexp_like(email, '^[a-z0-9\.\-_]+@([a-z0-9\-]+\.)+[a-z]{2,6}$');



-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÀü
select * from test;
-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÈÄ : ÀÌ¸§
select * from test
where regexp_like(name, '^[°¡-ÆR]{2,4}$');


-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÀü
select * from test;
-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÈÄ : ÁÖ¹Î¹øÈ£
select * from test 
where regexp_like(jumin ,'^[0-9]{6}+[-]+[0-9]{7}$');

-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÀü
select * from test;
-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÈÄ : ÈÞ´ëÀüÈ­¹øÈ£
select * from test 
where regexp_like(phonenum ,'^[0][1]\d{1}-\d{4}-\d{4}$');

-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÀü
select * from test;
-- Á¤±ÔÇ¥Çö½Ä »ç¿ëÈÄ : ¿ìÆí¹øÈ£
select * from test 
where regexp_like(postnum ,'^\d{5}$');
