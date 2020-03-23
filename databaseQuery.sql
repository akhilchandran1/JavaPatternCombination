CREATE TABLE country (

Code CHAR(3) NOT NULL,
Name CHAR(52) NOT NULL,
Continent ENUM('Asia', 'Europe', 'North America', 'Africa', 'Oceania', 'Antarctica', 'South America') NOT NULL,
SurfaceArea FLOAT(10,2) NOT NULL,
HeadOfState CHAR(60),

PRIMARY KEY (Code)


);