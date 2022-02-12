import "./modal.css";

const Modal = ({child}) => {

    return (
        <div className="module_modal">
            {child}
        </div>
    );
}

export default Modal;