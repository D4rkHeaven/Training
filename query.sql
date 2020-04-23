select * from products p 
where title like '% ALADDIN';


select * from products p
where p.price = 9.99 and category = 8
order by category,price;


select * from products
where category in(8,15);


select * from products p2
where price between 10 and 20;


select * from orders
where orderdate >= '2004-01-05'::date and orderdate < '2004-02-05'::date


select customerid, count(customerid) from orders
group by customerid
order by customerid;


select customerid, orderdate, sum(totalamount) from orders
group by customerid,orderdate,totalamount 
having totalamount > 100;


select distinct c.firstname || ' ' || c.lastname as fullname, p.title, o.orderdate from customers c
join orders o on o.customerid = c.customerid
join orderlines ol on ol.orderid = o.orderid
join products p on p.prod_id = ol.prod_id ;