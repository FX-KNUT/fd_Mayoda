import { Children } from "react";
import "./modal.css";

const Modal = ({children}) => {

    return (
        <div className="module_modal">
            {children}
        </div>
    );
}

export default Modal;