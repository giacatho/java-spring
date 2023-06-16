import React, { useEffect, useState } from 'react'
import Course from './Course'
import CourseDetail from './CourseDetail';
import axios from 'axios';

const REST_API_URL = "http://localhost:8080/api/courses";

export default function ListCourse() {
  const [ myCourseList, updateMyCourseList ] = useState([]); 
  const [ detailId, updateDetailId ] = useState('');
  
  useEffect(() => {
    console.log("Retrieving course list from server");
    apiRetrieveCourseList();
  });

  function apiRetrieveCourseList() {
    axios.get(REST_API_URL)
      .then(response => {
        updateMyCourseList(response.data)
        console.log(response.data);
      })
      .catch(e => {
        
      });
  }

  function handleCourseClick(id) {
    updateDetailId(id);
  }

  const listCourseHtml = myCourseList.map((myCourse) =>
    <div key={myCourse.id}>
      <Course myCourse={myCourse} handleCourseClick={handleCourseClick} />
    </div>
  );

  const detailCourse = 
    myCourseList.find(myCourse => myCourse.id === detailId);

  function getDetailCourseHtml() {
    if (detailCourse) {
      return (
        <CourseDetail detailCourse={detailCourse} />
      );
    } 
    return <></>;
  }

  return (
    <div>
      {listCourseHtml}
      {getDetailCourseHtml()}
    </div>
  )
}
