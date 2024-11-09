import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [color, setcolor] = useState("olive")
  const [textColor, setTextColor] = useState("black");

 
  

  return (
    
    <div className="w-full h-screen duration-200" style={{backgroundColor:color}}>
      <p style={{color:textColor}}>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi consequatur, quo saepe numquam earum quisquam iusto quod dicta placeat odit?</p>
      <div className="fixed flex flex-wrap justify-center bottom-12 inset-x-0 px-2">
        
        <div className="flex flex-wrap shadow-lg bg-white justify-center rounded-lg px-3 py-2">
          <button onClick={()=>{setcolor("black");setTextColor("white")}}className="outline-none px-4 py-2 rounded-3xl m-2" style={{backgroundColor:"red"}}>RED</button>
          <button onClick={()=>setcolor("green")} className="outline-none px-4 py-2 rounded-3xl m-2" style={{backgroundColor:"green"}}>GREEN</button>
          <button onClick={()=>setcolor("yellow")}  className="outline-none px-4 py-2 rounded-3xl m-2" style={{backgroundColor:"yellow"}}>YEELLOW</button>
          <button onClick={()=>setcolor("Blue")}  className="outline-none px-4 py-2 rounded-3xl m-2" style={{backgroundColor:"blue"}}>BLUE</button>
                                                

        </div>
      </div>
    </div>
     

  )
}

export default App
