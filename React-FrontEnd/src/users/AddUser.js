import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function AddUser() {
    const apiURL=process.env.REACT_APP_API_PORT
    let navigate = useNavigate()

    const [user, setUser] = useState({
        username: "",
        age: ""
    })

    const { username, age } = user

    const onInputChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value }) //在 React 或 JavaScript 中，e.target.name 是事件觸發的 HTML 元素的 name 屬性。在這個程式碼中，當使用者輸入表單時，e.target.name 指的是該輸入欄位的 name 屬性。

        //使用 e.target.name 作為 setUser 函式中的物件鍵，可以讓程式碼更具有彈性。這是因為當使用者更改表單時，這個函式會使用 e.target.name 來更新 user 物件中相應的屬性。這樣一來，即使表單中新增或刪除了欄位，只要每個欄位都有 name 屬性，就不需要修改 onInputChange 函式的程式碼。
    }

    const onSubmit =async (e) => {
        e.preventDefault();
        await  axios.post(apiURL+"member/",user);
        navigate("/");
    }
    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Register User</h2>
                    {/* <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>Name:</label>
                        <input type={"text"} className='formm-control' placeholder='Enter Your Name' name='name'></input>
                    </div> */}
                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className='mb-3'>
                            <label htmlFor='username' className='form-label'>Userame:</label>
                            <input type={"text"} className='formm-control' placeholder='Enter Your Username' name='username' value={username} onChange={(e) => onInputChange(e)}></input>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='age' className='form-label'>Age:</label>
                            <input type={"text"} className='formm-control' placeholder='Enter Your Age' name='age' value={age} onChange={(e) => onInputChange(e)}></input>
                        </div>
                        <button type='submit' className='btn btn-outline-primary'> Sumbit</button>
                        <Link type='submit' className='btn btn-outline-danger mx-2' to="/">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    )
}
