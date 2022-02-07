import React from "react";
import "./main.css";

const Main = () => {
  return (
    <main class="padding">
      <div class='today'>
          <span>TODAY'S BUCKET</span>
          <div class='today_style'>
              <p>예정된 일정이 없습니다.</p>
          </div>
      </div>
      <div class="size"></div>
      <div class="size"></div>
      <div class="done">
        <span>DONE HISTORY</span>
        <div class='done_style'>
            <p>예정된 일정이 없습니다.</p>
        </div>
      </div>
    </main>
  );
};

export default Main;