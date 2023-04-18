import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom';

export default function Home() {

    const {id} = useParams()

    const [users, setUsers] = useState([]) //在 React 中，useState 是一個 Hook 函数，它用於添加 state 變量到 React 函數式組件中。這個 Hook 接受一個初始值作為參數，並返回一個由當前狀態和一個更新狀態的函數組成的數組。

    //在這段代碼中，useState([]) 表示創建一個名為 users 的狀態變量，其初始值為一個空數組 []。setUsers 是一個函數，當它被調用時，它會更新 users 狀態的值。例如，當有新的用戶數據可用時，可以調用 setUsers 函數，將新的用戶數據設置為 users 狀態的值。這樣，React 會自動重新渲染組件，並將更新後的用戶數據顯示在 UI 上。

    useEffect(() => { //useEffect 是 React 中的一個 Hook 函數，用於處理組件的副作用，例如訂閱事件、更新 DOM 等。當你呼叫 useEffect 時，你可以傳入一個函數，這個函數會在每次渲染組件後執行，以處理副作用。
        loadUsers();
    }, [])

    const loadUsers = async () => {
        const result = await axios.get("http://localhost:8080/member/");
        setUsers(result.data);

    }

    const deleteUser = async (id)=>{
        await axios.delete(`http://localhost:8080/member/${id}`)
        loadUsers()
    }

    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Order</th>
                            <th scope="col">Name</th>
                            <th scope="col">Age</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map((user, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{user.id}</td>
                                    <td>{user.username}</td>
                                    <td>{user.age}</td>
                                    <td>
                                        <button className='btn btn-primary mx-2'>View</button>
                                        <Link className='btn btn-outline-primary mx-2' to={`/edituser/${user.id}`}>Edit</Link>
                                        <button className='btn btn-outline-danger mx-2' onClick={()=>deleteUser(user.id)}>Delete</button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}
