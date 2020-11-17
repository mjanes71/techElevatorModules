/*
    Example of a multi-line comment just like in C#/Java
*/
console.log('Hello from the script.js file.');
// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const daysPerWeek = 7;

  console.log('There are ' + daysPerWeek + ' days in a week.');
  
  // Declares a variable those value can be changed
let daysPerMonth = 30;
console.log(`There are  ${daysPerMonth} days in a month. This is a template literal.` );

  // Declares a variable that will always be an array

  const weekdays = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'];
  console.log(weekdays);
  console.table(weekdays); //prints out a nice table view

  return null;
}
/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true, this is a dark corner. stay the heck away from this
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: 'Bill',
    'last name': 'Lumbergh',
    age: 42,
    employees: [
      'Peter Gibbons',
      'Milton Waddams',
      'Samir Nagheenanajar',
      'Michael Bolton'
    ]
  };

  // Log the object
  console.log(person);

  // Log the first and last name
  console.log(`${person.firstName} is my first name. ${person['last name']} is my last name.`)

  // Log each employee
for (let i = 0; i < person.employees.length; i++){ // for i
  console.log(`Employee ${i} is ${person.employees[i]}`);
}

for (let employee of person.employees) { //for each
  console.log(`Employee: ${employee}`);
}
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log('Math.PI : ' + Math.PI);
  console.log('Math.LOG10E : ' + Math.LOG10E);
  console.log('Math.abs(-10) : ' + Math.abs(-10));
  console.log('Math.floor(1.99) : ' + Math.floor(1.99));
  console.log('Math.ceil(1.01) : ' + Math.ceil(1.01));
  console.log('Math.random() : ' + Math.random());
}

function rollDie() {
  return Math.floor(Math.random() *6) + 1;
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith('World')}`);
  console.log(`.startsWith('Hello') - ${value.startsWith('Hello')}`);
  console.log(`.indexOf('Hello') - ${value.indexOf('Hello')}`);

  /*
    Other Methods
        - split(string)
        - substring(number, number)
        - toLowerCase() and toUpperCase()
        - trim()
        - includes(string)
    */
}

/*
########################
Array Methods
########################
*/

function arrays() {
  const names = ['Larry', 'Moe', 'Curly'];
  console.log(`names: ${names.toString()}`);
  console.log(`names[1]: ${names[1]}`);

  //.join()
console.log(names.join(', ')); //you determine how to display string instead of the default ,
  //.push() & .pop() //stuff on and off end
  names.push('Schemp');
  console.log(names);

 let removedName = names.pop();
  console.log(names);
  console.log(removedName);


  //.shift() & .unshift() // stuff on and off front
  names.unshift('Schemp');
  console.log(names);

  let anotherNameRemoved = names.shift();
  console.log(names);
  console.log(anotherNameRemoved);

  //.concat()

  const lesserKnownStooges = ['Schemp', 'Joe'];
  const moreNames = names.concat(lesserKnownStooges);
  console.log(names);
  console.log(moreNames);

  //.slice() like substring but for arrays. creates new array
  console.log(names.slice(1,3));

  //.reverse() and .sort()  don't return new arrays, affect the passed array

  names.reverse();
  console.log(names);

  names.sort();
  console.log(names);

  //.indexOf() and .lastIndexOf()
  console.log(names.indexOf('Larry'));

  //spread operator (...) allows you to combine arrays easily

  const allStooges = [...names, 'David', ...lesserKnownStooges];
  console.log(allStooges);

  const sortedStooges = [...allStooges].sort(); //if you use this will the sort and reverse functions, it makes a copy of the array to sort or reverse instead of affecting change on the original
  

}
