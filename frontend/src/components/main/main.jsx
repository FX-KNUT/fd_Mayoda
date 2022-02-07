import React from 'react';
import './main.css';

function Main() {
  return (
    <main class="padding">
      
        <div class='today'>
            <span>TODAY'S BUCKETS</span> <br/>
            <p>예정된 일정이 없습니다.</p>
        </div>
        <div class='size'></div>
        <div class='size'></div>
        <div class='done'>
            <span>DONE HISTORY</span> <br/>
            <p>예정된 일정이 없습니다.</p>
        </div>
       
    </main>
  )
}

export default Main;