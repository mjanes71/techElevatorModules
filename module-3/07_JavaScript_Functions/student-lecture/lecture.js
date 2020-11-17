/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;

}
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  let result = firstParameter * secondParameter;
  if (Number.isNaN(result)) {
    throw 'This makes no sense';
  } else {
    return result;
  }
}


/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter === 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

////////////////////////////////////Writing JSDoc Comments////////////////////////////////////////////////////

/**
 * This function creates an english sentence from a user's information. This will be displayed on the MadLib page.
 * @param {string} name - name who madlib is about
 * @param {number} age -age of person in years
 * @param {string[]} listOfQuirks - list of quirky characteristics about named person
 * @param {string} separator - used to join all information in output of function
 * @returns {string} sentence that describes a person using all inputted information
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}
/**
 * 
 * @param {number} n 
 */
function logTimesTwo(n) {
  console.log(n * 2);
}

function imperativeForEach() {
  const myArray = [1, 4, 2, 6, 8, 9];
  for (let num of myArray) {
    logTimesTwo(num);
  }
}

function declarativeForEach(){ //forEach takes array and does something to each value based on logic its passed
  const myArray = [1, 4, 2, 6, 8, 9];
  myArray.forEach(logTimesTwo);//does same thing as line below 
  myArray.forEach(function(n) {console.log(n * 2);}) // this line shows how to create anon function within body of current function
  myArray.forEach( (n) => {console.log(n * 2);}); //this line shows how to create anon function with arrow syntax
  myArray.forEach( n => console.log(n * 2)); // can remove parens around n because only one argument, and got rid of curly braces because only one line of code
}

function isEven(num){
  return num % 2 === 0;
}

function filterDemo(){ //filter takes array and makes new array based on the function thats passed to the filter
  const myArray = [1, 4, 2, 6, 8, 9];

 //return myArray.filter(isEven);
 //return myArray.filter(n => {return n % 2 === 0;});
 return myArray.filter(n => n % 2 === 0); //most simplified version
}

function mapDemo(){
  const myArray = [1, 4, 2, 6, 8, 9];
  return myArray.map(n => n * 3); //returns new array where every value has been multiplied by 3
}



function mapWithObjects(){
  const customers = [ //array of customer objects
    {name: 'Fred', amountSpent: 1000},
    {name: 'Mary', amountSpent: 500},
    {name: 'Moe', amountSpent: 2500}
  ];

  return customers.map(cus => cus.name);//gets the name of each customer and returns it as an array
  //return customers.filter(c => c.amountSpent >= 1000).map(c => c.name); first filters by amount spent, then returns array with names left- array function on array function

}

function reduceToSum() { //boils an array down to one item based on function it is passed
  const myArray = [1, 4, 2, 6, 8, 9];
  return myArray.reduce((total, num) => total + num); //reduce takes up to 4 params, but has to have first two, which is a 'total' and the current item
//default behavior is to set 'total' as first value and then start reading at second element in array
//can say ((total, num) => total + num, 100); that 100 makes total start at 100 and then adds from the first element
}

function reduceWithObects() {
  const customers = [ //array of customer objects
    {name: 'Fred', amountSpent: 1000},
    {name: 'Mary', amountSpent: 500},
    {name: 'Moe', amountSpent: 2500}
  ];

  return customers.reduce((total, customer) => total + customer.amountSpent, 0); //if you don't specify the accumulator (total) it will look at the whole first object which won't work
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce((sum, num) => sum + num);
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter(n => n % 3 === 0);
}
