const todoList = document.getElementById('todos');

let todos = [];
let pageTitle = '';

function init() {
    pageTitle = 'My Morning Routine';
    todos = [
      { id: 1, task: 'Wake up', completed: false },
      { id: 2, task: 'Brush Teeth', completed: false },
      { id: 3, task: 'Shower', completed: false },
      { id: 4, task: 'Get Dressed', completed: false },
      { id: 5, task: 'Drive to work', completed: false },
      { id: 6, task: 'Work', completed: false },
      { id: 7, task: 'Drive home from work', completed: false },
      { id: 8, task: 'Dinner', completed: false },
      { id: 9, task: 'Brush Teeth', completed: false },
      { id: 10, task: 'Go to bed', completed: false }
    ]
  }

  // set up the page title and tasks
init();
// // add page title to the DOM
addPageTitle();
// // add the task to the DOM
addTodos();

function addPageTitle() {
    const heading = document.createElement('h1'); //create a new h1 element
    heading.innerText = pageTitle; //make the inner text of the new element = page title (from above)
    todoList.appendChild(heading); // make the new h1 element the child of the todo list element
}

function addTodos() {
    const ul = document.createElement('ul'); //create a new ul element
    todoList.appendChild(ul); // make new ul element a child of the to do list

    todos.forEach(todo => { //for each item in the todos array created above...
        const li = document.createElement('li'); //create an li element
        li.innerText = todo.task; //make the inner text of that element the task associated with the todo object in the array
        ul.appendChild(li); //make the li the child of the ul
    });
}

