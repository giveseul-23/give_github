/*
    특수 Query
    
    CASE
    DECODE
*/

--  CASE =? SWITCH
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
        WHEN '515' THEN '서울'
        WHEN '590' THEN '부산'
        WHEN '659' THEN '광주'
        WHEN '603' THEN '강릉'
        ELSE '기타'
    END 
FROM employees;
-- 다른 방법
SELECT employee_id, first_name, phone_number,
    CASE 
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '서울'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '부산'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '광주'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '강릉'
        ELSE '기타'
    END 
FROM employees;


-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE( SUBSTR(phone_number, 1, 3), 
            '515' ,'서울',
            '590' ,'부산',
            '659' ,'광주',
            '603' , '강릉',
            '기타'
    )
FROM employees