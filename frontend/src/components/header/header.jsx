import { useEffect, useState } from "react";
import ReactDOM from "react-dom";
import Dim from "../module/dim/dim";
import Modal from "../module/modal/modal";
import "./header.css";


const Header = () => {

  const [showModal, setShowModal] = useState(false);

  const icons = [
    { id: "person", name: "person_outline" },
    { id: "calendar", name: "calendar_today" },
    { id: "bell", name: "notifications" },
    { id: "test", name: "test"},
  ];

  const onIconClicked = (id) => {
    console.log(`클릭이벤트 발생! - ${id}`);
    if(id === 'test') {
      setShowModal(prev => !prev);
    }
    console.log(showModal);
  };

  useEffect(() => {
    if(showModal === true) {
      const target_portal = document.querySelector("#portal");
      const test_dim = (
        <Dim childComponent={Modal} show={true}/>
      );
      ReactDOM.createPortal(test_dim, target_portal);
      console.log("fuck");
    }
  }, [showModal])

  return (
    <header className="header_container">
      <p className="header_logo"> MAYODA </p>
      <p className="header_space"></p>
      <div className="header_icon">
        {icons.map((icon) => (
          <span className="header_button" key={icon.id}>
            <span
              id={icon.id}
              className="material-icons md-36"
              draggable="false"
              role="button"
              onClick={() => onIconClicked(icon.id)}
            >
              {icon.name}
            </span>
          </span>
        ))}
      </div>
    </header>
  );
};

export default Header;
