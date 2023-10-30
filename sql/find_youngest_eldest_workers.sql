select 'YOUNGEST' as type,name,birthday
from worker
where birthday = (select min(birthday) from worker)
union all
select 'ELDEST' as type, name, birthday
from worker
where birthday = (select max(birthday) from worker)