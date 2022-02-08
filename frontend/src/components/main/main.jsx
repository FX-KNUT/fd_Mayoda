import React, { useEffect } from "react";
import axios from "axios";
import "./main.css";
import Todos from "./Todos/todos";

const Main = () => {

  // TEST API 테스트[1] = 이소윤
  /*
    endpoint: /get/test1
    querystring: ?name=somename
    response: {
    "message": "OK"
    }
  */

  // <!-- TEST API 테스트[1] - 이소윤
    useEffect(() => {
      fetchData();
    }, [])

    const fetchData = async () => {
      const endpoint = '/get/test1';
      const querystring = 'name=somename';
      const ip = 'secret';
      const portNumber = 8080;
      const uri = `http://${ip}:${portNumber}${endpoint}?${querystring}`;

      const result = await axios.get(uri);
      return result;
    }
  // TEST API 테스트[1] - 이소윤 -->

  return (
    <main className="padding">
      <Todos />
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
