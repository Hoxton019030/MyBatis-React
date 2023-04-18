import React from 'react'

export default function AddUser() {
    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Register User</h2>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>Name:</label>
                        <input type={"text"} className='formm-control' placeholder='Enter Your Name' name='name'></input>
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='username' className='form-label'>Userame:</label>
                        <input type={"text"} className='formm-control' placeholder='Enter Your Username' name='username'></input>
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='age' className='form-label'>Age:</label>
                        <input type={"text"} className='formm-control' placeholder='Enter Your Age' name='age'></input>
                    </div>
                <button type='submit' className='btn btn-outline-primary'> Sumbit</button>
                <button type='submit' className='btn btn-outline-danger mx-2'>Cancel</button>
                </div>
            </div>
        </div>
    )
}
