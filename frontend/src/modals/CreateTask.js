import React, { useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import axios from 'axios';

const CreateTaskPopup = ({modal, toggle, save}) => {
    const [title, setTitle] = useState('');
    const [text, setText] = useState('');

    const handleChange = (e) => {
        
        const {name, value} = e.target

        if(name === "title"){
            setTitle(value)
        }else{
            setText(value)
        }


    }

    const handleSave = (e) => {
        e.preventDefault()
        const taskObj = {}
        taskObj["title"] = title
        taskObj["text"] = text
        
        console.log(taskObj.value)
        console.log(taskObj)
        console.log(title)
        console.log(text)
        axios.post("http://localhost:8080/api/add",taskObj);
    


        axios.get("http://localhost:8080/api/tasks").then(res => {
            const tasks = res.data;
            console.log(tasks);
             localStorage.setItem("taskList", JSON.stringify(tasks))
        })
    
        save(taskObj)
    }
    return (
        <Modal isOpen={modal} toggle={toggle}>
            <ModalHeader toggle={toggle}>Create Task</ModalHeader>
            <ModalBody>
            
                    <div className = "form-group">
                        <label>Task Name</label>
                        <input type="text" className = "form-control" value = {title} onChange = {handleChange} name = "title"/>
                    </div>
                    <div className = "form-group">
                        <label>Description</label>
                        <textarea rows = "5" className = "form-control" value = {text} onChange = {handleChange} name = "text"></textarea>
                    </div>
                
            </ModalBody>
            <ModalFooter>
            <Button color="primary" onClick={handleSave}>Create</Button>{' '}
            <Button color="secondary" onClick={toggle}>Cancel</Button>
            </ModalFooter>
      </Modal>
    );
};

export default CreateTaskPopup;