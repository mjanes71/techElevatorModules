
SELECT ALL name FROM city;
SELECT DISTINCT name FROM city; --this eliminates repeats (duplicate values)

-- The name and population of all cities in the USA with a population of greater than 1 million people
SELECT * FROM city;
SELECT name, population FROM city WHERE countrycode = 'USA' AND population > 1000000;

-- The name and population of all cities in China with a population of greater than 1 million people
SELECT code FROM country WHERE name = 'China';
SELECT * FROM country; -- used the two lines above 12 to find what we needed for 12
SELECT name, population FROM city WHERE countrycode = 'CHN' AND population > 1000000;

-- The name and region of all countries in North or South America
SELECT * FROM country;
SELECT name, region FROM country WHERE continent IN ('North America', 'South America');
  
-- The name, continent, and head of state of all countries whose form of government is a monarchy

SELECT * FROM country;
SELECT name, continent, headofstate, governmentform FROM country WHERE governmentform LIKE '%Monarchy%'; -- % at beginning of monary says "anything that ends in monarchy, % at end says "anything that begins with monarchy"

-- The name, country code, and population of all cities with a population less than one thousand people

SELECT * FROM country;
SELECT name, countrycode, population FROM city WHERE population < 1000;

-- The name and region of all countries in North or South America except for countries in the Caribbean

SELECT name, region 
FROM country 
WHERE continent IN ('North America', 'South America') AND region <> 'Caribbean';

-- The name, population, and GNP of all countries with a GNP greater than $1 trillion dollars and a population of less than 1 billion people
SELECT name, population, gnp 
FROM country
WHERE gnp > 1000000 AND population < 1000000000; --gnp is in millions, so 1 million gnp actually equals a trillion

-- The name and population of all cities in Texas that have a population of greater than 1 million people
SELECT name, population 
FROM city
WHERE district = 'Texas' AND population > 1000000;

-- The name and average life expectancy of all countries in southern-ish regions (something that has south in its name)
SELECT * FROM country;

SELECT name, lifeexpectancy, region 
FROM country 
WHERE region LIKE 'South%';



-- The name and average life expectancy of all countries in southern regions for which an average life expectancy has been provided (i.e. not equal to null)
SELECT name, lifeexpectancy, region 
FROM country 
WHERE region LIKE 'South%' AND lifeexpectancy IS NOT NULL;


-- The name, continent, GNP, and average life expectancy of all countries in Africa or Asia that have an average life expectancy of at least 70 years and a GNP between $1 million and $1 billion dollars
SELECT name, continent, gnp, lifeexpectancy 
FROM country
WHERE continent IN ('Africa', 'Asia') AND lifeexpectancy >= 70 AND gnp BETWEEN 1 and 1000; --new key word between is inclusive
