USE AdventureWorks2008R2;

--1.1

select count(*) from Sales.SalesPerson;

--1.2

select FirstName,LastName from Person.Person where FirstName like 'B%';

--1.3

SELECT p.FirstName + ' ' + p.LastName AS 'Full Name'
FROM Person.Person AS p, HumanResources.Employee AS e
WHERE e.BusinessEntityID = p.BusinessEntityID 
    AND e.JobTitle IN ('Design Engineer','Tool Designer','Marketing Assistant');

--1.4

SELECT Name, Color 
FROM Production.Product
WHERE [Weight] = (SELECT MAX([Weight]) FROM Production.Product);

--1.5

SELECT [Description], COALESCE(MaxQty, 0.00)   
FROM Sales.SpecialOffer;

--1.6

SELECT AVG(AverageRate) AS 'Average Exchange Rate'
FROM Sales.CurrencyRate
WHERE FromCurrencyCode = 'USD' 
	AND ToCurrencyCode = 'GBP' 
	AND YEAR(CurrencyRateDate) = 2012;

--1.7

SELECT ROW_NUMBER() OVER(ORDER BY FirstName, LastName) AS 'Sr. No.', FirstName, LastName
FROM Person.Person
WHERE FirstName LIKE '%ss%';

--1.8

SELECT BusinessEntityID AS 'SalesPersonID',
	CASE
		WHEN CommissionPct = 0.0 then 'BAND 0'
		WHEN CommissionPct > 0.0 AND CommissionPct <=0.01 then 'BAND 1'
		WHEN CommissionPct > 0.01 AND CommissionPct <=0.015 then 'BAND 2'
		WHEN CommissionPct > 0.015 then 'BAND 3'
		END AS 'Commission Band'
FROM Sales.SalesPerson;

--1.9

DECLARE @ID int;
SELECT @ID = BusinessEntityID 
FROM Person.Person 
WHERE FirstName = 'Ruth' 
	AND LastName = 'Ellerbrock'
	AND PersonType = 'EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @ID;

--1.10

SELECT MAX(dbo.ufnGetStock(ProductID)) FROM Production.Product;


