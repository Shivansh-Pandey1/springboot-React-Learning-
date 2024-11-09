import { useState,useCallback,useEffect,useRef } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [length, setlength] = useState(8)
  const [NumberAllowed, setNumberAllowed] = useState(false)
  const [charAllowed, setcharAllowed] = useState(false)
  const [password, setpassword] = useState("")



  const passwordgenerator=useCallback(()=>{
    let pass = ""
    let str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    if(NumberAllowed){
      str+="0123456789"

    }
    if(charAllowed){
      str+="?@#$/<>~"
    }
    for(let i=1;i<=length;i++){
      let char=Math.floor(Math.random()*str.length+1)
      pass+=str.charAt(char)

    }
    setpassword(pass)
  },[length,NumberAllowed,charAllowed,setpassword])

  //useRef

  const passwordref=useRef(null)
  //



  useEffect(()=>{
    passwordgenerator()
  },[length,NumberAllowed,charAllowed,passwordgenerator])



  const copypasswordtoclip=useCallback(()=>{
    passwordref.current?.select()
    window.navigator.clipboard.writeText(password)

  },[password])
  return (
    <>
    <div className='w-full max-w-md mx-auto rounded-lg px-4 my-8 text-orange-500 bg-gray-900'>
    
    <h1 className='text-4xl text-center text-white'>PASSWORD GENERATOR</h1>
      <div className='flex rounded-lg overflow-hidden mb-4'>
      <input type="text" value={password} placeholder="password" 
      readOnly
      ref={passwordref}
      className='rounded-tl-lg rounded-bl-lg my-3 w-80 ' />
      <button onClick={copypasswordtoclip} className='bg-blue-600 active:bg-blue-900 rounded-tr-lg rounded-br-lg w-14 h-8 my-3' >copy</button>
    </div>
    <div className='flex text-sm gap-x-2'> 
      <div className='flex items-center gap-x-1'>
        <input type="range" 
        min={8}
        max={40}
        value={length}
        className='cursor-pointer'
        onChange={(e) => {setlength(e.target.value)}}
        />
        <label> length:{length}</label>
      </div>
      <div className='flex items-center gap-x-1'>
      <input type="checkbox" 
      defaultChecked={NumberAllowed}
      id="numberImput"
        onChange={(e) => {setNumberAllowed((prev)=>!prev)}}
        />
        <label>numbersAllowed</label>
        <input type="checkbox" 
      defaultChecked={NumberAllowed}
      id="numberImput"
        onChange={(e) => {setcharAllowed((prev)=>!prev)}}
        />
        <label>charAllowed</label>


      </div>
      
      </div>

    </div>
    
      
     
      
     
    </>
  )
}

export default App
