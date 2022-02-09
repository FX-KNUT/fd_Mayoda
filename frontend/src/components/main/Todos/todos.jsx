import {TodoTitle} from "./TodoTitle/TodoTitle";

const Todos = () => {

  // todo가 있으면 todo를 뿌리고
  // todo가 없으면 "예정된 일정이 없습니다."

  // ternary operator
  // 삼항 연산자
  // console.log("hello world!") ? true : false;

    return (
        <div className="today">
          <TodoTitle />
          <div className="today_style">
            <p>예정된 일정이 없습니다.</p>
          </div>
        </div>
    );
}

export default Todos;