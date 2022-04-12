select distinct
	sell_date as sell_date,
	count(distinct product) as num_sold,
	array_to_string(array_agg(distinct product order by product), ', ') as products
from activities
group by sell_date
order by sell_date