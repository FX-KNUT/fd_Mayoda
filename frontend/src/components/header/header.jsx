import "./header.css";
import "material-icons/iconfont/material-icons.css";

const Header = () => {
  const icons = [
    { id: "person", name: "person_outline" },
    { id: "calendar", name: "calendar_today" },
    { id: "bell", name: "notifications" },
  ];

  const onClick = () => {
    console.log("클릭이벤트 발생!");
  };

  return (
    <header className="header_container">
      <p className="header_logo"> MAYODA </p>
      <p className="header_space"></p>
      <div className="header_icon">
        {icons.map((icon) => (
          <span className="header_button" key={icon.id}>
            <span
              className="material-icons md-36"
              draggable="false"
              role="button"
              onClick={onClick}
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
