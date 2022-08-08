USE AdventureWorks2008R2;

--FUNCTION

GO
CREATE FUNCTION Sales.uf_getProoducts(@SalesOrderID int, @CurrencyCode nchar(3) ,@CurrencyRateDate datetime)
	RETURNS TABLE 
AS
	RETURN
	WITH Products
	AS (
		SELECT *
		FROM Sales.SalesOrderDetail AS sod 
		WHERE sod.SalesOrderID = @SalesOrderID
	)
	SELECT p.ProductID, p.OrderQty, p.UnitPrice, p.UnitPrice*scr.EndOfDayRate AS 'Converted Price'
	FROM Products AS p, Sales.CurrencyRate AS scr
	WHERE scr.ToCurrencyCode = @CurrencyCode
		AND scr.CurrencyRateDate = @CurrencyRateDate
