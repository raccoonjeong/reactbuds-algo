-- JOIN
-- 보호소에서 중성화한 동물
-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
SELECT 
    ins.animal_id, 
    ins.animal_type, 
    ins.name
from ANIMAL_OUTS outs 
inner join ANIMAL_INS ins 
    on outs.animal_id = ins.animal_id
where 
    SUBSTRING_INDEX(ins.SEX_UPON_INTAKE, " ", 1) = 'Intact' 
    and SUBSTRING_INDEX(outs.SEX_UPON_OUTCOME, " ", 1) in ('Spayed', 'Neutered')
order by ins.animal_id, ins.animal_type, ins.name;