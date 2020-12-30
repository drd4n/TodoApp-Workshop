import { useEffect, useState, React} from "react";
import './App.css';
import { TodoItems } from "./components/todoItems";

function App() {
  const [todoItems, setTodoItems] = useState(null);

  useEffect(() => {
    //do fetch on load
    console.log("Hi loaded up!");
    if (!todoItems) {
      fetch('http://localhost:8080/api/todoItems').then((response) => 
        response.json()
        ).then((data) => {
        console.log("Todo Items List: ", data);
        setTodoItems(data);
     });
  }
}, [todoItems]);

//ternary operator คือ if else statement in 1 line 
//todoitems ? คือ todoitems != null ?

  return (
    <div>
      {todoItems ? todoItems.map((todoItem) => {
          return <TodoItems key={todoItem.id} data={todoItem} />;
      }) : 'loading data...'}
    </div>
  );
}

export default App;
