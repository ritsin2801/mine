USE AdventureWorks2008R2;

--PROCEDURE
GO
CREATE PROCEDURE Person.up_getNamsByType
	@Type nchar(2) = 'EM'
AS
SELECT FirstName FROM Person.Person WHERE PersonType = @Type
GO

--EXEC Person.up_getNamsByType @Type ='SC'

