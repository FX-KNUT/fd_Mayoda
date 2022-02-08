import React from "react";
import "./main.css";

const Main = () => {
  return (
    <main className="padding">
      <div className="today">
        <div>
          <span>TODAY'S BUCKET</span>
        </div>
        <div className="today_style">
          <p>예정된 일정이 없습니다.</p>
        </div>
      </div>
      <div className="size"></div>
      <div className="size"></div>
      <div className="done">
        <div>
          <span>DONE HISTORY</span>
        </div>
        <div className="done_style">
          <p>예정된 일정이 없습니다.</p>
        </div>
      </div>
    </main>
  );
};

export default Main;
