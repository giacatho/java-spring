import axios from 'axios';
import React, { useRef, useState } from 'react';

const REST_API_URL = "http://localhost:8080/api/courses";

export default function CreateCourse() {
  const [isCreatedSuccess, updateIsCreatedSuccess] = useState(false);

  const codeElement = useRef();
  const nameElement = useRef();
  const descriptionElement = useRef(); 

  function handleCreateClick(e) {
    e.preventDefault();
    
    console.log("Create button is click");
    // Validate the input 
    apiCreateCourse();
  }

  function apiCreateCourse() {
    const data = {
      code: codeElement.current.value,
      name: nameElement.current.value,
      description: descriptionElement.current.value
    };

    axios.post(REST_API_URL, data)
      .then(response => {
        updateIsCreatedSuccess(true);
      })
      .catch(e => {
        console.log(e);
      })
  }

  function getCreateCourseHtml() {
    if (isCreatedSuccess) {
      return (
        <div>
          <h5>Create a new course successfully!</h5>
        </div>
      );
    }

    return (
      <div>
        <h4>Create a new Course</h4>
        <form>
          <label htmlFor='code'>Code:</label><br/>
          <input type='text' name='code' ref={codeElement} /><br/>
          <label htmlFor='name'>Name:</label><br/>
          <input type='text' name='name' ref={nameElement} /><br/>
          <label htmlFor='description'>Description:</label><br/>
          <input type='text' name='description' ref={descriptionElement} /><br/>
          <button onClick={handleCreateClick}>Create</button>
        </form> 
      </div>
    );
  }

  return (
    getCreateCourseHtml()
  );
}