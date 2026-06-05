import { useState } from "react";

export default function TaskManager() {
  const [currentInput, setCurrentInput] = useState("");
  const [todos, setTodos] = useState([]);

  const addTask = () => {
    if (currentInput.trim() === "") return;

    const newTask = {
      id: Date.now(),
      text: currentInput,
      completed: false,
    };

    setTodos([...todos, newTask]);
    setCurrentInput(""); // Clear input
  };

  const toggleTask = (id) => {
    const updatedTodos = todos.map((todo) =>
      todo.id === id
        ? { ...todo, completed: !todo.completed }
        : todo
    );

    setTodos(updatedTodos);
  };

  const deleteTask = (id) => {
    const updatedTodos = todos.filter(
      (todo) => todo.id !== id
    );

    setTodos(updatedTodos);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Task Manager</h2>

      <input
        type="text"
        value={currentInput}
        onChange={(e) => setCurrentInput(e.target.value)}
        placeholder="Enter a task"
      />

      <button onClick={addTask}>Add</button>

      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>
            <span
              onClick={() => toggleTask(todo.id)}
              style={{
                cursor: "pointer",
                textDecoration: todo.completed
                  ? "line-through"
                  : "none",
              }}
            >
              {todo.text}
            </span>

            <button
              onClick={() => deleteTask(todo.id)}
              style={{ marginLeft: "10px" }}
            >
              X
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}