import { createPortal } from "react-dom";
import "./dim.css";

const Dim = ({ children, setIsShowModal }) => {
  return createPortal(
    //ReactDom. x
    <div className="module_dim" onClick={() => setIsShowModal((prev) => !prev)}>
      {children}
    </div>,
    //click시 이전 버전으로
    document.getElementById("portal")
    //id와 같은 DOM 요소를 나탄는 Elememt 반환..없을 시 null
  );
};

export default Dim;
