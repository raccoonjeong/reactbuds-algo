# select 
#     CAR_ID,
#     CAR_TYPE,
#     FEE
# from (
#     select 
#         c.car_id, 
#         c.car_type, 
#         round(c.daily_fee * 30 * (100 - p.DISCOUNT_RATE) / 100) as FEE
#     from CAR_RENTAL_COMPANY_CAR c 
#     inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.car_type = p.car_type
#     where c.car_id not in 
#         (select 
#             h.car_id
#          from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
#          where 
#             (
#                 h.START_DATE between '2022-11-01' and '2022-11-30'
#                 or h.END_DATE between '2022-11-01' and '2022-11-30'
#             )
#             or 
#              (
#                  h.START_DATE < '2022-11-01' and h.END_DATE > '2022-11-30'
#              )
#         )
#         and c.car_type in ('세단', 'SUV')
#         and p.duration_type = '30일 이상') as A
# where fee >= 500000 and fee < 2000000
# order by fee desc, car_type asc, car_id desc;


select 
    CAR_ID,
    CAR_TYPE,
    FEE
from (
    select 
        c.car_id, 
        c.car_type, 
        round(c.daily_fee * 30 * (100 - p.DISCOUNT_RATE) / 100) as FEE
    from CAR_RENTAL_COMPANY_CAR c 
    inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.car_type = p.car_type
    where c.car_id not in 
        (select 
            h.car_id
         from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
         where 
             h.START_DATE <= '2022-11-30' and h.END_DATE >= '2022-11-01'
        )
        and c.car_type in ('세단', 'SUV')
        and p.duration_type = '30일 이상') as A
where fee >= 500000 and fee < 2000000
order by fee desc, car_type asc, car_id desc;