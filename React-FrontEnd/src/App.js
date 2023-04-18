
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddUser from './users/AddUser';
import EditUser from './users/EditUser';

//BrowserRouter 是 React-Router-DOM 模組中的一個 Router 元件，可以用於建立基於瀏覽器路由的應用程序。它可以讓你在應用程序中使用像是 <Link> 和 <Route> 這樣的元件來進行頁面導航和路由管理。
//Routes 是用來將多個 <Route> 元件組合在一起的元件，它的作用是讓 React-Router-DOM 知道所有可用的路由，以便正確地渲染應用程序的相應頁面。
//Route 元件是 React-Router-DOM 中最常用的元件之一，它用於定義一個路由規則，並指定當使用者訪問特定路徑時應該渲染哪個組件。
//這些元件可以幫助你建立一個具有多頁面路由功能的 React 應用程序，並管理用戶在應用程序中的導航和狀態。
function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home/>}/>
          <Route exact path="/adduser" element={<AddUser/>}/>
          <Route exact path="/edituser/:id" element={<EditUser/>}/>
        </Routes>

      </Router>
    </div>
  );
}

export default App;
