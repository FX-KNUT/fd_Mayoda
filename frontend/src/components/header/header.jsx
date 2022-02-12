import { useEffect, useState } from "react";
import Dim from "../module/dim/dim";
import Modal from "../module/modal/modal";
import "./header.css";


const Header = () => {

  const [showModal, setModalOpen] = useState(false);

  
  const icons = [
    { id: "person", name: "person_outline", label: "Login"},
    { id: "calendar", name: "calendar_today", label: "Calendar"},
    { id: "noti", name: "notifications", label: "Notification"},
    { id: "test", name: "test"},
  ];

  const onIconClicked = (id) => {
    console.log(`클릭이벤트 발생! - ${id}`);
    if(id = "test") {
       setModalOpen(true); 
      }
    };
 const test_dim = (
          <Dim child={Modal()} show={true}/>
        )
  return (
    <header className="header_container">
      {showModal && test_dim}
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
            <span className="label_transform">
              {icon.label}
            </span>
          </span>
        ))}
      </div>
    </header>
  );
};

export default Header;
