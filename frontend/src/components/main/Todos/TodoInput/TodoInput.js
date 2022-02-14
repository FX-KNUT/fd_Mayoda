import { useState, useEffect } from "react";
import "./TodoInput.css";

const TodoInput = () => {
  const [todos, setTodos] = useState([]);
  const [inputText, setInputText] = useState("");

  const onChange = (e) => {
    setInputText(e.target.value);
  };
  const onClick = () => {
    const nextText = todos.concat(inputText);
    if (!inputText) return window.alert("일정을 입력해주세요.");
    setTodos(nextText);
    setInputText("");
  };
  const onKeyPress = (e) => {
    if (e.key === "Enter") {
      onClick();
    }
  };

  const onRemove = (index) => {
    const nextText = todos.filter((_, idx) => idx !== index);
    setTodos(nextText);
  };

  const todoList = todos.map(
    (value, index) =>
      value !== "" && (
        <li key={index}>
          {value}
          <button className="remove_style" onClick={() => onRemove(index)}>
            x
          </button>
        </li>
      )
  );

  useEffect(() => {
    const data = localStorage.getItem("todo");
    if (data) setTodos(JSON.parse(data));
  },[]);

  useEffect(() => {
    localStorage.setItem("todo", JSON.stringify(todos));
  });

  return (
    <div>
      <div className="today_style">
        <div className="todo_insert">
          <input
            className="input_style"
            value={inputText}
            onChange={onChange}
            onKeyPress={onKeyPress}
          />
          <button className="click_style" onClick={onClick}>
            +
          </button>
        </div>
        <ul>{todos.length === 0 ? "예정된 일정이 없습니다." : todoList}</ul>
      </div>
    </div>
  );
};

export default TodoInput;
