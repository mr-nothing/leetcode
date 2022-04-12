select 	product_id,
		'store1',
		store1 as price
from 	products
having price is not null
	union
select	product_id,
		'store2',
		store2 as price
from products
having price is not null
	union
select 	product_id,
		'store3',
		store3 as price
from products
having price is not null