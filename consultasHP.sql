/***
Ver a los profesores que son head_teacher de una casa
***/
select h.name, p.last_name, p.first_name
	from house as h inner join person as p
					on h.head_teacher = p.id;
                    
select hp.giver, hp.points
	from house_points as hp left join person as p
					on hp.giver = p.id;

select * from person
;


select c.name
	from course as c
    where teacher_id = (
							select p.id
                            from person as p
                            where p.first_name = 'Sybill'
								and
									p.last_name ='Trelawney'
						);
start TRANSACTION;

delete 
	from enrollment 
    where person_enrollment = (
							select p.id
                            from person as p
                            where p.first_name = 'Harry'
								and
									p.last_name ='Potter'
						);
delete 
	from house_points 
    where receiver = (
							select p.id
                            from person as p
                            where p.first_name = 'Harry'
								and
									p.last_name ='Potter'
						);

delete 
	from person
    where first_name = 'Harry'
		and
			last_name ='Potter';

    
commit;
				