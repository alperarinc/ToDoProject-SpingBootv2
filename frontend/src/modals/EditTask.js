import React, { useState , useEffect} from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import axios from 'axios';

const EditTaskPopup = ({modal, toggle, updateTask, taskObj}) => {
    const [title, setTitle] = useState('');
    const [text, setText] = useState('');
    const [id, setId]= useState('');

    const handleChange = (e) => {
        
        const {name, value} = e.target

        if(name === "title"){
            setTitle(value)
        }else{
            setText(value)
        }
    }

    useEffect(() => {
        setTitle(taskObj.title)
        setText(taskObj.text)
        setId(taskObj.id)
    },[])

    const handleUpdate = (e) => {
        e.preventDefault();
        const tempObj = {}
        tempObj['title'] = title
        tempObj['text'] = text
        tempObj['id'] = id
        axios.post("http://localhost:8080/api/update", tempObj);
        updateTask(tempObj)

        axios.get("http://localhost:8080/api/todos").then(res => {
            const todos = res.data;
            console.log(todos);
             localStorage.setItem("taskList", JSON.stringify(todos))
        })
    }

    return (
        <Modal isOpen={modal} toggle={toggle}>
            <ModalHeader toggle={toggle}>Update Task</ModalHeader>
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
            <Button color="primary" onClick={handleUpdate}>Update</Button>{' '}
            <Button color="secondary" onClick={toggle}>Cancel</Button>
            </ModalFooter>
      </Modal>
    );
};

export default EditTaskPopup;