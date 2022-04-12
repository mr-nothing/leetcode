select 	name,
		(select sum(t.amount) from Transactions t where account = u.account) as balance
from Users u
having balance > 10000